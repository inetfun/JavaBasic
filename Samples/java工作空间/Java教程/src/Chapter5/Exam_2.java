// Exam_2.java
package Chapter5;

public class Exam_2 {
	public static void main(String args[]) {
		double a[] = { 1.1, 3.4, -9.8, 10 }; // 定义数组并初始化
		// 定义存储最大值、最小值和平均值的数组，将数组a作为方法的实参
		double b[] = max_min_ave(a);
		for (int i = 0; i < b.length; i++)
			// 输出最大值、最小值与平均值
			System.out.println("b[" + i + "]=" + b[i]);
	}

	// 取得数组的最大值、最小值和平均值的方法，返回值为数组类型
	static double[] max_min_ave(double a[]) {
		double res[] = new double[3];
		double max = a[0], min = a[0], sum = a[0];
		for (int i = 0; i < a.length; i++) {
			if (max < a[i])
				max = a[i]; // 取得数组中的最大值
			if (min > a[i])
				min = a[i]; // 取得数组中的最小值
			sum += a[i]; // 取得数组中元素的总和
		}
		res[0] = max;
		res[1] = min;
		res[2] = sum / a.length; // 得到数组元素的平均值
		return res; // 返回数组引用
	}
}
