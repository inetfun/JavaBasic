// ThreadExample2.java
package Chapter8;

class MyThread1 implements Runnable { // ʵ��Runnable�ӿڴ����߳���MyThread
	public void run() { // ʵ��Runnable�ӿڵ�run()����
		for (int i = 0; i < 9; i++) {
			System.out.print(i + "  ");
		}
	}
}

public class ThreadExample2 {
	public static void main(String args[]) {
		MyThread1 mt = new MyThread1(); // �����߳���MyThread��ʵ��t
		Thread t = new Thread(mt); // ����Thread���ʵ��t
		t.start(); // �����߳�
	}
}
