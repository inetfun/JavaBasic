//Exception5.java
package Chapter6;

public class Exception5 {
	public static void main(String args[]) {
		try {
			int i = args.length; // iֵ�洢main()������������ĳ���
			System.out.println("i=" + i);
			int j = 5 / i;
			int k[] = { 1, 2, 3 };
			k[3] = 5;
		} catch (ArithmeticException e) {
			System.out.println("��������Ϊ�㣺" + e);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�����±�Խ�磺" + e);
		}
		System.out.println("ִ��catch����Ĵ���飡");
	}
}
