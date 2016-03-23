package Chapter1;

public class HelloWorld {
	public static void main(String[] args) {
		// 输出提示信息
		System.out.println("打印main方法中的输入参数！");
		// 声明一个整型变量i，将其作为for循环控制变量
		// 以输出命令行中输入的字符串
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}

}
