// Loan.java
package Chapter3;

public class Loan {
	private double monthlyInterestRate; // �������������
	private int numberOfMonths; // �������������
	private double loanAmount; // ��������

	// ���췽������ʼ����Ա����
	public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
		// һ������£�����˵������Ϣ��5.5����ʵ����Ӧ��5.5%����ˣ�
		// ��������ϢֵӦ�Ǹ���ֵ����100��������Ϣ����ȻӦ�ٳ���12
		this.monthlyInterestRate = annualInterestRate / (100 * 12);
		this.numberOfMonths = numberOfYears * 12;
		this.loanAmount = loanAmount;
	}

	// ���صȶϢ���ʽ�µ��¾�����ʽΪ��
	// (�����*������*(1+������)^��������)/
	// ((1+������)^��������-1)
	public double getMonthlyPayment() {
		return (loanAmount * monthlyInterestRate * Math.pow(
				1 + monthlyInterestRate, numberOfMonths))
				/ (Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1);
	}

	// ���صȶϢ���ʽ��֧�����ܱ�Ϣ
	public double getTotalPayment() {
		return getMonthlyPayment() * numberOfMonths;
	}
}
