// ThreadTest.java
package Chapter8;

public class ThreadTest {
	public static void main(String[] args) {
		LeftHand left = new LeftHand(); // 创建线程left
		RightHand right = new RightHand(); // 创建线程right
		left.start(); // 线程启动后，LeftHand类中的run()方法将被执行
		right.start();
	}
}

// 左手线程类LeftHand
class LeftHand extends Thread {
	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.print("A");
			try {
				sleep(500); // left线程休眠500毫秒
			} catch (InterruptedException e) {
			}
		}
	}
}

// 右手线程类RightHand
class RightHand extends Thread {
	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.print("B");
			try {
				sleep(300); // right线程休眠300毫秒
			} catch (InterruptedException e) {
			}
		}
	}
}
