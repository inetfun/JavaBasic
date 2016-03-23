// SystemIOExample1.java
package Chapter7;

import java.io.IOException;

public class SystemIOExample1 {
	public static void main(String[] args) throws IOException {
		int b;
		System.out.println("请输入数据：");
		// 循环读取数据，遇到输入字符'N'终止循环
		while ((b = System.in.read()) != 'N') {
			System.out.print((char) b);
		}
	}
}
