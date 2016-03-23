// ChatClient.java
package Chapter10;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ChatClient extends Frame implements ActionListener {
	Label lb = new Label("聊天"); // 创建标签
	Panel pn = new Panel(); // 创建窗口
	TextField tf = new TextField(10); // 创建文本框
	TextArea ta = new TextArea(); // 创建文本区
	Socket client; // 定义socket对象
	InputStream in;
	OutputStream out;

	public ChatClient() {
		super("客户机");
		this.setSize(250, 250); // 设置窗口大小
		pn.add(lb); // 添加标签到面板
		pn.add(tf); // 添加文本框到面板
		tf.addActionListener(this); // 对文本框注册事件监听器
		this.add("North", pn); // 设置面板的位置
		this.add("Center", ta); // 设置文本区的位置
		// 接收窗口事件的监听器，并以窗口事件的适配器作为参数
		this.addWindowListener(new WindowAdapter() { // 关闭窗口
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
		setVisible(true); // 显示窗口
		try {
			client = new Socket(InetAddress.getLocalHost(), 5007);
			// 文本区显示连接的服务器主机名
			ta.append("已连接的服务器：" + client.getInetAddress().getHostName()
					+ "\n\n");
			in = client.getInputStream();
			out = client.getOutputStream();
		} catch (IOException e) {
			System.out.println("error:" + e);
		}
		// 循环接收服务器端发送的信息并显示在文本区
		while (true) {
			try {
				byte[] buf = new byte[256];
				in.read(buf);
				String str = new String(buf); // 将字节数组转换为字符串
				ta.append("服务器说：" + str); // 文本区显示服务器发来的内容
				ta.append("\n");
			} catch (IOException e) {
				System.out.println("error:" + e);
			}
		}
	}

	public void actionPerformed(ActionEvent e) { // 实现接口ActionListener的方法
		try {
			String str = tf.getText(); // 得到文本框输入的内容
			byte[] buf = str.getBytes(); // 将字符串转换为字节数组
			tf.setText(null); // 设置文本框显示为空
			out.write(buf); // 向服务器端发送内容
			ta.append("我说：" + str); // 在文本区中显示发送内容
			ta.append("\n");
		} catch (IOException e1) {
			System.out.println("error:" + e1);
		}
	}

	public static void main(String[] args) {
		new ChatClient();
	}
}
