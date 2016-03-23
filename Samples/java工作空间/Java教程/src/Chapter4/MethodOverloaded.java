// MethodOverloaded.java
package Chapter4;

public class MethodOverloaded {
	// 两个整数相加，返回整数
	int add(int x1, int x2) {
		return x1 + x2;
	}

	// 两个浮点数相加，返回浮点数
	double add(double x1, double x2) {
		return x1 + x2;
	}

	public static void main(String[] args) {
		// 创建MethodOverloaded类对象obj
		MethodOverloaded obj = new MethodOverloaded();
		// 分别调用不同的重载方法
		System.out.println("int add= " + obj.add(10, 23));
		System.out.println("double add= " + obj.add(10.0, 23));
	}

}
