//Exception7.java
package Chapter6;

public class Exception7 {
	private static void throwException() {
		try {
			String s = null;
			if (s == null) {
				// sΪnullʱ�׳�NullPointerException�쳣
				throw new NullPointerException("s is null");
			}
		} catch (NullPointerException e) {
			System.out
					.println("����throwException()���׳�һ��NullPointerException�쳣��");
			throw e; // �׳��쳣e
		}
	}

	public static void main(String[] args) {
		try {
			throwException(); // ��ط���
		} catch (NullPointerException e) {
			System.out.println("���񷽷�throwException()�е��쳣NullPointerException");
		}
	}
}
