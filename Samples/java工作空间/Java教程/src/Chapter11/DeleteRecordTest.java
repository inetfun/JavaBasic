// DeleteRecordTest.java
package Chapter11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRecordTest {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		// ������������ʡ�ԣ��������ټ���JDBC-ODBC����������
		String msodbc = "sun.jdbc.odbc.JdbcOdbcDriver";
		Class.forName(msodbc); // ������������
		String url = "jdbc:odbc:javaodbc"; // ����url
		Connection con = DriverManager.getConnection(url); // ��������
		Statement st = con.createStatement(); // ����Statemnet����
		// ����ɾ����¼��sql���
		String sql = "delete from ������¼  where �������='xx'";
		st.executeUpdate(sql); // ִ�����ݿ����
		st.close(); // �ر����
		con.close(); // �ر�����
	}
}
