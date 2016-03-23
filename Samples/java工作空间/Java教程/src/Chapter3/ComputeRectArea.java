// ComputeRectArea.java
package Chapter3;

class RectConstructor {			// 声明RectConstructor类
	double length;				// 声明成员变量
	double width;

	double area() {				// 定义实例方法
		return length * width;
	}

	RectConstructor(double width, double length) {	// 带参数的构造方法
		this.length = length;	// 为成员变量赋值
		this.width = width;
	}
}

public class ComputeRectArea {	// 声明ComputeRectArea类
	public static void main(String args[]) {
		// 基于创建RectConstructor类分别创建对象rect1和rect2，并为对象赋初值
		RectConstructor rect1 = new RectConstructor(10, 20);
		RectConstructor rect2 = new RectConstructor(3, 6);
		double ar;				// 声明局部变量
		ar = rect1.area();		// 调用对象方法
		System.out.println("第一个长方形的面积是" + ar);
		ar = rect2.area();		//调用对象方法
		System.out.println("第二个长方形的面积是" + ar);
	}
}
