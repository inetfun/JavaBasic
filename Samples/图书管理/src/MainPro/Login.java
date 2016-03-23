// Login.java
package MainPro;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.JOptionPane;

import PublicModule.*;

public class Login extends Frame {
	private static final long serialVersionUID = -1758475247807861408L;
	TextField text_user;
	TextField text_pass;

	public Login() {
		this.setTitle("��¼");
		this.setLayout(null);
		this.setSize(260, 170);
		/* ��ӱ�ǩ���ı��� */
		Label lbUser = new Label("�û�����");
		Label lbPass = new Label("��    �룺");
		Button btn_ok = new Button("ȷ��");
		Button btn_cancel = new Button("ȡ��");
		text_pass = new TextField();
		text_user = new TextField();
		lbUser.setBounds(40, 53, 60, 20);
		lbPass.setBounds(40, 83, 60, 20);
		text_user.setBounds(100, 50, 120, 20);
		text_pass.setBounds(100, 80, 120, 20);
		btn_ok.setBounds(45, 120, 80, 25); // ȷ����ť
		btn_ok.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_okActionPerformed(e);
			}
		}));
		btn_cancel.setBounds(135, 120, 80, 25); // ȡ����ť
		btn_cancel.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DbOp.Close(); // �ر����ݿ�
				System.exit(0);
			}
		}));
		/* �رմ��� */
		this.addWindowListener(new WindowAdapter() {
			// ��дwindowClosing()����
			public void windowClosing(WindowEvent e) {
				DbOp.Close(); // �ر����ݿ�
				System.exit(0);
			}
		});
		add(lbUser);
		add(lbPass);
		add(text_user);
		add(text_pass);
		add(btn_ok);
		add(btn_cancel);
		setLocationRelativeTo(null); // ʹ��������Ļ�Ͼ��з���
		this.setVisible(true); // ʹ����ɼ�
	}

	public void btn_okActionPerformed(ActionEvent e) {
		String user = text_user.getText();
		String pass = text_pass.getText();
		String is_admin;
		// ����û�����������һΪ�գ�����ֹ��������
		if (user.equals("")||pass.equals("")) {
			JOptionPane.showMessageDialog(null, "�û��������벻��Ϊ�գ�");
			return;
		}
		try {
			// �˶��û���������
			String sql = "select * from user where username=" + "'" + user
					+ "'and password=" + "'" + pass + "'";
			ResultSet rs = DbOp.executeQuery(sql);
			// ������û����ڣ����¼��״̬���񣺲��ǹ���Ա���ǣ��ǹ���Ա��
			if (rs.next()) {
				is_admin = rs.getString("is_admin");
			} else {
				JOptionPane.showMessageDialog(null, "�û��������벻��ȷ��");
				return;
			}
			GlobalVar.login_user = user; // ��¼��¼���û���
			ShowMain show = new ShowMain(); // ����������
			// ֻ�й���Ա����ʹ��"��������"��"���Ĺ���"�˵�
			show.setRights(is_admin);
			// �ͷŴ��弰��ȫ���������Ļ��Դ����ʹ�ͷŵ�¼����
			dispose(); // �ͷŵ�ǰ����
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "�û����ݿ�����");
		}

	}

	public static void main(String[] args) {
		new Login();
	}
}
