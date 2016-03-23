// Exception2.java
package Chapter6;

import java.io.*;

class Exception2 {
	public static void main(String args[]) throws FileNotFoundException,
			IOException {
		// 创建FileInputStream对象
		FileInputStream fis = new FileInputStream("text.txt");
		int b;
		while ((b = fis.read()) != -1) { // 读文件字节数据有效时循环
			System.out.print(b); // 显示读出的字节数据
		}
		fis.close(); // 关闭文件
		System.out.println("程序正常结束");
	}
}
