// ListTest.java
package Chapter9;

import java.awt.*;

public class ListTest {
	public static void main(String[] args) {
		Frame app = new Frame("List组件");
		app.setSize(220, 200);
		app.setLayout(null);
		Label lb = new Label("选择年份");
		lb.setBounds(80, 70, 50, 20);
		app.add(lb);
		// 创建列表，并添加列表项内容
		List list = new List(4, true);
		list.add("2010年");
		list.add("2009年");
		list.add("2008年");
		list.add("2007年");
		// 设置列表的大小和位置，并添加到窗体中
		list.setBounds(80, 100, 65, 70);
		app.add(list);
		app.setVisible(true);
	}
}
