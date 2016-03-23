// VarInherit.java
package Chapter4;
class Person {
	String name;	// 声明两个成员变量
	int age;
	// 有参构造方法
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	// 无参构造方法
	public Person() {
		this.name = "person name";
		this.age = 23;
	}
	// 成员方法，此时显示的是父类中成员变量的结果
	void pprint() {
		System.out.println("class:Person;  " + "Name: " + this.name + ";  age: "
				+ this.age);
	}
}
// 基于Person类定义Student子类
class Student extends Person {
	String name;	// 在派生类中声明自己的成员变量
	int classno;	// 声明新成员变量
	// 无参构造方法
	public Student() {
		this.name = "student name";
		this.age = 20;
	}
	// 有参构造方法
	public Student(String name, int age, int classno) {
		this.name = name;
		this.age = age;
		this.classno = classno;
	}
	// 成员方法，此时显示的是子类中成员变量的结果
	void sprint() {
		System.out.println("class:Student;  " + "Name: " + this.name + ";  age: "
				+ this.age + ";  classno: " + this.classno);
	}
}
//声明公共类
public class VarInherit {
	public static void main(String[] args) {
		// 调用无参构造方法创建对象
		Student obj1 = new Student();
		// 调用有参构造方法创建对象
		Student obj2 = new Student("LiXiao", 18, 1);
		obj1.pprint();	// 调用父类的成员方法
		obj1.sprint();	// 调用子类的成员方法
		obj2.pprint();	// 调用父类的成员方法
		obj2.sprint();	// 调用子类的成员方法
	}
}

