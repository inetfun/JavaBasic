// Exam_1.java
package Chapter5;

class Student { // ����Student��
	String name; // ������Ա����
	int age;

	public Student(String name, int age) { // ���췽��
		this.name = name;
		this.age = age;
	}
}

public class Exam_1 {
	public static void main(String args[]) {
		Student[] stu = new Student[3]; // ������������
		stu[0] = new Student("lily", 20); // Ϊ��������Ԫ�س�ʼ��
		stu[1] = new Student("lucy", 18);
		stu[2] = new Student("john", 21);
		for (int i = 0; i < stu.length; i++) { // ����������Ϣ
			System.out.println(stu[i].name + "  " + stu[i].age);
		}
	}
}
