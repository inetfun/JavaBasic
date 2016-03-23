// ThreadExample8.java
package Chapter8;

class MyThread7 implements Runnable {
	private int count = 0; // ���干�����count

	public void run() {
		test();
	}

	private synchronized void test() {
		for (int i = 0; i < 5; i++) {
			count++;
			Thread.yield(); // �߳��ò�
			count--;
			System.out.print(count + "  "); // ���count��ֵ
		}
	}
}

public class ThreadExample8 {
	public static void main(String[] args) throws InterruptedException {
		MyThread7 t = new MyThread7();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		t1.start(); // �����߳�t1
		t2.start(); // �����߳�t2
	}
}
