// ChatServer.java
package Chapter10;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ChatServer extends Frame implements ActionListener {
	Label lb = new Label("聊天");
	Panel pn = new Panel();
	TextField tf = new TextField(10);
	TextArea ta = new TextArea();
	ServerSocket server; // 声明ServerSocket对象
	Socket client; // 声明Socket对象
	InputStream in;
	OutputStream out;

	public ChatServer() {
		super("服务器");
		this.setSize(250, 250);
		pn.add(lb);
		pn.add(tf);
		tf.addActionListener(this); // 对文本框注册事件监听器
		this.add("North", pn);
		this.add("Center", ta);
		this.addWindowListener(new WindowAdapter() { // 接收窗口事件的监听器
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
		show();
		try {
			// ServerSocket对象
			server = new ServerSocket(5007);
			client = server.accept(); // 监听客户端发来的请求
			// 文本区显示客户端的IP地址
			ta.append("已连接的客户机：" + client.getInetAddress().getHostAddress()
					+ "\n\n");
			in = client.getInputStream();
			out = client.getOutputStream();
		} catch (IOException e) {
			System.out.println("error:" + e);
		}
		// 循环接收客户端发送的信息并显示在文本区
		while (true) {
			try {
				byte[] buf = new byte[256];
				in.read(buf);
				String str = new String(buf);
				ta.append("客户机说：" + str);
				ta.append("\n");
			} catch (IOException e) {
				System.out.println("error:" + e);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		try {
			String str = tf.getText();
			byte[] buf = str.getBytes();
			tf.setText(null);
			out.write(buf); // 向客户端发送信息
			ta.append("我说：" + str);
			ta.append("\n");
		} catch (IOException e1) {
			System.out.println("error:" + e1);
		}
	}

	public static void main(String[] args) {
		new ChatServer();
	}
}
