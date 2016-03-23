// Validate.java
package Chapter6;

public class Validate {
	private String account, password; // �����û���������

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void login(String account, String password) // ��֤�û����������Ƿ���ȷ
			throws AccountNotExistException, PasswordIncorrectException {
		if (!validateAccout(account)) {
			throw new AccountNotExistException("�˺Ų�����");
		}
		if (!validatePassword(account, password)) {
			throw new PasswordIncorrectException("���벻��ȷ");
		}
	}

	// ��֤�˺��Ƿ����
	private boolean validateAccout(String account) {
		if (account.equals("aaa")) {
			return true;
		}
		return false;
	}

	// ��֤�����Ƿ���ȷ
	private boolean validatePassword(String account, String password) {
		if (account.equals("aaa") && password.equals("111")) {
			return true;
		}
		return false;
	}
}
