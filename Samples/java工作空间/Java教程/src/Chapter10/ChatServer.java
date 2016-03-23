// ChatServer.java
package Chapter10;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ChatServer extends Frame implements ActionListener {
	Label lb = new Label("����");
	Panel pn = new Panel();
	TextField tf = new TextField(10);
	TextArea ta = new TextArea();
	ServerSocket server; // ����ServerSocket����
	Socket client; // ����Socket����
	InputStream in;
	OutputStream out;

	public ChatServer() {
		super("������");
		this.setSize(250, 250);
		pn.add(lb);
		pn.add(tf);
		tf.addActionListener(this); // ���ı���ע���¼�������
		this.add("North", pn);
		this.add("Center", ta);
		this.addWindowListener(new WindowAdapter() { // ���մ����¼��ļ�����
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
		show();
		try {
			// ServerSocket����
			server = new ServerSocket(5007);
			client = server.accept(); // �����ͻ��˷���������
			// �ı�����ʾ�ͻ��˵�IP��ַ
			ta.append("�����ӵĿͻ�����" + client.getInetAddress().getHostAddress()
					+ "\n\n");
			in = client.getInputStream();
			out = client.getOutputStream();
		} catch (IOException e) {
			System.out.println("error:" + e);
		}
		// ѭ�����տͻ��˷��͵���Ϣ����ʾ���ı���
		while (true) {
			try {
				byte[] buf = new byte[256];
				in.read(buf);
				String str = new String(buf);
				ta.append("�ͻ���˵��" + str);
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
			out.write(buf); // ��ͻ��˷�����Ϣ
			ta.append("��˵��" + str);
			ta.append("\n");
		} catch (IOException e1) {
			System.out.println("error:" + e1);
		}
	}

	public static void main(String[] args) {
		new ChatServer();
	}
}
