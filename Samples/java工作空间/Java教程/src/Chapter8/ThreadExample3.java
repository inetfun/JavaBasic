// ThreadExample3.java
package Chapter8;

class MyThread2 extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i + " " + getName() + "优先级是：" + getPriority());
		}
	}
}

public class ThreadExample3 {
	public static void main(String args[]) {
		MyThread2 t1 = new MyThread2(); // 创建线程类MyThread2的实例t1
		MyThread2 t2 = new MyThread2(); // 创建线程类MyThread2的实例t2
		t1.setPriority(1); // 设置线程t1的优先级为1
		t2.setPriority(10); // 设置线程t2的优先级为10
		t1.start(); // 启动线程t1
		t2.start(); // 启动线程t2
	}
}
