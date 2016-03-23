// InterfaceExample.java
package Chapter4;
// ������һϵ�нӿ�
interface VideoCard {		// �Կ�
	void getName();			// ��ȡ�Կ�����
	void getVideoMemory();	// ��ȡ�Դ�����
}
interface Memory {			// �ڴ���
	void getMemoryVolume();	// ��ȡ�ڴ�������
	void getMemoryType();	// ��ȡ�ڴ�������
}
interface CPU {				// CPU
	void getName();			// ��ȡCPU����
	void getSpeed();		// ��ȡCPU�ٶ�
}
interface AudioCard {		// ����
	void getName();			// ��ȡ��������
}
interface Mainboard {		// ����
	void setCPU(CPU cpu);	// CPU
	void setMemory(Memory memory);		// �ڴ���
	void setVideoCard(VideoCard vc);	// �Կ�
	void setAudioCard(AudioCard ac);	// ����
}
// һ���࣬�����̳к�ʵ������Ľӿ�
class VideoCardImpl implements VideoCard {
	public void getName() {
		System.out.println("The video card name is Winfast");
	}
	public void getVideoMemory() {
		System.out.println("The video memory is 256M");
	}
}
class MemoryImpl implements Memory {
	public void getMemoryVolume() {
		System.out.println("The memory volume is 2GB");
	}
	public void getMemoryType() {
		System.out.println("The memory type is DDR2");
	}
}
class CPUImpl implements CPU {
	public void getName() {
		System.out.println("The CPU name is Intel");
	}
	public void getSpeed() {
		System.out.println("The CPU speed is 2.8G");
	}
}
class AudioCardImpl implements AudioCard {
	public void getName() {
		System.out.println("The audio card name is Ac97");
	}
}
class MainboardImpl implements Mainboard {
	public void setCPU(CPU cpu) {
		cpu.getName();
		cpu.getSpeed();
	}
	public void setMemory(Memory memory) {
		memory.getMemoryVolume();
		memory.getMemoryType();
	}
	public void setVideoCard(VideoCard vc) {
		vc.getName();
		vc.getVideoMemory();
	}
	public void setAudioCard(AudioCard ac) {
		ac.getName();
	}
}
// ���幫����
public class InterfaceExample {
	public static void main(String args[]) {
		Mainboard mb = new MainboardImpl();
		mb.setCPU(new CPUImpl());
		mb.setMemory(new MemoryImpl());
		mb.setVideoCard(new VideoCardImpl());
		mb.setAudioCard(new AudioCardImpl());
	}
}
