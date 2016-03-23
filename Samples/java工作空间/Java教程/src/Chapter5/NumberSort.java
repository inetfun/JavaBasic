// NumberSort.java
package Chapter5;

public class NumberSort {
	public static void main(String[] args) {
		int[] array = { 3, 1, 6, 2, 9, 0, 7, 4, 5, 8 };
		System.out.print("数组排列前的顺序为：");
		for (int i = 0; i < array.length; i++) { // 输出数组中的每个元素
			System.out.print(array[i] + " ");
		}
		int temp; // 存储交换的变量值
		for (int i = 0; i < array.length - 1; i++) { // 比较n-1轮
			for (int j = 0; j < array.length - i - 1; j++) { // 每轮比较
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		System.out.println();
		System.out.print("数组排列后的顺序为：");
		for (int i = 0; i < array.length; i++) { // 输出数组中的每个元素
			System.out.print(array[i] + " ");
		}
	}
}
