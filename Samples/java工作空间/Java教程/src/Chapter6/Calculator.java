// Calclulator.java
package Chapter6;

public class Calculator {
	static private float result; // �������������

	// calculate()�������ڼ����������ж������������ĺϷ���
	static void calculate(float op1, char sign, float op2)
			throws IllegalSignException, ArithmeticException {
		switch (sign) {
		case '+': // �ӷ�����
			result = op1 + op2;
			break;
		case '-': // ��������
			result = op1 - op2;
			break;
		case 'x': // �˷�����
			result = op1 * op2;
			break;
		case '/': // ��������ʱ���������Ϊ0���׳��쳣
			if (op2 == 0)
				throw new ArithmeticException();
			result = op1 / op2;
			break;
		default: // �׳��Զ����쳣IllegalSignException
			throw new IllegalSignException("���������������ԣ�");
		}
	}

	public static void main(String[] args) {
		float in0, in2; // ���������������
		char in1; // ��������������
		try {
			in0 = Float.parseFloat(args[0]); // ���յ�һ������
			in1 = args[1].charAt(0); // ���������
			in2 = Float.parseFloat(args[2]); // ���յڶ�������
			calculate(in0, in1, in2); // ������������
			System.out.println(in0 + " " + in1 + " " + in2 + "=" + result);
		} catch (NumberFormatException e) {
			System.out.println("����������еĿ��ܲ��ǺϷ�����." + "ע�⣺�˺�����ĸx���档");
		} catch (ArrayIndexOutOfBoundsException aie) {
			System.out.println("��û��������������ݣ�" + "������Ҫ�������ֺ�һ���������");
		} catch (ArithmeticException ae) {
			System.out.println("���г�������ʱ���ڶ������ֲ���Ϊ0��");
		} catch (IllegalSignException ise) {
			System.out.println(ise.getMessage());
			System.out.println("ÿ��ֻ�����루+��-��x��/�����е�һ����" + "ע�⣺�˺�����ĸx���档");
		} finally {
			System.out.println("ллʹ�ã�");
		}
	}
}
