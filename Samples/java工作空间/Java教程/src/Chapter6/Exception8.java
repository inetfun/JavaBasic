//Exception8.java
package Chapter6;

public class Exception8 {
	// 声明抛出异常IllegalAccessException
	private static void throwException() throws IllegalAccessException {
		throw new IllegalAccessException("非法访问异常");
	}

	public static void main(String[] args) {
		try {
			throwException(); // 监控方法
		} catch (IllegalAccessException e) {
			System.out.println("捕获" + e);
		}
		System.out.println("程序正常结束");
	}
}
