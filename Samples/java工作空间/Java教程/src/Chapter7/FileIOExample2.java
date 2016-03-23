// FileIOExample2.java
package Chapter7;

import java.io.*;

public class FileIOExample2 {
	public static void readFile() throws IOException {
		// �����ļ��ַ����������󣬼���һ���ļ�
		FileReader fr = new FileReader("d:\\test.txt");
		// ����һ���ַ�����
		char data[] = new char[1024];
		// �����ݶ����ַ�����data�ڣ�numΪ�ַ�����
		int num = fr.read(data);
		// ���ַ�����ת�����ַ���
		String str = new String(data, 0, num);
		System.out.println(str);
		fr.close(); // �ر��ļ�
	}

	public static void writeFile(String s) throws IOException {
		// �����ļ��ַ���������󣬼��򿪻��½�һ���ļ�
		FileWriter fw = new FileWriter("d:\\test.txt", true);
		fw.write(s); // ���ַ���sд���ļ�
		fw.close(); // �ر��ļ�
	}

	public static void main(String[] args) throws IOException {
		// ����InputStreamReader�������������Լ���
		InputStreamReader iin = new InputStreamReader(System.in);
		// ����InputStreamReader���󴴽�BufferedReader����
		BufferedReader stdin = new BufferedReader(iin);
		// s1������ʱ�����ȡ�ĵ�ǰ�����ݣ�S2����������ն�ȡ���ַ���
		String s1 = "", s2 = "";
		// ѭ����ȡ���ݣ�
		do {
			s1 = stdin.readLine(); // ��ȡһ��
			System.out.println(s1);
			// ���û���Ctrl+Z��ϼ�ʱ��readLine()�������ص���һ��null
			// ͬʱ������������������ϡ���ˣ���ʱӦ�˳���������ѭ��
			if (s1 == null) {
				break;
			}
			// �����ĳ��ֱ�Ӱ��س����������κ����ݣ���ʱ��readLine()����
			// ��ȡ���ַ�����length()Ϊ0�������������롣��֮�����length()
			// ��Ϊ0����ʾ�����������ַ���
			if (s1.length() != 0) { // ����������ַ���
				s1 = s1 + '\r' + '\n'; // Ϊ�ַ���ĩβ���ӻس����ͻ��з�
				s2 = s2 + s1; // �����ַ������ӵ�Ŀ���ַ�����
			}
		} while (s1.length() != 0);
		writeFile(s2); // ����ȡ������д�ļ�
		readFile(); // ��ȡ�ļ�����
	}
}
