// FileCopy.java
package Chapter7;

import java.io.*;
import java.util.Scanner;

public class FileCopy {
	public static void copyFile(String sourceFileName, String targetFileName)
			throws IOException {
		File sourceFile = new File(sourceFileName); // 创建源文件
		File targetFile = new File(targetFileName); // 创建目标文件
		// 验证源文件是否存在
		if (!sourceFile.exists()) {
			System.out.println("文件复制失败！源文件" + sourceFile.getName() + "不存在");
			return;
		}
		// 验证目标文件是否为目录
		if (targetFile.isDirectory()) {
			// 如果为目录，则修改目标文件的路径和名称
			targetFile = new File(targetFile, sourceFile.getName());
		}
		// 如果目标文件存在
		if (targetFile.exists()) {
			// 询问用户是否覆盖目标文件
			System.out.println("文件进行复制，是否覆盖现有文件" + targetFile.getName()
					+ "?(Y/N):");
			// 以标准输入创建字符缓冲流
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));
			String override = in.readLine(); // 存储用户的输入值
			// 取消复制
			if (!override.equalsIgnoreCase("Y")) {
				System.out.println("操作已取消!");
				return;
			}
		}
		/* 复制文件 */
		FileInputStream in = null;
		FileOutputStream out = null;
		in = new FileInputStream(sourceFile); // 创建源文件输入流
		out = new FileOutputStream(targetFile); // 创建目标文件输出流
		byte[] buffer = new byte[8]; // 创建缓冲区
		int num;
		/* 循环读取源文件数据并写入目标文件 */
		while ((num = in.read(buffer)) != -1)
			out.write(buffer, 0, num);
		System.out.println("文件复制成功！");
		System.out.println("源文件：" + sourceFile.getPath());
		System.out.println("目标文件：" + targetFile.getPath());
		// 关闭源文件和目标文件
		in.close();
		out.close();
	}

	public static void main(String[] args) throws IOException {
		String SrcFileName, DesFileName;
		Scanner in = new Scanner(System.in);
		System.out.println("请输入源文件名： ");
		SrcFileName = in.nextLine();
		System.out.println("请输入目标文件名： ");
		DesFileName = in.nextLine();
		// 调用复制文件方法copyFile
		FileCopy.copyFile(SrcFileName, DesFileName);
	}
}
