// FileIOExample4.java
package Chapter7;

import java.io.*;

public class FileIOExample4 {
	public static void main(String[] args) throws IOException {
		File file = new File("d:\\test.txt");
		// 如果文件已存在，则删除后重新创建一个空文件
		if (file.exists()) { // 判断文件是否存在
			file.delete(); // 如果存在，则删除文件
		}
		file.createNewFile(); // 创建新文件
		// 以读写方式创建RandomAccessFile对象
		RandomAccessFile rafile = new RandomAccessFile(file, "rw");
		// 向文件中写入字符串，每个字符占两个字节
		rafile.writeChars("Are you ready? 你准备好了吗？");
		// 记录当前指针的位置
		long p1=rafile.getFilePointer();
		// 输出文件指针的位置
		System.out.println("当前文件指针位置：" + p1);
		// 向文件中写入一个长整型数和一个浮点数
		rafile.writeLong(2345);
		rafile.writeFloat(890.7F);
		// 输出文件中的字符串
		for (int i = 0; i < p1; i = i + 2) {
			rafile.seek(i); // 定位指针
			// 输出文件指针所在位置的字符
			System.out.print(rafile.readChar());
		}
		// 输出写入的长整数和浮点数
		System.out.println();
		System.out.println(rafile.readLong());
		System.out.println(rafile.readFloat());
	}
}
