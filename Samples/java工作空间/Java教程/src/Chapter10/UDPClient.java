// UDPClient.java
package Chapter10;

import java.io.*;
import java.net.*;

public class UDPClient {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(); // ����DatagramSocket����
		byte[] buf = new byte[256];
		InetAddress address = InetAddress.getByName("localhost");
		// ����DatagramPacket����
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address,
				2556);
		socket.send(packet); // �ͻ��˷������ݱ�
		// �����������ݱ���DatagramPacket����
		packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet); // �ͻ��˽������ݱ�
		// �����յ����ݱ�ת��Ϊ�ַ���
		String recevied = new String(packet.getData());
		System.out.println("�ͻ��˽��յ���Ϣ��" + recevied);
		socket.close();
	}
}
