// ConstructorInherit.java
package Chapter4;
class PersonA {
	String name; // ����������Ա����
	int age;
	// �вι��췽��
	public PersonA(String name, int age) {
		this.name = name;
		this.age = age;
	}
	// �޲ι��췽��
	public PersonA() {
		this.name = "person name";
		this.age = 23;
	}
	// ��Ա��������ʱ��ʾ���Ǹ����г�Ա�����Ľ��
	void pprint() {
		System.out.println("class:Person;  " + "Name: " + this.name
				+ ";  age: " + this.age);
	}
}
// ����Person�ඨ��Student����
class StudentA extends PersonA {
	String name; // ���������������Լ��ĳ�Ա����
	int classno; // �����³�Ա����
	// �޲ι��췽��
	public StudentA() {
		super("xyz", 30); // ���ø�����вι��췽��
		this.name = "student name";
		this.age = 20;
	}
	// �вι��췽��
	public StudentA(String name, int age, int classno) {
		super(name, age); // ���ø�����вι��췽��
		this.name = name;
		this.age = age;
		this.classno = classno;
	}
	// ��Ա��������ʱ��ʾ���������г�Ա�����Ľ��
	void sprint() {
		System.out.println("class:Student;  " + "Name: " + this.name
				+ ";  age: " + this.age + ";  classno: " + this.classno);
		// ��Ա����������super������ʾ�����Ա����
		System.out.println("�����е�name��Ա������" + super.name);
	}
}
// ����������
public class ConstructorInherit {
	public static void main(String[] args) {
		// �����޲ι��췽����������
		StudentA obj1 = new StudentA();
		// �����вι��췽����������
		StudentA obj2 = new StudentA("LiXiao", 18, 1);
		obj1.pprint(); // ���ø���ĳ�Ա����
		obj1.sprint(); // ��������ĳ�Ա����
		obj2.pprint(); // ���ø���ĳ�Ա����
		obj2.sprint(); // ��������ĳ�Ա����
	}
}