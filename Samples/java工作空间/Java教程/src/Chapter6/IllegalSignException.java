// IllegalSignException.java
package Chapter6;

// �Զ����쳣�࣬���������������ǺϷ��������ʱ�׳����쳣
public class IllegalSignException extends Exception {
	private String message;

	public IllegalSignException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
