// ListTest.java
package Chapter9;

import java.awt.*;

public class ListTest {
	public static void main(String[] args) {
		Frame app = new Frame("List���");
		app.setSize(220, 200);
		app.setLayout(null);
		Label lb = new Label("ѡ�����");
		lb.setBounds(80, 70, 50, 20);
		app.add(lb);
		// �����б�������б�������
		List list = new List(4, true);
		list.add("2010��");
		list.add("2009��");
		list.add("2008��");
		list.add("2007��");
		// �����б�Ĵ�С��λ�ã�����ӵ�������
		list.setBounds(80, 100, 65, 70);
		app.add(list);
		app.setVisible(true);
	}
}
