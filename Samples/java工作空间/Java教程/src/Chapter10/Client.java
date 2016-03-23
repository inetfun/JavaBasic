// Client.java
package Chapter10;

import java.io.*;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		String clientInfo = null; // ����ͻ����յ�����Ϣ
		Socket mySocket; // ����socket����
		DataInputStream in = null; // ��������������
		DataOutputStream out = null; // �������������
		try {

			mySocket = new Socket("localhost", 4212); // ��������������Socket����
			in = new DataInputStream(mySocket.getInputStream());
			out = new DataOutputStream(mySocket.getOutputStream());
			out.writeUTF("��ã�"); // ���������� ����á�
			// ÿ��800������������ж�ȡ���ݣ������������д�����
			for (int i = 0; i < 4; i++) {
				clientInfo = in.readUTF(); // ��ȡ�������˵�����
				out.writeUTF(":" + Math.random()); // �������д�����
				System.out.println("�ͻ����յ���" + clientInfo);
				Thread.sleep(800); // �߳�����800����
			}
			out.close(); // �ر������
			in.close(); // �ر�������
			mySocket.close(); // �رտͻ���socket
		} catch (IOException e) {
			System.out.println("�޷�����");
		} catch (InterruptedException e) {
		}
	}
}
