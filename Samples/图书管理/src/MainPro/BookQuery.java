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
	Label lbbookname = new Label("ͼ������");
	Label lbauthor = new Label("��        ��");
	Label lbpublisher = new Label("��  ��  ��");
	Label lbpublish_time = new Label("����ʱ��");
	Label lbnotes = new Label("���ꡪ�£�");
	TextField tf_bookname = new TextField("");
	TextField tf_author = new TextField("");
	TextField tf_publisher = new TextField("");
	TextField tf_publish_time = new TextField("");
	Button queryBtn = new Button("��ѯ");
	Button closeBtn = new Button("�ر�");
	String[] heads = { "ͼ����", "ͼ������", "ͼ�����", "����", "����", "������", "��������", "����",
			"�������" };

	// ���췽��
	public BookQuery() {
		setTitle("ͼ���ѯ"); // ���ô������
		setSize(800, 500); // ���ô���ߴ�
		setLayout(null); // ȡ�����岼��
		lbbookname.setBounds(170, 20, 50, 20); // ����
		tf_bookname.setBounds(230, 20, 160, 20);
		lbauthor.setBounds(410, 20, 50, 20); // ����
		tf_author.setBounds(470, 20, 160, 20);
		lbpublisher.setBounds(170, 50, 50, 20); // ������
		tf_publisher.setBounds(230, 50, 160, 20);
		lbpublish_time.setBounds(410, 40, 50, 20); // ����ʱ��
		lbnotes.setBounds(405, 60, 60, 20);
		tf_publish_time.setBounds(470, 50, 160, 20);

		queryBtn.setBounds(300, 90, 80, 25); // ��ѯ��ť
		queryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_queryActionPerformed(e);
			}
		});
		closeBtn.setBounds(420, 90, 80, 25);// �رհ�ť
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // �ͷŵ�ǰ����
			}
		});

		/* �رմ��� */
		this.addWindowListener(new WindowAdapter() {
			// ��дwindowClosing()����
			public void windowClosing(WindowEvent e) {
				dispose(); // �ͷŵ�ǰ����
			}
		});
		add(lbbookname); // ���������ӵ�������
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
		setLocationRelativeTo(null); // ʹ��������Ļ�Ͼ��з���
		setVisible(true); // ʹ����ɼ�
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
			// ����һ��������SQL��䣬��ʾѡ������ȫ����¼
			sql = "select * from book ";
			// ����������գ�����sql1�־�
			if (bookname.equals(""))
				sql1 = "";
			else
				sql1 = " bookname like '" + bookname + "%' ";
			// ������߲��գ�����sql2�־�
			if (author.equals(""))
				sql2 = "";
			else {
				sql2 = " author like '" + author + "%' ";
				if (!bookname.equals("")) // ���������Ϊ��
					sql2 = " and " + sql2;
			}
			// ��������粻�գ�����sql3�־�
			if (publisher.equals(""))
				sql3 = "";
			else {
				sql3 = "publisher like '" + publisher + "%' ";
				// ���������������һ�Ϊ��
				if (!(bookname.equals("") && author.equals("")))
					sql3 = " and " + sql3;
			}
			// ����������ڲ��գ�����sql4�־�
			if (publishtime.equals("")) {
				sql4 = "";
			} else {
				// ����һ�������ڸ�ʽ����ע�⣺MMһ��Ҫ�ô�д
				// �����û��������ڵĸ�ʽ����-�£���2010-7��2009-10��
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
				// ����һ��Calendar����
				Calendar cal = new GregorianCalendar();
				// ���ַ���ת��Ϊ����
				Date pubtime = sdf.parse(tf_publish_time.getText());
				// ʹ�ø�����������cal��ʱ��
				cal.setTime(pubtime);
				// ��ȡ��
				pubyear = String.valueOf(cal.get(Calendar.YEAR));
				// ��ȡ��
				pubmonth = String.valueOf(cal.get(Calendar.MONTH) + 1);
				sql4 = " year(publish_time)=" + pubyear + " and ";
				sql4 = sql4 + "month(publish_time)=" + pubmonth;
				// ������������߻��������һ�Ϊ��
				if (!(bookname.equals("") && author.equals("") && publisher
						.equals("")))
					sql4 = " and " + sql4;
			}
			sql5 = sql1 + sql2 + sql3 + sql4;
			// �������������һ�����������޸�SQL���
			if (!sql5.equals("")) {
				sql = sql + " where " + sql5;
			}
			// ִ�в�ѯ
			ResultSet rs = DbOp.executeQuery(sql);
			// ����һ�������ά����
			Object[][] bookq = new Object[30][heads.length];
			int i = 0; // ����һ������
			while (rs.next()) { // ����ѯ�������Book����
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
			table = new JTable(bookq, heads); // ����һ�����
			// ����һ����ʾ����JScrollPane
			scrollPane = new JScrollPane(table);
			// ����JScrollPane��λ�úͳߴ�
			scrollPane.setBounds(20, 140, 760, 300);
			// ��JScrollPane��ӵ�������
			add(scrollPane);
		} catch (ParseException e2) {
			JOptionPane.showMessageDialog(null, "����ʱ���ʽ�����ꡪ�£���");
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "���ݿⲻ���ڣ�����ڴ���");
		}
	}

	// Ϊ�˱��ڵ��Գ����ر𴴽�main����
	public static void main(String[] args) {
		new BookQuery();
	}
}
