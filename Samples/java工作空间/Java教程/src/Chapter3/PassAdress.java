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
		System.out.println("����֮ǰa��b����ֵ�ֱ��ǣ�" + p.a + "," + p.b);
		doPower(p); // �Զ���Ϊ�������÷���
		System.out.println("����֮��a��b����ֵ�ֱ��ǣ�" + p.a + "," + p.b);
	}
}
