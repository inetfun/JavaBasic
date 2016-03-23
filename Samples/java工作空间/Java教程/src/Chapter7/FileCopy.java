// FileCopy.java
package Chapter7;

import java.io.*;
import java.util.Scanner;

public class FileCopy {
	public static void copyFile(String sourceFileName, String targetFileName)
			throws IOException {
		File sourceFile = new File(sourceFileName); // ����Դ�ļ�
		File targetFile = new File(targetFileName); // ����Ŀ���ļ�
		// ��֤Դ�ļ��Ƿ����
		if (!sourceFile.exists()) {
			System.out.println("�ļ�����ʧ�ܣ�Դ�ļ�" + sourceFile.getName() + "������");
			return;
		}
		// ��֤Ŀ���ļ��Ƿ�ΪĿ¼
		if (targetFile.isDirectory()) {
			// ���ΪĿ¼�����޸�Ŀ���ļ���·��������
			targetFile = new File(targetFile, sourceFile.getName());
		}
		// ���Ŀ���ļ�����
		if (targetFile.exists()) {
			// ѯ���û��Ƿ񸲸�Ŀ���ļ�
			System.out.println("�ļ����и��ƣ��Ƿ񸲸������ļ�" + targetFile.getName()
					+ "?(Y/N):");
			// �Ա�׼���봴���ַ�������
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));
			String override = in.readLine(); // �洢�û�������ֵ
			// ȡ������
			if (!override.equalsIgnoreCase("Y")) {
				System.out.println("������ȡ��!");
				return;
			}
		}
		/* �����ļ� */
		FileInputStream in = null;
		FileOutputStream out = null;
		in = new FileInputStream(sourceFile); // ����Դ�ļ�������
		out = new FileOutputStream(targetFile); // ����Ŀ���ļ������
		byte[] buffer = new byte[8]; // ����������
		int num;
		/* ѭ����ȡԴ�ļ����ݲ�д��Ŀ���ļ� */
		while ((num = in.read(buffer)) != -1)
			out.write(buffer, 0, num);
		System.out.println("�ļ����Ƴɹ���");
		System.out.println("Դ�ļ���" + sourceFile.getPath());
		System.out.println("Ŀ���ļ���" + targetFile.getPath());
		// �ر�Դ�ļ���Ŀ���ļ�
		in.close();
		out.close();
	}

	public static void main(String[] args) throws IOException {
		String SrcFileName, DesFileName;
		Scanner in = new Scanner(System.in);
		System.out.println("������Դ�ļ����� ");
		SrcFileName = in.nextLine();
		System.out.println("������Ŀ���ļ����� ");
		DesFileName = in.nextLine();
		// ���ø����ļ�����copyFile
		FileCopy.copyFile(SrcFileName, DesFileName);
	}
}
