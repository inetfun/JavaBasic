// LoanMain.java
package Chapter3;

import java.util.Scanner;
import java.text.DecimalFormat;

public class LoanMain {
	public static void main(String[] args) {
		double interestrate, loanvalue; // ����������ʺʹ�������
		int loanperiod; // �����������
		Scanner in = new Scanner(System.in);
		System.out.println("��������������ʣ�");
		interestrate = in.nextDouble(); // �����������
		System.out.println("������������ޣ�");
		loanperiod = in.nextInt(); // �����������
		System.out.println("����������ܶ");
		loanvalue = in.nextDouble(); // ��������ܶ�
		// �������������
		Loan loan = new Loan(interestrate, loanperiod, loanvalue);
		// ����DecimalFormat����df���Կ������ʱС����λ��
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("�ȶϢ����µ��¾������Ϊ��"
				+ df.format(loan.getMonthlyPayment()) + "��");
		System.out.println("����" + loanperiod + "����ܻ����Ϊ:"
				+ df.format(loan.getTotalPayment()) + "��");
	}
}
