// PassAdress.java
package Chapter3;

public class PassAdress {
	int a = 25, b = 5;

	static void doPower(PassAdress p) {
		p.a += 5;
		p.b *= 3;
	}

	public static void main(String[] args) {
		PassAdress p = new PassAdress();
		System.out.println("传递之前a和b的数值分别是：" + p.a + "," + p.b);
		doPower(p); // 以对象为参数调用方法
		System.out.println("传递之后a和b的数值分别是：" + p.a + "," + p.b);
	}
}
