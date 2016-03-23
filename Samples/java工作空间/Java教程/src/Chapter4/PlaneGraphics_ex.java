// PlaneGraphics_ex.java
package Chapter4;

abstract class PlaneGraphics { // 平面图形类，抽象类
	private String shape; // 形状

	// 构造方法，将形状类型字符串赋予变量shape
	public PlaneGraphics(String shape) {
		this.shape = shape;
	}

	// 无参构造方法，图形类型为"未知图形"
	public PlaneGraphics() {
		this("未知图形");
	}

	// 计算面积的抽象方法，分号";"必不可少
	public abstract double area();

	// 显示面积，非抽象方法
	public void print() {
		System.out.println(this.shape + "面积为 " + this.area());
	}
}

// 设计长方形类Rectangle，继承平面图形类
class Rectangle extends PlaneGraphics {
	protected double length; // 长度
	protected double width; // 宽度

	// 长方形构造方法
	public Rectangle(double length, double width) {
		super("长方形");
		this.length = length;
		this.width = width;
	}

	// 正方形构造方法，正方形是长方形的特例
	public Rectangle(double width) {
		super("正方形");
		this.length = width;
		this.width = width;
	}

	// 无参构造方法，将length和width均赋0，此时图形形状为"未知图形"
	public Rectangle() {
	}

	// 计算长方形面积，实现父类的抽象方法
	public double area() {
		return width * length;
	}
}

// 设计椭圆类Eclipse，继承平面图形类
class Eclipse extends PlaneGraphics {
	protected double radius_a; // a轴半径
	protected double radius_b; // b轴半径

	// 椭圆构造方法
	public Eclipse(double radius_a, double radius_b) {
		super("椭圆");
		this.radius_a = radius_a;
		this.radius_b = radius_b;
	}

	// 圆构造方法，圆是椭圆的特例
	public Eclipse(double radius_a) {
		super("圆");
		this.radius_a = radius_a;
		this.radius_b = radius_a;
	}

	// 无参构造方法，将radius_a和radius_b均赋0，此时图形形状为"未知图形"
	public Eclipse() {
	}

	// 计算椭圆的面积，实现父类的抽象方法
	public double area() {
		return Math.PI * radius_a * radius_b;
	}
}

// 声明公共类
public class PlaneGraphics_ex {
	// 使用平面图形类及子类
	public static void main(String[] args) {
		// 获得长方形子类实例
		PlaneGraphics g = new Rectangle(10, 20);
		// 调用抽象类中的print()方法
		g.print();
		g = new Rectangle(10); // 正方形
		g.print();
		g = new Rectangle(); // 图形形状未知
		g.print();
		g = new Eclipse(10, 20); // 椭圆
		g.print();
		g = new Eclipse(10); // 圆
		g.print();
		g = new Eclipse(); // 图形形状未知
		g.print();
	}
}
