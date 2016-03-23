// Server.java
package Chapter10;

import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) {
		ServerSocket server = null; // 声明ServerSocket对象
		Socket you; // 声明Socket对象
		String serverInfo = null; // 定义服务器收到的信息
		DataOutputStream out = null;
		DataInputStream in = null;
		try {
			server = new ServerSocket(4212); // 创建ServerSocket对象
		} catch (IOException e) {
			System.out.println("error:" + e);
		}
		try {
			you = server.accept(); // 监听客户端的请求
			in = new DataInputStream(you.getInputStream());
			out = new DataOutputStream(you.getOutputStream());
			// 每隔800毫秒从输出流读取数据，并向客户端写数据
			for (int i = 0; i < 4; i++) {
				serverInfo = in.readUTF(); // 读取客户端的数据
				// 向客户端写数据
				out.writeUTF("你好，我是服务器，你的请求是：" + serverInfo);
				System.out.println("服务器收到：" + serverInfo);
				Thread.sleep(800); // 线程休眠
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
