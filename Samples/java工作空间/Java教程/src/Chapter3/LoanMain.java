// LoanMain.java
package Chapter3;

import java.util.Scanner;
import java.text.DecimalFormat;

public class LoanMain {
	public static void main(String[] args) {
		double interestrate, loanvalue; // 定义贷款利率和贷款额变量
		int loanperiod; // 定义贷款年限
		Scanner in = new Scanner(System.in);
		System.out.println("请输入贷款年利率：");
		interestrate = in.nextDouble(); // 输入贷款利率
		System.out.println("请输入贷款年限：");
		loanperiod = in.nextInt(); // 输入贷款年限
		System.out.println("请输入贷款总额：");
		loanvalue = in.nextDouble(); // 输入贷款总额
		// 创建贷款类对象
		Loan loan = new Loan(interestrate, loanperiod, loanvalue);
		// 创建DecimalFormat对象df，以控制输出时小数的位数
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("等额本息情况下的月均还款额为："
				+ df.format(loan.getMonthlyPayment()) + "￥");
		System.out.println("贷款" + loanperiod + "年的总还款额为:"
				+ df.format(loan.getTotalPayment()) + "￥");
	}
}
