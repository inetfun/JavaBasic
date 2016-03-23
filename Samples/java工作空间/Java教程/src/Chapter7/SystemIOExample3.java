// SystemIOExample3.java
package Chapter7;

import java.io.*;

public class SystemIOExample3 {
	public static void main(String[] args) throws IOException {
		// 创建文件输出字节流对象，其目标为d:\test.txt文件。如果该文件
		// 已存在，则删除并新建该文件；否则，将新建该文件
		FileOutputStream out = new FileOutputStream("d:\\test.txt");
		// 创建缓冲输出字节流对象，其目标为文件输出字节流对象
		BufferedOutputStream buffer_out = new BufferedOutputStream(out);
		// 要写入文件的内容
		String s = "These will be writed to d:\\test.txt file!\r\n";
		// 将字符串s的内容以字节形式写入缓冲区buffer_out。实际上，也就间接
		// 写入到了d:\test.txt文件中。getBytes()为String类的方法，其作用是将
		// 字符串转换为字节数组
		buffer_out.write(s.getBytes());
		buffer_out.write(s.getBytes());
		buffer_out.write(s.getBytes());
		buffer_out.write(s.getBytes());
		buffer_out.flush(); // 清空缓冲区
		buffer_out.close(); // 关闭缓冲输入流，同时关闭了文件
		// 创建文件输入流，其内容源自文件d:\test.txt
		FileInputStream in = new FileInputStream("d:\\test.txt");
		// 将文件输入流包装成缓冲流，即把文件内容首先读入缓冲区
		BufferedInputStream buffer_in = new BufferedInputStream(in);
		byte[] b = new byte[1024];
		// 将数据读入字节数组b内，num为读入的字节个数
		int num = buffer_in.read(b);
		// 将字节数组转换成字符串
		String str = new String(b, 0, num);
		System.out.println(str);// 输出读入的结果
		buffer_in.close();// 关闭缓冲输入流，同时关闭了文件
	}
}
