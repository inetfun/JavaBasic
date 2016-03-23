// PlaneGraphics_ex.java
package Chapter4;

abstract class PlaneGraphics { // ƽ��ͼ���࣬������
	private String shape; // ��״

	// ���췽��������״�����ַ����������shape
	public PlaneGraphics(String shape) {
		this.shape = shape;
	}

	// �޲ι��췽����ͼ������Ϊ"δ֪ͼ��"
	public PlaneGraphics() {
		this("δ֪ͼ��");
	}

	// ��������ĳ��󷽷����ֺ�";"�ز�����
	public abstract double area();

	// ��ʾ������ǳ��󷽷�
	public void print() {
		System.out.println(this.shape + "���Ϊ " + this.area());
	}
}

// ��Ƴ�������Rectangle���̳�ƽ��ͼ����
class Rectangle extends PlaneGraphics {
	protected double length; // ����
	protected double width; // ���

	// �����ι��췽��
	public Rectangle(double length, double width) {
		super("������");
		this.length = length;
		this.width = width;
	}

	// �����ι��췽�����������ǳ����ε�����
	public Rectangle(double width) {
		super("������");
		this.length = width;
		this.width = width;
	}

	// �޲ι��췽������length��width����0����ʱͼ����״Ϊ"δ֪ͼ��"
	public Rectangle() {
	}

	// ���㳤���������ʵ�ָ���ĳ��󷽷�
	public double area() {
		return width * length;
	}
}

// �����Բ��Eclipse���̳�ƽ��ͼ����
class Eclipse extends PlaneGraphics {
	protected double radius_a; // a��뾶
	protected double radius_b; // b��뾶

	// ��Բ���췽��
	public Eclipse(double radius_a, double radius_b) {
		super("��Բ");
		this.radius_a = radius_a;
		this.radius_b = radius_b;
	}

	// Բ���췽����Բ����Բ������
	public Eclipse(double radius_a) {
		super("Բ");
		this.radius_a = radius_a;
		this.radius_b = radius_a;
	}

	// �޲ι��췽������radius_a��radius_b����0����ʱͼ����״Ϊ"δ֪ͼ��"
	public Eclipse() {
	}

	// ������Բ�������ʵ�ָ���ĳ��󷽷�
	public double area() {
		return Math.PI * radius_a * radius_b;
	}
}

// ����������
public class PlaneGraphics_ex {
	// ʹ��ƽ��ͼ���༰����
	public static void main(String[] args) {
		// ��ó���������ʵ��
		PlaneGraphics g = new Rectangle(10, 20);
		// ���ó������е�print()����
		g.print();
		g = new Rectangle(10); // ������
		g.print();
		g = new Rectangle(); // ͼ����״δ֪
		g.print();
		g = new Eclipse(10, 20); // ��Բ
		g.print();
		g = new Eclipse(10); // Բ
		g.print();
		g = new Eclipse(); // ͼ����״δ֪
		g.print();
	}
}
