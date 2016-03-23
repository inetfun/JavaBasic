// SystemIOExample2.java
package Chapter7;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class SystemIOExample2 {
	public static void main(String args[]) throws IOException {
		// 定义一个文件输入流对象，其内容源自d:\test.txt文件
		FileInputStream in = new FileInputStream("d:\\test.txt");
		// 定义一个缓冲输入流对象，其内容源自文件输入流
		BufferedInputStream bufin = new BufferedInputStream(in);
		// 定义一个缓冲输入流对象，其内容源自键盘
		BufferedInputStream keyin = new BufferedInputStream(System.in);
		// 定义两个字节数组
		byte[] b1 = new byte[1024], b2 = new byte[1024];
		// 将从文件中读取的数据放入字节数组b1内，num1为读入的字节个数
		int num1 = bufin.read(b1);
		// 将字节数组转换成字符串
		String str1 = new String(b1, 0, num1);
		System.out.println(str1);
		// 关闭缓冲输入流，同时关闭了文件
		bufin.close();
		// 将从键盘读取的数据放入字节数组b2内，num2为读入的字节个数
		int num2 = keyin.read(b2);
		// 将字节数组转换成字符串
		String str2 = new String(b2, 0, num2);
		System.out.println(str2);
	}
}