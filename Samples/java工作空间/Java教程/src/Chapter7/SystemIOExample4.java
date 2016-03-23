// SystemIOExample4.java
// �������ж����ַ��������������ʾ
package Chapter7;

import java.io.*;

public class SystemIOExample4 {
	public static void main(String[] args) throws IOException {
		// ʹ��System.in����InputStreamReader����iin
		// �ö��������Ӽ��̶���һ�����ֽ��ַ�
		InputStreamReader iin = new InputStreamReader(System.in);
		// ����iin������BufferedReader����stdin
		// �ö����������ַ��������ж�ȡ�ı���������
		BufferedReader stdin = new BufferedReader(iin);
		// ��ȡ������ַ�����
		System.out.print("������һ���ַ���: ");
		System.out.println(stdin.readLine());
		boolean dataright = false;
		do {
			try {
				// ��ȡ�ַ�����ת����double�����������
				System.out.print("������һ��������: ");
				// ���ַ�������Ϊ�����ŵ�double�������ݡ����������Ч����
				// ����һ��NumberFormatException�쳣
				double numberx = Double.parseDouble(stdin.readLine());
				System.out.println(numberx);
				dataright = false;
			} catch (NumberFormatException e) {
				System.out.println("������Ч�����������룡");
				dataright = true;
			}
		} while (dataright);
	}
}