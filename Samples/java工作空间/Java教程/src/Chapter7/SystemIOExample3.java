// SystemIOExample3.java
package Chapter7;

import java.io.*;

public class SystemIOExample3 {
	public static void main(String[] args) throws IOException {
		// �����ļ�����ֽ���������Ŀ��Ϊd:\test.txt�ļ���������ļ�
		// �Ѵ��ڣ���ɾ�����½����ļ������򣬽��½����ļ�
		FileOutputStream out = new FileOutputStream("d:\\test.txt");
		// ������������ֽ���������Ŀ��Ϊ�ļ�����ֽ�������
		BufferedOutputStream buffer_out = new BufferedOutputStream(out);
		// Ҫд���ļ�������
		String s = "These will be writed to d:\\test.txt file!\r\n";
		// ���ַ���s���������ֽ���ʽд�뻺����buffer_out��ʵ���ϣ�Ҳ�ͼ��
		// д�뵽��d:\test.txt�ļ��С�getBytes()ΪString��ķ������������ǽ�
		// �ַ���ת��Ϊ�ֽ�����
		buffer_out.write(s.getBytes());
		buffer_out.write(s.getBytes());
		buffer_out.write(s.getBytes());
		buffer_out.write(s.getBytes());
		buffer_out.flush(); // ��ջ�����
		buffer_out.close(); // �رջ�����������ͬʱ�ر����ļ�
		// �����ļ���������������Դ���ļ�d:\test.txt
		FileInputStream in = new FileInputStream("d:\\test.txt");
		// ���ļ���������װ�ɻ������������ļ��������ȶ��뻺����
		BufferedInputStream buffer_in = new BufferedInputStream(in);
		byte[] b = new byte[1024];
		// �����ݶ����ֽ�����b�ڣ�numΪ������ֽڸ���
		int num = buffer_in.read(b);
		// ���ֽ�����ת�����ַ���
		String str = new String(b, 0, num);
		System.out.println(str);// �������Ľ��
		buffer_in.close();// �رջ�����������ͬʱ�ر����ļ�
	}
}
