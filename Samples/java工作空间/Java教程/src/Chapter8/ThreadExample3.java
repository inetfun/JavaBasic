// ThreadExample3.java
package Chapter8;

class MyThread2 extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i + " " + getName() + "���ȼ��ǣ�" + getPriority());
		}
	}
}

public class ThreadExample3 {
	public static void main(String args[]) {
		MyThread2 t1 = new MyThread2(); // �����߳���MyThread2��ʵ��t1
		MyThread2 t2 = new MyThread2(); // �����߳���MyThread2��ʵ��t2
		t1.setPriority(1); // �����߳�t1�����ȼ�Ϊ1
		t2.setPriority(10); // �����߳�t2�����ȼ�Ϊ10
		t1.start(); // �����߳�t1
		t2.start(); // �����߳�t2
	}
}
