// SystemIOExample5.java
package Chapter7;

import java.io.*;
import java.util.*;

public class SystemIOExample5 {
	public static void main(String[] args) throws IOException {
		float numberx = 0; // 输入的浮点数
		// 创建Scanner对象in，其内容来自InputStream类对象System.in，即键盘输入
		Scanner in = new Scanner(System.in);
		System.out.println("请输入一组浮点数，最后以任意非数" + 
				"字字符串或按Ctrl+Z结束输入！ ");
		// 如果读入的数是浮点数，则循环读
		while (in.hasNextFloat()) {
			// 读入浮点数并输出
			numberx = in.nextFloat();
			System.out.print(numberx + "  ");
		}
	}
}
