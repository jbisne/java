// 간단하지만 중요하다. 나중에 공공데이터 이렇게 읽는것.
// 에디터로 보면 콘솔값으로 나오는것이고, HTML로 파싱하면 웹페이지로 나오는것.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class NetworkEx4 {
	public static void main(String[] args) {
		URL url = null;
		BufferedReader input = null;
		String address = "http://www.enjoypuzzle.com";
		String line = "";
		
		try {
			url = new URL(address);
			
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while((line = input.readLine()) != null) {
				System.out.println(line);
			}
			input.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
