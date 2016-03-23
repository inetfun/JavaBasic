// FileIOExample3.java
package Chapter7;

import java.io.*;

public class FileIOExample3 {
	public static void main(String[] args) throws IOException {
		File dir = new File("c:\\xyz"); // 创建file对象
		if (!dir.exists()) { // 判断c:\xyz目录是否存在
			dir.mkdir(); // 如果不存在，则创建目录
		}
		File file = new File("c:\\xyz", "test.txt"); // 创建file对象
		if (!file.exists()) { // 判断c:\abc目录下，文件test.txt是否存在
			file.createNewFile(); // 如果不存在，则创建一个新文件
		}
		System.out.println("文件路径：" + file.getAbsolutePath()); // 输出文件路径
		if (file.exists()) { // 判断c:\abc目录下，文件test.txt是否存在
			file.delete(); // 如果存在，则删除之
		}
		if (dir.exists()) { // 判断c:\xyz目录是否存在
			dir.delete(); // 如果存在，则删除之
		}
		if (dir.exists()) { // 判断c:\xyz目录是否存在
			System.out.println("c:\\xyz目录存在！");
		} else {
			System.out.println("c:\\xyz目录不存在！");
		}
	}
}
