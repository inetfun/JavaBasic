// Chess.java
package Chapter9;

import java.awt.*;
import java.awt.event.*;

public class Chess extends Frame {
	ChessPad cp = new ChessPad(); // 定义棋盘类

	Chess() { // 定义Chess类的构造方法
		this.setLayout(null); // 取消窗体的默认布局管理器
		// 定义标签并设置其位置、大小和背景颜色，然后将其加入窗体
		Label lb = new Label("单击左键下棋子，双击吃棋子，用右键单击棋子悔棋", Label.CENTER);
		lb.setBounds(70, 55, 440, 26);
		lb.setBackground(Color.orange);
		add(lb);
		add(cp); // 将棋盘加入窗体
		cp.setBounds(70, 90, 440, 440); // 设置棋盘的位置和大小
		// 实现关闭窗口方法
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setSize(600, 550); // 设置窗体的大小
		setLocationRelativeTo(null); // 使窗体在屏幕上居中放置
		this.setVisible(true); // 使窗体可见
	}

	public static void main(String args[]) {
		Chess cs = new Chess();
	}
}
