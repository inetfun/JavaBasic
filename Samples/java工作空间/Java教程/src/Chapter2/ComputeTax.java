// ComputeTax.java
package Chapter2;

import java.util.Scanner;

public class ComputeTax {
	public static void main(String[] args) {
		double income = 0.0; // �������˰����
		int status = 0; // ������˰�˵����
		double tax = 0; // ����˰��
		// ��ʾ�û�������˰�˵�����
		System.out.println("��������˰�˵�����:0-����1-�ѻ飬2-��ͥ");
		Scanner inStatus = new Scanner(System.in);
		// ����hasNextInt()�ж�ɨ���������������Ƿ���Խ���Ϊint������
		if (inStatus.hasNextInt()) {
			// ����nextInt()��������Ϣɨ��Ϊһ��int������
			status = inStatus.nextInt(); // ������˰�˵�����
		}
		System.out.println("���������˰���룺");
		Scanner in = new Scanner(System.in);
		if (in.hasNextDouble()) {
			income = in.nextDouble(); // �������˰����
		}
		if (status == 0) { // ���㵥����˰�˵Ľ���˰��
			if (income <= 6000)
				tax = income * 0.10;
			else if (income <= 27950)
				tax = 6000 * 0.10 + (income - 6000) * 0.15;
			else if (income <= 67700)
				tax = 6000 * 0.10 + (27950 - 6000) * 0.15 + (income - 27950)
						* 0.27;
			else if (income <= 141250)
				tax = 6000 * 0.10 + (27950 - 6000) * 0.15 + (67700 - 27950)
						* 0.27 + (income - 67700) * 0.30;
			else
				tax = 6000 * 0.10 + (27950 - 6000) * 0.15 + (67700 - 27950)
						* 0.27 + (141250 - 67700) * 0.30 + (income - 141250)
						* 0.35;
		} else if (status == 1) { // �����ѻ���˰�˵Ľ���˰��
			if (income <= 12000)
				tax = income * 0.10;
			else if (income <= 46700)
				tax = 12000 * 0.10 + (income - 12000) * 0.15;
			else if (income <= 112850)
				tax = 12000 * 0.10 + (46700 - 12000) * 0.15 + (income - 46700)
						* 0.27;
			else if (income <= 171950)
				tax = 12000 * 0.10 + (46700 - 12000) * 0.15 + (112850 - 46700)
						* 0.27 + (income - 112850) * 0.30;
			else
				tax = 2000 * 0.10 + (46700 - 12000) * 0.15 + (112850 - 46700)
						* 0.27 + (171950 - 112850) * 0.30 + (income - 171950)
						* 0.35;
		} else if (status == 2) { // �����ͥ��˰�˵Ľ���˰��
			// ����
		}
		System.out.println("��˰����Ҫ���ɵ�˰��Ϊ" + tax + "��");
	}
}
