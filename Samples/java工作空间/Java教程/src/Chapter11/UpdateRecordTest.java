// UpdateRecordTest.java
package Chapter11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateRecordTest {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		// ������������ʡ�ԣ��������ټ���JDBC-ODBC����������
		String msodbc = "sun.jdbc.odbc.JdbcOdbcDriver";
		Class.forName(msodbc); // ������������
		String url = "jdbc:odbc:javaodbc"; // ����url
		Connection con = DriverManager.getConnection(url); // ��������
		Statement st = con.createStatement(); // ����Statemnet����
		// �����޸ļ�¼��sql���
		String sql = "update ������¼  set �������='yy',"
				+ "��������='C++ϵ�д���' where �������='xx'";
		st.executeUpdate(sql); // ִ�����ݿ����
		st.close(); // �ر����
		con.close(); // �ر�����
	}
}