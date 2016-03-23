// Questionnaire.java
package Chapter9;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class Questionnaire extends Frame implements ActionListener,
		KeyListener, FocusListener {
	TextField name = new TextField(10); // ���������Ϊ10
	Checkbox man = new Checkbox("��"), woman = new Checkbox("Ů");
	CheckboxGroup sex = new CheckboxGroup(); // �Ա�ѡť��
	TextField age = new TextField("20", 4); // ���䣬��ʼֵΪ20���ı�����Ϊ4
	Choice nativeplace = new Choice(); // ����
	Checkbox like1 = new Checkbox("����"); // ����
	Checkbox like2 = new Checkbox("����");
	Checkbox like3 = new Checkbox("�����");
	List website = new List(4); // ϲ������վ����ʾ4��
	Button btn1 = new Button("ȷ��"); // ȷ�ϡ�ȡ�����˳���ť
	Button btn2 = new Button("ȡ��");
	Button btn3 = new Button("�˳�");
	Label l = new Label("������Ϣ�����");
	Label l1 = new Label("����"), l2 = new Label("�Ա�");
	Label l3 = new Label("����"), l4 = new Label("����");
	Label l5 = new Label("����"), l6 = new Label("ϲ������վ");

	// ���췽�����������ô�����⡢��С����ȡ������Ĳ��ֹ�����
	public Questionnaire(String title) {
		super(title); // ���ø��๹�췽��
		this.setSize(400, 400); // ���ô���ĳߴ�
		this.setLayout(null); // ȡ������Ĳ��ֹ�����
		l.setBounds(150, 50, 100, 20);// ������Ϣ�����
		l1.setBounds(50, 100, 40, 20);// ������ǩ
		name.setBounds(90, 100, 100, 20);// �����ı���
		l2.setBounds(230, 100, 40, 20);// �Ա��ǩ
		man.setCheckboxGroup(sex);// ������ѡ��ť��
		woman.setCheckboxGroup(sex);
		sex.setSelectedCheckbox(man);
		man.setBounds(270, 100, 60, 20);// �е�ѡť
		woman.setBounds(330, 100, 60, 20);// Ů��ѡť
		l3.setBounds(50, 150, 40, 20);// �����ǩ
		age.setBounds(90, 150, 50, 20);// �����ı���
		l4.setBounds(230, 150, 40, 20);// �����ǩ
		nativeplace.add("����");// ����ѡ�������
		nativeplace.add("�Ϻ�");
		nativeplace.add("���");
		nativeplace.add("����");
		nativeplace.add("�㶫");
		nativeplace.add("����");
		nativeplace.setBounds(270, 150, 60, 20);// ����ѡ���
		l5.setBounds(50, 200, 40, 20);// ���ñ�ǩ
		like1.setBounds(90, 200, 60, 20);// ����
		like2.setBounds(150, 200, 60, 20);// ����
		like3.setBounds(210, 200, 100, 20);// �����
		website.add("��     ��"); // ϲ������վ
		website.add("��     ��");
		website.add("��     ��");
		website.add("��     ��");
		website.add("�ϼ���");
		website.add("�»���");
		l6.setBounds(50, 250, 80, 20);// ϲ������վ��ǩ
		website.setBounds(130, 250, 100, 60);// ϲ������վ
		btn1.setBounds(110, 330, 50, 20);// ȷ��
		btn2.setBounds(180, 330, 50, 20);// ȡ��
		btn3.setBounds(250, 330, 50, 20);// �˳�
		this.add(l);// ���������ӵ�������
		this.add(l1);
		this.add(name);
		this.add(l2);
		this.add(man);
		this.add(woman);
		this.add(l3);
		this.add(age);
		this.add(l4);
		this.add(nativeplace);
		this.add(l5);
		this.add(like1);
		this.add(like2);
		this.add(like3);
		this.add(l6);
		this.add(website);
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		setLocationRelativeTo(null); // ʹ��������Ļ�Ͼ��з���
		btn1.addActionListener(this); // Ϊ������ťע���¼�������
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		age.addKeyListener(this); // Ϊ�����ı���ע������¼�������
		age.addFocusListener(this); // Ϊ�����ı���ע�ό���¼�������
	}

	// �����ActionEvent�¼�������
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource(); // ��ȡ�¼�����
		if (ob == btn3) { // �����˳���ť
			System.exit(0); // �˳�ϵͳ
		} else if (ob == btn1) {// ����ȷ�ϰ�ť
			System.out.println("������" + name.getText());
			System.out.println("�Ա�" + sex.getSelectedCheckbox().getLabel());
			System.out.println("���䣺" + age.getText());
			System.out.println("���᣺" + nativeplace.getSelectedItem());
			// �����ѡ��ѡ�У��򷵻����ǩ�������ַ�������Ϊ��
			String s1 = like1.getState() ? like1.getLabel() + "  " : "";
			String s2 = like2.getState() ? like2.getLabel() + "  " : "";
			String s3 = like3.getState() ? like3.getLabel() + "  " : "";
			System.out.println("���ã�" + s1 + s2 + s3);
			System.out.println("ϲ������վ��" + website.getSelectedItem());
		} else if (ob == btn2) { // ����ȡ����ť
			name.setText(""); // ��������ı���
			sex.setSelectedCheckbox(man); // ѡ��"����"��ѡ��ť
			age.setText("20"); // ���������ı���Ϊ20
			like1.setState(false); // ȡ�����ø���ѡ��
			like2.setState(false);
			like3.setState(false);
			website.deselect(website.getSelectedIndex());// ȡ����ѡϲ������վ
		}
	}

	// ����ĳ����ʱ���ô˷���
	public void keyPressed(KeyEvent e) {

	}

	// �ͷ�ĳ����ʱ���ô˷���
	public void keyReleased(KeyEvent e) {
	}

	// ����ĳ����ʱ���ô˷���
	public void keyTyped(KeyEvent e) {
		// ���������ַ���0~9�����߰�����Del����Backspace������
		// ֱ�ӷ��ض���ļ����ַ����������ü�����ַ�Ϊ��λδ֪��0��
		if (((e.getKeyChar() <= 0x39) && (e.getKeyChar() >= 0x30))
				|| (e.getKeyChar() == 127) || (e.getKeyChar() == 8)) {
			e.setKeyChar(e.getKeyChar());
		} else {
			e.setKeyChar((char) 0);
		}

	}

	// �����ı����ü��̽���ʱ���ô˷���
	public void focusGained(FocusEvent e) {
	}

	// �����ı���ʧȥ���̽���ʱ���ô˷���
	public void focusLost(FocusEvent e) {
		// �������ַ���ת��Ϊ����
		int i = Integer.parseInt(age.getText());
		// ������Ч�������ı���ָ�Ĭ��ֵ���ػ���̽���
		if ((i == 0) || (i >= 200)) {
			// ����һ��������ʾ�Ի���
			JOptionPane.showMessageDialog(null, "����������ֵӦ��Ϊ1-199��", "������ʾ",
					JOptionPane.ERROR_MESSAGE);
			age.setText("20"); // �ָ�����Ĭ��ֵ
			age.requestFocusInWindow(); // �����ı����ػ񽹵�
		}
	}

	public static void main(String[] args) {
		Questionnaire app = new Questionnaire("������Ϣ");
		app.setVisible(true);
	}
}
