// MethodOverloaded.java
package Chapter4;

public class MethodOverloaded {
	// ����������ӣ���������
	int add(int x1, int x2) {
		return x1 + x2;
	}

	// ������������ӣ����ظ�����
	double add(double x1, double x2) {
		return x1 + x2;
	}

	public static void main(String[] args) {
		// ����MethodOverloaded�����obj
		MethodOverloaded obj = new MethodOverloaded();
		// �ֱ���ò�ͬ�����ط���
		System.out.println("int add= " + obj.add(10, 23));
		System.out.println("double add= " + obj.add(10.0, 23));
	}

}
