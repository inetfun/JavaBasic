// DataTypeConvert.java
package Chapter2;

public class DataTypeConvert {
	public static void main(String[] args) {
		char c1 = 'a', c2 = 'b', c3; // 声明三个字符变量
		int x1 = 10, x2, x3;// 声明三个整型变量
		float y1 = 20.56F, y2;// 声明两个浮点型变量
		c3 = (char) (c1 + c2);// 两个字符相加，表示其ASCII码值相加，结果为整型
		// 由于c3为字符型，故必须将整型强制转换为字符型
		x2 = x1 + c1;// 整型加字符型（实际上是字符的ASCII码值），结果为整型
		x3 = (int) (x1 + y1);// 整型加浮点型，结果为浮点型。由于x3为整型，其级别
		// 低于浮点型，故必须进行强制转换
		y2 = x1 * y1; // 整型与浮点型相乘，结果为浮点型
		System.out.println("c3=" + c3 + "  x2=" + x2 + "  x3=" + x3);
		System.out.println("y2=" + y2);
	}
}
