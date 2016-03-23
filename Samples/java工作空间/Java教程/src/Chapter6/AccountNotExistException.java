// AccountNotExistException.java
package Chapter6;

public class AccountNotExistException extends Exception { // ºÃ≥–Exception¿‡
	public AccountNotExistException() {
	}

	public AccountNotExistException(String message) {
		super(message);
	}
}
