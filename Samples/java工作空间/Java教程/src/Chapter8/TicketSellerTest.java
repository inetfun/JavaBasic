// TicketSellerTest.java
package Chapter8;

public class TicketSellerTest implements Runnable {
	static Thread MrZhang, MrLi;
	static TicketSeller MissWang;

	public void run() {
		if (Thread.currentThread() == MrZhang) { // �жϵ�ǰ���߳�

			MissWang.sellRegulate(20); // ������Ʊ�ķ���
		} else if (Thread.currentThread() == MrLi) {

			MissWang.sellRegulate(5);
		}
	}

	public static void main(String[] args) {
		TicketSellerTest t = new TicketSellerTest();
		MrZhang = new Thread(t);
		MrLi = new Thread(t);
		MissWang = new TicketSeller();
		MrZhang.start(); // �������������߳�
		MrLi.start(); // �������������߳�
	}
}
