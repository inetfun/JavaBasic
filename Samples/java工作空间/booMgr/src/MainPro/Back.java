// Back.java
package MainPro;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import PublicModule.*;

public class Back extends Frame {
	private static final long serialVersionUID = -1036076990599464079L;
	String SepLine = "-------------------------------------------------";
	Label lbbookid = new Label("图书编号");
	Label lbreaderid = new Label("读者编号");
	TextField tf_bookid = new TextField();
	TextField tf_readerid = new TextField();
	Button queryBtn = new Button("查询");

	Label lbbookinfo = new Label(SepLine + "图书信息" + SepLine);
	Label lbbookname = new Label("图书名称：");
	Label tf_bookname = new Label("xx");
	Label lbauthor = new Label("作者：");
	Label tf_author = new Label("xx");
	Label lbpublisher = new Label("出版社：");
	Label tf_publisher = new Label("xx");
	Label lbpublish_time = new Label("出版时间：");
	Label tf_publish_time = new Label("xx");
	Label lbprice = new Label("定价：");
	Label tf_price = new Label("xx");
	Label lbstock = new Label("库存数量：");
	Label tf_stock = new Label("xx");

	Label lbreaderinfo = new Label(SepLine + "读者信息" + SepLine);
	Label lbreadername = new Label("读者姓名：");
	Label tf_readername = new Label("xx");
	Label lbreadertype = new Label("读者类型：");
	Label tf_readertype = new Label("xx");
	Label lbmax_num = new Label("最大可借数：");
	Label tf_max_num = new Label("xx");
	Label lbdays_num = new Label("最大可借天数：");
	Label tf_days_num = new Label("xx");

	Label lbbackinfo = new Label(SepLine + "还书信息" + SepLine);
	Label lbback_date = new Label("还书日期：");
	Label tf_back_date = new Label("xx");
	Button backBtn = new Button("还书");
	Button closeBtn = new Button("关闭");

	public Back() {
		setLayout(null);
		setTitle("还回图书");
		setSize(500, 310);
		this.setForeground(Color.BLACK); // 设置前景色为黑色
		lbbookid.setBounds(30, 40, 50, 20);// 图书编号
		tf_bookid.setBounds(90, 40, 90, 20);
		lbreaderid.setBounds(200, 40, 50, 20);// 读者编号
		tf_readerid.setBounds(260, 40, 90, 20);
		queryBtn.setBounds(370, 40, 80, 20); // 查询按钮

		lbbookinfo.setBounds(30, 70, 440, 20); // 图书信息提示条
		lbbookname.setBounds(30, 90, 60, 20); // 图书名称
		tf_bookname.setBounds(90, 90, 200, 20);
		lbauthor.setBounds(310, 90, 60, 20); // 作者
		tf_author.setBounds(370, 90, 90, 20);
		lbpublisher.setBounds(30, 110, 60, 20);// 出版社
		tf_publisher.setBounds(90, 110, 200, 20);
		lbpublish_time.setBounds(310, 110, 60, 20);// 出版时间
		tf_publish_time.setBounds(370, 110, 90, 20);
		lbprice.setBounds(30, 130, 60, 20); // 定价
		tf_price.setBounds(90, 130, 200, 20);
		lbstock.setBounds(310, 130, 60, 20); // 库存数量
		tf_stock.setBounds(370, 130, 90, 20);

		lbreaderinfo.setBounds(30, 150, 440, 20); // 读者信息提示条
		lbreadername.setBounds(30, 170, 60, 20); // 读者姓名
		tf_readername.setBounds(90, 170, 90, 20);
		lbreadertype.setBounds(310, 170, 60, 20); // 读者类型
		tf_readertype.setBounds(370, 170, 90, 20);
		lbmax_num.setBounds(30, 190, 75, 20); // 最大可借数
		tf_max_num.setBounds(105, 190, 90, 20);
		lbdays_num.setBounds(310, 190, 85, 20); // 最大可借天数
		tf_days_num.setBounds(395, 190, 70, 20);

		lbbackinfo.setBounds(30, 210, 440, 20); // 还书信息提示条
		lbback_date.setBounds(30, 230, 60, 20);// 还书日期
		tf_back_date.setBounds(90, 230, 100, 20);

		backBtn.setBounds(160, 260, 80, 25);// 还书按钮
		backBtn.setEnabled(false); // 开始时禁用还书按钮
		closeBtn.setBounds(260, 260, 80, 25);// 关闭按钮

		queryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_querywActionPerformed(e);
			}
		});

		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_backActionPerformed(e);
			}
		});

		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setForeground(Color.BLACK); // 设置前景色为黑色
				dispose(); // 关闭窗体
			}
		});

		/* 关闭窗口 */
		this.addWindowListener(new WindowAdapter() {
			// 重写windowClosing()方法
			public void windowClosing(WindowEvent e) {
				setForeground(Color.BLACK); // 设置前景色为黑色
				dispose(); // 关闭窗体
			}
		});
		add(lbbookid);
		add(lbreaderid);
		add(queryBtn);
		add(lbbookinfo);
		add(lbbookname);
		add(lbauthor);
		add(lbpublisher);
		add(lbpublish_time);
		add(lbprice);
		add(lbstock);
		add(lbreaderinfo);
		add(lbreadername);
		add(lbreadertype);
		add(lbmax_num);
		add(lbdays_num);
		add(lbbackinfo);
		add(lbback_date);
		add(backBtn);
		add(closeBtn);
		setLocationRelativeTo(null); // 使窗体在屏幕上居中放置
		setVisible(true); // 使窗体可见
		setForeground(Color.RED); // 设置前景色为红色
		add(tf_bookid);
		add(tf_readerid);
		add(tf_bookname);
		add(tf_author);
		add(tf_publisher);
		add(tf_publish_time);
		add(tf_price);
		add(tf_stock);
		add(tf_readername);
		add(tf_readertype);
		add(tf_max_num);
		add(tf_days_num);
		add(tf_back_date);
	}

	// 图书和读者查询
	private void btn_querywActionPerformed(ActionEvent e) {
		String bookid = tf_bookid.getText();
		String readerid = tf_readerid.getText();
		// 如果图书编号或读者编号两者均为空，或者有一个为空，则返回
		if (bookid.equals("") || readerid.equals("")) {
			JOptionPane.showMessageDialog(null, "图书编号和读者编号均不能为空！");
			init(); // 重新初始化各参数并禁止还书按钮
			return;
		}
		// 按编号查询图书，结果存入book对象中
		Book book = BookSelect.SelectBookById(bookid);
		// 如果查询到结果，将其显示在各文本框中
		if (book != null) {
			tf_bookname.setText(book.getBookname());
			tf_author.setText(book.getAuthor());
			tf_publisher.setText(book.getPublisher());
			tf_publish_time.setText(book.getPublish_time().toString());
			tf_price.setText(String.valueOf((book.getPrice())));
			tf_stock.setText(String.valueOf(book.getStock()));
		} else {
			JOptionPane.showMessageDialog(null, "图书编号有误，查无此书！");
			init(); // 重新初始化各参数并禁止还书按钮
			return;
		}
		// 按编号查询读者，结果存入reader对象中
		Reader reader = ReaderSelect.selectReaderById(readerid);
		// 如果查询到结果，将其显示在各文本框中
		if (reader != null) {
			tf_readername.setText(reader.getReadername());
			tf_readertype.setText(reader.getReadertype());
			tf_max_num.setText(String.valueOf(reader.getMax_num()));
			tf_days_num.setText(String.valueOf(reader.getDays_num()));
		} else {
			JOptionPane.showMessageDialog(null, "读者编号有误，查无此人！");
			init(); // 重新初始化各参数并禁止还书按钮
			return;
		}
		// 查询指定读者是否借阅过指定图书，且未归还
		if (!IfBorrowBack.findbook(bookid,readerid)){
			JOptionPane.showMessageDialog(null, "该读者没有借过此种图书！");
			init(); // 重新初始化各参数并禁止还书按钮
			return;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 创建日期变量，其内容为当前日期
		Date currentdate = new Date();
		// 将日期按指定格式输出
		String borrowdate = sdf.format(currentdate);
		tf_back_date.setText(borrowdate);
		backBtn.setEnabled(true); // 使还书按钮有效
	}

	// 填写还书记录
	private void btn_backActionPerformed(ActionEvent e) {
		String sql;
		String bookid = tf_bookid.getText();
		String readerid = tf_readerid.getText();
		String backdate = tf_back_date.getText();
		// 更新borrow表记录
		sql = "update borrow set if_back='是',back_date='";
		sql = sql + backdate + "' where ";
		sql = sql + " book_id='" + bookid + "' and ";
		sql = sql + "reader_id='" + readerid + "' and ";
		sql = sql + "if_back='否'";
		DbOp.executeUpdate(sql);
		// 将图书库存数量加1
		int istock = Integer.parseInt(tf_stock.getText()) + 1;
		String cstock = String.valueOf(istock);
		// 更新画面中的图书库存数量
		tf_stock.setText(cstock);
		// 更新数据库中的图书库存数量
		sql = "update book set stock='" + cstock;
		sql = sql + "' where id='" + bookid + "'";
		DbOp.executeUpdate(sql);
		JOptionPane.showMessageDialog(null, "还书成功！");
		init(); // 重新初始化各参数并禁止还书按钮
	}

	// 初始化各参数项并禁止还书按钮
	private void init() {
		tf_bookname.setText("xx");
		tf_author.setText("xx");
		tf_publisher.setText("xx");
		tf_publish_time.setText("xx");
		tf_price.setText("xx");
		tf_stock.setText("xx");
		tf_readername.setText("xx");
		tf_readertype.setText("xx");
		tf_max_num.setText("xx");
		tf_days_num.setText("xx");
		tf_back_date.setText("xx");
		backBtn.setEnabled(false); // 禁止还书按钮
	}
	
	// 增加main()方法，主要为了调试程序界面
	public static void main(String[] args) {
		new Back();
	}
}
