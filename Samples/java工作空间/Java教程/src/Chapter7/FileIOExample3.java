// FileIOExample3.java
package Chapter7;

import java.io.*;

public class FileIOExample3 {
	public static void main(String[] args) throws IOException {
		File dir = new File("c:\\xyz"); // ����file����
		if (!dir.exists()) { // �ж�c:\xyzĿ¼�Ƿ����
			dir.mkdir(); // ��������ڣ��򴴽�Ŀ¼
		}
		File file = new File("c:\\xyz", "test.txt"); // ����file����
		if (!file.exists()) { // �ж�c:\abcĿ¼�£��ļ�test.txt�Ƿ����
			file.createNewFile(); // ��������ڣ��򴴽�һ�����ļ�
		}
		System.out.println("�ļ�·����" + file.getAbsolutePath()); // ����ļ�·��
		if (file.exists()) { // �ж�c:\abcĿ¼�£��ļ�test.txt�Ƿ����
			file.delete(); // ������ڣ���ɾ��֮
		}
		if (dir.exists()) { // �ж�c:\xyzĿ¼�Ƿ����
			dir.delete(); // ������ڣ���ɾ��֮
		}
		if (dir.exists()) { // �ж�c:\xyzĿ¼�Ƿ����
			System.out.println("c:\\xyzĿ¼���ڣ�");
		} else {
			System.out.println("c:\\xyzĿ¼�����ڣ�");
		}
	}
}
