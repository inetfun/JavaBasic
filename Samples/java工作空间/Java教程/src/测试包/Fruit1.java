// Fruit1.java
package 测试包; // 声明文件所属包

// 导入Chapter3包中的Fruit类库
// 如果本文件与Fruit.java在同一个包中，则无需导入，即无需此语句
import Chapter3.Fruit;

public class Fruit1 {
	public static void main(String[] args) {
		boolean myseed, myseason; // 声明局部变量
		float mycost;
		myseed = true; // 为局部变量赋值
		myseason = false;
		mycost = 15F;
		Fruit MyFruit = new Fruit(); // 基于类创建对象
		// 调用setPrioperties方法，为成员变量赋值
		MyFruit.setPrioperties(myseed, myseason, mycost);
		MyFruit.printProperties(); // 调用printProperties方法，输出水果属性
	}
}
