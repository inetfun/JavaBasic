// Fruit1.java
package ���԰�; // �����ļ�������

// ����Chapter3���е�Fruit���
// ������ļ���Fruit.java��ͬһ�����У������赼�룬����������
import Chapter3.Fruit;

public class Fruit1 {
	public static void main(String[] args) {
		boolean myseed, myseason; // �����ֲ�����
		float mycost;
		myseed = true; // Ϊ�ֲ�������ֵ
		myseason = false;
		mycost = 15F;
		Fruit MyFruit = new Fruit(); // �����ഴ������
		// ����setPrioperties������Ϊ��Ա������ֵ
		MyFruit.setPrioperties(myseed, myseason, mycost);
		MyFruit.printProperties(); // ����printProperties���������ˮ������
	}
}
