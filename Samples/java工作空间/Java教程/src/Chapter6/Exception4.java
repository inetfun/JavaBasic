// Exception4.java
package Chapter6;

class Exception4 {
	public static void main(String args[]) {
		int a = 0;
		try {
			System.out.println(5 / a);
		} catch (ArithmeticException e) {
			System.out.println("��������Ϊ�㣡");
		}
		System.out.println("������������");
	}
}
