// Fruit.java
package Chapter3; //声明程序所在包

//类声明，每个Java程序中只能有一个类被声明为Public类
//与此同时，Java程序名必须与该类的名字相同
public class Fruit {
	private boolean seedless; // 成员变量声明
	private boolean seasonal;
	private float price;

	// 成员方法，设置水果属性
	public void setPrioperties(boolean seed, boolean season, float cost) {
		seedless = seed;
		seasonal = season;
		price = cost;
	}

	// 成员方法，输出水果属性
	public void printProperties() {
		if (seedless) {
			System.out.println("Friut is seedless");
		} else {
			System.out.println("Friut is seedes");
		}
		if (seasonal) {
			System.out.println("Friut is seasonal");
		} else {
			System.out.println("Friut is not seasonal");
		}
		System.out.println("Price is " + price);
	}

	// 类中包含了main方法，说明该类为Java程序的主类，即可以被运行的类
	// 这是Java Application应用程序的入口
	public static void main(String[] args) {
		boolean myseed, myseason;// 声明局部变量
		float mycost;
		myseed = false;// 为局部变量赋值
		myseason = true;
		mycost = 25.86F;
		Fruit MyFruit = new Fruit();// 基于类创建对象
		// 调用setPrioperties方法，为成员变量赋值
		MyFruit.setPrioperties(myseed, myseason, mycost);
		MyFruit.printProperties(); // 调用printProperties方法，输出水果属性
	}
}
