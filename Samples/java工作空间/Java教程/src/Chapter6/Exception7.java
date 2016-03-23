//Exception7.java
package Chapter6;

public class Exception7 {
	private static void throwException() {
		try {
			String s = null;
			if (s == null) {
				// s为null时抛出NullPointerException异常
				throw new NullPointerException("s is null");
			}
		} catch (NullPointerException e) {
			System.out
					.println("方法throwException()中抛出一个NullPointerException异常。");
			throw e; // 抛出异常e
		}
	}

	public static void main(String[] args) {
		try {
			throwException(); // 监控方法
		} catch (NullPointerException e) {
			System.out.println("捕获方法throwException()中的异常NullPointerException");
		}
	}
}
