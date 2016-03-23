// ChessPoint_black.java
package Chapter9;

import java.awt.*;
import java.awt.event.*;

//定义继承画布的黑棋子类并实现鼠标侦听器接口
public class ChessPoint_black extends Canvas implements MouseListener {
	ChessPad cp = null;

	ChessPoint_black(ChessPad cp) {
		this.cp = cp;
		addMouseListener(this); // 注册鼠标侦听器
	}

	// 设置黑棋子的颜色、位置和大小
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillOval(0, 0, 14, 14);
	}

	// 实现鼠标按下方法，当鼠标右击棋子时，从棋盘中去掉该棋子（悔棋）
	public void mousePressed(MouseEvent e) {
		if (e.getModifiers() == InputEvent.BUTTON3_MASK) {
			cp.remove(this);
			cp.chessmancolor = 1;
			cp.text_2.setText("");
			cp.text_1.setText("请黑棋下子");
		}
	}

	// 当双击棋子时，则吃掉当前棋子
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() >= 2)
			cp.remove(this);
	}

	// 实现鼠标侦听口类的未实现的方法
	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
}
