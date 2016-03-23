// DataInFormatCheck.java
package Chapter6;

import java.io.*;
import java.util.*;

public class DataInFormatCheck {
	public static void main(String[] args) throws IOException {
		// 创建Scanner对象in
		Scanner in = new Scanner(System.in);
		// 设置控制变量dataright并赋值
		boolean dataright = false;
		// 循环控制
		do {
			try {
				System.out.print("请输入一个浮点数: ");
				// 将字符串解析为带符号的double类型数据
				double numberx = in.nextDouble();
				// 如果输入正确，则执行如下的语句
				System.out.println(numberx);
				// 修改循环变量，使循环结束
				dataright = false;
			// 捕捉输入数据错误异常
			} catch (InputMismatchException e) {
				System.out.println("数据无效，请重新输入！");
				// 修改循环变量，使之有效，继续循环
				dataright = true;
				// 读取数据换行
				String x = in.nextLine();
			}
		} while (dataright);
	}
}