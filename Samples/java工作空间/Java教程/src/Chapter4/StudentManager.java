//  StudentManager.java
package Chapter4;
abstract class Studentx {			// 抽象类
	public String id;				// 学生学号
	public String name;				// 学生姓名
	public String className;		// 班级
	public abstract void logIn();	// 注册方法
	public abstract void clearOut();// 注销方法
}
// 本科生类
class UnderGraduate extends Studentx {
	private String counsellors;		// 辅导员
	public void logIn() {			// 本科生注册
		// 注册过程.....
		System.out.println("本科生注册，注册成功！");
	}
	public void clearOut() {		// 本科生注销
		// 注销过程.....
		System.out.println("本科生注销，注销成功！");
	}
}
// 研究生类
class Graduate extends Studentx {
	private String instrutor;		// 导师
	private String research;		// 研究方向
	public void logIn() {			// 研究生注册
		//注册过程......
		System.out.println("研究生注册，注册成功！");
	}
	public void clearOut() {		// 研究生注销
		//注销过程....
		System.out.println("研究生注销，注销成功！");
	}
}
// 学生管理公共类StudentManager
public class StudentManager {
	public void add(Studentx s) {	// 学生注册
		s.logIn();
	}
	public void delete(Studentx s) {	// 学生注销
		s.clearOut();
	}
	public static void main(String[] args) {
		StudentManager manager = new StudentManager();
		Studentx underGraduate = new UnderGraduate();
		Studentx graduate = new Graduate();
		manager.add(underGraduate);			//本科生注册
		manager.delete(underGraduate);		//本科生注销
		manager.add(graduate);				//研究生注册
		manager.delete(graduate);			//研究生注销
	}
}
