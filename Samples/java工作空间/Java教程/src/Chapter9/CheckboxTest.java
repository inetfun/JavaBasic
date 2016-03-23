// CheckboxTest.java
package Chapter9;

import java.awt.*;

public class CheckboxTest extends Frame {
	// 构造方法，用于设置窗体标题、大小，并取消窗体的布局管理器
	public CheckboxTest(String title) { 
		super(title);
		this.setSize(220, 200);
		this.setLayout(null);
	}

	public static void main(String[] args) {
		CheckboxTest app = new CheckboxTest("个人信息");
		// 创建复选框数组，包括性别选项与水果选项
		Checkbox[] chk = { new Checkbox("Male"), new Checkbox("Female"),
				new Checkbox("Apple"), new Checkbox("Orange"),
				new Checkbox("Mango") };
		Label lblPrompt = new Label("个人信息");
		lblPrompt.setBounds(90, 40, 150, 20);
		app.add(lblPrompt);
		// 创建单选按钮对象
		CheckboxGroup sexGroup = new CheckboxGroup();
		Label lblSex = new Label("性别:");
		lblSex.setBounds(30, 70, 50, 20);
		app.add(lblSex);
		for (int k = 0; k < 2; k++) {
			chk[k].setBounds(20, 100 + 50 * k, 50, 20);
			// 将复选框对象指定为CheckboxGroup对象
			chk[k].setCheckboxGroup(sexGroup);
		}
		Label lblFruit = new Label("我喜爱的水果");
		lblFruit.setBounds(110, 70, 90, 20);
		app.add(lblFruit);
		for (int k = 2; k < 5; k++)
			// 设置Checkbox组件的位置
			chk[k].setBounds(125, 100 + 25 * (k - 2), 80, 20);
		for (int k = 0; k < 5; k++)
			// 添加Checkbox组件到窗口
			app.add(chk[k]);
		app.setLocation(200, 100);
		app.setVisible(true);
	}
}
