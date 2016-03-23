// PaintRectangle.java
package Chapter3;

import java.awt.*;

public class PaintRectangle extends Frame {
	private int x, y, width, height; // ����˽�б���

	// ����һ�����ڲ�ʹ��ɼ�����ʱϵͳ���Զ�����paint����
	public void init() {
		setSize(400, 200); // ���ô��ڴ�С
		setVisible(true); // ʹ���ڿɼ�
	}

	// �޲����Ĺ��췽����ʹȫ����Ա������Ϊ0
	public PaintRectangle() {
		x = 0;
		y = 0;
		width = 0;
		height = 0;
	}

	// �������Ĺ��췽����Ϊ��Ա������ֵ
	public PaintRectangle(int xPos, int yPos, int w, int h) {
		x = xPos;
		y = yPos;
		width = w;
		height = h;
	}

	// ����ͼ��λ�����С�ķ���
	public void setPosition(int xPos, int yPos, int w, int h) {
		x = xPos;
		y = yPos;
		width = w;
		height = h;
	}

	// �ض���paint����������Ļ�ϻ��ƾ��β����������Ϣ
	// �÷����ڻ滭ʱ�ᱻ�Զ�����
	public void paint(Graphics g) {
		PaintRectangle b1; // ��������
		// �������󲢵����޲������췽����ʹȫ����Ա������Ϊ0
		b1 = new PaintRectangle();
		// �������󲢵����в������췽��
		PaintRectangle b2 = new PaintRectangle(170, 40, 60, 60);
		// Ϊ��Ա������ֵ
		b1.setPosition(20, 40, 60, 60);
		b1.draw(g); // ����b1�����draw���������ƾ���
		g.drawString("����1��X���꣺" + b1.x, 20, 120);
		g.drawString("����1��Y���꣺" + b1.y, 20, 140);
		b2.draw(g); // ����b2�����draw���������ƾ���
		g.drawString("����2��X���꣺" + b2.x, 170, 120);
		g.drawString("����2��Y���꣺" + b2.y, 170, 140);
	}

	// ����draw���������ƾ���
	public void draw(Graphics g) {
		g.drawRect(x, y, width, height);
	}

	public static void main(String[] args) {
		// �������󲢵����޲������췽����Ȼ�����init����
		new PaintRectangle().init();
	}
}
