/*JavaApplet.java*/ 
import java.awt.Graphics; 			//��import�������java.awt.Graphics��
import java.applet.Applet; 			//��import�������java.applet.Applet��
/**
*   �����˹�����JavaApplet����������Ӧ����һ�£���extendsָ���˸�����Applet
*   ������������࣬����Java Applet������������
*/
public class JavaApplet extends Applet{
public void paint(Graphics g){
	//�����˶���g��drawString( )������
	//�����꣨20,20��������ַ�������ӭ��ѧϰJava���ԣ�����
	//���У�������������Ϊ��λ��
        g.drawString("��ӭ��ѧϰJava���ԣ�",20,20);
      }
}
