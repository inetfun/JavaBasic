// ProducerConsumerSyn.java
package Chapter8;

// �������߳�
class Producer extends Thread {
	private Monitor s;

	Producer(Monitor s) {
		this.s = s;
	}

	public void run() {
		for (char ch = 'A'; ch <= 'E'; ch++) {
			try {
				Thread.sleep((int) Math.random() * 400); // �߳�����
			} catch (InterruptedException e) {
			}
			s.recordProduct(ch); // ��¼�����Ĳ�Ʒ
			System.out.println(ch + " product has been produced by producer.");
		}
	}
}

// �������߳���
class Consumer extends Thread {
	private Monitor s;

	Consumer(Monitor s) {
		this.s = s;
	}

	public void run() {
		char ch;
		do {
			try {
				Thread.sleep((int) Math.random() * 400); // �߳�����
			} catch (InterruptedException e) {
			}
			ch = s.getProduct(); // ��ȡ�����Ĳ�Ʒ
			System.out.println(ch + " product has been consumed by consumer!");
		} while (ch != 'E');
	}
}

// ��������
class Monitor {
	private char c;
	// �������ѱ�ǡ�true: ��ʾ��Ʒ����������δ����
	// flase����ʾ��Ʒ�����ѣ����µĲ�Ʒ��δ��������
	private boolean flag = true;

	// ��¼�����Ĳ�Ʒ�������Ʒδ���ѣ���ȴ�����flag��false��Ϊtrue	
	public synchronized void recordProduct(char c) {
		// ����µĲ�Ʒ��δ�������������������ߵȴ�
		if (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		this.c = c; // ��¼�����Ĳ�Ʒ
		flag = false;// ��Ʒ��δ����
		notify(); // ֪ͨ�������̣߳���Ʒ�Ѿ���������
	}

	// ��ȡ�����Ĳ�Ʒ�������Ʒ�����ѣ���ȴ��µĲ�Ʒ��������
	// ��flag��true��Ϊflase
	public synchronized char getProduct() {
		// ��Ʒ�������������ȴ�����
		if (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		flag = true;// ��Ʒ������
		notify(); // ֪ͨ��������Ҫ�����µĲ�Ʒ
		return this.c; // ���������Ĳ�Ʒ
	}
}

// ����������
public class ProducerConsumerSyn {
	public static void main(String args[]) {
		Monitor s = new Monitor();
		new Producer(s).start(); // ���������߽���
		new Consumer(s).start(); // ���������߽���
	}
}
