import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		String s = "";
		
		try {
			serverSocket = new ServerSocket(9999);
			System.out.println("서버가 시작되었습니다.");
			
			socket = serverSocket.accept();	
			//서버 접속하는 식
			System.out.println(socket.getInetAddress()	+ ":" + socket.getPort());
			//로직상 불량사용자(?)를 여기서 걸러낸다.접속을 막을방법은 없다.
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(
											socket.getInputStream() ));
			
			s= in.readLine();
			System.out.println(s);
			out.println(s);
			
			System.out.println("Bye...");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
				
				socket.close();
				serverSocket.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
