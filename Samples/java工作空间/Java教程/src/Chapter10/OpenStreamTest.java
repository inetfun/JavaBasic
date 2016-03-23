// OpenStreamTest.java
package Chapter10;

import java.io.*;
import java.net.*;

public class OpenStreamTest {
	public static void main(String[] args) {
		try {
			URL google = new URL("http://www.google.com/");
			DataInputStream dis = new DataInputStream(google.openStream());
			String inputLine;
			while ((inputLine = dis.readLine()) != null) {
				System.out.println(inputLine);
			}
			dis.close();
		} catch (MalformedURLException me) { // 创建一个URL对象失败
			System.out.println("MalformedURLException:" + me);
		} catch (IOException ioe) { // 打开一个连接失败
			System.out.println("IOException:" + ioe);
		}
	}
}
