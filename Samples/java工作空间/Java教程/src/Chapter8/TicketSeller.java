// TicketSeller.java
package Chapter8;

public class TicketSeller {
	int sumFive = 2, sumTwenty = 0; // ����5ԪǮ��20ԪǮ�ĸ���

	public synchronized void sellRegulate(int money) {
		if (money == 5) {
			System.out.println("������������Ǯ�����á�");
		} else if (money == 20) {
			while (sumFive < 3) {
				try {
					wait(); // ���5Ԫ�ĸ�������3�ţ����̵߳ȴ�
				} catch (InterruptedException e) {
				}
				sumFive = sumFive - 3;
				sumTwenty = sumTwenty + 1;
				System.out.println("��������������20Ԫ������15Ԫ��");
			}
		}
		notifyAll(); // ֪ͨ�ȴ����߳�
	}
}
