// SystemIOExample1.java
package Chapter7;

import java.io.IOException;

public class SystemIOExample1 {
	public static void main(String[] args) throws IOException {
		int b;
		System.out.println("���������ݣ�");
		// ѭ����ȡ���ݣ����������ַ�'N'��ֹѭ��
		while ((b = System.in.read()) != 'N') {
			System.out.print((char) b);
		}
	}
}
