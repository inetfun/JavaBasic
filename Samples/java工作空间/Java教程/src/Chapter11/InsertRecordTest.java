// InsertRecordTest.java
package Chapter11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecordTest {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		// ������������ʡ�ԣ��������ټ���JDBC-ODBC����������
		String msodbc = "sun.jdbc.odbc.JdbcOdbcDriver";
		Class.forName(msodbc); // ������������
		String url = "jdbc:odbc:javaodbc"; // ����url
		Connection con = DriverManager.getConnection(url); // ��������
		Statement st = con.createStatement(); // ����Statemnet����
		// ��������¼��sql���
		String sql = "insert into ������¼(���,�������,��������)"
				+ "values(1000,'xx','Javaϵ�д���')";
		st.executeUpdate(sql); // ִ�����ݿ����
		st.close();	// �ر����
		con.close(); // �ر�����
	}
}
