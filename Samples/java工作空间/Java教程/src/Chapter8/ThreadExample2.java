// ThreadExample2.java
package Chapter8;

class MyThread1 implements Runnable { // 实现Runnable接口创建线程类MyThread
	public void run() { // 实现Runnable接口的run()方法
		for (int i = 0; i < 9; i++) {
			System.out.print(i + "  ");
		}
	}
}

public class ThreadExample2 {
	public static void main(String args[]) {
		MyThread1 mt = new MyThread1(); // 创建线程类MyThread的实例t
		Thread t = new Thread(mt); // 创建Thread类的实例t
		t.start(); // 启动线程
	}
}
