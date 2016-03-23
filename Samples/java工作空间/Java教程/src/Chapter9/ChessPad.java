// ChessPad.java
package Chapter9;

import java.awt.*;
import java.awt.event.*;

public class ChessPad extends Panel implements MouseListener, ActionListener {
	// 定义棋子颜色变量，1代表黑色棋子，-1代表白色棋子
	int x = -1, y = -1, chessmancolor = 1;
	Button btn = new Button("重新开局"); // 定义重新开局按钮
	// 定义提示下棋的两个文本框
	TextField text_1 = new TextField("请黑棋下子");
	TextField text_2 = new TextField();

	ChessPad() { // 棋盘构造方法
		// 设置面板的尺寸和背景颜色，并取消其布局管理器
		this.setSize(440, 400);
		this.setBackground(Color.pink);
		this.setLayout(null);
		addMouseListener(this); // 为当前对象注册MouseEvent侦听器
		btn.setBounds(10, 5, 60, 26); // 设置按钮的位置和大小
		btn.addActionListener(this); // 为按钮注册ActionEvent侦听器
		this.add(btn); // 将按钮添加到面板中
		// 将两个提示文本框加入面板，并设置其位置和大小
		this.add(text_1);
		text_1.setBounds(90, 5, 90, 24);
		this.add(text_2);
		text_2.setBounds(290, 5, 90, 24);
		// 设置文本框不可以被编辑
		text_1.setEditable(false);
		text_2.setEditable(false);
	}

	// 绘制棋盘外观的方法
	public void paint(Graphics g) {
		for (int i = 40; i <= 380; i = i + 20) {
			g.drawLine(40, i, 400, i); // 绘制棋盘直线
		}
		g.drawLine(40, 400, 400, 400); // 绘制棋盘下边界
		for (int j = 40; j <= 380; j = j + 20) { // 绘制棋盘竖线
			g.drawLine(j, 40, j, 400);
		}
		g.drawLine(400, 40, 400, 400); // 绘制棋盘右边界
		// 添加5个椭圆，参数表示椭圆的左上角x.、y坐标、宽度和高度*
		g.fillOval(97, 97, 6, 6);
		g.fillOval(337, 97, 6, 6);
		g.fillOval(97, 337, 6, 6);
		g.fillOval(337, 337, 6, 6);
		g.fillOval(217, 217, 6, 6);
	}

	public void mousePressed(MouseEvent e) { // 实现鼠标按下的方法
		// 如果用户单击棋子，则记录棋子的X、Y坐标
		// InputEvent类的getModifiers()方法用来返回当前鼠标的状态
		if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
			// 得到棋子的X、Y坐标
			x = (int) e.getX();
			y = (int) e.getY();
			// 创建黑棋和白棋对象
			ChessPoint_black blackPoint = new ChessPoint_black(this);
			ChessPoint_white whitePoint = new ChessPoint_white(this);
			int a = (x + 10) / 20, b = (y + 10) / 20;
			// 如果鼠标在棋盘外单击，则不下棋子
			if (x / 20 < 2 || y / 20 < 2 || x / 20 > 19 || y / 20 > 19) {
			} else {
				// 如果为黑色棋子，则添加到棋盘，并设置 其大小、位置以及提示框的文本
				if (chessmancolor == 1) {
					this.add(blackPoint);
					blackPoint.setBounds(a * 20 - 7, b * 20 - 7, 16, 16);
					chessmancolor = chessmancolor * (-1);
					text_2.setText("请白棋下子");
					text_1.setText("");
					// 如果为白色棋子，则添加到棋盘
				} else if (chessmancolor == -1) {
					this.add(whitePoint);
					whitePoint.setBounds(a * 20 - 7, b * 20 - 7, 16, 16);
					chessmancolor = chessmancolor * (-1);
					text_1.setText("请黑棋下子");
					text_2.setText("");
				}
			}
		}
	}

	// 实现重新开局的方法，即清除棋盘上的棋子并设置为初始状态
	public void actionPerformed(ActionEvent e) {
		this.removeAll(); // 从容器中移除全部组件
		chessmancolor = 1;
		add(btn);
		btn.setBounds(10, 5, 60, 26);
		text_1.setBounds(90, 5, 90, 24);
		text_1.setText("请黑棋下子");
		add(text_1);
		text_2.setText("");
		text_2.setBounds(290, 5, 90, 24);
		add(text_2);
	}

	// 实现侦听器接口MouseListener中的方法
	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
}
