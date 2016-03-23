// ScrollbarTest.java
package Chapter9;

import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class ScrollbarTest implements AdjustmentListener {
	// 声明并创建窗体
	Frame app = new Frame("Scrollbar组件");;
	// 创建三个标签
	Label lblColor[] = { new Label("Red:"), new Label("Green:"),
			new Label("Blue:") };
	// 创建三个水平方向的滚动条，滑块宽度为20，滚动条最小值为0，最大值为255
	Scrollbar scbColor[] = {
			new Scrollbar(Scrollbar.HORIZONTAL, 0, 20, 0, 255),
			new Scrollbar(Scrollbar.HORIZONTAL, 0, 20, 0, 255),
			new Scrollbar(Scrollbar.HORIZONTAL, 0, 20, 0, 255) };

	void sbinit() {
		app.setSize(260, 250);
		app.setLayout(null);
		for (int k = 0; k < 3; k++) { // 设置标签与滚动条的位置与大小
			lblColor[k].setBounds(110, 60 + 60 * k, 50, 20);
			scbColor[k].setBounds(30, 85 + 60 * k, 200, 20);
			// 为滚动条注册侦听器
			scbColor[k].addAdjustmentListener(this);
		}
		for (int k = 0; k < 3; k++) { // 将标签与滚动条添加到窗体中
			app.add(lblColor[k]);
			app.add(scbColor[k]);
		}
		app.setLocation(200, 100);
		app.setVisible(true);
	}

	public static void main(String[] args) {
		// 声明并创建ScrollbarTest对象
		ScrollbarTest sbt = new ScrollbarTest();
		// 初始化对象
		sbt.sbinit();
	}

	public void adjustmentValueChanged(AdjustmentEvent e) {
		Object ob = e.getSource(); // 获取事件对象
		// 在控制台中显示滚动条当前值
		// 滚动条的getValue()方法用于读取滚动条当前值
		if (ob == scbColor[0]) {
			System.out.print(scbColor[0].getValue()+"  ");
		} else if (ob == scbColor[1]) {
			System.out.print(scbColor[1].getValue()+"  ");
		} else if (ob == scbColor[2]) {
			System.out.print(scbColor[2].getValue()+"  ");
		}
	}
}
