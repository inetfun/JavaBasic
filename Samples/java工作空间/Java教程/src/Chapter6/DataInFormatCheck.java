// DataInFormatCheck.java
package Chapter6;

import java.io.*;
import java.util.*;

public class DataInFormatCheck {
	public static void main(String[] args) throws IOException {
		// ����Scanner����in
		Scanner in = new Scanner(System.in);
		// ���ÿ��Ʊ���dataright����ֵ
		boolean dataright = false;
		// ѭ������
		do {
			try {
				System.out.print("������һ��������: ");
				// ���ַ�������Ϊ�����ŵ�double��������
				double numberx = in.nextDouble();
				// ���������ȷ����ִ�����µ����
				System.out.println(numberx);
				// �޸�ѭ��������ʹѭ������
				dataright = false;
			// ��׽�������ݴ����쳣
			} catch (InputMismatchException e) {
				System.out.println("������Ч�����������룡");
				// �޸�ѭ��������ʹ֮��Ч������ѭ��
				dataright = true;
				// ��ȡ���ݻ���
				String x = in.nextLine();
			}
		} while (dataright);
	}
}