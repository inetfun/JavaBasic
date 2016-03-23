// ChoiceTest.java
package Chapter9;
import java.awt.*;
public class ChoiceTest {
	public static void main(String[] args) {
		Frame myWin = new Frame("choice组件");
		myWin.setSize(250, 200);
		myWin.setLayout(null);
		Label lblDepiction = new Label("The book of which I am fondest:");
		lblDepiction.setBounds(30, 40, 200, 20);
		// 创建选项框，并设置选项框的位置
		Choice chcBook = new Choice();
		chcBook.setLocation(25, 65);
		// 将选项添加到窗口中
		chcBook.add("Gone with the Wind");
		chcBook.add("The Old Man and the Sea");
		chcBook.add("David Copperfield");
		chcBook.add("The Adventures of Tom Sawyer");
		// 将标签、选项框添加到窗体中
		myWin.add(lblDepiction);
		myWin.add(chcBook);
		myWin.setVisible(true);
	}
}
