//  StudentManager.java
package Chapter4;
abstract class Studentx {			// ������
	public String id;				// ѧ��ѧ��
	public String name;				// ѧ������
	public String className;		// �༶
	public abstract void logIn();	// ע�᷽��
	public abstract void clearOut();// ע������
}
// ��������
class UnderGraduate extends Studentx {
	private String counsellors;		// ����Ա
	public void logIn() {			// ������ע��
		// ע�����.....
		System.out.println("������ע�ᣬע��ɹ���");
	}
	public void clearOut() {		// ������ע��
		// ע������.....
		System.out.println("������ע����ע���ɹ���");
	}
}
// �о�����
class Graduate extends Studentx {
	private String instrutor;		// ��ʦ
	private String research;		// �о�����
	public void logIn() {			// �о���ע��
		//ע�����......
		System.out.println("�о���ע�ᣬע��ɹ���");
	}
	public void clearOut() {		// �о���ע��
		//ע������....
		System.out.println("�о���ע����ע���ɹ���");
	}
}
// ѧ����������StudentManager
public class StudentManager {
	public void add(Studentx s) {	// ѧ��ע��
		s.logIn();
	}
	public void delete(Studentx s) {	// ѧ��ע��
		s.clearOut();
	}
	public static void main(String[] args) {
		StudentManager manager = new StudentManager();
		Studentx underGraduate = new UnderGraduate();
		Studentx graduate = new Graduate();
		manager.add(underGraduate);			//������ע��
		manager.delete(underGraduate);		//������ע��
		manager.add(graduate);				//�о���ע��
		manager.delete(graduate);			//�о���ע��
	}
}
