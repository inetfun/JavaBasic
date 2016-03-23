// BookDelete.java
package MainPro;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

import PublicModule.*;

public class BookDelete extends Frame {
	private static final long serialVersionUID = 7451605980497182697L;
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
	Button saveBtn = new Button("ɾ��");
	Button closeBtn = new Button("�ر�");
	Button queryBtn = new Button("��ѯ");
	TextField tf_bookid = new TextField();
	TextField tf_bookname = new TextField();
	TextField tf_author = new TextField();
	TextField tf_translator = new TextField();
	TextField tf_publisher = new TextField();
	TextField tf_publish_time = new TextField();
	TextField tf_price = new TextField();
	TextField tf_stock = new TextField();
	TextField tf_bookid1 = new TextField();
	Choice tf_booktype = new Choice();

	public BookDelete() {
		setLayout(null);
		setTitle("ɾ��ͼ��");
		setSize(500, 280);
		lbbookid_1.setBounds(100, 40, 50, 20);// ͼ����
		tf_bookid1.setBounds(160, 40, 100, 20);
		queryBtn.setBounds(280, 40, 80, 20); // ��ѯ��ť
		queryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_queryActionPerformed(e);
			}
		});
		lbbookid.setBounds(50, 80, 50, 20); // ͼ����
		tf_bookid.setBounds(110, 80, 100, 20);
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
		lbstock.setBounds(50, 200, 50, 20);// �������
		tf_stock.setBounds(110, 200, 100, 20);

		saveBtn.setBounds(150, 240, 80, 25); // ɾ����ť
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_delActionPerformed(e);

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
		add(lbbookid); // ����������ӵ�������
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
		add(tf_bookid1);
		add(tf_booktype);
		setLocationRelativeTo(null); // ʹ��������Ļ�Ͼ��з���
		setVisible(true); // ʹ����ɼ�
	}

	private void btn_delActionPerformed(ActionEvent e) {
		String id = tf_bookid.getText();
		// ���ͼ����Ϊ�գ���ɾ��������ֹ
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "ͼ���Ų���Ϊ�գ�");
			return;
		}
		String sql = "delete from book where id='" + id + "'";
		int i = DbOp.executeUpdate(sql);
		if (i == 1) {
			JOptionPane.showMessageDialog(null, "ͼ����Ϣɾ���ɹ�!");
			// ���ȫ���ı���
			clearAllTextfield();
		} else
			JOptionPane.showMessageDialog(null, "ͼ����Ϣɾ��ʧ�ܣ�");
	}

	private void btn_queryActionPerformed(ActionEvent e) {
		String id = tf_bookid1.getText();
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
			tf_bookid.setEditable(false);
			tf_bookname.setText(book.getBookname());
			// ��Choice��ѡ��������Ϊ�����Ƶ���ָ���ַ�������
			tf_booktype.select(book.getBooktype());
			tf_author.setText(book.getAuthor());
			tf_translator.setText(book.getTranslator());
			tf_publisher.setText(book.getPublisher());
			tf_publish_time.setText(book.getPublish_time().toString());
			tf_price.setText(String.valueOf((book.getPrice())));
			tf_stock.setText(String.valueOf(book.getStock()));
		} else
			JOptionPane.showMessageDialog(null, "ͼ�������󣬲��޴��飡");
	}

	// ���ȫ���ı���
	private void clearAllTextfield() {
		tf_bookid1.setText("");
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
		new BookDelete();
	}
}
