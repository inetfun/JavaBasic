// BookQuery.java
package Chapter11;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookQuery extends Frame implements ActionListener {
	private static final long serialVersionUID = 1093264799018513820L;
	TextField seriesName;
	TextArea bookName;
	Button button;

	BookQuery() { // ���췽��
		super("ͼ���ѯ");
		setBounds(150, 150, 300, 300);
		seriesName = new TextField(16);
		bookName = new TextArea(5, 10);
		button = new Button("ȷ��");
		Panel p1 = new Panel(), p2 = new Panel();
		p1.add(new Label("�������������"));
		p1.add(seriesName);
		p2.add(button);
		add(p1, "North");
		add(p2, "South");
		add(bookName, "Center");
		button.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setLocationRelativeTo(null); // ʹ��������Ļ�Ͼ��з���
		setVisible(true); // ��ʾ����
	}

	public void actionPerformed(ActionEvent e) {
		// �����ǰ��������Ϊ��ť
		if (e.getSource() == button) {
			try {
				bookName.setText(null); // ����ı���
				ListStudent();
			} catch (SQLException ee) {
			}
		}
	}

	private void ListStudent() throws SQLException {
		String bn1, bn2;
		try {
			// ����JDBC-ODBC��������
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
		}
		// �������ݿ�����
		Connection con = DriverManager.getConnection("jdbc:odbc:javaodbc");
		// ����Statement����
		Statement st = con.createStatement();
		// ����ȫ����¼���õ������ResultSet����
		ResultSet rs = st.executeQuery("select * from ��Ŀ��¼");
		boolean boo = false;
		while (rs.next()) {
			bn1 = rs.getString("�������"); // ��ȡ�������
			bn2 = rs.getString("����"); // ��ȡ����
			// ��������������������ı�����ʾ����
			if (bn1.equals(seriesName.getText())) {
				bookName.append(bn2 + "\n");
				boo = true; // ��ϵ�д��鲻Ϊ��
			}
		}
		con.close();
		if (boo == false) {
			bookName.append("��ϵ�д��鲻���ڣ�");
		}
	}

	public static void main(String[] args) {
		new BookQuery();
	}
}
