// ThreadExample4.java
package Chapter8;

class MyThread3 extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.print(i+"  ");
			try {
				sleep(1000); // �߳�����1�룬��ÿ��1���ӡһ������
			} catch (InterruptedException e) {
				System.out.print("error:" + e);
			}
		}
	}
}

public class ThreadExample4 {
	public static void main(String[] args) {
		MyThread3 t = new MyThread3();
		t.start(); // �����߳�t
	}
}
