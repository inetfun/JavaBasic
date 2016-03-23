// AccountMain.java
package Chapter7;

import java.io.*;
import java.text.*;

public class AccountMain {
	public static void main(String[] args) throws Exception {
		// getDateInstance用来获取国家/地区的标准日期格式
		DateFormat ssd = DateFormat.getDateInstance();
		File file = null;
		if (args.length > 0) {
			file = new File(args[0]); // 以main()方法参数创建File对象
		} else {
			file = new File("c:\\account.txt");
		}
		// 创建账户对象数组。ssd对象的parse方法用来将字符串转换为Date对象
		Account[] accounts = { new Account(1, 2000.5, ssd.parse("2010-04-25")),
				new Account(2, 1000.5, ssd.parse("2010-06-25")) };
		System.out.println("正在保存数据中......");
		if (Account.writeAccount(accounts, file)) { // 调用写账户信息方法
			System.out.println("数据保存成功！");
		} else {
			System.out.println("数据保存失败！");
		}
		accounts = Account.readAccount(file); // 调用读账户信息方法
		System.out.println("数据读取结束，正在回显中......");
		if (accounts.length == 0) { // 判断是否有账户信息
			System.out.println("文件中没有数据！");
		} else {
			for (int i = 0; i < accounts.length; i++) {
				System.out.println(accounts[i]); // 输出账户信息
			}
			System.out.println("数据显示结束！");
		}
	}
}
