// Exception2.java
package Chapter6;

import java.io.*;

class Exception2 {
	public static void main(String args[]) throws FileNotFoundException,
			IOException {
		// ����FileInputStream����
		FileInputStream fis = new FileInputStream("text.txt");
		int b;
		while ((b = fis.read()) != -1) { // ���ļ��ֽ�������Чʱѭ��
			System.out.print(b); // ��ʾ�������ֽ�����
		}
		fis.close(); // �ر��ļ�
		System.out.println("������������");
	}
}
