// ComputeRectCircleArea.java
package Chapter3;

class RectCircleConstructor { // ����RectConstructor��
	final double PI = 3.14; // ��������
	double length; // ������Ա����
	double width;
	double radius;

	double rectarea() { // ����ʵ�����������㳤���ε����
		return length * width;
	}

	double circlearea() { // ����ʵ������������Բ�����
		return PI * radius * radius;
	}

	// ��һ���������Ĺ��췽�������ݳ����εĳ����
	RectCircleConstructor(double width, double length) {
		this.length = length; // Ϊ��Ա������ֵ
		this.width = width;
	}

	// �ڶ����������Ĺ��췽��������Բ�İ뾶
	RectCircleConstructor(double radius) {
		this.radius = radius;  // Ϊ��Ա������ֵ
	}
}

public class ComputeRectCircleArea {// ����ComputeRectArea��
	public static void main(String args[]) {
		// ����RectCircleConstructor�ഴ������rect
		// �����õ�һ�����췽��Ϊ�����Ա��������ֵ
		RectCircleConstructor rect = new RectCircleConstructor(10, 20);
		// ����RectCircleConstructor�ഴ������circle
		// �����õڶ������췽��Ϊ�����Ա��������ֵ
		RectCircleConstructor circle = new RectCircleConstructor(6);
		// ���ö���Ĳ�ͬ�����ֱ���㳤���κ�Բ����������
		System.out.println("�����ε������" + rect.rectarea());
		System.out.println("Բ�������" + circle.circlearea());
	}
}
