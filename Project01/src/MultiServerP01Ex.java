import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MultiServerP01Ex
{
	ServerSocket serverSocket = null;
	Socket socket = null;
	Map<String, PrintWriter> clientMap;
	
	//생성자
	public MultiServerP01Ex() {
		clientMap = new HashMap<String, PrintWriter>();
		Collections.synchronizedMap(clientMap);
	}
	
	public void init()
	{
		try {
			serverSocket = new ServerSocket(9999); //9999포트로 서버소켓 객체생성
			System.out.println("서버가 시작되었습니다.");
			
			while (true) {
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress()+":"+socket.getPort());
				
				Thread mst = new MultiServerT(socket); //쓰레드 생성
				mst.start(); //쓰레드 시동.
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//접속된 모든 클라이언트들에게 메시지를 전달.
	public void sendAllMsg(String user, String msg)
	{
		//출력스트림을 순차적으로 얻어와서 해당 메시지를 출력한다.
		Iterator<String> it = clientMap.keySet().iterator();
		
		while (it.hasNext()) {
			try {
				PrintWriter it_out = (PrintWriter) clientMap.get(it.next());
				if (user.equals(""))
					it_out.println(msg);
				else
					it_out.println("["+user+"] "+msg);
			} catch (Exception e) {
				System.out.println("예외:"+e);
			}
		}
	}

	public static void main(String[] args) 
	{
		//서버객체 생성
		MultiServerP01Ex ms = new MultiServerP01Ex();
		ms.init();

	}
	
	public void Command() {
		
	}
	class MultiServerT extends Thread
	{
		Socket socket;
		PrintWriter out = null;
		BufferedReader in = null;
		
		//생성자
		public MultiServerT(Socket socket) {
			this.socket = socket;
			try {
				out = new PrintWriter(this.socket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(
												this.socket.getInputStream() ));
			} catch (Exception e) {
				System.out.println("예외:"+e);
			}
		}
		
		//쓰레드를 사용하기 위해서 run()메서드 재정의
		@Override
		public void run()
		{
			//String s = "";
			String ID = ""; //클라이언트로부터 받은 이름을 저장할 변수.
			try {
				ID = in.readLine(); //클라이언트에서 처음으로 보내는 메시지는
									  //클라이언트가 사용할 이름이다.
				
				sendAllMsg("",ID + "님이 입장하셨습니다.");
				//현재 객체가 가지고 있는 소켓을 제외하고 다른 소켓(클라이언트)들에게 접속을알림.
				clientMap.put(ID, out); //해쉬맵에 키를 name으로 출력스트림 객체를 저장.
				System.out.println("현재 접속자 수는 " +clientMap.size()+"명 입니다.");
				
				// 입력스트림이 null이 아니면 반복.
				String s = "";
				while (in != null) {
					s = in.readLine();
					System.out.println(s);
//					if (s.equlas("q") || s.equals("Q") )
//						break;
						sendAllMsg(ID, s);
				}
			
//					System.out.println("Bye...");
			
			} catch(Exception e) {
				System.out.println("예외:"+e);
			} finally {
				//예외가 발생할때 퇴장. 해쉬맵에서 해당 데이터 제거.
				//보통 종료하거나 나가면 java.net.socketException: 예외발생
				
				clientMap.remove(ID);
				sendAllMsg("",ID + "님이 퇴장하셨습니다.");
				System.out.println("현재 접속자 수는 "+clientMap.size()+"명 입니다.");
			
				try {
					in.close();
					out.close();
					
					socket.close();
					
					
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	/////////////////////////////////////////////////////////////////
}
