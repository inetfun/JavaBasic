// PaintRectangle.java
package Chapter3;

import java.awt.*;

public class PaintRectangle extends Frame {
	private int x, y, width, height; // 声明私有变量

	// 绘制一个窗口并使其可见，此时系统会自动调用paint方法
	public void init() {
		setSize(400, 200); // 设置窗口大小
		setVisible(true); // 使窗口可见
	}

	// 无参数的构造方法，使全部成员变量均为0
	public PaintRectangle() {
		x = 0;
		y = 0;
		width = 0;
		height = 0;
	}

	// 带参数的构造方法，为成员变量赋值
	public PaintRectangle(int xPos, int yPos, int w, int h) {
		x = xPos;
		y = yPos;
		width = w;
		height = h;
	}

	// 定义图形位置与大小的方法
	public void setPosition(int xPos, int yPos, int w, int h) {
		x = xPos;
		y = yPos;
		width = w;
		height = h;
	}

	// 重定义paint方法，在屏幕上绘制矩形并输出坐标信息
	// 该方法在绘画时会被自动调用
	public void paint(Graphics g) {
		PaintRectangle b1; // 声明对象
		// 创建对象并调用无参数构造方法，使全部成员变量均为0
		b1 = new PaintRectangle();
		// 创建对象并调用有参数构造方法
		PaintRectangle b2 = new PaintRectangle(170, 40, 60, 60);
		// 为成员变量赋值
		b1.setPosition(20, 40, 60, 60);
		b1.draw(g); // 调用b1对象的draw方法，绘制矩形
		g.drawString("矩形1的X坐标：" + b1.x, 20, 120);
		g.drawString("矩形1的Y坐标：" + b1.y, 20, 140);
		b2.draw(g); // 调用b2对象的draw方法，绘制矩形
		g.drawString("矩形2的X坐标：" + b2.x, 170, 120);
		g.drawString("矩形2的Y坐标：" + b2.y, 170, 140);
	}

	// 定义draw方法，绘制矩形
	public void draw(Graphics g) {
		g.drawRect(x, y, width, height);
	}

	public static void main(String[] args) {
		// 创建对象并调用无参数构造方法，然后调用init方法
		new PaintRectangle().init();
	}
}
