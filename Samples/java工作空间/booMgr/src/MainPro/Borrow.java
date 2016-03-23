// Borrow.java
package MainPro;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import PublicModule.*;

public class Borrow extends Frame {
	private static final long serialVersionUID = -1036076990599464079L;
	String SepLine = "-------------------------------------------------";
	Label lbbookid = new Label("ͼ����");
	Label lbreaderid = new Label("���߱��");
	TextField tf_bookid = new TextField();
	TextField tf_readerid = new TextField();
	Button queryBtn = new Button("��ѯ");

	Label lbbookinfo = new Label(SepLine + "ͼ����Ϣ" + SepLine);
	Label lbbookname = new Label("ͼ�����ƣ�");
	Label tf_bookname = new Label("xx");
	Label lbauthor = new Label("���ߣ�");
	Label tf_author = new Label("xx");
	Label lbpublisher = new Label("�����磺");
	Label tf_publisher = new Label("xx");
	Label lbpublish_time = new Label("����ʱ�䣺");
	Label tf_publish_time = new Label("xx");
	Label lbprice = new Label("���ۣ�");
	Label tf_price = new Label("xx");
	Label lbstock = new Label("���������");
	Label tf_stock = new Label("xx");

	Label lbreaderinfo = new Label(SepLine + "������Ϣ" + SepLine);
	Label lbreadername = new Label("����������");
	Label tf_readername = new Label("xx");
	Label lbreadertype = new Label("�������ͣ�");
	Label tf_readertype = new Label("xx");
	Label lbmax_num = new Label("���ɽ�����");
	Label tf_max_num = new Label("xx");
	Label lbdays_num = new Label("���ɽ�������");
	Label tf_days_num = new Label("xx");

	Label lbborrowinfo = new Label(SepLine + "������Ϣ" + SepLine);
	Label lbborrowednum = new Label("�ö����ѽ�ͼ��������");
	Label tf_borrowednum = new Label("xx");
	Label lbif_borrow = new Label("�ö����Ƿ�ɽ���ѡͼ�飺");
	Label tf_if_borrow = new Label("xx");
	Label lbborrow_date = new Label("�������ڣ�");
	Label tf_borrow_date = new Label("xx");
	Button borrowBtn = new Button("���");
	Button closeBtn = new Button("�ر�");

	public Borrow() {
		setLayout(null);
		setTitle("����ͼ��");
		setSize(500, 420);
		this.setForeground(Color.BLACK); // ����ǰ��ɫΪ��ɫ
		lbbookid.setBounds(30, 40, 50, 25); // ͼ����
		tf_bookid.setBounds(90, 40, 90, 20);
		lbreaderid.setBounds(200, 40, 50, 25); // ���߱��
		tf_readerid.setBounds(260, 40, 90, 20);
		queryBtn.setBounds(370, 40, 80, 25); // ��ѯ��ť

		lbbookinfo.setBounds(30, 70, 440, 25); // ͼ����Ϣ��ʾ��
		lbbookname.setBounds(30, 100, 60, 25); // ͼ������
		tf_bookname.setBounds(90, 100, 200, 25);
		lbauthor.setBounds(310, 100, 60, 25); // ����
		tf_author.setBounds(370, 100, 90, 25);
		lbpublisher.setBounds(30, 125, 60, 25); // ������
		tf_publisher.setBounds(90, 125, 200, 25);
		lbpublish_time.setBounds(310, 125, 60, 25); // ����ʱ��
		tf_publish_time.setBounds(370, 125, 90, 25);
		lbprice.setBounds(30, 150, 60, 25); // ����
		tf_price.setBounds(90, 150, 200, 25);
		lbstock.setBounds(310, 150, 60, 25); // �������
		tf_stock.setBounds(370, 150, 90, 25);

		lbreaderinfo.setBounds(30, 180, 440, 25); // ������Ϣ��ʾ��
		lbreadername.setBounds(30, 205, 60, 25); // ��������
		tf_readername.setBounds(90, 205, 90, 25);
		lbreadertype.setBounds(310, 205, 60, 25); // ��������
		tf_readertype.setBounds(370, 205, 90, 25);
		lbmax_num.setBounds(30, 230, 75, 25); // ���ɽ���
		tf_max_num.setBounds(105, 230, 90, 25);
		lbdays_num.setBounds(310, 230, 85, 25); // ���ɽ�����
		tf_days_num.setBounds(395, 230, 70, 25);

		lbborrowinfo.setBounds(30, 260, 440, 25); // ������Ϣ��ʾ��
		lbborrowednum.setBounds(30, 285, 120, 25);// �ѽ�ͼ������
		tf_borrowednum.setBounds(150, 285, 50, 25);
		lbif_borrow.setBounds(30, 310, 145, 25); // �Ƿ�ɽ�
		tf_if_borrow.setBounds(175, 310, 50, 25);
		lbborrow_date.setBounds(30, 335, 60, 25);// ��������
		tf_borrow_date.setBounds(90, 335, 100, 25);

		borrowBtn.setBounds(160, 365, 80, 25);// �����ť
		borrowBtn.setEnabled(false); // ��ʼʱ���ý����ť
		closeBtn.setBounds(260, 365, 80, 25);// �رհ�ť

		queryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_querywActionPerformed(e);
			}
		});

		borrowBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_borrowActionPerformed(e);
			}
		});

		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setForeground(Color.BLACK); // ����ǰ��ɫΪ��ɫ
				dispose(); // �رմ���
			}
		});

		/* �رմ��� */
		this.addWindowListener(new WindowAdapter() {
			// ��дwindowClosing()����
			public void windowClosing(WindowEvent e) {
				setForeground(Color.BLACK); // ����ǰ��ɫΪ��ɫ
				dispose(); // �رմ���
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
		add(lbborrowinfo);
		add(lbborrowednum);
		add(lbif_borrow);
		add(lbborrow_date);
		add(borrowBtn);
		add(closeBtn);
		setLocationRelativeTo(null); // ʹ��������Ļ�Ͼ��з���
		setVisible(true); // ʹ����ɼ�
		setForeground(Color.RED); // ����ǰ��ɫΪ��ɫ
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
		add(tf_borrowednum);
		add(tf_if_borrow);
		add(tf_borrow_date);
	}

	// ͼ��Ͷ��߲�ѯ
	private void btn_querywActionPerformed(ActionEvent e) {
		String bookid = tf_bookid.getText();
		String readerid = tf_readerid.getText();
		// ���ͼ���Ż���߱�����߾�Ϊ�գ�������һ��Ϊ�գ��򷵻�
		if (bookid.equals("") || readerid.equals("")) {
			JOptionPane.showMessageDialog(null, "ͼ���źͶ��߱�ž�����Ϊ�գ�");
			init(); // ���³�ʼ������������ֹ�����ť
			return;
		}
		// ����Ų�ѯͼ�飬�������book������
		Book book = BookSelect.SelectBookById(bookid);
		// �����ѯ�������������ʾ�ڸ��ı�����
		if (book != null) {
			tf_bookname.setText(book.getBookname());
			tf_author.setText(book.getAuthor());
			tf_publisher.setText(book.getPublisher());
			tf_publish_time.setText(book.getPublish_time().toString());
			tf_price.setText(String.valueOf((book.getPrice())));
			tf_stock.setText(String.valueOf(book.getStock()));
		} else {
			JOptionPane.showMessageDialog(null, "ͼ�������󣬲��޴��飡");
			init(); // ���³�ʼ������������ֹ�����ť
			return;
		}
		if (book.getStock() == 0) {
			JOptionPane.showMessageDialog(null, "ͼ�����޿�棬�޷����ģ�");
			init(); // ���³�ʼ������������ֹ�����ť
			return;
		}
		// ����Ų�ѯ���ߣ��������reader������
		Reader reader = ReaderSelect.selectReaderById(readerid);
		// �����ѯ�������������ʾ�ڸ��ı�����
		if (reader != null) {
			tf_readername.setText(reader.getReadername());
			tf_readertype.setText(reader.getReadertype());
			tf_max_num.setText(String.valueOf(reader.getMax_num()));
			tf_days_num.setText(String.valueOf(reader.getDays_num()));
		} else {
			JOptionPane.showMessageDialog(null, "���߱�����󣬲��޴��ˣ�");
			init(); // ���³�ʼ������������ֹ�����ť
			return;
		}
		// ��ѯָ�������Ƿ��ѽ��ָ��ͼ����δ�黹
		if (IfBorrowBack.findbook(bookid, readerid)) {
			JOptionPane.showMessageDialog(null, "�ö����ѽ�����ѡͼ�飬��δ�黹��");
			init(); // ���³�ʼ������������ֹ�����ť
			return;
		}
		// ͳ�ƶ�������ͼ������
		int borrowednum = statborrowednum(readerid);
		tf_borrowednum.setText(String.valueOf(borrowednum));
		// ��������ѽ�ͼ����δ�������������������������������������ѡͼ��
		if (borrowednum < reader.getMax_num()) {
			tf_if_borrow.setText("��");
			// ����һ�������ڸ�ʽ����ע�⣺MMһ��Ҫ�ô�д
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// �������ڱ�����������Ϊ��ǰ����
			Date currentdate = new Date();
			// �����ڰ�ָ����ʽ���
			String borrowdate = sdf.format(currentdate);
			tf_borrow_date.setText(borrowdate);
			borrowBtn.setEnabled(true); // ʹ�����ť��Ч
		} else {
			JOptionPane.showMessageDialog(null, "�ö��߽�����࣬�޷��������ģ�");
			init(); // ���³�ʼ������������ֹ�����ť
			return;
		}
	}

	// ��д���ͼ���¼
	private void btn_borrowActionPerformed(ActionEvent e) {
		String sql;
		String bookid = tf_bookid.getText();
		String readerid = tf_readerid.getText();
		String borrowdate = tf_borrow_date.getText();
		// Ϊborrow�����ӽ����¼
		sql = "insert into borrow (book_id,reader_id,"
				+ "borrow_date,if_back) values('" + bookid + "','" + readerid
				+ "','" + borrowdate + "','��')";
		DbOp.executeUpdate(sql);
		// ���ö�������ͼ��������1
		int iborrowednum = Integer.parseInt(tf_borrowednum.getText()) + 1;
		String cborrowednum = String.valueOf(iborrowednum);
		tf_borrowednum.setText(cborrowednum);
		// ��ͼ����������1
		int istock = Integer.parseInt(tf_stock.getText()) - 1;
		String cstock = String.valueOf(istock);
		// ���»����е�ͼ��������
		tf_stock.setText(cstock);
		// �������ݿ��е�ͼ��������
		sql = "update book set stock='" + cstock;
		sql = sql + "' where id='" + bookid + "'";
		DbOp.executeUpdate(sql);
		JOptionPane.showMessageDialog(null, "����ɹ���");
		init(); // ���³�ʼ������������ֹ�����ť
	}

	// ͳ��ĳ�����ߵ�ǰ�ѽ�ͼ����δ�黹������
	private int statborrowednum(String readerid) {
		int borrowednum = 0;
		String reader_id, if_back;
		// ��ȡ���ݿ��м�¼
		String sql = "select * from borrow";
		ResultSet rs = DbOp.executeQuery(sql);
		// ִ�в�ѯͳ�Ʋ���
		try {
			while (rs.next()) {
				reader_id = rs.getString("reader_id");
				if_back = rs.getString("if_back");
				if (reader_id.equals(readerid) && if_back.equals("��")) {
					borrowednum++;
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "���ݿ�ͳ��ʧ�ܣ�");
		}
		return borrowednum;
	}

	// ��ʼ�����������ֹ�����ť
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
		tf_borrowednum.setText("xx");
		tf_if_borrow.setText("xx");
		tf_borrow_date.setText("xx");
		borrowBtn.setEnabled(false); // ��ֹ�����ť
	}

	// ����main()��������ҪΪ�˵��Գ������
	public static void main(String[] args) {
		new Borrow();
	}
}
