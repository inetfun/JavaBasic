//Example2_1.java
//������������Ȼ�����
package Chapter2; //�����������ڰ�

import java.util.Scanner;

public class Example2_1 {
	public static void main(String[] args) {
		int x, y, z; // ������������
		System.out.println("����������������");
		// Scanner���ʾһ���ı�ɨ������������ɨ��Ӽ�����������ַ�
		Scanner in = new Scanner(System.in); // ����Scanner�ഴ��in����
		x = in.nextInt();// ����nextInt()���ؼ����������һ������
		y = in.nextInt();
		z = x + y;
		System.out.println(x + "+" + y + "=" + z);
	}
}
