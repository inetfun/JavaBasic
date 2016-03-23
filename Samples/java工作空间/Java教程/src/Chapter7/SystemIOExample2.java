// SystemIOExample2.java
package Chapter7;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class SystemIOExample2 {
	public static void main(String args[]) throws IOException {
		// ����һ���ļ�����������������Դ��d:\test.txt�ļ�
		FileInputStream in = new FileInputStream("d:\\test.txt");
		// ����һ����������������������Դ���ļ�������
		BufferedInputStream bufin = new BufferedInputStream(in);
		// ����һ����������������������Դ�Լ���
		BufferedInputStream keyin = new BufferedInputStream(System.in);
		// ���������ֽ�����
		byte[] b1 = new byte[1024], b2 = new byte[1024];
		// �����ļ��ж�ȡ�����ݷ����ֽ�����b1�ڣ�num1Ϊ������ֽڸ���
		int num1 = bufin.read(b1);
		// ���ֽ�����ת�����ַ���
		String str1 = new String(b1, 0, num1);
		System.out.println(str1);
		// �رջ�����������ͬʱ�ر����ļ�
		bufin.close();
		// ���Ӽ��̶�ȡ�����ݷ����ֽ�����b2�ڣ�num2Ϊ������ֽڸ���
		int num2 = keyin.read(b2);
		// ���ֽ�����ת�����ַ���
		String str2 = new String(b2, 0, num2);
		System.out.println(str2);
	}
}