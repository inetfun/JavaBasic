// Calclulator.java
package Chapter6;

public class Calculator {
	static private float result; // 定义计算结果变量

	// calculate()方法用于计算结果，并判断输入的运算符的合法性
	static void calculate(float op1, char sign, float op2)
			throws IllegalSignException, ArithmeticException {
		switch (sign) {
		case '+': // 加法运算
			result = op1 + op2;
			break;
		case '-': // 减法运算
			result = op1 - op2;
			break;
		case 'x': // 乘法运算
			result = op1 * op2;
			break;
		case '/': // 除法运算时，如果除数为0，抛出异常
			if (op2 == 0)
				throw new ArithmeticException();
			result = op1 / op2;
			break;
		default: // 抛出自定义异常IllegalSignException
			throw new IllegalSignException("你输入的运算符不对！");
		}
	}

	public static void main(String[] args) {
		float in0, in2; // 定义输入的两个数
		char in1; // 定义输入的运算符
		try {
			in0 = Float.parseFloat(args[0]); // 接收第一个数字
			in1 = args[1].charAt(0); // 接收运算符
			in2 = Float.parseFloat(args[2]); // 接收第二个数字
			calculate(in0, in1, in2); // 进行算数运算
			System.out.println(in0 + " " + in1 + " " + in2 + "=" + result);
		} catch (NumberFormatException e) {
			System.out.println("你输入的数有的可能不是合法数字." + "注意：乘号用字母x代替。");
		} catch (ArrayIndexOutOfBoundsException aie) {
			System.out.println("你没有输入所需的数据，" + "程序需要两个数字和一个运算符。");
		} catch (ArithmeticException ae) {
			System.out.println("进行除法运算时，第二个数字不能为0！");
		} catch (IllegalSignException ise) {
			System.out.println(ise.getMessage());
			System.out.println("每次只能输入（+、-、x、/）其中的一个。" + "注意：乘号用字母x代替。");
		} finally {
			System.out.println("谢谢使用！");
		}
	}
}
