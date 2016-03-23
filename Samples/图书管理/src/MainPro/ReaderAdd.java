// ReaderAdd.java
package MainPro;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import PublicModule.*;

public class ReaderAdd extends Frame {
	private static final long serialVersionUID = -2399939451497711745L;
	Label lbreaderid = new Label("读者编号");
	Label lbreadername = new Label("读者姓名");
	Label lbreadertype = new Label("读者类别");
	Label lbsex = new Label("性别");
	Label lbmax_num = new Label("可借数量");
	Label lbdays_num = new Label("可借天数");
	TextField tf_readerid = new TextField();
	TextField tf_readername = new TextField();
	TextField tf_max_num = new TextField();
	TextField tf_days_num = new TextField();
	Choice tf_readertype = new Choice();
	Choice tf_sex = new Choice();
	Button saveBtn = new Button("保存");
	Button closeBtn = new Button("关闭");

	public ReaderAdd() {
		setLayout(null);
		setTitle("添加读者信息");
		setSize(500, 200);
		lbreaderid.setBounds(50, 50, 50, 20); // 读者编号
		tf_readerid.setBounds(110, 50, 100, 20);
		lbreadername.setBounds(240, 50, 50, 20); // 读者姓名
		tf_readername.setBounds(300, 50, 100, 20);
		lbreadertype.setBounds(50, 80, 50, 20); // 读者类别
		tf_readertype.setBounds(110, 80, 100, 20);
		tf_readertype.add("教师");
		tf_readertype.add("学生");
		tf_readertype.add("职工");
		lbsex.setBounds(240, 80, 50, 20); // 性别
		tf_sex.setBounds(300, 80, 100, 20);
		tf_sex.add("男");
		tf_sex.add("女");
		lbmax_num.setBounds(50, 110, 50, 20); // 最大可借数
		tf_max_num.setBounds(110, 110, 100, 20);
		lbdays_num.setBounds(240, 110, 50, 20); // 最大可借天数
		tf_days_num.setBounds(300, 110, 100, 20);

		saveBtn.setBounds(150, 150, 80, 25); // 保存按钮
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_saveActionPerformed(e);
			}
		});
		closeBtn.setBounds(280, 150, 80, 25);// 关闭按钮
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // 释放当前窗体
			}
		});

		/* 关闭窗口 */
		this.addWindowListener(new WindowAdapter() {
			// 重写windowClosing()方法
			public void windowClosing(WindowEvent e) {
				dispose(); // 释放当前窗体
			}
		});
		add(lbreaderid);
		add(lbreadername);
		add(lbreadertype);
		add(lbsex);
		add(lbmax_num);
		add(lbdays_num);
		add(tf_readerid);
		add(tf_readername);
		add(tf_max_num);
		add(tf_days_num);
		add(tf_readertype);
		add(tf_sex);
		add(saveBtn);
		add(closeBtn);
		setLocationRelativeTo(null); // 使窗体在屏幕上居中放置
		setVisible(true); // 使窗体可见
	}

	private void btn_saveActionPerformed(ActionEvent e) {
		String id = tf_readerid.getText();
		String name = tf_readername.getName();
		String type = tf_readertype.getSelectedItem().toString();
		String sex = tf_sex.getSelectedItem().toString();
		// 如果读者编号为空，则终止保存记录操作
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "读者编号不能为空！");
			return;
		}
		// 如果读者编号重复，则记录无效，需修改读者编号
		if (IfReaderIdExit(id)) {
			JOptionPane.showMessageDialog(null, "读者编号重复！");
			return;
		}
		try {
			int max_num = Integer.parseInt(tf_max_num.getText());
			int days_num = Integer.parseInt(tf_days_num.getText());
			String sql = "insert into reader(id,name,type,sex,"
					+ "max_num,days_num) values('" + id + "','" + name + "','"
					+ type + "','" + sex + "','" + max_num + "','" + days_num
					+ "')";
			int i = DbOp.executeUpdate(sql);
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "读者添加成功！");
				// 清空全部文本框
				clearAllTextfield();
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "最大可借数或"
					+ "最大可借天数错误，应为整数！");
		}
	}

	// 判断Reader表中是否存在指定编号的读者，如果存在，返回true，否则，返回false
	private boolean IfReaderIdExit(String id) {
		String sql = "select * from reader where id='" + id + "'";
		ResultSet rs = DbOp.executeQuery(sql);
		try {
			if (rs.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "无法正常读取数据库！");
		}
		return false;
	}

	// 清空全部文本框
	private void clearAllTextfield() {
		tf_readerid.setText("");
		tf_readername.setText("");
		tf_max_num.setText("");
		tf_days_num.setText("");
	}

	// 增加main()方法，主要为了调试程序界面
	public static void main(String[] args) {
		new ReaderAdd();
	}
}
