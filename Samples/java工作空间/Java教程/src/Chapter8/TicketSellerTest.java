// TicketSellerTest.java
package Chapter8;

public class TicketSellerTest implements Runnable {
	static Thread MrZhang, MrLi;
	static TicketSeller MissWang;

	public void run() {
		if (Thread.currentThread() == MrZhang) { // 判断当前的线程

			MissWang.sellRegulate(20); // 调用买票的方法
		} else if (Thread.currentThread() == MrLi) {

			MissWang.sellRegulate(5);
		}
	}

	public static void main(String[] args) {
		TicketSellerTest t = new TicketSellerTest();
		MrZhang = new Thread(t);
		MrLi = new Thread(t);
		MissWang = new TicketSeller();
		MrZhang.start(); // 启动张先生的线程
		MrLi.start(); // 启动李先生的线程
	}
}
