// ClassInherit.java
package Chapter4;
// ��������Pclass
class Pclass {
	void Draw() {
		System.out.println("Pclass�࣬Draw������");
	}
}
// ��������Sclass
class Sclass extends Pclass {
	void Draw() {
		System.out.println("Sclass�࣬Draw������");
	}
	void NewDraw() {
		System.out.println("Sclass�࣬NewDraw������");
	}
}
// ����������
public class ClassInherit {
	public static void main(String[] args) {
		Pclass obj1 = new Pclass();		// ����Pclass�����obj1
		Sclass obj2 = new Sclass();		// ����Sclass�����obj2
		obj1.Draw();	// ����Obj1��Draw����
		obj2.Draw();	// ����obj2��Draw����
		obj2.NewDraw();	// ����obj2��NewDraw����
		obj1 = obj2;	// ���������ֵ���������
		// ����ת����obj1�����Draw������ʵ����������������Draw������
		obj1.Draw();
		// ���ǣ���ʹת���˶������ͣ����������Ȼ�Ƿ���obj1����
		// ֻ�ܵ��ø���ķ���
		// obj1.NewDraw();
	}
}
