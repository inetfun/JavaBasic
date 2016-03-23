// FileIOExample1.java
package Chapter7;
import java.io.*;
public class FileIOExample1 {
	public static void main(String[] args) throws IOException {
		// �����ļ�����������½������ļ�d:\test.txt
		FileOutputStream out = new FileOutputStream("d:\\test.txt");
		for (int i = 0; i <= 10; i++) {
			out.write(i); 	// ���ļ���д����
		}
		out.close(); 		// �ر�����������رմ򿪵��ļ�
		// �����ļ����������󣬴��ļ�d:\test.txt
		FileInputStream in = new FileInputStream("d:\\test.txt");
		int value;
		while ((value = in.read()) != -1) { 		// ѭ����ȡ�ļ��е�����
			System.out.print(value + " "); 	// ����ļ��е�����
		}
		in.close(); 		// �ر������������رմ򿪵��ļ�
	}
}

