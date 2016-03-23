// DbOp.java
package PublicModule;

import java.sql.*;

import javax.swing.JOptionPane;

public class DbOp {
	// JDBC-ODBC��������
	private static String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	// ���ݿ�url·��
	private static String url = "jdbc:odbc:bookdb";
	private static Connection con = null;

	// ���췽����������ݿ�δ�򿪣���ͨ���������Ӵ����ݿ�
	private DbOp() {
		try {
			// �����ǰδ�������ӣ������JDBC��������Ȼ�󴴽�����
			if (con == null) {
				Class.forName(driver);
				con = DriverManager.getConnection(url);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "���ݿ�δ�ܴ򿪣�");
		}
	}

	 // ִ�����ݿ��ѯ��������������쳣������null
	public static ResultSet executeQuery(String sql) {
		try {
			// ���δ�������ݿ����ӣ��򴴽�����
			if (con == null)
				new DbOp();
			// ���ز�ѯ���
			return con.createStatement().executeQuery(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "���ݿⲻ���ڣ�����ڴ���");
			return null;
		}
	}

	// ִ�����ݿ���²�������������⣬�򷵻�-1
	public static int executeUpdate(String sql) {
		try {
			// ���δ�������ݿ����ӣ��򴴽�����
			if (con == null)
				new DbOp();
			// ���ز������
			return con.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "�������󣬼�¼�޷������������£�");
			return -1;
		}
	}

	// �ر����ݿ�
	public static void Close() {
		try {
			// ������ݿ��Ѵ򿪣���ر�֮
			if (con != null)
				con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "���ݿ�δ�򿪣�");
		}
	}
}