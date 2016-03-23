// TicketSeller.java
package Chapter8;

public class TicketSeller {
	int sumFive = 2, sumTwenty = 0; // 定义5元钱与20元钱的个数

	public synchronized void sellRegulate(int money) {
		if (money == 5) {
			System.out.println("李先生，您的钱数正好。");
		} else if (money == 20) {
			while (sumFive < 3) {
				try {
					wait(); // 如果5元的个数少于3张，则线程等待
				} catch (InterruptedException e) {
				}
				sumFive = sumFive - 3;
				sumTwenty = sumTwenty + 1;
				System.out.println("张先生，您给我20元，找您15元。");
			}
		}
		notifyAll(); // 通知等待的线程
	}
}
