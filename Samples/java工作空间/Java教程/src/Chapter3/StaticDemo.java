// StaticDemo.java
package Chapter3;
public class StaticDemo {
	private int x; 				// ����ʵ������
	private static int y; 		// ���������
	public static void setXY1(int newX, int newY) {	// �����෽��
//		x = newX;		// �Ƿ����෽��ֻ�ܷ��������
        y = newY;		// �Ϸ�
	}
	public void setXY2(int newX, int newY) {		// ����ʵ������
		x = newX;		// �Ϸ�
		y = newY;		// �Ϸ�
	}
	public static void main(String args[]) {	// �����෽��
		StaticDemo t1 = new StaticDemo();		// ��������
		StaticDemo.setXY1(10, 20);				// �Ϸ�
//		StaticDemo.setXY2(10, 30);				// �Ƿ�������ֱ���������ʵ������
		t1.setXY1(1, 18);						// �Ϸ�
		t1.setXY2(9, 28);						// �Ϸ�
	}
}

