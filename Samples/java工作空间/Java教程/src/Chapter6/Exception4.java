// Exception4.java
package Chapter6;

class Exception4 {
	public static void main(String args[]) {
		int a = 0;
		try {
			System.out.println(5 / a);
		} catch (ArithmeticException e) {
			System.out.println("除数不能为零！");
		}
		System.out.println("程序正常结束");
	}
}
