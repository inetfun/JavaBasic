// ServerThread.java
package Chapter10;

import java.io.*;
import java.net.*;

public class ServerThread extends Thread {
	DatagramSocket socket = null;
	BufferedReader in = null;
	boolean moreQuotes = true;
	int number = 0; // 定义访问者的数量

	public ServerThread() throws IOException {
		this("ServerThread");
	}

	public ServerThread(String name) throws IOException {
		super(name);
		// 创建DatagramSocket对象
		socket = new DatagramSocket(2556);
	}

	public void run() {
		while (moreQuotes) {
			try {
				byte[] buf = new byte[256];
				// 创建DatagramPacket对象
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet); // 服务器端接收数据报
				String quote = null;
				number++;
				quote = "Hi！你是第" + number + "个访问者";
				buf = quote.getBytes(); // 把字符串转换成字节数组
				InetAddress address = packet.getAddress(); // 获取客户端的IP地址
				int port = packet.getPort(); // 获取客户端的端口号
				packet = new DatagramPacket(buf, buf.length, address, port);
				socket.send(packet); // 服务器发送数据报
			} catch (IOException e) {
				System.out.println("error:" + e);
				moreQuotes = false;
			}
		}
		socket.close();
	}
}
