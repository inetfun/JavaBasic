// ComputeRectArea.java
package Chapter3;

class RectConstructor {			// ����RectConstructor��
	double length;				// ������Ա����
	double width;

	double area() {				// ����ʵ������
		return length * width;
	}

	RectConstructor(double width, double length) {	// �������Ĺ��췽��
		this.length = length;	// Ϊ��Ա������ֵ
		this.width = width;
	}
}

public class ComputeRectArea {	// ����ComputeRectArea��
	public static void main(String args[]) {
		// ���ڴ���RectConstructor��ֱ𴴽�����rect1��rect2����Ϊ���󸳳�ֵ
		RectConstructor rect1 = new RectConstructor(10, 20);
		RectConstructor rect2 = new RectConstructor(3, 6);
		double ar;				// �����ֲ�����
		ar = rect1.area();		// ���ö��󷽷�
		System.out.println("��һ�������ε������" + ar);
		ar = rect2.area();		//���ö��󷽷�
		System.out.println("�ڶ��������ε������" + ar);
	}
}
