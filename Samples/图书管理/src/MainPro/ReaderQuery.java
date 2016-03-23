// ReaderQuery.java
package MainPro;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import PublicModule.*;

public class ReaderQuery extends JFrame {
	private static final long serialVersionUID = -7717113202745852409L;
	JTable table;
	JScrollPane scrollPane;
	Label lbreadername = new Label("��������");
	Label lbreadertype = new Label("��������");
	TextField tf_readername = new TextField("");
	TextField tf_readertype = new TextField("");
	Button queryBtn = new Button("��ѯ");
	Button closeBtn = new Button("�ر�");
	String[] heads = { "���߱��", "��������", "��������", 
			"�����Ա�", "���ɽ���", "�ɽ�����" };

	// ���췽��
	public ReaderQuery() {
		setTitle("���߲�ѯ"); // ���ô������
		setSize(600, 500); // ���ô���ߴ�
		setLayout(null); // ȡ�����岼��
		lbreadername.setBounds(70, 20, 50, 20); // ��������
		tf_readername.setBounds(130, 20, 160, 20);
		lbreadertype.setBounds(310, 20, 50, 20); // �������
		tf_readertype.setBounds(370, 20, 160, 20);
		queryBtn.setBounds(200, 60, 80, 25); // ��ѯ��ť
		queryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_queryActionPerformed(e);
			}
		});
		closeBtn.setBounds(320, 60, 80, 25); // �رհ�ť
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
		add(lbreadername); // ���������ӵ�������
		add(tf_readername);
		add(lbreadertype);
		add(tf_readertype);
		add(queryBtn);
		add(closeBtn);
		setLocationRelativeTo(null); // ʹ��������Ļ�Ͼ��з���
		setVisible(true); // ʹ����ɼ�
	}

	private void btn_queryActionPerformed(ActionEvent e) {
		try {
			String readername, readertype;
			String sql, sql1, sql2, sql3;
			readername = tf_readername.getText();
			readertype = tf_readertype.getText();
			// ����һ��������SQL��䣬��ʾѡ������ȫ����¼
			sql = "select * from reader ";
			// ��������������գ�����sql1�־�
			if (readername.equals(""))
				sql1 = "";
			else
				sql1 = " readername like '" + readername + "%' ";
			// ������߲��գ�����sql2�־�
			if (readertype.equals(""))
				sql2 = "";
			else {
				sql2 = " readertype like '" + readertype + "%' ";
				if (!readername.equals("")) // ���������Ϊ��
					sql2 = " and " + sql2;
			}
			sql3 = sql1 + sql2;
			// �������������һ�����������޸�SQL���
			if (!sql3.equals("")) {
				sql = sql + " where " + sql3;
			}
			// ִ�в�ѯ
			ResultSet rs = DbOp.executeQuery(sql);
			// ����һ�������ά����
			Object[][] readerq = new Object[30][heads.length];
			int i = 0; // ����һ������
			while (rs.next()) { // ����ѯ�������Book����
				readerq[i][0] = rs.getString("id");
				readerq[i][1] = rs.getString("readername");
				readerq[i][2] = rs.getString("readertype");
				readerq[i][3] = rs.getString("sex");
				readerq[i][4] = rs.getString("max_num");
				readerq[i][5] = rs.getString("days_num");
				i++;
			}
			table = new JTable(readerq, heads); // ����һ�����
			// ����һ����ʾ����JScrollPane
			scrollPane = new JScrollPane(table);
			// ����JScrollPane��λ�úͳߴ�
			scrollPane.setBounds(20, 120, 560, 300);
			// ��JScrollPane��ӵ�������
			add(scrollPane);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "���ݿⲻ���ڣ�����ڴ���");
		}
	}

	// Ϊ�˱��ڵ��Գ����ر𴴽�main����
	public static void main(String[] args) {
		new ReaderQuery();
	}
}
