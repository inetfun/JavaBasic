//Exception9.java
package Chapter6;

class MyException extends Exception { // �����Զ����쳣��MyException
	MyException(String s) { // ���췽��
		super(s);  // ���ø���Ĺ��췽��
	}
}

public class Exception9 {
	// �����׳�MyException�쳣
	static void method(int level) throws MyException {
		System.out.println("���÷��� method(" + level + ")");
		if (level > 10) {
			throw new MyException("ˮλ���ߣ�");
		}
		System.out.println("û�з����쳣��");
	}

	public static void main(String args[]) {
		try {
			method(1);
			method(11);
		} catch (MyException e) {
			System.out.println("��׽�Զ����쳣" + e);
		}
	}
}
