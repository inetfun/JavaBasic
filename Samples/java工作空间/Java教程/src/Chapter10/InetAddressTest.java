// InetAddressTest.java
package Chapter10;

import java.net.InetAddress;

public class InetAddressTest {
	public static void main(String[] args) throws Exception {
		InetAddress ia;
		// ��ñ���������InetAddress����
		ia = InetAddress.getLocalHost();
		// �����������IP��ַ
		System.out.println("��������IP��ַ:" + ia.getHostAddress());
		// �������������
		System.out.println("������������" + ia.getHostName());
		// ��ðٶ���������InetAddress����
		ia = InetAddress.getByName("www.baidu.com");
		// ����ٶ�������IP��ַ
		System.out.println("�ٶ�������IP��ַ:" + ia.getHostAddress());
		// ����ٶ���������
		System.out.println("�ٶ�����������" + ia.getHostName());
	}
}
