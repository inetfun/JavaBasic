// PassValue.java
package Chapter3;

public class PassValue {
	static void doPower(int i, int j) {
		i += 5;
		j *= 3;
		System.out.println("����֮��i��j����ֵ�ֱ��ǣ�" + i + "," + j);
	}

	public static void main(String[] args) {
		int a = 25, b = 5;
		System.out.println("����֮ǰa��b����ֵ�ֱ��ǣ�" + a + "," + b);
		doPower(a, b); // ���÷���
		System.out.println("����֮��a��b����ֵ�ֱ��ǣ�" + a + "," + b);
	}
}
