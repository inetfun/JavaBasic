// MethodInherit.java
package Chapter4;

// ��������
class parentclass {
	// ������Ա����
	void pprint() {
		this.print();
		this.print1(0);
	}

	// ����ͬ���͡�ͬ����ͬ������Ա����
	void print() {
		System.out.println("���ࣺͬ���͡�ͬ����ͬ������Ա������");
	}

	// ����ͬ���͡�ͬ����������ͬ�ĳ�Ա����
	void print1(int a) {
		System.out.println("���ࣺͬ���͡�ͬ����������ͬ�ĳ�Ա������");
	}
}

// ����parentclass�ඨ��subclass����
class subclass extends parentclass {
	// ������Ա����
	void sprint() {
		this.print();
		this.print1();
	}

	// ����ͬ���͡�ͬ����ͬ������Ա����
	void print() {
		System.out.println("���ࣺͬ���͡�ͬ����ͬ������Ա������");
	}

	// ����ͬ���͡�ͬ����������ͬ�ĳ�Ա����
	void print1() {
		System.out.println("���ࣺͬ���͡�ͬ����������ͬ�ĳ�Ա������");
	}
}

// ����������
public class MethodInherit {
	public static void main(String[] args) {
		subclass obj = new subclass();
		obj.pprint(); // ���ø���ĳ�Ա����
		obj.sprint(); // ��������ĳ�Ա����
	}
}