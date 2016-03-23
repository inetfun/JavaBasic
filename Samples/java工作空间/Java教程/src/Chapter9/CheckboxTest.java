// CheckboxTest.java
package Chapter9;

import java.awt.*;

public class CheckboxTest extends Frame {
	// ���췽�����������ô�����⡢��С����ȡ������Ĳ��ֹ�����
	public CheckboxTest(String title) { 
		super(title);
		this.setSize(220, 200);
		this.setLayout(null);
	}

	public static void main(String[] args) {
		CheckboxTest app = new CheckboxTest("������Ϣ");
		// ������ѡ�����飬�����Ա�ѡ����ˮ��ѡ��
		Checkbox[] chk = { new Checkbox("Male"), new Checkbox("Female"),
				new Checkbox("Apple"), new Checkbox("Orange"),
				new Checkbox("Mango") };
		Label lblPrompt = new Label("������Ϣ");
		lblPrompt.setBounds(90, 40, 150, 20);
		app.add(lblPrompt);
		// ������ѡ��ť����
		CheckboxGroup sexGroup = new CheckboxGroup();
		Label lblSex = new Label("�Ա�:");
		lblSex.setBounds(30, 70, 50, 20);
		app.add(lblSex);
		for (int k = 0; k < 2; k++) {
			chk[k].setBounds(20, 100 + 50 * k, 50, 20);
			// ����ѡ�����ָ��ΪCheckboxGroup����
			chk[k].setCheckboxGroup(sexGroup);
		}
		Label lblFruit = new Label("��ϲ����ˮ��");
		lblFruit.setBounds(110, 70, 90, 20);
		app.add(lblFruit);
		for (int k = 2; k < 5; k++)
			// ����Checkbox�����λ��
			chk[k].setBounds(125, 100 + 25 * (k - 2), 80, 20);
		for (int k = 0; k < 5; k++)
			// ���Checkbox���������
			app.add(chk[k]);
		app.setLocation(200, 100);
		app.setVisible(true);
	}
}
