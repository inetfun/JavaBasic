// ChessPoint_black.java
package Chapter9;

import java.awt.*;
import java.awt.event.*;

//����̳л����ĺ������ಢʵ������������ӿ�
public class ChessPoint_black extends Canvas implements MouseListener {
	ChessPad cp = null;

	ChessPoint_black(ChessPad cp) {
		this.cp = cp;
		addMouseListener(this); // ע�����������
	}

	// ���ú����ӵ���ɫ��λ�úʹ�С
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillOval(0, 0, 14, 14);
	}

	// ʵ����갴�·�����������һ�����ʱ����������ȥ�������ӣ����壩
	public void mousePressed(MouseEvent e) {
		if (e.getModifiers() == InputEvent.BUTTON3_MASK) {
			cp.remove(this);
			cp.chessmancolor = 1;
			cp.text_2.setText("");
			cp.text_1.setText("���������");
		}
	}

	// ��˫������ʱ����Ե���ǰ����
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() >= 2)
			cp.remove(this);
	}

	// ʵ��������������δʵ�ֵķ���
	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
}
