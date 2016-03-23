/*JavaApplet.java*/ 
import java.awt.Graphics; 			//用import语句引入java.awt.Graphics类
import java.applet.Applet; 			//用import语句引入java.applet.Applet类
/**
*   定义了公共类JavaApplet（程序名字应与它一致）。extends指明了该类是Applet
*   的派生类或子类，这是Java Applet程序的真正入口
*/
public class JavaApplet extends Applet{
public void paint(Graphics g){
	//调用了对象g的drawString( )方法，
	//在坐标（20,20）处输出字符串“欢迎你学习Java语言！”。
	//其中，坐标是以像素为单位的
        g.drawString("欢迎你学习Java语言！",20,20);
      }
}
