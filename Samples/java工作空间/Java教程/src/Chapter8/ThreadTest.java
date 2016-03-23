// ThreadTest.java
package Chapter8;

public class ThreadTest {
	public static void main(String[] args) {
		LeftHand left = new LeftHand(); // �����߳�left
		RightHand right = new RightHand(); // �����߳�right
		left.start(); // �߳�������LeftHand���е�run()��������ִ��
		right.start();
	}
}

// �����߳���LeftHand
class LeftHand extends Thread {
	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.print("A");
			try {
				sleep(500); // left�߳�����500����
			} catch (InterruptedException e) {
			}
		}
	}
}

// �����߳���RightHand
class RightHand extends Thread {
	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.print("B");
			try {
				sleep(300); // right�߳�����300����
			} catch (InterruptedException e) {
			}
		}
	}
}
