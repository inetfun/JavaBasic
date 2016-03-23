//Exception5.java
package Chapter6;

public class Exception5 {
	public static void main(String args[]) {
		try {
			int i = args.length; // i值存储main()方法数组参数的长度
			System.out.println("i=" + i);
			int j = 5 / i;
			int k[] = { 1, 2, 3 };
			k[3] = 5;
		} catch (ArithmeticException e) {
			System.out.println("除数不能为零：" + e);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("数组下标越界：" + e);
		}
		System.out.println("执行catch语句后的代码块！");
	}
}
