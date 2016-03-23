// Shapes.java
package Chapter4;
import java.util.*;
// 创建一个Shape基类
class Shape {
	public void draw() {
	}
	public void erase() {
	}
}
// 基于Shape类创建Circle子类
class Circle extends Shape {
	public void draw() {
		System.out.println("Circle.draw()");
	}
	public void erase() {
		System.out.println("Circle.erase()");
	}
}
//基于Shape类创建Square子类
class Square extends Shape {
	public void draw() {
		System.out.println("Square.draw()");
	}
	public void erase() {
		System.out.println("Square.erase()");
	}
}
//基于Shape类创建Triangle子类
class Triangle extends Shape {
	public void draw() {
		System.out.println("Triangle.draw()");
	}
	public void erase() {
		System.out.println("Triangle.erase()");
	}
}
// 创建随机形状发生器类RandomShapeGenerator
class RandomShapeGenerator {
	// 创建Random类型rand随机数发生器，其种子为长整型数47
	private Random rand = new Random(47);
	// 创建Shape类型方法next
	public Shape next() {
		// rand.nextInt(3)用来产生0——3之间的随机数
		switch (rand.nextInt(3)) {
		default:
		case 0:
			return new Circle();	// 返回Circle对象
		case 1:
			return new Square();	// 返回Square对象
		case 2:
			return new Triangle();	// 返回Triangle对象
		}
	}
}
// 定义公共类
public class Shapes {
	// 基于RandomShapeGenerator类创建私有静态对象gen
	private static RandomShapeGenerator gen = new RandomShapeGenerator();
	public static void main(String[] args) {
		Shape[] s = new Shape[9];			// 基于Shape类创建对象数组s
		// 为对象数组s赋值，其内容应为Circle、Square或Triangle子类对象
		for (int i = 0; i < s.length; i++)
			s[i] = gen.next();
		// 遍历数组s，将其值赋给临时Shape对象shp
		for (Shape shp : s)
			// 调用shp对象的draw方法。由于shp对象内容分别为Circle、
			// Square或Triangle类型，故draw方法也分别隶属于这三种类型
			shp.draw();
	}
}
