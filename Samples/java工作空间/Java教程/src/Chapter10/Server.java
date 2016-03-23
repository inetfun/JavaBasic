// Server.java
package Chapter10;

import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) {
		ServerSocket server = null; // ����ServerSocket����
		Socket you; // ����Socket����
		String serverInfo = null; // ����������յ�����Ϣ
		DataOutputStream out = null;
		DataInputStream in = null;
		try {
			server = new ServerSocket(4212); // ����ServerSocket����
		} catch (IOException e) {
			System.out.println("error:" + e);
		}
		try {
			you = server.accept(); // �����ͻ��˵�����
			in = new DataInputStream(you.getInputStream());
			out = new DataOutputStream(you.getOutputStream());
			// ÿ��800������������ȡ���ݣ�����ͻ���д����
			for (int i = 0; i < 4; i++) {
				serverInfo = in.readUTF(); // ��ȡ�ͻ��˵�����
				// ��ͻ���д����
				out.writeUTF("��ã����Ƿ���������������ǣ�" + serverInfo);
				System.out.println("�������յ���" + serverInfo);
				Thread.sleep(800); // �߳�����
			}
			in.close();
			out.close();
			you.close();
			server.close();
		} catch (IOException e) {
			System.out.println("error:" + e);
		} catch (InterruptedException e) {
		}
	}
}
