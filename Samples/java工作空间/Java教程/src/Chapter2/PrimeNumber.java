// PrimeNumber.java
package Chapter2;

public class PrimeNumber {
	public static void main(String[] args) {
		final int NUMBER_OF_PRIME = 30; // ������ʾ��������
		final int NUMBER_OF_PRIME_PERLINE = 10; // ����һ����ʾ������
		int count = 0; // ��¼�����ļ�����
		int number = 2; // �������ֱ���
		System.out.println("ǰ30�������ǣ�");
		while (count < NUMBER_OF_PRIME) {
			boolean isPrime = true; // ���������ı�ʶ����
			// ѭ���ҳ�����
			for (int divisor = 2; divisor <= number / 2; divisor++) {
				if (number % divisor == 0) { // �����ֲ�������ʱ
					isPrime = false; // �ı�������ʶ��״̬
					break; // ����ѭ��
				}
			}
			if (isPrime) { // ���������
				count++; // ��������1
				// ���������������10�ı������������������ת������һ�����
				if (count % NUMBER_OF_PRIME_PERLINE == 0) {
					System.out.println(number);
				} else
					System.out.print(number + " ");
			}
			number++;
		}
	}
}
