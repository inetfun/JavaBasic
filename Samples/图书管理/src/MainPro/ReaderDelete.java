// ReaderDelete.java
package MainPro;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

import PublicModule.*;

public class ReaderDelete extends Frame {
	private static final long serialVersionUID = 8992814149454286463L;
	Label lbreaderid = new Label("���߱��");
	Label lbreaderid_1 = new Label("���߱��");
	Label lbreadername = new Label("��������");
	Label lbreadertype = new Label("�������");
	Label lbsex = new Label("�Ա�");
	Label lbmax_num = new Label("�ɽ�����");
	Label lbdays_num = new Label("�ɽ�����");
	TextField tf_readerid = new TextField();
	TextField tf_readername = new TextField();
	TextField tf_max_num = new TextField();
	TextField tf_days_num = new TextField();
	TextField tf_readerid1 = new TextField();
	Choice tf_readertype = new Choice();
	Choice tf_sex = new Choice();
	Button queryBtn = new Button("��ѯ");
	Button delBtn = new Button("ɾ��");
	Button closeBtn = new Button("�ر�");

	public ReaderDelete() {
		setLayout(null);
		setTitle("ɾ��������Ϣ");
		setSize(500, 240);
		lbreaderid_1.setBounds(100, 40, 50, 20); // ���߱��
		tf_readerid1.setBounds(160, 40, 100, 20);
		queryBtn.setBounds(290, 40, 80, 20); // ��ѯ��ť
		queryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_queryActionPerformed(e);
			}
		});
		lbreaderid.setBounds(50, 80, 50, 20); // ���߱��
		tf_readerid.setBounds(110, 80, 100, 20);
		lbreadername.setBounds(240, 80, 50, 20); // ��������
		tf_readername.setBounds(300, 80, 100, 20);
		lbreadertype.setBounds(50, 110, 50, 20); // �������
		tf_readertype.setBounds(110, 110, 100, 20);
		tf_readertype.add("��ʦ");
		tf_readertype.add("ѧ��");
		tf_readertype.add("ְ��");
		lbsex.setBounds(240, 110, 50, 20); // �Ա�
		tf_sex.setBounds(300, 110, 100, 20);
		tf_sex.add("��");
		tf_sex.add("Ů");
		lbmax_num.setBounds(50, 140, 50, 20); // ���ɽ���
		tf_max_num.setBounds(110, 140, 100, 20);
		lbdays_num.setBounds(240, 140, 50, 20); // ���ɽ�����
		tf_days_num.setBounds(300, 140, 100, 20);

		delBtn.setBounds(150, 180, 80, 25); // ɾ����ť
		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_delActionPerformed(e);
			}
		});
		closeBtn.setBounds(280, 180, 80, 25); // �رհ�ť
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
		add(lbreaderid); // ���������ӵ�������
		add(lbreaderid_1);
		add(lbreadername);
		add(lbreadertype);
		add(lbsex);
		add(lbmax_num);
		add(lbdays_num);
		add(tf_readerid);
		add(tf_readername);
		add(tf_max_num);
		add(tf_days_num);
		add(tf_readerid1);
		add(tf_readertype);
		add(tf_sex);
		add(delBtn);
		add(closeBtn);
		add(queryBtn);
		setLocationRelativeTo(null); // ʹ��������Ļ�Ͼ��з���
		setVisible(true); // ʹ����ɼ�
	}

	private void btn_delActionPerformed(ActionEvent e) {
		String id = tf_readerid.getText();
		// ������߱��Ϊ�գ�����ֹɾ������
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "���߱�Ų���Ϊ�գ�");
			return;
		}
		String sql = "delete from reader where id='" + id + "'";
		int i = DbOp.executeUpdate(sql);
		if (i == 1) {
			JOptionPane.showMessageDialog(null, "������Ϣɾ���ɹ���");
			// ���ȫ���ı���
			clearAllTextfield();
		} else
			JOptionPane.showMessageDialog(null, "���߱�����󣬲��޴��ˣ�");
	}

	private void btn_queryActionPerformed(ActionEvent e) {
		String id = tf_readerid1.getText();
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "���߱�Ų���Ϊ�գ�");
			return;
		}
		// ����Ų�ѯ���ߣ��������reader������
		Reader reader = ReaderSelect.selectReaderById(id);
		// �����ѯ�������������ʾ�ڸ��ı�����
		if (reader != null) {
			tf_readerid.setText(reader.getId());
			tf_readerid.setEditable(false);
			tf_readername.setText(reader.getReadername());
			// ��Choice��ѡ��������Ϊ�����Ƶ���ָ���ַ�������
			tf_readertype.select(reader.getReadertype());
			tf_sex.select(reader.getSex());
			tf_max_num.setText(String.valueOf(reader.getMax_num()));
			tf_days_num.setText(String.valueOf(reader.getDays_num()));
		} else
			JOptionPane.showMessageDialog(null, "���߱�����󣬲��޴��ˣ�");
	}

	// ���ȫ���ı���
	private void clearAllTextfield() {
		tf_readerid1.setText("");
		tf_readerid.setText("");
		tf_readername.setText("");
		tf_max_num.setText("");
		tf_days_num.setText("");
	}

	// ����main()��������ҪΪ�˵��Գ������
	public static void main(String[] args) {
		new ReaderDelete();
	}
}
