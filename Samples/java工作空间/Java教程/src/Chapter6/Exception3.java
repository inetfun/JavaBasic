//Exception3.java
package Chapter6;

import java.io.*;

public class Exception3 {
	public static void main(String args[]) {
		// try����飬���п��ܻ�����쳣
		try {
			FileInputStream fis = new FileInputStream("text.txt");
			int b;
			while ((b = fis.read()) != -1) {
				System.out.print(b);
			}
			fis.close();
		} catch (FileNotFoundException e) {
			// ����catch��䲶׽FileNotFoundException�쳣������
			// FileNotFoundExceptionΪ�쳣���ͣ�eΪ�쳣����
			System.out.println(e);
			System.out.println("message���쳣��ʾ��: " + e.getMessage());
		} catch (IOException e) {
			// ����catch��䲶׽IOException�쳣������
			System.out.println(e);
		}
		System.out.println("������������");
	}
}
