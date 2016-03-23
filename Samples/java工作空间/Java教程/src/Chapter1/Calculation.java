//Calculation.java
//完成两个整数相加与相减运算
package Chapter1; //声明Java程序所在的包

class Add { // 定义Add类
	int x, y; // 定义相加的两个整数

	// 定义构造方法，以便将输入的参数传递给类变量
	Add(int num1, int num2) {
		x = num1;
		y = num2;
	}

	// 定义getSum方法，计算两个整数的和
	int getSum() {
		return x + y;
	}
}

/* 完成两个整数相减运算的类定义 */
class Sub { // 定义Sub类
	int x, y; // 定义相减的两个整数

	// 定义构造方法，以便将输入的参数传递给类变量
	Sub(int num1, int num2) {
		x = num1;
		y = num2;
	}

	// 定义getDif方法，计算两个整数的差
	int getDif() {
		return x - y;
	}
}

public class Calculation {
	public static void main(String[] args) {
		// 基于Add类创建add对象，并利用构造方法传递参数
		Add add = new Add(2, 3);
		// 输出两个数的和
		System.out.println(add.x + "+" + add.y + "=" + add.getSum());
		// 基于Sub类创建sub对象，并利用构造方法传递参数
		Sub sub = new Sub(8, 2);
		// 输出两个数的差
		System.out.println(sub.x + "-" + sub.y + "=" + sub.getDif());
	}
}
