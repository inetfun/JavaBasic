// ThreadExample1.java
package Chapter8;

class MyThread extends Thread { // �̳�Thread�ഴ���߳���MyThread
	public void run() { // ��дThread���run()����
		for (int i = 0; i < 10; i++) {
			System.out.print(i+"  "); // ��ӡ0~9֮�������
		}
	}
}

public class ThreadExample1 {
	public static void main(String args[]) {
		MyThread t = new MyThread(); // �����߳���MyThread��ʵ��t
		t.start(); // �����߳�
	}
}
