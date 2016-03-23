// ConcentCircle.java
package Chapter3;

class ConcentCircle {
	public static int x = 100, y = 100; // 定义圆心坐标变量
	public int r; // 定义半径变量

	public static void main(String args[]) {
		ConcentCircle t1 = new ConcentCircle(); // 创建对象
		ConcentCircle t2 = new ConcentCircle();
		t1.x += 100; // 设置圆心的横坐标
		t1.r = 50; // 初始化半径变量
		t2.x += 200;
		t2.r = 150;
		System.out.println("Circle1:x=" + t1.x + ",y=" + t1.y + ",r=" + t1.r);
		System.out.println("Circle2:x=" + t2.x + ",y=" + t2.y + ",r=" + t2.r);
	}
}
