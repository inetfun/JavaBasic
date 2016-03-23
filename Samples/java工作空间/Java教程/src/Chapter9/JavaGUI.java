// JavaGUI.java
package Chapter9;

import java.awt.*;
import java.awt.event.*;

public class JavaGUI {
	// ����һ������
	static Frame f = new Frame("Java GUI��ʾ����");
	// ����������ǩ
	static Label lb1 = new Label("��ӭѧϰJava GUI��̣�");
	static Label lb2 = new Label("��ǰ�����İ�ť�¼���");
	static Label lb3 = new Label("��   ť   ��   ��   ��   ��");
	// ����������ť
	static Button b1 = new Button("��˵���İ�ť");
	static Button b2 = new Button("�˳���ť");

	public static void main(String args[]) {
		// ----------------------------------------------
		// ���ô���ı���ɫ���ٻ�ɫ����ǰ��ɫ����ɫ��
		// �����ǰ��ɫ�������ð�ť��ǩ����ǩ�ȵ�������ɫ
		f.setBackground(Color.orange);
		f.setForeground(Color.red);
		// ���ô���Ŀ�Ⱥ͸߶�
		f.setSize(200, 200);
		// ������Ĳ�������Ϊ˳�򲼾�
		f.setLayout(new FlowLayout());
		// ���ñ�ǩ3�ı���ɫΪ��ɫ
		lb3.setBackground(Color.CYAN);
		// ----------------------------------------------
		// ������ǩ�Ͱ�ť˳����ӵ�������
		f.add(lb1);
		f.add(lb2);
		f.add(lb3);
		f.add(b1);
		f.add(b2);
		// (1)ͨ������addMouseListener����Ϊ��ťb1ע��MouseEvent�¼�
		// ������MouseListener�����У�Ҫ������¼����Ϳ��Դӷ�������
		// ���������磬�������� addMouseListener����Ҫ������¼�ΪMouseEvent
		// (2)�÷����Ĳ������¼�������Ķ���������ʵ���������ӿ�MouseListener
		// (3)MouseListener�������ж���������Դ������ĸ��ֶ�������
		// �����밴ť�Ϸ���������ť������뿪��ť��
		b1.addMouseListener(new Button1Handler());
		// Ϊ��ťb2ע��ActionEvent�¼�������ActionListener��ֻ�е���
		// ��ťʱ�ŷ���ActionEvent�¼�
		b2.addActionListener(new Button2Handler());
		// -----------------------------------------------
		// ʹ��������Ļ�Ͼ��з���
		f.setLocationRelativeTo(null);
		// ʹ����ɼ�
		f.setVisible(true);
	}
}

// ����ʵ��MouseListener�ӿڵ�MouseEvent�¼�������
class Button1Handler implements MouseListener {
	// ��갴��������ϵ��������²��ͷţ�ʱ���ô˷���
	public void mouseClicked(MouseEvent e) {
		JavaGUI.lb3.setText("���ѵ�����꣡");
	}

	// �����뵽����Ϸ�ʱ���ô˷���
	public void mouseEntered(MouseEvent e) {
		JavaGUI.lb3.setText("���ѽ��밴ť�Ϸ���");
	}

	// ����뿪���ʱ���ô˷���
	public void mouseExited(MouseEvent e) {
		JavaGUI.lb3.setText("�����뿪��ť�Ϸ���");
	}

	// ��갴��������ϰ���ʱ���ô˷���
	public void mousePressed(MouseEvent e) {
		JavaGUI.lb3.setText("���Ѱ��°�ť��");
	}

	// ��갴ť��������ͷ�ʱ���ô˷���
	public void mouseReleased(MouseEvent e) {
	}
}

// ����ʵ��ActionListener�ӿڵ�ActionEvent�¼�������
class Button2Handler implements ActionListener {
	// ���ӿ�ֻ��һ������������¼�����ʱ��ϵͳ���Զ����ñ�����
	// ϵͳ������ActionEvent�¼����󱻵����������ݸ��÷���
	public void actionPerformed(ActionEvent e) {
		System.exit(0);  // �˳�ϵͳ
	}
}
