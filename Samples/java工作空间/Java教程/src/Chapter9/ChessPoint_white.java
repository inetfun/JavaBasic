// ChessPoint_white.java
package Chapter9;

import java.awt.*;
import java.awt.event.*;

public class ChessPoint_white extends Canvas implements MouseListener {
	ChessPad cp = null;

	ChessPoint_white(ChessPad cp) {
		this.cp = cp;
		addMouseListener(this);
	}

	// ���ð����ӵ���ɫ��λ�úʹ�С
	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(0, 0, 14, 14);
	}

	// ʵ�ֻ���ķ���
	public void mousePressed(MouseEvent e) {
		if (e.getModifiers() == InputEvent.BUTTON3_MASK) {
			cp.remove(this);
			cp.chessmancolor = -1;
			cp.text_2.setText("���������");
			cp.text_1.setText("");
		}
	}

	// ʵ�ֳԵ����ӵķ���
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() >= 2)
			cp.remove(this);
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
}
