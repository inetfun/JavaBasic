// IfBorrowBack.java
package PublicModule;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class IfBorrowBack {
	// ��ָ�������Ƿ���ָ��ͼ����δ�黹
	public static boolean findbook(String bookid, String readerid) {
		String sql;
		sql = "select * from borrow where book_id='";
		sql = sql + bookid + "' and reader_id='" + readerid + "' and ";
		sql = sql + "if_back='��'";
		ResultSet rs = DbOp.executeQuery(sql);
		try {
			// ���ָ�����߽�����ָ��ͼ�飬��δ�黹������true�����򷵻�false
			if (rs.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "���ݿ��ѯʧ�ܣ�");
		}
		return true;
	}
}
