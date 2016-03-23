// ComputeRectCircleArea.java
package Chapter3;

class RectCircleConstructor { // 声明RectConstructor类
	final double PI = 3.14; // 声明常量
	double length; // 声明成员变量
	double width;
	double radius;

	double rectarea() { // 定义实例方法，计算长方形的面积
		return length * width;
	}

	double circlearea() { // 定义实例方法，计算圆的面积
		return PI * radius * radius;
	}

	// 第一个带参数的构造方法，传递长方形的长与宽
	RectCircleConstructor(double width, double length) {
		this.length = length; // 为成员变量赋值
		this.width = width;
	}

	// 第二个带参数的构造方法，传递圆的半径
	RectCircleConstructor(double radius) {
		this.radius = radius;  // 为成员变量赋值
	}
}

public class ComputeRectCircleArea {// 声明ComputeRectArea类
	public static void main(String args[]) {
		// 基于RectCircleConstructor类创建对象rect
		// 并调用第一个构造方法为对象成员变量赋初值
		RectCircleConstructor rect = new RectCircleConstructor(10, 20);
		// 基于RectCircleConstructor类创建对象circle
		// 并调用第二个构造方法为对象成员变量赋初值
		RectCircleConstructor circle = new RectCircleConstructor(6);
		// 调用对象的不同方法分别计算长方形和圆的面积并输出
		System.out.println("长方形的面积是" + rect.rectarea());
		System.out.println("圆的面积是" + circle.circlearea());
	}
}
