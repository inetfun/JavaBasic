// Chess.java
package Chapter9;

import java.awt.*;
import java.awt.event.*;

public class Chess extends Frame {
	ChessPad cp = new ChessPad(); // ����������

	Chess() { // ����Chess��Ĺ��췽��
		this.setLayout(null); // ȡ�������Ĭ�ϲ��ֹ�����
		// �����ǩ��������λ�á���С�ͱ�����ɫ��Ȼ������봰��
		Label lb = new Label("������������ӣ�˫�������ӣ����Ҽ��������ӻ���", Label.CENTER);
		lb.setBounds(70, 55, 440, 26);
		lb.setBackground(Color.orange);
		add(lb);
		add(cp); // �����̼��봰��
		cp.setBounds(70, 90, 440, 440); // �������̵�λ�úʹ�С
		// ʵ�ֹرմ��ڷ���
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setSize(600, 550); // ���ô���Ĵ�С
		setLocationRelativeTo(null); // ʹ��������Ļ�Ͼ��з���
		this.setVisible(true); // ʹ����ɼ�
	}

	public static void main(String args[]) {
		Chess cs = new Chess();
	}
}
