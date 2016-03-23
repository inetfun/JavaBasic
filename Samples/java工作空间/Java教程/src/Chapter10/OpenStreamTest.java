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
		} catch (MalformedURLException me) { // ����һ��URL����ʧ��
			System.out.println("MalformedURLException:" + me);
		} catch (IOException ioe) { // ��һ������ʧ��
			System.out.println("IOException:" + ioe);
		}
	}
}
