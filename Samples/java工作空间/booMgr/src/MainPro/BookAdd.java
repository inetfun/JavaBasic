// BookAdd.java
package MainPro;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

import PublicModule.*;

public class BookAdd extends Frame {
	private static final long serialVersionUID = 377287301994613384L;
	Label lbbookid = new Label("ͼ����");
	Label lbbookname = new Label("ͼ������");
	Label lbbooktype = new Label("ͼ�����");
	Label lbauthor = new Label("����");
	Label lbtranslator = new Label("����");
	Label lbpublisher = new Label("������");
	Label lbpublish_time = new Label("����ʱ��");
	Label lbprice = new Label("����");
	Label lbstock = new Label("�������");
	Button saveBtn = new Button("����");
	Button closeBtn = new Button("�ر�");
	TextField tf_bookid = new TextField();
	TextField tf_bookname = new TextField();
	TextField tf_author = new TextField();
	TextField tf_translator = new TextField();
	TextField tf_publisher = new TextField();
	TextField tf_publish_time = new TextField();
	TextField tf_price = new TextField();
	TextField tf_stock = new TextField();
	Choice tf_booktype = new Choice();

	BookAdd() {
		setLayout(null);
		setTitle("���ͼ��");
		setSize(500, 250);
		lbbookid.setBounds(50, 50, 50, 20); // ͼ����
		tf_bookid.setBounds(110, 50, 100, 20);
		lbbookname.setBounds(240, 50, 50, 20); // ͼ������
		tf_bookname.setBounds(300, 50, 100, 20);
		lbbooktype.setBounds(50, 80, 50, 20); // ͼ�����
		tf_booktype.setBounds(110, 80, 100, 20);
		tf_booktype.add("�Ƽ�");
		tf_booktype.add("��ѧ");
		tf_booktype.add("���");
		tf_booktype.add("����");
		lbauthor.setBounds(240, 80, 50, 20); // ����
		tf_author.setBounds(300, 80, 100, 20);
		lbtranslator.setBounds(50, 110, 50, 20); // ��������
		tf_translator.setBounds(110, 110, 100, 20);
		lbpublisher.setBounds(240, 110, 50, 20); // ������
		tf_publisher.setBounds(300, 110, 100, 20);
		lbpublish_time.setBounds(50, 140, 50, 20); // ����ʱ��
		tf_publish_time.setBounds(110, 140, 100, 20);
		lbprice.setBounds(240, 140, 50, 20); // ����
		tf_price.setBounds(300, 140, 100, 20);
		lbstock.setBounds(50, 170, 50, 20); // �������
		tf_stock.setBounds(110, 170, 100, 20);

		saveBtn.setBounds(150, 210, 80, 25); // ���水ť
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_saveActionPerformed(e);
			}
		});
		closeBtn.setBounds(280, 210, 80, 25);// �رհ�ť
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // �ͷŵ�ǰ����
			}
		});
		/* �رմ��� */
		this.addWindowListener(new WindowAdapter() {
			// ��дwindowClosing()����
			public void windowClosing(WindowEvent e) { // �رյ�ǰ����
				dispose(); // �ͷŵ�ǰ����
			}
		});
		add(lbbookid);
		add(lbbookname);
		add(lbbooktype);
		add(lbauthor);
		add(lbtranslator);
		add(lbpublisher);
		add(lbpublish_time);
		add(lbprice);
		add(lbstock);
		add(saveBtn);
		add(closeBtn);
		add(tf_bookid);
		add(tf_bookname);
		add(tf_author);
		add(tf_translator);
		add(tf_publisher);
		add(tf_publish_time);
		add(tf_price);
		add(tf_stock);
		add(tf_booktype);
		setLocationRelativeTo(null); // ʹ��������Ļ�Ͼ��з���
		setVisible(true); // ʹ����ɼ�
	}

	// �����¼
	private void btn_saveActionPerformed(ActionEvent e) {
		String id = tf_bookid.getText();
		String bookname = tf_bookname.getText();
		String booktype = tf_booktype.getSelectedItem().toString();
		String author = tf_author.getText();
		String translator = tf_translator.getText();
		String publisher = tf_publisher.getText();
		String publish_time = tf_publish_time.getText();
		// ���ͼ����Ϊ�գ�����ֹ�����¼����
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "ͼ���Ų���Ϊ�գ�");
			return;
		}
		// ���ͼ�����ظ������¼��Ч�����޸�ͼ����
		if (IfBookIdExit(id)) {
			JOptionPane.showMessageDialog(null, "ͼ�����ظ���");
			return;
		}
		try {
			// -------------------------------------------------
			// ���³������ڼ�������Ƿ���Ч�����������Ч�����
			// ����ParseException�쳣
			// ����һ�������ڸ�ʽ����ע�⣺MMһ��Ҫ�ô�д
			// �����û��������ڵĸ�ʽ����-�£���2010-7��2009-10��
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			// ���ַ���ת��Ϊ���ڡ����������Ч�����׳�ParseException�쳣
			// ��ˣ��������Ҫ�����ж����ڸ�ʽ�Ƿ���Ч
			sdf.parse(tf_publish_time.getText());
			// -------------------------------------------------
			float price = Float.parseFloat(tf_price.getText());
			int stock = Integer.parseInt(tf_stock.getText());
			// ����¼���浽book����
			String sql = "insert into book(id,bookname,booktype,"
					+ "author,translator,"
					+ "publisher,publish_time,price,stock) values('" + id
					+ "','" + bookname + "','" + booktype + "','" + author
					+ "','" + translator + "','" + publisher + "','"
					+ publish_time + "','" + price + "','" + stock + "')";
			int i = DbOp.executeUpdate(sql);
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "ͼ����ӳɹ���");
				// ���ȫ���ı���
				clearAllTextfield();
			}
		} catch (ParseException e2) {
			JOptionPane.showMessageDialog(null, "����ʱ���ʽ�����ꡪ�£���");
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "��������ͼ۸����ӦΪ���֣�");
		}
	}

	// �ж�Book�����Ƿ����ָ����ŵ�ͼ�飬������ڣ�����true�����򣬷���false
	private boolean IfBookIdExit(String id) {
		String sql = "select * from book where id='" + id + "'";
		ResultSet rs = DbOp.executeQuery(sql);
		try {
			if (rs.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "�޷�������ȡ���ݿ⣡");
		}
		return false;
	}

	// ���ȫ���ı���
	private void clearAllTextfield() {
		tf_bookid.setText("");
		tf_bookname.setText("");
		tf_author.setText("");
		tf_translator.setText("");
		tf_publisher.setText("");
		tf_publish_time.setText("");
		tf_price.setText("");
		tf_stock.setText("");
	}

	// ����main()��������ҪΪ�˵��Գ������
	public static void main(String[] args) {
		new BookAdd();
	}
}
