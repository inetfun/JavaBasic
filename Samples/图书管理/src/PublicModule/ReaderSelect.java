// ReaderSelect.java
package PublicModule;

import java.sql.*;
import javax.swing.JOptionPane;

public class ReaderSelect {
	// �����߱�Ų�ѯ�����������Reader��Ķ�����
	public static Reader selectReaderById(String id) {
		String sql = "select * from reader where id='" + id + "'";
		ResultSet rs = DbOp.executeQuery(sql);
		Reader reader = null;
		try {
			if (rs.next()) {
				reader = new Reader();
				reader.setId(rs.getString("id"));
				reader.setReadername(rs.getString("readername"));
				reader.setReadertype(rs.getString("readertype"));
				reader.setSex(rs.getString("sex"));
				reader.setMax_num(rs.getInt("max_num"));
				reader.setDays_num(rs.getInt("days_num"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "�޷�������ȡ���ݿ⣡");
		}
		return reader;
	}
}
