// NumberSort.java
package Chapter5;

public class NumberSort {
	public static void main(String[] args) {
		int[] array = { 3, 1, 6, 2, 9, 0, 7, 4, 5, 8 };
		System.out.print("��������ǰ��˳��Ϊ��");
		for (int i = 0; i < array.length; i++) { // ��������е�ÿ��Ԫ��
			System.out.print(array[i] + " ");
		}
		int temp; // �洢�����ı���ֵ
		for (int i = 0; i < array.length - 1; i++) { // �Ƚ�n-1��
			for (int j = 0; j < array.length - i - 1; j++) { // ÿ�ֱȽ�
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		System.out.println();
		System.out.print("�������к��˳��Ϊ��");
		for (int i = 0; i < array.length; i++) { // ��������е�ÿ��Ԫ��
			System.out.print(array[i] + " ");
		}
	}
}
