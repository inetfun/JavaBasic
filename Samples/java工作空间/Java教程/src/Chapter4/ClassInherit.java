// ClassInherit.java
package Chapter4;
// 创建父类Pclass
class Pclass {
	void Draw() {
		System.out.println("Pclass类，Draw方法！");
	}
}
// 创建子类Sclass
class Sclass extends Pclass {
	void Draw() {
		System.out.println("Sclass类，Draw方法！");
	}
	void NewDraw() {
		System.out.println("Sclass类，NewDraw方法！");
	}
}
// 创建公共类
public class ClassInherit {
	public static void main(String[] args) {
		Pclass obj1 = new Pclass();		// 创建Pclass类对象obj1
		Sclass obj2 = new Sclass();		// 创建Sclass类对象obj2
		obj1.Draw();	// 调用Obj1的Draw方法
		obj2.Draw();	// 调用obj2的Draw方法
		obj2.NewDraw();	// 调用obj2的NewDraw方法
		obj1 = obj2;	// 将子类对象赋值给父类对象
		// 调用转换后obj1对象的Draw方法（实际上已是子类对象的Draw方法）
		obj1.Draw();
		// 但是，即使转换了对象类型，下述语句依然非法，obj1对象
		// 只能调用父类的方法
		// obj1.NewDraw();
	}
}
