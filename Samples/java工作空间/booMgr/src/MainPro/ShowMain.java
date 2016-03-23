// ShowMain.java
package MainPro;

import java.awt.*;
import java.awt.event.*;

import PublicModule.DbOp;

public class ShowMain extends Frame {
	private static final long serialVersionUID = 5003296786441785470L;
	MenuBar menuBar1;
	Menu menu1, menu2, menu3, menu4, menu5, menu6, menu7;
	MenuItem mi_book_add, mi_book_update, mi_book_delete, mi_reader_add,
			mi_reader_update, mi_reader_delete, mi_borrow, mi_back,
			mi_query_book, mi_query_reader, mi_update_pass, mi_exit;

	public void setRights(String rights) {
		// ������ǹ���Ա�����ֹ�û�ά��ͼ����Ϣ�Ͷ�����Ϣ
		// �Լ���ֹ���н��Ĺ�����ֻ�ܲ�ѯ
		if (rights.equals("��")) {
			menu1.setEnabled(false);
			menu5.setEnabled(false);
		}
	}

	public ShowMain() {
		setTitle("ͼ�����ϵͳ");
		setLayout(new BorderLayout());
		setSize(640, 480);
		menuBar1 = new MenuBar();
		menu5 = new Menu("����ά��");// ����ά���˵�
		menu6 = new Menu("ͼ��ά��");// ͼ��ά���˵�
		mi_book_add = new MenuItem("���");// ���ͼ��˵�
		mi_book_update = new MenuItem("�޸�");// �޸�ͼ��˵�
		mi_book_delete = new MenuItem("ɾ��");// ɾ��ͼ��˵�
		menu7 = new Menu("����ά��");// ����ά���˵�
		mi_reader_add = new MenuItem("��Ӷ���");// ��Ӷ��߲˵�
		mi_reader_update = new MenuItem("�޸Ķ���");
		mi_reader_delete = new MenuItem("ɾ������");
		menu1 = new Menu("���Ĺ���");
		mi_borrow = new MenuItem("�������");
		mi_back = new MenuItem("�������");
		menu2 = new Menu("��ѯ����");
		mi_query_book = new MenuItem("ͼ���ѯ");
		mi_query_reader = new MenuItem("���߲�ѯ");
		menu3 = new Menu("ϵͳ����");
		mi_update_pass = new MenuItem("�޸�����");
		mi_exit = new MenuItem("�˳�ϵͳ");
		// ���ͼ��˵�
		mi_book_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookAdd();
			}
		});
		mi_book_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookUpdate();
			}
		});
		mi_book_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookDelete();
			}
		});
		mi_reader_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReaderAdd();
			}
		});
		mi_reader_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReaderUpdate();
			}
		});
		mi_reader_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReaderDelete();
			}
		});

		mi_borrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Borrow();
			}
		});

		mi_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Back();
			}
		});
		mi_query_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookQuery();
			}
		});
		mi_query_reader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReaderQuery();
			}
		});

		mi_update_pass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdatePassword();
			}
		});
		mi_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DbOp.Close(); // �ر����ݿ�
				System.exit(0);
			}
		});
		/* �رմ��� */
		this.addWindowListener(new WindowAdapter() {
			// ��дwindowClosing()����
			public void windowClosing(WindowEvent e) {
				DbOp.Close(); // �ر����ݿ�
				System.exit(0);
			}
		});
		menu5.add(menu6);
		menu6.add(mi_book_add);
		menu6.add(mi_book_update);
		menu6.add(mi_book_delete);
		menu5.add(menu7);
		menu7.add(mi_reader_add);
		menu7.add(mi_reader_update);
		menu7.add(mi_reader_delete);
		menu5.add(menu1);
		menu1.add(mi_borrow);
		menu1.add(mi_back);
		menu5.add(menu2);
		menu2.add(mi_query_book);
		menu2.add(mi_query_reader);
		menu5.add(menu3);
		menu3.add(mi_update_pass);
		menu3.add(mi_exit);
		menuBar1.add(menu5);
		menuBar1.add(menu1);
		menuBar1.add(menu2);
		menuBar1.add(menu3);
		setMenuBar(menuBar1);
		setLocationRelativeTo(null); // ʹ��������Ļ�Ͼ��з���
		setVisible(true); // ʹ����ɼ�
	}

	// ����main()��������ҪΪ�˵��Գ������
	public static void main(String[] args) {
		new ShowMain();
	}
}