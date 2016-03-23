// NumberManager.java
package Chapter5;

public class NumberManager {
	/* ͳ��ÿ�����֣�0��1����8��9�����ֵ�Ƶ�� */
	public static int[] countNumbers(String[] numbers) {
		int[] numberArray = new int[10];
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length(); j++) {
				/*
				 * numbers[i].charAt(index)������������λ�ô����ַ��������ַ�'0'�Ĳ�ֵΪ��Ӧ���ַ�����ֵ��
				 * ���磬'1'-'0'=1��'5'-'0'=5�ȡ���ˣ�����ַ�Ϊ'5'��
				 * ���൱��numberArray[5]��1�������ַ�������ơ�
				 */
				numberArray[numbers[i].charAt(j) - '0']++;
			}
		}
		return numberArray;
	}

	/* ��ӡ�������� */
	private static void printArray(int[] numArr) {
		for (int i = 0; i < numArr.length; i++) {
			System.out.printf(i + ":" + numArr[i] + ",");
		}
		System.out.println();
	}

	/* �滻���� */
	public static String[] replaceNumbers(String[] numbers, int[] numberCounts) {
		String[] results = new String[numbers.length];
		int replaceNum = getMaxNumber(numberCounts); // �õ�������������±�
		for (int i = 0; i < numbers.length; i++) {
			String replaceString = replaceOneString(replaceNum, numbers[i]);
			results[i] = replaceString; // �����results[i]��ֵ
		}
		return results;
	}

	/* �õ�����Ƶ��������ֵ��±� */
	private static int getMaxNumber(int[] numberCounts) {
		int currenMaxNumber = -1;
		int index = -1;
		// ��ȡnumberCounts�����е������
		for (int i = 0; i < numberCounts.length; i++) {
			if (numberCounts[i] > currenMaxNumber) { // ��¼��ǰ�����
				currenMaxNumber = numberCounts[i]; // ��¼��������±�
				index = i;
			}
		}
		return index;
	}

	/* ���ַ��������е�ĳ���ַ���'8'���л��� */
	private static String replaceOneString(int replaceNum, String oldString) {
		StringBuffer strBuf = new StringBuffer();
		// ����ֵת��Ϊ�ַ���ʽ�����֣�����1->'1'
		char replacedChar = (char) (replaceNum + '0');
		for (int i = 0; i < oldString.length(); i++) {
			// ��ȡoldString�ַ����е��ַ�
			char ch = oldString.charAt(i);
			// ����ַ������ַ�Ϊָ���ַ������任Ϊ'8'
			if (ch == replacedChar) {
				ch = '8';
			} else if (ch == '8') {
				ch = replacedChar; // ��'8'��Ϊָ���ַ�
			}
			strBuf.append(ch); // ��ch�ַ���ӵ�strBuf��β��
		}
		// StrBuf.toString()�������ڰ��ַ���������������ַ�������һ�𲢷���
		return strBuf.toString();
	}

	/* ��ӡ�ַ��� */
	private static void printString(String[] newArr) {
		for (int i = 0; i < newArr.length; i++) {
			System.out.printf(newArr[i]);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		String[] numbers = { "13701192543", "82876650", "33933" };
		System.out.println("ԭʼ�绰���룺");
		for (int i = 0; i < numbers.length; i++) { // ���ԭʼ����
			System.out.println(numbers[i]);
		}
		// ͳ�Ƹ����ִ��������ַ�'0'��'1'...'9'���ֵ�Ƶ��
		int[] numArr = countNumbers(numbers);
		System.out.println("�������ڵ绰�����г��ֵ�Ƶ�ʣ�");
		// ��ӡ�����ַ�'0'��'1'...'9'���ֵ�Ƶ��
		printArray(numArr);
		// �����ִ��и�Ƶ���ַ����ַ�'8'����
		String[] newArr = replaceNumbers(numbers, numArr);
		System.out.println("��Ƶ������8������ĵ绰����: ");
		printString(newArr);
	}
}
