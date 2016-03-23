// BookQuery.java
package MainPro;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;

import javax.swing.*;

import PublicModule.*;

public class BookQuery extends JFrame {
	private static final long serialVersionUID = -3045513015088987091L;
	JTable table;
	JScrollPane scrollPane;
	Label lbbookname = new Label("图书名称");
	Label lbauthor = new Label("作        者");
	Label lbpublisher = new Label("出  版  社");
	Label lbpublish_time = new Label("出版时间");
	Label lbnotes = new Label("（年—月）");
	TextField tf_bookname = new TextField("");
	TextField tf_author = new TextField("");
	TextField tf_publisher = new TextField("");
	TextField tf_publish_time = new TextField("");
	Button queryBtn = new Button("查询");
	Button closeBtn = new Button("关闭");
	String[] heads = { "图书编号", "图书名称", "图书类别", "作者", "译者", "出版社", "出版日期", "定价",
			"库存数量" };

	// 构造方法
	public BookQuery() {
		setTitle("图书查询"); // 设置窗体标题
		setSize(800, 500); // 设置窗体尺寸
		setLayout(null); // 取消窗体布局
		lbbookname.setBounds(170, 20, 50, 20); // 书名
		tf_bookname.setBounds(230, 20, 160, 20);
		lbauthor.setBounds(410, 20, 50, 20); // 作者
		tf_author.setBounds(470, 20, 160, 20);
		lbpublisher.setBounds(170, 50, 50, 20); // 出版社
		tf_publisher.setBounds(230, 50, 160, 20);
		lbpublish_time.setBounds(410, 40, 50, 20); // 出版时间
		lbnotes.setBounds(405, 60, 60, 20);
		tf_publish_time.setBounds(470, 50, 160, 20);

		queryBtn.setBounds(300, 90, 80, 25); // 查询按钮
		queryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_queryActionPerformed(e);
			}
		});
		closeBtn.setBounds(420, 90, 80, 25);// 关闭按钮
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
		add(lbbookname); // 将各组件添加到窗体中
		add(tf_bookname);
		add(lbauthor);
		add(tf_author);
		add(lbpublisher);
		add(tf_publisher);
		add(lbpublish_time);
		add(lbnotes);
		add(tf_publish_time);
		add(queryBtn);
		add(closeBtn);
		setLocationRelativeTo(null); // 使窗体在屏幕上居中放置
		setVisible(true); // 使窗体可见
	}

	private void btn_queryActionPerformed(ActionEvent e) {
		try {
			String bookname, author, publisher, publishtime;
			String sql, sql1, sql2, sql3, sql4, sql5;
			String pubyear, pubmonth;
			bookname = tf_bookname.getText();
			author = tf_author.getText();
			publisher = tf_publisher.getText();
			publishtime = tf_publish_time.getText();
			// 创建一条基本的SQL语句，表示选出表中全部记录
			sql = "select * from book ";
			// 如果书名不空，生成sql1字句
			if (bookname.equals(""))
				sql1 = "";
			else
				sql1 = " bookname like '" + bookname + "%' ";
			// 如果作者不空，生成sql2字句
			if (author.equals(""))
				sql2 = "";
			else {
				sql2 = " author like '" + author + "%' ";
				if (!bookname.equals("")) // 如果书名不为空
					sql2 = " and " + sql2;
			}
			// 如果出版社不空，生成sql3字句
			if (publisher.equals(""))
				sql3 = "";
			else {
				sql3 = "publisher like '" + publisher + "%' ";
				// 如果书名和作者有一项不为空
				if (!(bookname.equals("") && author.equals("")))
					sql3 = " and " + sql3;
			}
			// 如果出版日期不空，生成sql4字句
			if (publishtime.equals("")) {
				sql4 = "";
			} else {
				// 创建一个简单日期格式对象，注意：MM一定要用大写
				// 这是用户输入日期的格式：年-月，如2010-7、2009-10等
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
				// 创建一个Calendar对象
				Calendar cal = new GregorianCalendar();
				// 将字符串转换为日期
				Date pubtime = sdf.parse(tf_publish_time.getText());
				// 使用给定日期设置cal的时间
				cal.setTime(pubtime);
				// 获取年
				pubyear = String.valueOf(cal.get(Calendar.YEAR));
				// 获取月
				pubmonth = String.valueOf(cal.get(Calendar.MONTH) + 1);
				sql4 = " year(publish_time)=" + pubyear + " and ";
				sql4 = sql4 + "month(publish_time)=" + pubmonth;
				// 如果书名、作者或出版社有一项不为空
				if (!(bookname.equals("") && author.equals("") && publisher
						.equals("")))
					sql4 = " and " + sql4;
			}
			sql5 = sql1 + sql2 + sql3 + sql4;
			// 如果已设置任意一项条件，则修改SQL语句
			if (!sql5.equals("")) {
				sql = sql + " where " + sql5;
			}
			// 执行查询
			ResultSet rs = DbOp.executeQuery(sql);
			// 创建一个对象二维数组
			Object[][] bookq = new Object[30][heads.length];
			int i = 0; // 定义一个变量
			while (rs.next()) { // 将查询结果赋予Book数组
				bookq[i][0] = rs.getString("id");
				bookq[i][1] = rs.getString("bookname");
				bookq[i][2] = rs.getString("booktype");
				bookq[i][3] = rs.getString("author");
				bookq[i][4] = rs.getString("translator");
				bookq[i][5] = rs.getString("publisher");
				bookq[i][6] = rs.getDate("publish_time");
				bookq[i][7] = rs.getFloat("price");
				bookq[i][8] = rs.getInt("stock");
				i++;
			}
			table = new JTable(bookq, heads); // 创建一个表格
			// 创建一个显示表格的JScrollPane
			scrollPane = new JScrollPane(table);
			// 设置JScrollPane的位置和尺寸
			scrollPane.setBounds(20, 140, 760, 300);
			// 将JScrollPane添加到窗体中
			add(scrollPane);
		} catch (ParseException e2) {
			JOptionPane.showMessageDialog(null, "出版时间格式错误（年—月）！");
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "数据库不存在，或存在错误！");
		}
	}

	// 为了便于调试程序，特别创建main方法
	public static void main(String[] args) {
		new BookQuery();
	}
}
