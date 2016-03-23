// InetAddressTest.java
package Chapter10;

import java.net.InetAddress;

public class InetAddressTest {
	public static void main(String[] args) throws Exception {
		InetAddress ia;
		// 获得本地主机的InetAddress对象
		ia = InetAddress.getLocalHost();
		// 输出本地主机IP地址
		System.out.println("本地主机IP地址:" + ia.getHostAddress());
		// 输出本地主机名
		System.out.println("本地主机名：" + ia.getHostName());
		// 获得百度网主机的InetAddress对象
		ia = InetAddress.getByName("www.baidu.com");
		// 输出百度网主机IP地址
		System.out.println("百度网主机IP地址:" + ia.getHostAddress());
		// 输出百度网主机名
		System.out.println("百度网主机名：" + ia.getHostName());
	}
}
