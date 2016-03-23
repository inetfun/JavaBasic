// GetDayTime.java
package Chapter10;
import java.io.*;
import java.net.*;

public class GetDayTime {
	public static void main(String[] args) {
		try {
			Socket conn = new Socket("stdtime.gov.hk", 13); // 创建Socket对象
			BufferedReader in = new BufferedReader(new InputStreamReader(conn
					.getInputStream()));
			String daytime = in.readLine();
			System.out.println("DayTime received:" + daytime);
			conn.close();
		} catch (IOException e) {
			System.out.println("Error:" + e);
		}
	}
}
