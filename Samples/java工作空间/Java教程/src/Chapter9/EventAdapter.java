// EventAdapter.java
package Chapter9;

import java.awt.*;
import java.awt.event.*;

public class EventAdapter extends Frame {
	private TextArea txtApp = new TextArea("�����ı�����");
	private Button btnApp = new Button("���ǰ�ť");
	// ��������¼�������
	MouseEventHandler handler = new MouseEventHandler();

	public EventAdapter(String title) {
		super(title);
		// Ϊ����ע�ᴰ���¼�������
		this.addWindowListener(new WindowAdapter() {
			// ��дwindowClosing()����
			public void windowClosing(WindowEvent e) { // �رյ�ǰ����
				System.exit(0);
			}
		});
		// ���ô���ĳߴ磬ȡ���䲼�ֹ���������ʹ��������Ļ�Ͼ��з���
		this.setSize(300, 200);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		// �����ı�������塢λ�úͳߴ�
		txtApp.setFont(new Font("����", Font.PLAIN, 16));
		txtApp.setBounds(0, 30, 300, 100);
		// Ϊ�ı���ע������¼�������
		txtApp.addMouseListener(handler);
		// ���ð�ť��λ�úͳߴ�
		btnApp.setBounds(120, 150, 60, 30);
		// Ϊ��ťע������¼�������
		btnApp.addMouseListener(handler);
		// ���ı���Ͱ�ť��ӵ�������
		this.add(txtApp);
		this.add(btnApp);
		// ��ʾ����
		this.setVisible(true);
	}

	public static void main(String args[]) {
		new EventAdapter("Adapter Usage Demo");
	}

	// ����̳�MouseAdapter���������¼���������
	class MouseEventHandler extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			// ����¼�Դ���ı����ǰ�ť
			if (e.getSource() == txtApp) {
				String s = "����������λ��Ϊ�ı���\n";
				s += "���������λ��Ϊ:\nX=" + e.getX() + ";Y=" + e.getY();
				// �ú�ɫ������ʾ�������λ������
				txtApp.setForeground(Color.RED);
				txtApp.setText(s);
			}
			if (e.getSource() == btnApp) {
				String s = "����������λ��Ϊ��ť��\n";
				s += "���������λ��Ϊ:\nX=" + e.getX() + ";Y=" + e.getY();
				// ����ɫ������ʾ�������λ������
				txtApp.setForeground(Color.BLUE);
				txtApp.setText(s);
			}
		}
	}
}
