// ThreadExample7.java
package Chapter8;

class MyThread6 implements Runnable {
	private int count = 0; // ���干�����count

	public void run() {
		test();
	}

	private void test() {
		for (int i = 0; i < 5; i++) {
			count++;
			Thread.yield(); // �߳��ò�
			count--;
			System.out.print(count + "  "); // ���count��ֵ
		}
	}
}

public class ThreadExample7 {
	public static void main(String[] args) throws InterruptedException {
		MyThread6 t = new MyThread6();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		t1.start(); // �����߳�t1
		t2.start(); // �����߳�t2
	}
}
