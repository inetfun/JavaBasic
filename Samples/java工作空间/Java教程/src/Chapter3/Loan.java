// Loan.java
package Chapter3;

public class Loan {
	private double monthlyInterestRate; // 定义贷款月利率
	private int numberOfMonths; // 定义贷款总月数
	private double loanAmount; // 定义贷款额

	// 构造方法，初始化成员变量
	public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
		// 一般情况下，我们说贷款利息是5.5，它实际上应是5.5%，因此，
		// 真正的利息值应是该数值除以100。至于月息，当然应再除以12
		this.monthlyInterestRate = annualInterestRate / (100 * 12);
		this.numberOfMonths = numberOfYears * 12;
		this.loanAmount = loanAmount;
	}

	// 返回等额本息还款方式下的月均还款额公式为：
	// (贷款本金*月利率*(1+月利率)^还款月数)/
	// ((1+月利率)^还款月数-1)
	public double getMonthlyPayment() {
		return (loanAmount * monthlyInterestRate * Math.pow(
				1 + monthlyInterestRate, numberOfMonths))
				/ (Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1);
	}

	// 返回等额本息还款方式下支付的总本息
	public double getTotalPayment() {
		return getMonthlyPayment() * numberOfMonths;
	}
}
