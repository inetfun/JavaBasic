// ThreadExample6.java
package Chapter8;

class MyThread5 extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.print(i);
		}
	}
}

public class ThreadExample6 {
	public static void main(String[] args) throws InterruptedException {
		MyThread5 t1 = new MyThread5();
		MyThread5 t2 = new MyThread5();
		t1.start(); // �����߳�t1
		t1.join(); // �ȴ�t1ִ�н���
		t2.start();
	}
}
