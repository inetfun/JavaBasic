// FileIOExample1.java
package Chapter7;
import java.io.*;
public class FileIOExample1 {
	public static void main(String[] args) throws IOException {
		// 创建文件输出流对象，新建并打开文件d:\test.txt
		FileOutputStream out = new FileOutputStream("d:\\test.txt");
		for (int i = 0; i <= 10; i++) {
			out.write(i); 	// 向文件中写数据
		}
		out.close(); 		// 关闭输出流，即关闭打开的文件
		// 创建文件输入流对象，打开文件d:\test.txt
		FileInputStream in = new FileInputStream("d:\\test.txt");
		int value;
		while ((value = in.read()) != -1) { 		// 循环读取文件中的数据
			System.out.print(value + " "); 	// 输出文件中的数据
		}
		in.close(); 		// 关闭输入流，即关闭打开的文件
	}
}

