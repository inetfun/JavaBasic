// ScrollbarTest.java
package Chapter9;

import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class ScrollbarTest implements AdjustmentListener {
	// ��������������
	Frame app = new Frame("Scrollbar���");;
	// ����������ǩ
	Label lblColor[] = { new Label("Red:"), new Label("Green:"),
			new Label("Blue:") };
	// ��������ˮƽ����Ĺ�������������Ϊ20����������СֵΪ0�����ֵΪ255
	Scrollbar scbColor[] = {
			new Scrollbar(Scrollbar.HORIZONTAL, 0, 20, 0, 255),
			new Scrollbar(Scrollbar.HORIZONTAL, 0, 20, 0, 255),
			new Scrollbar(Scrollbar.HORIZONTAL, 0, 20, 0, 255) };

	void sbinit() {
		app.setSize(260, 250);
		app.setLayout(null);
		for (int k = 0; k < 3; k++) { // ���ñ�ǩ���������λ�����С
			lblColor[k].setBounds(110, 60 + 60 * k, 50, 20);
			scbColor[k].setBounds(30, 85 + 60 * k, 200, 20);
			// Ϊ������ע��������
			scbColor[k].addAdjustmentListener(this);
		}
		for (int k = 0; k < 3; k++) { // ����ǩ���������ӵ�������
			app.add(lblColor[k]);
			app.add(scbColor[k]);
		}
		app.setLocation(200, 100);
		app.setVisible(true);
	}

	public static void main(String[] args) {
		// ����������ScrollbarTest����
		ScrollbarTest sbt = new ScrollbarTest();
		// ��ʼ������
		sbt.sbinit();
	}

	public void adjustmentValueChanged(AdjustmentEvent e) {
		Object ob = e.getSource(); // ��ȡ�¼�����
		// �ڿ���̨����ʾ��������ǰֵ
		// ��������getValue()�������ڶ�ȡ��������ǰֵ
		if (ob == scbColor[0]) {
			System.out.print(scbColor[0].getValue()+"  ");
		} else if (ob == scbColor[1]) {
			System.out.print(scbColor[1].getValue()+"  ");
		} else if (ob == scbColor[2]) {
			System.out.print(scbColor[2].getValue()+"  ");
		}
	}
}
