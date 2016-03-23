// AccountMain.java
package Chapter7;

import java.io.*;
import java.text.*;

public class AccountMain {
	public static void main(String[] args) throws Exception {
		// getDateInstance������ȡ����/�����ı�׼���ڸ�ʽ
		DateFormat ssd = DateFormat.getDateInstance();
		File file = null;
		if (args.length > 0) {
			file = new File(args[0]); // ��main()������������File����
		} else {
			file = new File("c:\\account.txt");
		}
		// �����˻��������顣ssd�����parse�����������ַ���ת��ΪDate����
		Account[] accounts = { new Account(1, 2000.5, ssd.parse("2010-04-25")),
				new Account(2, 1000.5, ssd.parse("2010-06-25")) };
		System.out.println("���ڱ���������......");
		if (Account.writeAccount(accounts, file)) { // ����д�˻���Ϣ����
			System.out.println("���ݱ���ɹ���");
		} else {
			System.out.println("���ݱ���ʧ�ܣ�");
		}
		accounts = Account.readAccount(file); // ���ö��˻���Ϣ����
		System.out.println("���ݶ�ȡ���������ڻ�����......");
		if (accounts.length == 0) { // �ж��Ƿ����˻���Ϣ
			System.out.println("�ļ���û�����ݣ�");
		} else {
			for (int i = 0; i < accounts.length; i++) {
				System.out.println(accounts[i]); // ����˻���Ϣ
			}
			System.out.println("������ʾ������");
		}
	}
}
