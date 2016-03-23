// Exam_1.java
package Chapter5;

class Student { // 声明Student类
	String name; // 声明成员变量
	int age;

	public Student(String name, int age) { // 构造方法
		this.name = name;
		this.age = age;
	}
}

public class Exam_1 {
	public static void main(String args[]) {
		Student[] stu = new Student[3]; // 声明对象数组
		stu[0] = new Student("lily", 20); // 为对象数组元素初始化
		stu[1] = new Student("lucy", 18);
		stu[2] = new Student("john", 21);
		for (int i = 0; i < stu.length; i++) { // 输出对象的信息
			System.out.println(stu[i].name + "  " + stu[i].age);
		}
	}
}
