// LoginMain.java
package Chapter6;

import java.util.Scanner;

public class LoginMain {
	public static void main(String[] args) {
		Validate test = new Validate();
		System.out.println("�������û�����");
		Scanner inAccount = new Scanner(System.in);
		test.setAccount(inAccount.nextLine()); // Ϊ�û���������ֵ
		System.out.println("���������룺");
		Scanner inPassword = new Scanner(System.in);
		test.setPassword(inPassword.nextLine()); // Ϊ���������ֵ
		try {
			test.login(test.getAccount(), test.getPassword()); // ���÷���������֤
			System.out.println("��¼�ɹ���");
		} catch (PasswordIncorrectException e) { // �������벻��ȷ�쳣
			System.out.println("��׽���벻��ȷ�쳣\n" + e);
		} catch (AccountNotExistException e) { // �����û����������쳣
			System.out.println("��׽�˻�����ȷ�쳣��\n" + e);
		}
	}
}
