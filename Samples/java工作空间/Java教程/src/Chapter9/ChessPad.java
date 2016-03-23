// ChessPad.java
package Chapter9;

import java.awt.*;
import java.awt.event.*;

public class ChessPad extends Panel implements MouseListener, ActionListener {
	// ����������ɫ������1�����ɫ���ӣ�-1�����ɫ����
	int x = -1, y = -1, chessmancolor = 1;
	Button btn = new Button("���¿���"); // �������¿��ְ�ť
	// ������ʾ����������ı���
	TextField text_1 = new TextField("���������");
	TextField text_2 = new TextField();

	ChessPad() { // ���̹��췽��
		// �������ĳߴ�ͱ�����ɫ����ȡ���䲼�ֹ�����
		this.setSize(440, 400);
		this.setBackground(Color.pink);
		this.setLayout(null);
		addMouseListener(this); // Ϊ��ǰ����ע��MouseEvent������
		btn.setBounds(10, 5, 60, 26); // ���ð�ť��λ�úʹ�С
		btn.addActionListener(this); // Ϊ��ťע��ActionEvent������
		this.add(btn); // ����ť��ӵ������
		// ��������ʾ�ı��������壬��������λ�úʹ�С
		this.add(text_1);
		text_1.setBounds(90, 5, 90, 24);
		this.add(text_2);
		text_2.setBounds(290, 5, 90, 24);
		// �����ı��򲻿��Ա��༭
		text_1.setEditable(false);
		text_2.setEditable(false);
	}

	// ����������۵ķ���
	public void paint(Graphics g) {
		for (int i = 40; i <= 380; i = i + 20) {
			g.drawLine(40, i, 400, i); // ��������ֱ��
		}
		g.drawLine(40, 400, 400, 400); // ���������±߽�
		for (int j = 40; j <= 380; j = j + 20) { // ������������
			g.drawLine(j, 40, j, 400);
		}
		g.drawLine(400, 40, 400, 400); // ���������ұ߽�
		// ���5����Բ��������ʾ��Բ�����Ͻ�x.��y���ꡢ��Ⱥ͸߶�*
		g.fillOval(97, 97, 6, 6);
		g.fillOval(337, 97, 6, 6);
		g.fillOval(97, 337, 6, 6);
		g.fillOval(337, 337, 6, 6);
		g.fillOval(217, 217, 6, 6);
	}

	public void mousePressed(MouseEvent e) { // ʵ����갴�µķ���
		// ����û��������ӣ����¼���ӵ�X��Y����
		// InputEvent���getModifiers()�����������ص�ǰ����״̬
		if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
			// �õ����ӵ�X��Y����
			x = (int) e.getX();
			y = (int) e.getY();
			// ��������Ͱ������
			ChessPoint_black blackPoint = new ChessPoint_black(this);
			ChessPoint_white whitePoint = new ChessPoint_white(this);
			int a = (x + 10) / 20, b = (y + 10) / 20;
			// �������������ⵥ������������
			if (x / 20 < 2 || y / 20 < 2 || x / 20 > 19 || y / 20 > 19) {
			} else {
				// ���Ϊ��ɫ���ӣ�����ӵ����̣������� ���С��λ���Լ���ʾ����ı�
				if (chessmancolor == 1) {
					this.add(blackPoint);
					blackPoint.setBounds(a * 20 - 7, b * 20 - 7, 16, 16);
					chessmancolor = chessmancolor * (-1);
					text_2.setText("���������");
					text_1.setText("");
					// ���Ϊ��ɫ���ӣ�����ӵ�����
				} else if (chessmancolor == -1) {
					this.add(whitePoint);
					whitePoint.setBounds(a * 20 - 7, b * 20 - 7, 16, 16);
					chessmancolor = chessmancolor * (-1);
					text_1.setText("���������");
					text_2.setText("");
				}
			}
		}
	}

	// ʵ�����¿��ֵķ���������������ϵ����Ӳ�����Ϊ��ʼ״̬
	public void actionPerformed(ActionEvent e) {
		this.removeAll(); // ���������Ƴ�ȫ�����
		chessmancolor = 1;
		add(btn);
		btn.setBounds(10, 5, 60, 26);
		text_1.setBounds(90, 5, 90, 24);
		text_1.setText("���������");
		add(text_1);
		text_2.setText("");
		text_2.setBounds(290, 5, 90, 24);
		add(text_2);
	}

	// ʵ���������ӿ�MouseListener�еķ���
	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
}
