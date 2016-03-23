//Exception3.java
package Chapter6;

import java.io.*;

public class Exception3 {
	public static void main(String args[]) {
		// try代码块，其中可能会出现异常
		try {
			FileInputStream fis = new FileInputStream("text.txt");
			int b;
			while ((b = fis.read()) != -1) {
				System.out.print(b);
			}
			fis.close();
		} catch (FileNotFoundException e) {
			// 利用catch语句捕捉FileNotFoundException异常并处理
			// FileNotFoundException为异常类型，e为异常对象
			System.out.println(e);
			System.out.println("message（异常提示）: " + e.getMessage());
		} catch (IOException e) {
			// 利用catch语句捕捉IOException异常并处理
			System.out.println(e);
		}
		System.out.println("程序正常结束");
	}
}
