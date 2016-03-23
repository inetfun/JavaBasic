// Time.java
package Chapter3;	// 声明程序所在包

import java.util.Calendar;	//导入外部包中的类

public class Time {
	private Calendar t; // 定义私有变量
	private int y, m, d, hh, mm, ss;

	Time() { // 构造方法
		t = Calendar.getInstance(); // 获取当前日期和时间
		y = t.get(t.YEAR); // 获取年
		m = t.get(t.MONTH) + 1; // 获取月
		d = t.get(t.DATE); // 获取日
		hh = t.get(t.HOUR_OF_DAY); // 获取小时
		mm = t.get(t.MINUTE); // 获取分
		ss = t.get(t.SECOND); // 获取秒
	}

	public String getDate() { // 返回日期的方法
		return y + "年" + m + "月" + d + "日";
	}

	public String getTime() { // 返回时间的方法
		String s = hh + "时" + mm + "分" + ss + "秒";
		return s;
	}

	public static void main(String[] args) {
		Time time = new Time(); // 创建对象
		System.out.println("当前日期:" + time.getDate());// 输出当前日期
		System.out.println("当前时间:" + time.getTime());// 输出当前时间
	}
}
