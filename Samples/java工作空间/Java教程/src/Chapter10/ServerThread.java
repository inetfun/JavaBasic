// ServerThread.java
package Chapter10;

import java.io.*;
import java.net.*;

public class ServerThread extends Thread {
	DatagramSocket socket = null;
	BufferedReader in = null;
	boolean moreQuotes = true;
	int number = 0; // ��������ߵ�����

	public ServerThread() throws IOException {
		this("ServerThread");
	}

	public ServerThread(String name) throws IOException {
		super(name);
		// ����DatagramSocket����
		socket = new DatagramSocket(2556);
	}

	public void run() {
		while (moreQuotes) {
			try {
				byte[] buf = new byte[256];
				// ����DatagramPacket����
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet); // �������˽������ݱ�
				String quote = null;
				number++;
				quote = "Hi�����ǵ�" + number + "��������";
				buf = quote.getBytes(); // ���ַ���ת�����ֽ�����
				InetAddress address = packet.getAddress(); // ��ȡ�ͻ��˵�IP��ַ
				int port = packet.getPort(); // ��ȡ�ͻ��˵Ķ˿ں�
				packet = new DatagramPacket(buf, buf.length, address, port);
				socket.send(packet); // �������������ݱ�
			} catch (IOException e) {
				System.out.println("error:" + e);
				moreQuotes = false;
			}
		}
		socket.close();
	}
}
