// ProducerConsumerSyn.java
package Chapter8;

// 生产者线程
class Producer extends Thread {
	private Monitor s;

	Producer(Monitor s) {
		this.s = s;
	}

	public void run() {
		for (char ch = 'A'; ch <= 'E'; ch++) {
			try {
				Thread.sleep((int) Math.random() * 400); // 线程休眠
			} catch (InterruptedException e) {
			}
			s.recordProduct(ch); // 记录生产的产品
			System.out.println(ch + " product has been produced by producer.");
		}
	}
}

// 消费者线程类
class Consumer extends Thread {
	private Monitor s;

	Consumer(Monitor s) {
		this.s = s;
	}

	public void run() {
		char ch;
		do {
			try {
				Thread.sleep((int) Math.random() * 400); // 线程休眠
			} catch (InterruptedException e) {
			}
			ch = s.getProduct(); // 获取生产的产品
			System.out.println(ch + " product has been consumed by consumer!");
		} while (ch != 'E');
	}
}

// 监视器类
class Monitor {
	private char c;
	// 生产消费标记。true: 表示产品已生产，但未消费
	// flase：表示产品已消费，但新的产品尚未生产出来
	private boolean flag = true;

	// 记录生产的产品。如果产品未消费，则等待，即flag由false变为true	
	public synchronized void recordProduct(char c) {
		// 如果新的产品尚未生产出来，则让消费者等待
		if (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		this.c = c; // 记录生产的产品
		flag = false;// 产品尚未消费
		notify(); // 通知消费者线程，产品已经可以消费
	}

	// 获取生产的产品。如果产品已消费，则等待新的产品生产出来
	// 即flag由true变为flase
	public synchronized char getProduct() {
		// 产品已生产出来，等待消费
		if (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		flag = true;// 产品已消费
		notify(); // 通知生产者需要生产新的产品
		return this.c; // 返回生产的产品
	}
}

// 公共测试类
public class ProducerConsumerSyn {
	public static void main(String args[]) {
		Monitor s = new Monitor();
		new Producer(s).start(); // 启动生产者进程
		new Consumer(s).start(); // 启动消费者进程
	}
}
