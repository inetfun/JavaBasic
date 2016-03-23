// PassValue.java
package Chapter3;

public class PassValue {
	static void doPower(int i, int j) {
		i += 5;
		j *= 3;
		System.out.println("传递之后i和j的数值分别是：" + i + "," + j);
	}

	public static void main(String[] args) {
		int a = 25, b = 5;
		System.out.println("传递之前a和b的数值分别是：" + a + "," + b);
		doPower(a, b); // 调用方法
		System.out.println("传递之后a和b的数值分别是：" + a + "," + b);
	}
}
