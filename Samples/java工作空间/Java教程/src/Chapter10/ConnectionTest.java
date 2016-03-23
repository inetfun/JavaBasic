// ConnectionTest.java
package Chapter10;

import java.io.*;
import java.net.*;

public class ConnectionTest {
	public static void main(String[] args) {
		try {
			URL baidu = new URL("http://www.google.com/");
			URLConnection baiduConnection = baidu.openConnection();
			// ��������������
			DataInputStream dis = new DataInputStream(baiduConnection
					.getInputStream());
			String inputLine;
			while ((inputLine = dis.readLine()) != null) {
				System.out.println(inputLine);
			}
			dis.close();
		} catch (MalformedURLException me) { // ����һ��URL����ʧ��
			System.out.println("MalformedURLException:" + me);
		} catch (IOException ioe) { // ��һ������ʧ��
			System.out.println("IOException:" + ioe);
		}
	}
}
