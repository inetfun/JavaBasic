//Exception9.java
package Chapter6;

class MyException extends Exception { // 定义自定义异常类MyException
	MyException(String s) { // 构造方法
		super(s);  // 调用父类的构造方法
	}
}

public class Exception9 {
	// 声明抛出MyException异常
	static void method(int level) throws MyException {
		System.out.println("调用方法 method(" + level + ")");
		if (level > 10) {
			throw new MyException("水位过高！");
		}
		System.out.println("没有发生异常！");
	}

	public static void main(String args[]) {
		try {
			method(1);
			method(11);
		} catch (MyException e) {
			System.out.println("捕捉自定义异常" + e);
		}
	}
}
