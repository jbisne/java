import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiverP01 extends Thread
{
	Socket socket;
	BufferedReader in = null;
	
	//Socket을 매개변수로 받는 생성자.
	public ReceiverP01(Socket socket)
	{
		this.socket = socket;
		
		try {
			in = new BufferedReader (new InputStreamReader(
										this.socket.getInputStream() ));
		} catch (Exception e) {
			System.out.println("예외:"+e);
		}
	}
	
	//run()메소드 재정의
	@Override
	public void run() {
		while (in !=null) {
			try {
				System.out.println(">>" + in.readLine());
			} catch (java.net.SocketException ne) {
				break;
			} catch (Exception e) {
				System.out.println("예외:"+e);
			}
		}
		
		try {
			in.close();
		} catch (Exception e) {
			System.out.println("예외3:"+e);
		}
	}
}