// Exam_2.java
package Chapter5;

public class Exam_2 {
	public static void main(String args[]) {
		double a[] = { 1.1, 3.4, -9.8, 10 }; // �������鲢��ʼ��
		// ����洢���ֵ����Сֵ��ƽ��ֵ�����飬������a��Ϊ������ʵ��
		double b[] = max_min_ave(a);
		for (int i = 0; i < b.length; i++)
			// ������ֵ����Сֵ��ƽ��ֵ
			System.out.println("b[" + i + "]=" + b[i]);
	}

	// ȡ����������ֵ����Сֵ��ƽ��ֵ�ķ���������ֵΪ��������
	static double[] max_min_ave(double a[]) {
		double res[] = new double[3];
		double max = a[0], min = a[0], sum = a[0];
		for (int i = 0; i < a.length; i++) {
			if (max < a[i])
				max = a[i]; // ȡ�������е����ֵ
			if (min > a[i])
				min = a[i]; // ȡ�������е���Сֵ
			sum += a[i]; // ȡ��������Ԫ�ص��ܺ�
		}
		res[0] = max;
		res[1] = min;
		res[2] = sum / a.length; // �õ�����Ԫ�ص�ƽ��ֵ
		return res; // ������������
	}
}
