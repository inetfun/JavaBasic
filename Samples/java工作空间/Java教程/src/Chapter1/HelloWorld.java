package Chapter1;

public class HelloWorld {
	public static void main(String[] args) {
		// �����ʾ��Ϣ
		System.out.println("��ӡmain�����е����������");
		// ����һ�����ͱ���i��������Ϊforѭ�����Ʊ���
		// �������������������ַ���
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}

}
