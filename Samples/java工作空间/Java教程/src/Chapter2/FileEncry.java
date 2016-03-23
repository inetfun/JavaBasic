// FileEncry.java
package Chapter2;

import java.util.Scanner;

public class FileEncry {
	public static void main(String[] args) {
		// 提示用户输入加密的内容
		System.out.println("请输入加密的内容：");
		// Scanner类表示一个文本扫描器，它可以扫描从键盘上输入的字符
		Scanner in = new Scanner(System.in);
		// 方法nextLine()返回键盘上输入的一行字符串
		String secretStr = in.nextLine();
		// 将字符串转换为字符数组，数组是具有相同数据类型的有序数据的集合
		char[] secretChars = secretStr.toCharArray();
		char secret = 'x'; // 字符变量用于保存加密密钥
		// 加密运算：将要加密的字符与字符x进行按位异或运算得到密文
		System.out.print("密文：");
		for (int i = 0; i < secretChars.length; i++) {
			// secretChars[0]、secretChars[1]……表示字符数组中的元素
			secretChars[i] = (char) (secretChars[i] ^ secret);
			System.out.print(secretChars[i]); // 显示密文
		}
		System.out.print("\n明文：");
		// 解密运算：已加密的字符再次与字符x按位异或可以取得原文
		for (int i = 0; i < secretChars.length; i++) {
			secretChars[i] = (char) (secretChars[i] ^ secret);
			System.out.print(secretChars[i]); // 显示明文
		}
	}
}
