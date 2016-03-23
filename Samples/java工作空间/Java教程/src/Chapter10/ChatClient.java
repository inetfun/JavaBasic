// ChatClient.java
package Chapter10;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ChatClient extends Frame implements ActionListener {
	Label lb = new Label("����"); // ������ǩ
	Panel pn = new Panel(); // ��������
	TextField tf = new TextField(10); // �����ı���
	TextArea ta = new TextArea(); // �����ı���
	Socket client; // ����socket����
	InputStream in;
	OutputStream out;

	public ChatClient() {
		super("�ͻ���");
		this.setSize(250, 250); // ���ô��ڴ�С
		pn.add(lb); // ��ӱ�ǩ�����
		pn.add(tf); // ����ı������
		tf.addActionListener(this); // ���ı���ע���¼�������
		this.add("North", pn); // ��������λ��
		this.add("Center", ta); // �����ı�����λ��
		// ���մ����¼��ļ����������Դ����¼�����������Ϊ����
		this.addWindowListener(new WindowAdapter() { // �رմ���
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
		setVisible(true); // ��ʾ����
		try {
			client = new Socket(InetAddress.getLocalHost(), 5007);
			// �ı�����ʾ���ӵķ�����������
			ta.append("�����ӵķ�������" + client.getInetAddress().getHostName()
					+ "\n\n");
			in = client.getInputStream();
			out = client.getOutputStream();
		} catch (IOException e) {
			System.out.println("error:" + e);
		}
		// ѭ�����շ������˷��͵���Ϣ����ʾ���ı���
		while (true) {
			try {
				byte[] buf = new byte[256];
				in.read(buf);
				String str = new String(buf); // ���ֽ�����ת��Ϊ�ַ���
				ta.append("������˵��" + str); // �ı�����ʾ����������������
				ta.append("\n");
			} catch (IOException e) {
				System.out.println("error:" + e);
			}
		}
	}

	public void actionPerformed(ActionEvent e) { // ʵ�ֽӿ�ActionListener�ķ���
		try {
			String str = tf.getText(); // �õ��ı������������
			byte[] buf = str.getBytes(); // ���ַ���ת��Ϊ�ֽ�����
			tf.setText(null); // �����ı�����ʾΪ��
			out.write(buf); // ��������˷�������
			ta.append("��˵��" + str); // ���ı�������ʾ��������
			ta.append("\n");
		} catch (IOException e1) {
			System.out.println("error:" + e1);
		}
	}

	public static void main(String[] args) {
		new ChatClient();
	}
}
