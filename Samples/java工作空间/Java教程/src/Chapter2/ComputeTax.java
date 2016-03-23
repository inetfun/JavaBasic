// ComputeTax.java
package Chapter2;

import java.util.Scanner;

public class ComputeTax {
	public static void main(String[] args) {
		double income = 0.0; // 定义可征税收入
		int status = 0; // 定义纳税人的情况
		double tax = 0; // 定义税额
		// 提示用户输入纳税人的类型
		System.out.println("请输入纳税人的类型:0-单身，1-已婚，2-家庭");
		Scanner inStatus = new Scanner(System.in);
		// 方法hasNextInt()判断扫描器的输入内容是否可以解释为int型数据
		if (inStatus.hasNextInt()) {
			// 方法nextInt()将输入信息扫描为一个int型数据
			status = inStatus.nextInt(); // 输入纳税人的类型
		}
		System.out.println("请输入可征税收入：");
		Scanner in = new Scanner(System.in);
		if (in.hasNextDouble()) {
			income = in.nextDouble(); // 输入可征税收入
		}
		if (status == 0) { // 计算单身纳税人的缴纳税额
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
		} else if (status == 1) { // 计算已婚纳税人的缴纳税额
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
		} else if (status == 2) { // 计算家庭纳税人的缴纳税额
			// ……
		}
		System.out.println("纳税人需要缴纳的税额为" + tax + "￥");
	}
}
