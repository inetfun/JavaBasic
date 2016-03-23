// Account.java
package Chapter7;

import java.io.*;
import java.text.DateFormat;
import java.util.*;

public class Account {
	private long id; // 定义账户ID
	private double amount; // 定义账户金额
	private Date date; // 定义交易日期

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	// 输出时将对象转换为字符串
	public String toString() {
		// 获取为日期和时间使用short风格的默认日期/时间格式器
		DateFormat ssd = DateFormat.getDateInstance();
		return "账户ID:" + this.getId() + " 账户金额：" + this.getAmount() + "￥"
				+ " 日期：" + ssd.format(this.date);
	}

	public Account() { // 无参数的构造方法
		this(0l, 0.0, new Date());
	}

	public Account(long id, double amount, Date date) { // 构造方法，初始化成员变量
		this.setId(id);
		this.setAmount(amount);
		this.setDate(date);
	}

	// 写账户信息方法
	public void write(DataOutputStream out) throws IOException {
		out.writeLong(this.getId());
		out.writeDouble(this.getAmount());
		out.writeLong(this.getDate().getTime());
	}

	// 读取账户信息方法
	public Account read(DataInputStream in) throws IOException {
		this.setId(in.readLong());
		this.setAmount(in.readDouble());
		this.setDate(new Date(in.readLong()));
		return this;
	}

	// 账户信息读取方法，返回账户对象数组
	public static Account[] readAccount(File file) throws IOException {
		FileInputStream in = null;
		DataInputStream dataIn = null;
		Account[] accounts = new Account[2];
		try {
			in = new FileInputStream(file); // 创建文件输入流类
		} catch (IOException e) {
			System.out.println("文件不存在！");
		}
		dataIn = new DataInputStream(in); // 创建数据输入流类
		try { // 调用dataIn.available()判断是否到达文件末尾
			for (int i = 0; i < accounts.length && dataIn.available() > 0; i++) {
				Account temp = new Account();
				accounts[i] = temp.read(dataIn); // 调用读账户信息方法
			}
		} catch (EOFException ee) {
			ee.printStackTrace();
		}
		dataIn.close();
		in.close();
		return accounts; // 返回数组
	}

	// 账户信息写方法
	public static boolean writeAccount(Account[] accounts, File file)
			throws IOException {
		boolean flag = true;
		FileOutputStream out = null;
		DataOutputStream dataOut = null;
		try {
			out = new FileOutputStream(file); // 创建文件输出流
			dataOut = new DataOutputStream(out); // 创建数据输出流
			for (int i = 0; i < accounts.length; i++) {
				accounts[i].write(dataOut); // 将账户信息写入文件
			}
		} catch (Exception e) {
			System.out.println("写账户信息失败！");
			flag = false;
		} finally {
			if (dataOut != null) {
				dataOut.close();
			}
		}
		return flag; // 返回标记值
	}
}
