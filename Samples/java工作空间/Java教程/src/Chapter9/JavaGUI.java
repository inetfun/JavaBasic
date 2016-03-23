// JavaGUI.java
package Chapter9;

import java.awt.*;
import java.awt.event.*;

public class JavaGUI {
	// 创建一个窗体
	static Frame f = new Frame("Java GUI演示程序");
	// 创建三个标签
	static Label lb1 = new Label("欢迎学习Java GUI编程！");
	static Label lb2 = new Label("当前发生的按钮事件：");
	static Label lb3 = new Label("按   钮   事   件   描   述");
	// 创建两个按钮
	static Button b1 = new Button("会说话的按钮");
	static Button b2 = new Button("退出按钮");

	public static void main(String args[]) {
		// ----------------------------------------------
		// 设置窗体的背景色（橘黄色）与前景色（红色）
		// 窗体的前景色用于设置按钮标签、标签等的文字颜色
		f.setBackground(Color.orange);
		f.setForeground(Color.red);
		// 设置窗体的宽度和高度
		f.setSize(200, 200);
		// 将窗体的布局设置为顺序布局
		f.setLayout(new FlowLayout());
		// 设置标签3的背景色为青色
		lb3.setBackground(Color.CYAN);
		// ----------------------------------------------
		// 将各标签和按钮顺序添加到窗体中
		f.add(lb1);
		f.add(lb2);
		f.add(lb3);
		f.add(b1);
		f.add(b2);
		// (1)通过调用addMouseListener方法为按钮b1注册MouseEvent事件
		// 侦听器MouseListener。其中，要处理的事件类型可以从方法名中
		// 看出。例如，本方法是 addMouseListener，则要处理的事件为MouseEvent
		// (2)该方法的参数是事件处理类的对象，它必须实现侦听器接口MouseListener
		// (3)MouseListener侦听器有多个方法，以处理鼠标的各种动作，如
		// 鼠标进入按钮上方、单击按钮、鼠标离开按钮等
		b1.addMouseListener(new Button1Handler());
		// 为按钮b2注册ActionEvent事件侦听器ActionListener。只有单击
		// 按钮时才发生ActionEvent事件
		b2.addActionListener(new Button2Handler());
		// -----------------------------------------------
		// 使窗体在屏幕上居中放置
		f.setLocationRelativeTo(null);
		// 使窗体可见
		f.setVisible(true);
	}
}

// 定义实现MouseListener接口的MouseEvent事件处理类
class Button1Handler implements MouseListener {
	// 鼠标按键在组件上单击（按下并释放）时调用此方法
	public void mouseClicked(MouseEvent e) {
		JavaGUI.lb3.setText("你已单击鼠标！");
	}

	// 鼠标进入到组件上方时调用此方法
	public void mouseEntered(MouseEvent e) {
		JavaGUI.lb3.setText("你已进入按钮上方！");
	}

	// 鼠标离开组件时调用此方法
	public void mouseExited(MouseEvent e) {
		JavaGUI.lb3.setText("你已离开按钮上方！");
	}

	// 鼠标按键在组件上按下时调用此方法
	public void mousePressed(MouseEvent e) {
		JavaGUI.lb3.setText("你已按下按钮！");
	}

	// 鼠标按钮在组件上释放时调用此方法
	public void mouseReleased(MouseEvent e) {
	}
}

// 定义实现ActionListener接口的ActionEvent事件处理类
class Button2Handler implements ActionListener {
	// 本接口只有一个方法，因此事件发生时，系统会自动调用本方法
	// 系统产生的ActionEvent事件对象被当作参数传递给该方法
	public void actionPerformed(ActionEvent e) {
		System.exit(0);  // 退出系统
	}
}
