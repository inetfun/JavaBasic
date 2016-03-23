// ThreadExample1.java
package Chapter8;

class MyThread extends Thread { // 继承Thread类创建线程类MyThread
	public void run() { // 重写Thread类的run()方法
		for (int i = 0; i < 10; i++) {
			System.out.print(i+"  "); // 打印0~9之间的数字
		}
	}
}

public class ThreadExample1 {
	public static void main(String args[]) {
		MyThread t = new MyThread(); // 创建线程类MyThread的实例t
		t.start(); // 启动线程
	}
}
