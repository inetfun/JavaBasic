// QueryRecordTest.java
package Chapter11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryRecordTest {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		// ������������ʡ�ԣ��������ټ���JDBC-ODBC����������
		String msodbc = "sun.jdbc.odbc.JdbcOdbcDriver";
		Class.forName(msodbc); // ������������
		String url = "jdbc:odbc:javaodbc"; // ����url
		Connection con = DriverManager.getConnection(url); // ��������
		Statement st = con.createStatement(); // ����Statemnet����
		// �����޸ļ�¼��sql���
		String sql = "select ����,ISBN,����,���,����   " + "from ��Ŀ��¼ where �������='A'";
		// ִ�в�ѯ���ݿ������������ѯ��������ResultSet����rs��
		ResultSet rs = st.executeQuery(sql);
		// ��ʾ��ѯ���
		while (rs.next()) {
			System.out.println("������" + rs.getString("����") + "  ISBN��"
					+ rs.getString("ISBN") + "  ���ࣺ" + rs.getString("����")
					+ "  ���" + rs.getString("���") + "  ���ۣ�"
					+ rs.getFloat("����"));
		}
		rs.close(); // �رղ�ѯ�����¼��
		st.close(); // �ر����
		con.close(); // �ر�����
	}
}