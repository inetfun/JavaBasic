// Account.java
package Chapter7;

import java.io.*;
import java.text.DateFormat;
import java.util.*;

public class Account {
	private long id; // �����˻�ID
	private double amount; // �����˻����
	private Date date; // ���彻������

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

	// ���ʱ������ת��Ϊ�ַ���
	public String toString() {
		// ��ȡΪ���ں�ʱ��ʹ��short����Ĭ������/ʱ���ʽ��
		DateFormat ssd = DateFormat.getDateInstance();
		return "�˻�ID:" + this.getId() + " �˻���" + this.getAmount() + "��"
				+ " ���ڣ�" + ssd.format(this.date);
	}

	public Account() { // �޲����Ĺ��췽��
		this(0l, 0.0, new Date());
	}

	public Account(long id, double amount, Date date) { // ���췽������ʼ����Ա����
		this.setId(id);
		this.setAmount(amount);
		this.setDate(date);
	}

	// д�˻���Ϣ����
	public void write(DataOutputStream out) throws IOException {
		out.writeLong(this.getId());
		out.writeDouble(this.getAmount());
		out.writeLong(this.getDate().getTime());
	}

	// ��ȡ�˻���Ϣ����
	public Account read(DataInputStream in) throws IOException {
		this.setId(in.readLong());
		this.setAmount(in.readDouble());
		this.setDate(new Date(in.readLong()));
		return this;
	}

	// �˻���Ϣ��ȡ�����������˻���������
	public static Account[] readAccount(File file) throws IOException {
		FileInputStream in = null;
		DataInputStream dataIn = null;
		Account[] accounts = new Account[2];
		try {
			in = new FileInputStream(file); // �����ļ���������
		} catch (IOException e) {
			System.out.println("�ļ������ڣ�");
		}
		dataIn = new DataInputStream(in); // ����������������
		try { // ����dataIn.available()�ж��Ƿ񵽴��ļ�ĩβ
			for (int i = 0; i < accounts.length && dataIn.available() > 0; i++) {
				Account temp = new Account();
				accounts[i] = temp.read(dataIn); // ���ö��˻���Ϣ����
			}
		} catch (EOFException ee) {
			ee.printStackTrace();
		}
		dataIn.close();
		in.close();
		return accounts; // ��������
	}

	// �˻���Ϣд����
	public static boolean writeAccount(Account[] accounts, File file)
			throws IOException {
		boolean flag = true;
		FileOutputStream out = null;
		DataOutputStream dataOut = null;
		try {
			out = new FileOutputStream(file); // �����ļ������
			dataOut = new DataOutputStream(out); // �������������
			for (int i = 0; i < accounts.length; i++) {
				accounts[i].write(dataOut); // ���˻���Ϣд���ļ�
			}
		} catch (Exception e) {
			System.out.println("д�˻���Ϣʧ�ܣ�");
			flag = false;
		} finally {
			if (dataOut != null) {
				dataOut.close();
			}
		}
		return flag; // ���ر��ֵ
	}
}
