// ShowDays.java
package Chapter2;

import java.util.Scanner;

public class ShowDays {
	public static void main(String[] args) {
		System.out.println("��������ݣ�");
		Scanner inYear = new Scanner(System.in);
		int year = inYear.nextInt(); // ������
		System.out.println("�������·ݣ�");
		Scanner inMonth = new Scanner(System.in);
		int month = inMonth.nextInt(); // �����·�
		int numDays = 0;
		switch (month) { // ���·���Ϊ��֧����
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			numDays = 31; // 1��3��5��7��8��10��12������Ϊ31
			break; // ����switch���
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30; // 4��6��9��11������Ϊ30
			break;
		case 2: // ����2�£������Ƿ�Ϊ�����жϵ�������
			if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)) {
				numDays = 29;
			} else {
				numDays = 28;
			}
			break;
		}
		System.out.println(year + "��" + month + "�·�" + " ��" + numDays + " ��");
	}
}
