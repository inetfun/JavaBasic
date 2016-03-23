// FileIOExample4.java
package Chapter7;

import java.io.*;

public class FileIOExample4 {
	public static void main(String[] args) throws IOException {
		File file = new File("d:\\test.txt");
		// ����ļ��Ѵ��ڣ���ɾ�������´���һ�����ļ�
		if (file.exists()) { // �ж��ļ��Ƿ����
			file.delete(); // ������ڣ���ɾ���ļ�
		}
		file.createNewFile(); // �������ļ�
		// �Զ�д��ʽ����RandomAccessFile����
		RandomAccessFile rafile = new RandomAccessFile(file, "rw");
		// ���ļ���д���ַ�����ÿ���ַ�ռ�����ֽ�
		rafile.writeChars("Are you ready? ��׼��������");
		// ��¼��ǰָ���λ��
		long p1=rafile.getFilePointer();
		// ����ļ�ָ���λ��
		System.out.println("��ǰ�ļ�ָ��λ�ã�" + p1);
		// ���ļ���д��һ������������һ��������
		rafile.writeLong(2345);
		rafile.writeFloat(890.7F);
		// ����ļ��е��ַ���
		for (int i = 0; i < p1; i = i + 2) {
			rafile.seek(i); // ��λָ��
			// ����ļ�ָ������λ�õ��ַ�
			System.out.print(rafile.readChar());
		}
		// ���д��ĳ������͸�����
		System.out.println();
		System.out.println(rafile.readLong());
		System.out.println(rafile.readFloat());
	}
}
