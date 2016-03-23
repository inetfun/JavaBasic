// ReaderUpdate.java
package MainPro;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

import PublicModule.*;

public class ReaderUpdate extends Frame {
	private static final long serialVersionUID = -4657058729583467505L;
	Label lbreaderid_1 = new Label("���߱��");
	Label lbreaderid = new Label("���߱��");
	Label lbreadername = new Label("��������");
	Label lbreadertype = new Label("�������");
	Label lbsex = new Label("�Ա�");
	Label lbmax_num = new Label("�ɽ�����");
	Label lbdays_num = new Label("�ɽ�����");
	TextField tf_readerid1 = new TextField();
	TextField tf_readerid = new TextField();
	TextField tf_readername = new TextField();
	TextField tf_max_num = new TextField();
	TextField tf_days_num = new TextField();
	Choice tf_readertype = new Choice();
	Choice tf_sex = new Choice();
	Button queryBtn = new Button("��ѯ");
	Button saveBtn = new Button("����");
	Button closeBtn = new Button("�ر�");

	public ReaderUpdate() {
		setLayout(null);
		setTitle("�޸Ķ�����Ϣ");
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
		tf_readerid.setEditable(false); // ��ֹ�޸Ķ��߱��
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

		saveBtn.setBounds(150, 180, 80, 25); // ���水ť
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_saveActionPerformed(e);
			}
		});
		closeBtn.setBounds(280, 180, 80, 25);// �رհ�ť
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
		add(lbreaderid_1);
		add(lbreaderid);
		add(lbreadername);
		add(lbreadertype);
		add(lbsex);
		add(lbmax_num);
		add(lbdays_num);
		add(tf_readerid1);
		add(tf_readerid);
		add(tf_readername);
		add(tf_max_num);
		add(tf_days_num);
		add(tf_readertype);
		add(tf_sex);
		add(saveBtn);
		add(closeBtn);
		add(queryBtn);
		setLocationRelativeTo(null); // ʹ��������Ļ�Ͼ��з���
		setVisible(true); // ʹ����ɼ�
	}

	private void btn_queryActionPerformed(ActionEvent e) {
		String id = tf_readerid1.getText();
		// ������߱��Ϊ�գ�����ֹ��ѯ����
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "���߱�Ų���Ϊ�գ�");
			return;
		}
		// ����Ų�ѯ���ߣ��������reader������
		Reader reader = ReaderSelect.selectReaderById(id);
		// �����ѯ�������������ʾ�ڸ��ı�����
		if (reader != null) {
			tf_readerid.setText(reader.getId());
			tf_readername.setText(reader.getReadername());
			// ��Choice��ѡ��������Ϊ�����Ƶ���ָ���ַ�������
			tf_readertype.select(reader.getReadertype());
			tf_sex.select(reader.getSex());
			tf_days_num.setText(String.valueOf(reader.getDays_num()));
			tf_max_num.setText(String.valueOf(reader.getMax_num()));
		} else
			JOptionPane.showMessageDialog(null, "���߱�����󣬲��޴��ˣ�");
	}

	private void btn_saveActionPerformed(ActionEvent e) {
		String id = tf_readerid.getText();
		String readername = tf_readername.getText();
		String readertype = tf_readertype.getSelectedItem().toString();
		// ������߱��Ϊ�գ�����ֹ�����¼����
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "���߱�Ų���Ϊ�գ�");
			return;
		}
		try {
			int max_num = Integer.parseInt(tf_max_num.getText());
			int days_num = Integer.parseInt(tf_days_num.getText());
			String sex = tf_sex.getSelectedItem().toString();
			String sql = "update reader set readername='" + readername
					+ "',readertype='" + readertype + "',days_num='" + days_num
					+ "',sex='" + sex + "',max_num='" + max_num
					+ "' where id='" + id + "'";
			int i = DbOp.executeUpdate(sql);
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "������Ϣ�޸ĳɹ���");
				// ���ȫ���ı���
				clearAllTextfield();
			} else
				JOptionPane.showMessageDialog(null, "������Ϣ�޸�ʧ�ܣ�");
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "���ɽ��������ɽ�" 
					+ "��������ӦΪ������");
		}
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
		new ReaderUpdate();
	}
}
