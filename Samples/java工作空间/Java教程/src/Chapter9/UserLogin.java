// TextFieldTest.java
package Chapter9;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UserLogin {
	Frame app = new Frame("TextField ���");
	Label lblName = new Label("UserName:");
	static TextField txtName = new TextField();
	Label lblPass = new Label("Password:");
	static TextField txtPass = new TextField();

	public UserLogin() {
		app.setSize(300, 150); // ���ô���ߴ�
		app.setLayout(null); // ȡ������Ĳ��ֹ�����
		/* ������������Ӧ�ı�ǩ���ı����λ�����С */
		lblName.setBounds(60, 50, 70, 20);
		txtName.setBounds(135, 50, 100, 20);
		// Ϊ�ı�������¼�������
		txtName.addKeyListener(new keyHandler());
		txtName.addFocusListener(new focusHandler());
		/* ������������Ӧ�ı�ǩ���ı����λ�����С */
		lblPass.setBounds(60, 90, 70, 20);
		txtPass.setBounds(135, 90, 100, 20);
		txtPass.setEchoChar('*'); // ����������ı���Ļ����ַ�
		// Ϊ���������¼�������
		txtPass.addKeyListener(new keyHandler());
		txtPass.addFocusListener(new focusHandler());
		/* �������ӵ����������� */
		app.add(lblName);
		app.add(txtName);
		app.add(lblPass);
		app.add(txtPass);
		/* ���ô����λ����ɼ��� */
		app.setLocation(200, 100);
		app.setVisible(true);
	}

	public static void main(String[] args) {
		// ��������
		UserLogin tft = new UserLogin();
	}
}

// ����ʵ��keyListener�ӿڵ�keyEvent�¼�������
class keyHandler implements KeyListener {
	// ����ĳ����ʱ���ô˷���
	public void keyPressed(KeyEvent e) {
		// ��ȡ�¼�����
		Object ob = e.getSource();
		// ����¼�����ΪtxtName�����Ұ��»س��������ڿ���̨��
		// ��ʾ������û���
		if ((ob == UserLogin.txtName) && (e.getKeyCode() == 10)) {
			System.out.println(UserLogin.txtName.getText());
		}
		// ����¼�����ΪtxtPass�����Ұ��»س��������ڿ���̨����ʾ���������
		else if ((ob == UserLogin.txtPass) && (e.getKeyCode() == 10)) {
			System.out.println(UserLogin.txtPass.getText());
		}
	}

	// �ͷ�ĳ����ʱ���ô˷���
	public void keyReleased(KeyEvent e) {
	}

	// ����ĳ����ʱ���ô˷���
	public void keyTyped(KeyEvent e) {
	}
}

// ����ʵ��FocusListener�ӿڵ�FocusEvent�¼�������
class focusHandler implements FocusListener {
	// ��ȡ���̽���
	public void focusGained(FocusEvent e) {
	}

	// ʧȥ���̽���
	public void focusLost(FocusEvent e) {
		// ��ȡ�¼�����
		Object ob = e.getSource();
		// ����¼�����ΪtxtName�����ڿ���̨����ʾ������û���
		if (ob == UserLogin.txtName) {
			System.out.println(UserLogin.txtName.getText());
		}
		// ����¼�����ΪtxtPass�����ڿ���̨����ʾ���������
		else if (ob == UserLogin.txtPass) {
			System.out.println(UserLogin.txtPass.getText());
		}
	}
}