// Fruit.java
package Chapter3; //�����������ڰ�

//��������ÿ��Java������ֻ����һ���౻����ΪPublic��
//���ͬʱ��Java����������������������ͬ
public class Fruit {
	private boolean seedless; // ��Ա��������
	private boolean seasonal;
	private float price;

	// ��Ա����������ˮ������
	public void setPrioperties(boolean seed, boolean season, float cost) {
		seedless = seed;
		seasonal = season;
		price = cost;
	}

	// ��Ա���������ˮ������
	public void printProperties() {
		if (seedless) {
			System.out.println("Friut is seedless");
		} else {
			System.out.println("Friut is seedes");
		}
		if (seasonal) {
			System.out.println("Friut is seasonal");
		} else {
			System.out.println("Friut is not seasonal");
		}
		System.out.println("Price is " + price);
	}

	// ���а�����main������˵������ΪJava��������࣬�����Ա����е���
	// ����Java ApplicationӦ�ó�������
	public static void main(String[] args) {
		boolean myseed, myseason;// �����ֲ�����
		float mycost;
		myseed = false;// Ϊ�ֲ�������ֵ
		myseason = true;
		mycost = 25.86F;
		Fruit MyFruit = new Fruit();// �����ഴ������
		// ����setPrioperties������Ϊ��Ա������ֵ
		MyFruit.setPrioperties(myseed, myseason, mycost);
		MyFruit.printProperties(); // ����printProperties���������ˮ������
	}
}
