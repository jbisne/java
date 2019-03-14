import java.awt.Toolkit;
import java.io.*;
import java.net.*;

public class Receiver extends Thread{
	Socket socket;
	BufferedReader in = null;
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	
	public Receiver(Socket socket) {
		
		this.socket = socket;
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));			
		} catch(Exception e) {
			printEndComment();
			try {
				in.close();
			} catch(Exception e1) { 
				printEndComment();
			}
		}
	}
	
	@Override
	public void run() {
		
		while(in != null) {
			try {
				toolkit.beep();
				System.out.println(in.readLine());
			} catch (java.net.SocketException ne) {
				printEndComment();
				break;
			} catch (Exception e) {
				printEndComment();
				break;
			}
		}
		
		try {
			in.close();
		} catch (Exception e) {
			printEndComment();
			return;
		}
	}
	
	public void printEndComment() {
		System.out.println("┌─────────────────────┐");
		System.out.println("│채팅이 종료되었습니다│");
		System.out.println("└─────────────────────┘");
	}
}
