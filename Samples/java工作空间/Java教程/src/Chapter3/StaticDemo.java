// StaticDemo.java
package Chapter3;
public class StaticDemo {
	private int x; 				// 声明实例变量
	private static int y; 		// 声明类变量
	public static void setXY1(int newX, int newY) {	// 声明类方法
//		x = newX;		// 非法，类方法只能访问类变量
        y = newY;		// 合法
	}
	public void setXY2(int newX, int newY) {		// 声明实例方法
		x = newX;		// 合法
		y = newY;		// 合法
	}
	public static void main(String args[]) {	// 声明类方法
		StaticDemo t1 = new StaticDemo();		// 创建对象
		StaticDemo.setXY1(10, 20);				// 合法
//		StaticDemo.setXY2(10, 30);				// 非法，不能直接引用类的实例方法
		t1.setXY1(1, 18);						// 合法
		t1.setXY2(9, 28);						// 合法
	}
}

