//Exception6.java
package Chapter6;

public class Exception6 {
	public static void main(String args[]) {
		try {
			int a[] = new int[4];
			a[4] = 2;
		} catch (ArithmeticException e) {
			System.out.println(e);
		} finally {
			System.out.println("finally语句总被执行！");
		}
		System.out.println("程序正常终止！");
	}
}
