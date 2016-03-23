// Shapes.java
package Chapter4;
import java.util.*;
// ����һ��Shape����
class Shape {
	public void draw() {
	}
	public void erase() {
	}
}
// ����Shape�ഴ��Circle����
class Circle extends Shape {
	public void draw() {
		System.out.println("Circle.draw()");
	}
	public void erase() {
		System.out.println("Circle.erase()");
	}
}
//����Shape�ഴ��Square����
class Square extends Shape {
	public void draw() {
		System.out.println("Square.draw()");
	}
	public void erase() {
		System.out.println("Square.erase()");
	}
}
//����Shape�ഴ��Triangle����
class Triangle extends Shape {
	public void draw() {
		System.out.println("Triangle.draw()");
	}
	public void erase() {
		System.out.println("Triangle.erase()");
	}
}
// ���������״��������RandomShapeGenerator
class RandomShapeGenerator {
	// ����Random����rand�������������������Ϊ��������47
	private Random rand = new Random(47);
	// ����Shape���ͷ���next
	public Shape next() {
		// rand.nextInt(3)��������0����3֮��������
		switch (rand.nextInt(3)) {
		default:
		case 0:
			return new Circle();	// ����Circle����
		case 1:
			return new Square();	// ����Square����
		case 2:
			return new Triangle();	// ����Triangle����
		}
	}
}
// ���幫����
public class Shapes {
	// ����RandomShapeGenerator�ഴ��˽�о�̬����gen
	private static RandomShapeGenerator gen = new RandomShapeGenerator();
	public static void main(String[] args) {
		Shape[] s = new Shape[9];			// ����Shape�ഴ����������s
		// Ϊ��������s��ֵ��������ӦΪCircle��Square��Triangle�������
		for (int i = 0; i < s.length; i++)
			s[i] = gen.next();
		// ��������s������ֵ������ʱShape����shp
		for (Shape shp : s)
			// ����shp�����draw����������shp�������ݷֱ�ΪCircle��
			// Square��Triangle���ͣ���draw����Ҳ�ֱ�����������������
			shp.draw();
	}
}
