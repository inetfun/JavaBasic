// SystemIOExample5.java
package Chapter7;

import java.io.*;
import java.util.*;

public class SystemIOExample5 {
	public static void main(String[] args) throws IOException {
		float numberx = 0; // ����ĸ�����
		// ����Scanner����in������������InputStream�����System.in������������
		Scanner in = new Scanner(System.in);
		System.out.println("������һ�鸡������������������" + 
				"���ַ�����Ctrl+Z�������룡 ");
		// �����������Ǹ���������ѭ����
		while (in.hasNextFloat()) {
			// ���븡���������
			numberx = in.nextFloat();
			System.out.print(numberx + "  ");
		}
	}
}
