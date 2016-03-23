// PrimeNumber.java
package Chapter2;

public class PrimeNumber {
	public static void main(String[] args) {
		final int NUMBER_OF_PRIME = 30; // 定义显示的总数量
		final int NUMBER_OF_PRIME_PERLINE = 10; // 定义一行显示的数量
		int count = 0; // 记录素数的计数器
		int number = 2; // 定义数字变量
		System.out.println("前30个素数是：");
		while (count < NUMBER_OF_PRIME) {
			boolean isPrime = true; // 定义素数的标识变量
			// 循环找出素数
			for (int divisor = 2; divisor <= number / 2; divisor++) {
				if (number % divisor == 0) { // 当数字不是素数时
					isPrime = false; // 改变素数标识的状态
					break; // 跳出循环
				}
			}
			if (isPrime) { // 如果是素数
				count++; // 计数器加1
				// 如果素数的数量是10的倍数，则输出素数，并转换到新一行输出
				if (count % NUMBER_OF_PRIME_PERLINE == 0) {
					System.out.println(number);
				} else
					System.out.print(number + " ");
			}
			number++;
		}
	}
}
