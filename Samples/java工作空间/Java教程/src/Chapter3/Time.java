// Time.java
package Chapter3;	// �����������ڰ�

import java.util.Calendar;	//�����ⲿ���е���

public class Time {
	private Calendar t; // ����˽�б���
	private int y, m, d, hh, mm, ss;

	Time() { // ���췽��
		t = Calendar.getInstance(); // ��ȡ��ǰ���ں�ʱ��
		y = t.get(t.YEAR); // ��ȡ��
		m = t.get(t.MONTH) + 1; // ��ȡ��
		d = t.get(t.DATE); // ��ȡ��
		hh = t.get(t.HOUR_OF_DAY); // ��ȡСʱ
		mm = t.get(t.MINUTE); // ��ȡ��
		ss = t.get(t.SECOND); // ��ȡ��
	}

	public String getDate() { // �������ڵķ���
		return y + "��" + m + "��" + d + "��";
	}

	public String getTime() { // ����ʱ��ķ���
		String s = hh + "ʱ" + mm + "��" + ss + "��";
		return s;
	}

	public static void main(String[] args) {
		Time time = new Time(); // ��������
		System.out.println("��ǰ����:" + time.getDate());// �����ǰ����
		System.out.println("��ǰʱ��:" + time.getTime());// �����ǰʱ��
	}
}
