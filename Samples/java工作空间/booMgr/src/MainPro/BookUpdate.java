// BookUpdate.java
package MainPro;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import PublicModule.*;

public class BookUpdate extends Frame {
	private static final long serialVersionUID = -7074630570516408587L;
	Label lbbookid_1 = new Label("ͼ����");
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
	Button queryBtn = new Button("��ѯ");
	TextField tf_bookid_1 = new TextField();
	TextField tf_bookid = new TextField();
	TextField tf_bookname = new TextField();
	TextField tf_author = new TextField();
	TextField tf_translator = new TextField();
	TextField tf_publisher = new TextField();
	TextField tf_publish_time = new TextField();
	TextField tf_price = new TextField();
	TextField tf_stock = new TextField();
	Choice tf_booktype = new Choice();

	public BookUpdate() {
		setLayout(null);
		setTitle("�޸�ͼ��");
		setSize(500, 280);
		lbbookid_1.setBounds(100, 40, 50, 20); // ͼ����
		tf_bookid_1.setBounds(160, 40, 100, 20);
		queryBtn.setBounds(280, 40, 80, 20); // ��ѯ��ť
		queryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_queryActionPerformed(e);
			}
		});
		lbbookid.setBounds(50, 80, 50, 20); // ͼ����
		tf_bookid.setBounds(110, 80, 100, 20);
		tf_bookid.setEditable(false); // ��ֹ�޸�ͼ����
		lbbookname.setBounds(240, 80, 50, 20); // ͼ������
		tf_bookname.setBounds(300, 80, 100, 20);
		lbbooktype.setBounds(50, 110, 50, 20); // ͼ�����
		tf_booktype.setBounds(110, 110, 100, 20);
		tf_booktype.add("�Ƽ�");
		tf_booktype.add("��ѧ");
		tf_booktype.add("���");
		tf_booktype.add("����");
		lbauthor.setBounds(240, 110, 50, 20); // ����
		tf_author.setBounds(300, 110, 100, 20);
		lbtranslator.setBounds(50, 140, 50, 20); // ����
		tf_translator.setBounds(110, 140, 100, 20);
		lbpublisher.setBounds(240, 140, 50, 20); // ������
		tf_publisher.setBounds(300, 140, 100, 20);
		lbpublish_time.setBounds(50, 170, 50, 20); // ����ʱ��
		tf_publish_time.setBounds(110, 170, 100, 20);
		lbprice.setBounds(240, 170, 50, 20); // �۸�
		tf_price.setBounds(300, 170, 100, 20);
		lbstock.setBounds(50, 200, 50, 20); // �������
		tf_stock.setBounds(110, 200, 100, 20);

		saveBtn.setBounds(150, 240, 80, 25); // ���水ť
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_saveActionPerformed(e);
			}

		});
		closeBtn.setBounds(280, 240, 80, 25); // �رհ�ť
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
		add(lbbookid);
		add(lbbookid_1);
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
		add(queryBtn);
		add(tf_bookid);
		add(tf_bookname);
		add(tf_author);
		add(tf_translator);
		add(tf_publisher);
		add(tf_publish_time);
		add(tf_price);
		add(tf_stock);
		add(tf_bookid_1);
		add(tf_booktype);
		setLocationRelativeTo(null); // ʹ��������Ļ�Ͼ��з���
		setVisible(true); // ʹ����ɼ�
	}

	// ��ͼ���Ų�ѯͼ���¼
	public void btn_queryActionPerformed(ActionEvent e)  {
		String id = tf_bookid_1.getText();
		// ���ͼ����Ϊ�գ����ѯ������ֹ
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "ͼ���Ų���Ϊ�գ�");
			return;
		}
		// ����Ų�ѯͼ�飬�������book������
		Book book = BookSelect.SelectBookById(id);
		// �����ѯ�������������ʾ�ڸ��ı�����
		if (book != null) {
			tf_bookid.setText(book.getId());
			tf_bookname.setText(book.getBookname());
			// ��Choice��ѡ��������Ϊ�����Ƶ���ָ���ַ�������
			tf_booktype.select(book.getBooktype());
			tf_author.setText(book.getAuthor());
			tf_translator.setText(book.getTranslator());
			tf_publisher.setText(book.getPublisher());
			tf_publish_time.setText(book.getPublish_time().toString());
			tf_price.setText(String.valueOf(book.getPrice()));
			tf_stock.setText(String.valueOf(book.getStock()));
		} else
			JOptionPane.showMessageDialog(null, "ͼ�������󣬲��޴��飡");
	}

	// �����޸ĵļ�¼
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
		try {
			// -------------------------------------------------
			// ���³������ڼ�������Ƿ���Ч�����������Ч�����
			// ����ParseException�쳣
			// ����һ�������ڸ�ʽ����ע�⣺MMһ��Ҫ�ô�д
			// �����û��������ڵĸ�ʽ����-�£���2010-7��2009-10��
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			// ���ַ���ת��Ϊ����
			sdf.parse(tf_publish_time.getText());
			// -------------------------------------------------
			float price = Float.parseFloat(tf_price.getText());
			int stock = Integer.parseInt(tf_stock.getText());
			String sql = "update book set bookname='" + bookname
					+ "',booktype='" + booktype + "',author='" + author
					+ "',translator='" + translator + "',publisher='"
					+ publisher + "',publish_time='" + publish_time
					+ "',price='" + price + "',stock='" + stock
					+ "' where id='" + id + "'";
			int i = DbOp.executeUpdate(sql);
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "ͼ����Ϣ�޸ĳɹ���");
				// ���ȫ���ı���
				clearAllTextfield();
			} else
				JOptionPane.showMessageDialog(null, "��������ͼ����Ϣ�޸�ʧ�ܣ�");
		} catch (ParseException e2) {
			JOptionPane.showMessageDialog(null, "����ʱ���ʽ�����ꡪ�£���");
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "�۸������������ӦΪ���֣�");
		}
	}

	// ���ȫ���ı���
	private void clearAllTextfield() {
		tf_bookid_1.setText("");
		tf_bookid.setText("");
		tf_bookname.setText("");
		tf_author.setText("");
		tf_translator.setText("");
		tf_publisher.setText("");
		tf_publish_time.setText("");
		tf_price.setText("");
		tf_stock.setText("");
	}

	public static void main(String[] args) {
		new BookUpdate();
	}
}
