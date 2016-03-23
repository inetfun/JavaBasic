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
		// 以下两条语句可省略，即无需再加载JDBC-ODBC桥驱动程序
		String msodbc = "sun.jdbc.odbc.JdbcOdbcDriver";
		Class.forName(msodbc); // 加载驱动程序
		String url = "jdbc:odbc:javaodbc"; // 定义url
		Connection con = DriverManager.getConnection(url); // 建立连接
		Statement st = con.createStatement(); // 创建Statemnet对象
		// 定义修改记录的sql语句
		String sql = "select 书名,ISBN,主编,版别,定价   " + "from 书目名录 where 丛书代号='A'";
		// 执行查询数据库操作，并将查询结果存放在ResultSet对象rs中
		ResultSet rs = st.executeQuery(sql);
		// 显示查询结果
		while (rs.next()) {
			System.out.println("书名：" + rs.getString("书名") + "  ISBN："
					+ rs.getString("ISBN") + "  主编：" + rs.getString("主编")
					+ "  版别：" + rs.getString("版别") + "  定价："
					+ rs.getFloat("定价"));
		}
		rs.close(); // 关闭查询结果记录集
		st.close(); // 关闭语句
		con.close(); // 关闭连接
	}
}