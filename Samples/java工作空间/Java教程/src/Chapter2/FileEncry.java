// FileEncry.java
package Chapter2;

import java.util.Scanner;

public class FileEncry {
	public static void main(String[] args) {
		// ��ʾ�û�������ܵ�����
		System.out.println("��������ܵ����ݣ�");
		// Scanner���ʾһ���ı�ɨ������������ɨ��Ӽ�����������ַ�
		Scanner in = new Scanner(System.in);
		// ����nextLine()���ؼ����������һ���ַ���
		String secretStr = in.nextLine();
		// ���ַ���ת��Ϊ�ַ����飬�����Ǿ�����ͬ�������͵��������ݵļ���
		char[] secretChars = secretStr.toCharArray();
		char secret = 'x'; // �ַ��������ڱ��������Կ
		// �������㣺��Ҫ���ܵ��ַ����ַ�x���а�λ�������õ�����
		System.out.print("���ģ�");
		for (int i = 0; i < secretChars.length; i++) {
			// secretChars[0]��secretChars[1]������ʾ�ַ������е�Ԫ��
			secretChars[i] = (char) (secretChars[i] ^ secret);
			System.out.print(secretChars[i]); // ��ʾ����
		}
		System.out.print("\n���ģ�");
		// �������㣺�Ѽ��ܵ��ַ��ٴ����ַ�x��λ������ȡ��ԭ��
		for (int i = 0; i < secretChars.length; i++) {
			secretChars[i] = (char) (secretChars[i] ^ secret);
			System.out.print(secretChars[i]); // ��ʾ����
		}
	}
}
