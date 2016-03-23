// ReaderAdd.java
package MainPro;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import PublicModule.*;

public class ReaderAdd extends Frame {
	private static final long serialVersionUID = -2399939451497711745L;
	Label lbreaderid = new Label("���߱��");
	Label lbreadername = new Label("��������");
	Label lbreadertype = new Label("�������");
	Label lbsex = new Label("�Ա�");
	Label lbmax_num = new Label("�ɽ�����");
	Label lbdays_num = new Label("�ɽ�����");
	TextField tf_readerid = new TextField();
	TextField tf_readername = new TextField();
	TextField tf_max_num = new TextField();
	TextField tf_days_num = new TextField();
	Choice tf_readertype = new Choice();
	Choice tf_sex = new Choice();
	Button saveBtn = new Button("����");
	Button closeBtn = new Button("�ر�");

	public ReaderAdd() {
		setLayout(null);
		setTitle("��Ӷ�����Ϣ");
		setSize(500, 200);
		lbreaderid.setBounds(50, 50, 50, 20); // ���߱��
		tf_readerid.setBounds(110, 50, 100, 20);
		lbreadername.setBounds(240, 50, 50, 20); // ��������
		tf_readername.setBounds(300, 50, 100, 20);
		lbreadertype.setBounds(50, 80, 50, 20); // �������
		tf_readertype.setBounds(110, 80, 100, 20);
		tf_readertype.add("��ʦ");
		tf_readertype.add("ѧ��");
		tf_readertype.add("ְ��");
		lbsex.setBounds(240, 80, 50, 20); // �Ա�
		tf_sex.setBounds(300, 80, 100, 20);
		tf_sex.add("��");
		tf_sex.add("Ů");
		lbmax_num.setBounds(50, 110, 50, 20); // ���ɽ���
		tf_max_num.setBounds(110, 110, 100, 20);
		lbdays_num.setBounds(240, 110, 50, 20); // ���ɽ�����
		tf_days_num.setBounds(300, 110, 100, 20);

		saveBtn.setBounds(150, 150, 80, 25); // ���水ť
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_saveActionPerformed(e);
			}
		});
		closeBtn.setBounds(280, 150, 80, 25);// �رհ�ť
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // �ͷŵ�ǰ����
			}
		});

		/* �رմ��� */
		this.addWindowListener(new WindowAdapter() {
			// ��дwindowClosing()����
			public void windowClosing(WindowEvent e) {
				dispose(); // �ͷŵ�ǰ����
			}
		});
		add(lbreaderid);
		add(lbreadername);
		add(lbreadertype);
		add(lbsex);
		add(lbmax_num);
		add(lbdays_num);
		add(tf_readerid);
		add(tf_readername);
		add(tf_max_num);
		add(tf_days_num);
		add(tf_readertype);
		add(tf_sex);
		add(saveBtn);
		add(closeBtn);
		setLocationRelativeTo(null); // ʹ��������Ļ�Ͼ��з���
		setVisible(true); // ʹ����ɼ�
	}

	private void btn_saveActionPerformed(ActionEvent e) {
		String id = tf_readerid.getText();
		String name = tf_readername.getName();
		String type = tf_readertype.getSelectedItem().toString();
		String sex = tf_sex.getSelectedItem().toString();
		// ������߱��Ϊ�գ�����ֹ�����¼����
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "���߱�Ų���Ϊ�գ�");
			return;
		}
		// ������߱���ظ������¼��Ч�����޸Ķ��߱��
		if (IfReaderIdExit(id)) {
			JOptionPane.showMessageDialog(null, "���߱���ظ���");
			return;
		}
		try {
			int max_num = Integer.parseInt(tf_max_num.getText());
			int days_num = Integer.parseInt(tf_days_num.getText());
			String sql = "insert into reader(id,name,type,sex,"
					+ "max_num,days_num) values('" + id + "','" + name + "','"
					+ type + "','" + sex + "','" + max_num + "','" + days_num
					+ "')";
			int i = DbOp.executeUpdate(sql);
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "������ӳɹ���");
				// ���ȫ���ı���
				clearAllTextfield();
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "���ɽ�����"
					+ "���ɽ���������ӦΪ������");
		}
	}

	// �ж�Reader�����Ƿ����ָ����ŵĶ��ߣ�������ڣ�����true�����򣬷���false
	private boolean IfReaderIdExit(String id) {
		String sql = "select * from reader where id='" + id + "'";
		ResultSet rs = DbOp.executeQuery(sql);
		try {
			if (rs.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "�޷�������ȡ���ݿ⣡");
		}
		return false;
	}

	// ���ȫ���ı���
	private void clearAllTextfield() {
		tf_readerid.setText("");
		tf_readername.setText("");
		tf_max_num.setText("");
		tf_days_num.setText("");
	}

	// ����main()��������ҪΪ�˵��Գ������
	public static void main(String[] args) {
		new ReaderAdd();
	}
}
