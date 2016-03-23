// UpdateRecordTest.java
package Chapter11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateRecordTest {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		// 以下两条语句可省略，即无需再加载JDBC-ODBC桥驱动程序
		String msodbc = "sun.jdbc.odbc.JdbcOdbcDriver";
		Class.forName(msodbc); // 加载驱动程序
		String url = "jdbc:odbc:javaodbc"; // 定义url
		Connection con = DriverManager.getConnection(url); // 建立连接
		Statement st = con.createStatement(); // 创建Statemnet对象
		// 定义修改记录的sql语句
		String sql = "update 丛书名录  set 丛书代号='yy',"
				+ "丛书名称='C++系列丛书' where 丛书代号='xx'";
		st.executeUpdate(sql); // 执行数据库更新
		st.close(); // 关闭语句
		con.close(); // 关闭连接
	}
}