// ChoiceTest.java
package Chapter9;
import java.awt.*;
public class ChoiceTest {
	public static void main(String[] args) {
		Frame myWin = new Frame("choice���");
		myWin.setSize(250, 200);
		myWin.setLayout(null);
		Label lblDepiction = new Label("The book of which I am fondest:");
		lblDepiction.setBounds(30, 40, 200, 20);
		// ����ѡ��򣬲�����ѡ����λ��
		Choice chcBook = new Choice();
		chcBook.setLocation(25, 65);
		// ��ѡ����ӵ�������
		chcBook.add("Gone with the Wind");
		chcBook.add("The Old Man and the Sea");
		chcBook.add("David Copperfield");
		chcBook.add("The Adventures of Tom Sawyer");
		// ����ǩ��ѡ�����ӵ�������
		myWin.add(lblDepiction);
		myWin.add(chcBook);
		myWin.setVisible(true);
	}
}
