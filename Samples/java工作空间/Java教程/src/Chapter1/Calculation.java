//Calculation.java
//�����������������������
package Chapter1; //����Java�������ڵİ�

class Add { // ����Add��
	int x, y; // ������ӵ���������

	// ���幹�췽�����Ա㽫����Ĳ������ݸ������
	Add(int num1, int num2) {
		x = num1;
		y = num2;
	}

	// ����getSum�������������������ĺ�
	int getSum() {
		return x + y;
	}
}

/* ��������������������ඨ�� */
class Sub { // ����Sub��
	int x, y; // �����������������

	// ���幹�췽�����Ա㽫����Ĳ������ݸ������
	Sub(int num1, int num2) {
		x = num1;
		y = num2;
	}

	// ����getDif�������������������Ĳ�
	int getDif() {
		return x - y;
	}
}

public class Calculation {
	public static void main(String[] args) {
		// ����Add�ഴ��add���󣬲����ù��췽�����ݲ���
		Add add = new Add(2, 3);
		// ����������ĺ�
		System.out.println(add.x + "+" + add.y + "=" + add.getSum());
		// ����Sub�ഴ��sub���󣬲����ù��췽�����ݲ���
		Sub sub = new Sub(8, 2);
		// ����������Ĳ�
		System.out.println(sub.x + "-" + sub.y + "=" + sub.getDif());
	}
}
