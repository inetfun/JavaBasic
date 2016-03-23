// ThreadExample4.java
package Chapter8;

class MyThread3 extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.print(i+"  ");
			try {
				sleep(1000); // 线程休眠1秒，即每隔1秒打印一个数字
			} catch (InterruptedException e) {
				System.out.print("error:" + e);
			}
		}
	}
}

public class ThreadExample4 {
	public static void main(String[] args) {
		MyThread3 t = new MyThread3();
		t.start(); // 启动线程t
	}
}
