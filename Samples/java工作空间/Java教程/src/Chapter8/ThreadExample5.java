// ThreadExample5.java
package Chapter8;

class MyThread4 extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.print(i);
			yield(); // 线程让步
		}
	}
}

public class ThreadExample5 {
	public static void main(String[] args) {
		MyThread4 t1 = new MyThread4();
		MyThread4 t2 = new MyThread4();
		t1.start(); // 启动线程t1
		t2.start(); // 启动线程t2
	}
}
