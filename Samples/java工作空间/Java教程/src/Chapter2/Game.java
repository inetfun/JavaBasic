// Game.java
package Chapter2;

import java.util.Scanner;

public class Game {
	static final int FGVALUE = 20; // ������Ů�ݵ��ۼ�
	static final int GSVALUE = 16; // ������������ۼ�
	static final int FGLIFE = 30; // ������Ů�����ӵ�������
	static final int GSLIFE = 20; // �������������ӵ�������

	public static void main(String[] args) {
		int goldcoin = 100; // �����ҵ�����
		int fg_num = 0, gs_num = 0; // ������Ů���������������
		int max_life = 0; // �������������ֵ
		System.out.println("�������ҵ�������");
		Scanner in = new Scanner(System.in); // ����Scanner�ഴ��in����
		goldcoin = in.nextInt(); // ����nextInt()���ؼ����������һ������
		for (int fg_loop = 0; fg_loop <= (goldcoin / FGVALUE); fg_loop++)
			for (int gs_loop = 0; gs_loop <= (goldcoin / GSVALUE); gs_loop++)
				if (((fg_loop * FGVALUE + gs_loop * GSVALUE) <= goldcoin)
						&& ((FGLIFE * fg_loop + GSLIFE * gs_loop) > max_life)) {
					fg_num = fg_loop; // ��¼��Ů�ݵ�����
					gs_num = gs_loop; // ��¼�����������
					// ��¼���ӵ����������
					max_life = FGLIFE * fg_loop + GSLIFE * gs_loop;
				}
		System.out.println("����ı��������������" + max_life + "����������");
		System.out.println("������Ů�ݵ�����Ϊ" + fg_num);
		System.out.println("���������������Ϊ" + gs_num);
	}
}
