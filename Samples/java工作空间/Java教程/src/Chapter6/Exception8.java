//Exception8.java
package Chapter6;

public class Exception8 {
	// �����׳��쳣IllegalAccessException
	private static void throwException() throws IllegalAccessException {
		throw new IllegalAccessException("�Ƿ������쳣");
	}

	public static void main(String[] args) {
		try {
			throwException(); // ��ط���
		} catch (IllegalAccessException e) {
			System.out.println("����" + e);
		}
		System.out.println("������������");
	}
}
