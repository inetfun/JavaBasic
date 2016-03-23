// SystemIOExample4.java
// 从命令行读入字符串，并处理和显示
package Chapter7;

import java.io.*;

public class SystemIOExample4 {
	public static void main(String[] args) throws IOException {
		// 使用System.in构造InputStreamReader对象iin
		// 该对象用来从键盘读入一个单字节字符
		InputStreamReader iin = new InputStreamReader(System.in);
		// 利用iin对象构造BufferedReader对象stdin
		// 该对象用来从字符输入流中读取文本到缓冲区
		BufferedReader stdin = new BufferedReader(iin);
		// 读取并输出字符串。
		System.out.print("请输入一个字符串: ");
		System.out.println(stdin.readLine());
		boolean dataright = false;
		do {
			try {
				// 读取字符串并转换成double类型数据输出
				System.out.print("请输入一个浮点数: ");
				// 将字符串解析为带符号的double类型数据。如果数据无效，则
				// 产生一个NumberFormatException异常
				double numberx = Double.parseDouble(stdin.readLine());
				System.out.println(numberx);
				dataright = false;
			} catch (NumberFormatException e) {
				System.out.println("数据无效，请重新输入！");
				dataright = true;
			}
		} while (dataright);
	}
}