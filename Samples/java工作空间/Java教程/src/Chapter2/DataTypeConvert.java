// DataTypeConvert.java
package Chapter2;

public class DataTypeConvert {
	public static void main(String[] args) {
		char c1 = 'a', c2 = 'b', c3; // ���������ַ�����
		int x1 = 10, x2, x3;// �����������ͱ���
		float y1 = 20.56F, y2;// �������������ͱ���
		c3 = (char) (c1 + c2);// �����ַ���ӣ���ʾ��ASCII��ֵ��ӣ����Ϊ����
		// ����c3Ϊ�ַ��ͣ��ʱ��뽫����ǿ��ת��Ϊ�ַ���
		x2 = x1 + c1;// ���ͼ��ַ��ͣ�ʵ�������ַ���ASCII��ֵ�������Ϊ����
		x3 = (int) (x1 + y1);// ���ͼӸ����ͣ����Ϊ�����͡�����x3Ϊ���ͣ��伶��
		// ���ڸ����ͣ��ʱ������ǿ��ת��
		y2 = x1 * y1; // �����븡������ˣ����Ϊ������
		System.out.println("c3=" + c3 + "  x2=" + x2 + "  x3=" + x3);
		System.out.println("y2=" + y2);
	}
}
