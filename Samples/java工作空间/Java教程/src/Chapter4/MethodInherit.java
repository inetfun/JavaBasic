// MethodInherit.java
package Chapter4;

// 声明父类
class parentclass {
	// 声明成员方法
	void pprint() {
		this.print();
		this.print1(0);
	}

	// 声明同类型、同名、同参数成员方法
	void print() {
		System.out.println("父类：同类型、同名、同参数成员方法！");
	}

	// 声明同类型、同名但参数不同的成员方法
	void print1(int a) {
		System.out.println("父类：同类型、同名但参数不同的成员方法！");
	}
}

// 基于parentclass类定义subclass子类
class subclass extends parentclass {
	// 声明成员方法
	void sprint() {
		this.print();
		this.print1();
	}

	// 声明同类型、同名、同参数成员方法
	void print() {
		System.out.println("子类：同类型、同名、同参数成员方法！");
	}

	// 声明同类型、同名但参数不同的成员方法
	void print1() {
		System.out.println("子类：同类型、同名但参数不同的成员方法！");
	}
}

// 声明公共类
public class MethodInherit {
	public static void main(String[] args) {
		subclass obj = new subclass();
		obj.pprint(); // 调用父类的成员方法
		obj.sprint(); // 调用子类的成员方法
	}
}