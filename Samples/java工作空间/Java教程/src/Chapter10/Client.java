// Client.java
package Chapter10;

import java.io.*;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		String clientInfo = null; // 定义客户端收到的信息
		Socket mySocket; // 声明socket对象
		DataInputStream in = null; // 声明数据输入流
		DataOutputStream out = null; // 声明数据输出流
		try {

			mySocket = new Socket("localhost", 4212); // 创建本地主机的Socket对象
			in = new DataInputStream(mySocket.getInputStream());
			out = new DataOutputStream(mySocket.getOutputStream());
			out.writeUTF("你好！"); // 向服务器输出 “你好”
			// 每隔800毫秒从输入流中读取数据，并向服务器端写随机数
			for (int i = 0; i < 4; i++) {
				clientInfo = in.readUTF(); // 读取服务器端的数据
				out.writeUTF(":" + Math.random()); // 向服务器写随机数
				System.out.println("客户端收到：" + clientInfo);
				Thread.sleep(800); // 线程休眠800毫秒
			}
			out.close(); // 关闭输出流
			in.close(); // 关闭输入流
			mySocket.close(); // 关闭客户端socket
		} catch (IOException e) {
			System.out.println("无法连接");
		} catch (InterruptedException e) {
		}
	}
}
