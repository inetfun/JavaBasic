// ThreadExample7.java
package Chapter8;

class MyThread6 implements Runnable {
	private int count = 0; // 定义共享变量count

	public void run() {
		test();
	}

	private void test() {
		for (int i = 0; i < 5; i++) {
			count++;
			Thread.yield(); // 线程让步
			count--;
			System.out.print(count + "  "); // 输出count的值
		}
	}
}

public class ThreadExample7 {
	public static void main(String[] args) throws InterruptedException {
		MyThread6 t = new MyThread6();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		t1.start(); // 启动线程t1
		t2.start(); // 启动线程t2
	}
}
