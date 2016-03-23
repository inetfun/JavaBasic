// FileIOExample2.java
package Chapter7;

import java.io.*;

public class FileIOExample2 {
	public static void readFile() throws IOException {
		// 创建文件字符输入流对象，即打开一个文件
		FileReader fr = new FileReader("d:\\test.txt");
		// 定义一个字符数组
		char data[] = new char[1024];
		// 将数据读入字符数组data内，num为字符个数
		int num = fr.read(data);
		// 将字符数组转换成字符串
		String str = new String(data, 0, num);
		System.out.println(str);
		fr.close(); // 关闭文件
	}

	public static void writeFile(String s) throws IOException {
		// 创建文件字符输出流对象，即打开或新建一个文件
		FileWriter fw = new FileWriter("d:\\test.txt", true);
		fw.write(s); // 将字符串s写入文件
		fw.close(); // 关闭文件
	}

	public static void main(String[] args) throws IOException {
		// 创建InputStreamReader对象，其内容来自键盘
		InputStreamReader iin = new InputStreamReader(System.in);
		// 基于InputStreamReader对象创建BufferedReader对象
		BufferedReader stdin = new BufferedReader(iin);
		// s1用于临时保存读取的当前行内容，S2用来存放最终读取的字符串
		String s1 = "", s2 = "";
		// 循环读取数据，
		do {
			s1 = stdin.readLine(); // 读取一行
			System.out.println(s1);
			// 当用户按Ctrl+Z组合键时，readLine()方法返回的是一个null
			// 同时，本行输入的内容作废。因此，此时应退出数据输入循环
			if (s1 == null) {
				break;
			}
			// 如果在某行直接按回车，不输入任何内容，此时用readLine()方法
			// 读取的字符串的length()为0，结束数据输入。反之，如果length()
			// 不为0，表示该行已输入字符串
			if (s1.length() != 0) { // 如果已输入字符串
				s1 = s1 + '\r' + '\n'; // 为字符串末尾增加回车符和换行符
				s2 = s2 + s1; // 将新字符串增加到目标字符串中
			}
		} while (s1.length() != 0);
		writeFile(s2); // 将读取的内容写文件
		readFile(); // 读取文件内容
	}
}
