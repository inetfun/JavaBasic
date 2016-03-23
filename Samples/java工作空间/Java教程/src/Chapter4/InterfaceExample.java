// InterfaceExample.java
package Chapter4;
// 定义了一系列接口
interface VideoCard {		// 显卡
	void getName();			// 获取显卡名称
	void getVideoMemory();	// 获取显存容量
}
interface Memory {			// 内存条
	void getMemoryVolume();	// 获取内存条容量
	void getMemoryType();	// 获取内存条类型
}
interface CPU {				// CPU
	void getName();			// 获取CPU名称
	void getSpeed();		// 获取CPU速度
}
interface AudioCard {		// 声卡
	void getName();			// 获取声卡名称
}
interface Mainboard {		// 主板
	void setCPU(CPU cpu);	// CPU
	void setMemory(Memory memory);		// 内存条
	void setVideoCard(VideoCard vc);	// 显卡
	void setAudioCard(AudioCard ac);	// 声卡
}
// 一组类，用来继承和实现上面的接口
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
// 定义公共类
public class InterfaceExample {
	public static void main(String args[]) {
		Mainboard mb = new MainboardImpl();
		mb.setCPU(new CPUImpl());
		mb.setMemory(new MemoryImpl());
		mb.setVideoCard(new VideoCardImpl());
		mb.setAudioCard(new AudioCardImpl());
	}
}
