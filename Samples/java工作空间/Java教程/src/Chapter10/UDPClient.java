// UDPClient.java
package Chapter10;

import java.io.*;
import java.net.*;

public class UDPClient {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(); // 创建DatagramSocket对象
		byte[] buf = new byte[256];
		InetAddress address = InetAddress.getByName("localhost");
		// 创建DatagramPacket对象
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address,
				2556);
		socket.send(packet); // 客户端发送数据报
		// 创建接收数据报的DatagramPacket对象
		packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet); // 客户端接收数据报
		// 将接收的数据报转换为字符串
		String recevied = new String(packet.getData());
		System.out.println("客户端接收的信息：" + recevied);
		socket.close();
	}
}
