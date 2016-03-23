// Fibonacci.java
package Chapter3;

public class Fibonacci {
	public static long fib_1(int n) { // ����ʵ�ֵݹ��㷨�ķ���
		long f1, f2;
		if (n == 0 || n == 1) { // ���n=0��n=1����n
			return n;
		} else {
			f1 = fib_1(n - 1);
			f2 = fib_1(n - 2);
			return (f1 + f2); // ���򷵻�fib��n-1��+fib��n-2��
		}
	}

	public static long fib_2(int n) { // ����ʵ��ѭ���㷨�ķ���
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

	// ѭ�����1~10�·ݵ���������
	public static void main(String[] args) {
		System.out.println("�ݹ�ʵ�֣�");
		for (int i = 1; i < 11; i++) {
			System.out.print(fib_1(i) + ",");
		}
		System.out.println("\nѭ��ʵ�֣�");
		for (int i = 1; i < 11; i++) {
			System.out.print(fib_2(i) + ",");
		}
	}
}
