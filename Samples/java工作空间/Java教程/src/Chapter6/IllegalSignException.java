// IllegalSignException.java
package Chapter6;

// 自定义异常类，当输入的运算符不是合法的运算符时抛出此异常
public class IllegalSignException extends Exception {
	private String message;

	public IllegalSignException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
