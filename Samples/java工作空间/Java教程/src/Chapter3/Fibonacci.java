// Fibonacci.java
package Chapter3;

public class Fibonacci {
	public static long fib_1(int n) { // 定义实现递归算法的方法
		long f1, f2;
		if (n == 0 || n == 1) { // 如果n=0或n=1返回n
			return n;
		} else {
			f1 = fib_1(n - 1);
			f2 = fib_1(n - 2);
			return (f1 + f2); // 否则返回fib（n-1）+fib（n-2）
		}
	}

	public static long fib_2(int n) { // 定义实现循环算法的方法
		long f1 = 0, f2 = 1;
		long sum = 0;
		if (n == 0 || n == 1) {
			return n;
		}
		for (int i = 1; i < n; i++) {
			sum = f1 + f2;
			f1 = f2;
			f2 = sum;
		}
		return sum;
	}

	// 循环输出1~10月份的兔子总数
	public static void main(String[] args) {
		System.out.println("递归实现：");
		for (int i = 1; i < 11; i++) {
			System.out.print(fib_1(i) + ",");
		}
		System.out.println("\n循环实现：");
		for (int i = 1; i < 11; i++) {
			System.out.print(fib_2(i) + ",");
		}
	}
}
