// UpdatePassword.java
package MainPro;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

import PublicModule.*;

public class UpdatePassword extends Frame {
	private static final long serialVersionUID = -6540483851542957663L;
	Label newPassword = new Label("������������");
	Label confirmPass = new Label("�ٴ�ȷ��������");
	TextField text_1 = new TextField();
	TextField text_2 = new TextField();
	Button confirmBtn = new Button("ȷ��");
	Button cancelBtn = new Button("ȡ��");

	public UpdatePassword() {
		setLayout(null);
		setTitle("�޸�����");
		setSize(300, 170);
		newPassword.setBounds(30, 50, 90, 30);
		text_1.setBounds(125, 53, 120, 20);
		confirmPass.setBounds(30, 80, 90, 30);
		text_2.setBounds(125, 83, 120, 20);
		confirmBtn.setBounds(70, 120, 70, 25); // ȷ����ť
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmButtonPerformed(e);
			}
		});
		cancelBtn.setBounds(160, 120, 70, 25); // �رհ�ť
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // �ͷŴ�����Դ
			}
		});

		/* �رմ��� */
		this.addWindowListener(new WindowAdapter() {
			// ��дwindowClosing()����
			public void windowClosing(WindowEvent e) {
				dispose(); // �ͷŴ�����Դ
			}
		});
		add(newPassword);
		add(confirmPass);
		add(text_1);
		add(text_2);
		add(confirmBtn);
		add(cancelBtn);
		setLocationRelativeTo(null); // ʹ��������Ļ�Ͼ��з���
		setVisible(true); // ʹ����ɼ�
	}

	private void confirmButtonPerformed(ActionEvent e) {
		System.out.println(GlobalVar.login_user);
		String pass1 = text_1.getText();
		String pass2 = text_2.getText();
		// ��������������������һ��Ϊ�գ�����ʾ������ʾ��Ϣ������
		if (pass1.equals("") || pass1.equals("")) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ����������룡");
			return;
		}
		// ��������������������������ݲ�һ�£�����ʾ������ʾ��Ϣ������
		if (!pass1.equals(pass2)) {
			JOptionPane.showMessageDialog(null, "������������벻һ�£����������룡");
			text_1.setText("");
			text_2.setText("");
			return;
		}
		String sql = "update user set password='" + pass1
				+ "' where username='" + GlobalVar.login_user + "'";
		int i = DbOp.executeUpdate(sql);
		if (i == 1) {
			JOptionPane.showMessageDialog(null, "�޸�����ɹ���");
		} else
			JOptionPane.showMessageDialog(null, "�û����ݿ�����򲻴��ڣ��޸�����ʧ�ܣ�");
	}

	// Ϊ�˱��ڵ��Գ����ر𴴽�main����
	public static void main(String[] args) {
		new UpdatePassword();
	}
}
