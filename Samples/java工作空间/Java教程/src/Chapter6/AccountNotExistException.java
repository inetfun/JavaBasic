// AccountNotExistException.java
package Chapter6;

public class AccountNotExistException extends Exception { // �̳�Exception��
	public AccountNotExistException() {
	}

	public AccountNotExistException(String message) {
		super(message);
	}
}
