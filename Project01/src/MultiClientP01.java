import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MultiClientP01 
{
	public static void main(String[] args) throws SQLException, UnknownHostException, IOException
	{
		System.out.println("이름, ID, 비밀번호를 입력해 주세요.");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		String ID = sc.nextLine();
		String pwd = sc.nextLine();
		
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
			Statement stmt = con.createStatement();
			
			StringBuffer sb = new StringBuffer();
			sb.append("insert into PERSON	");
			sb.append(" values ('"+name+"','"+ID+"' ,'"+pwd+"') ");
			stmt.executeUpdate(sb.toString());
			
			stmt.close();
			con.close();
			
		} catch(SQLException sqle){
			System.out.println("Connection Error");
			sqle.printStackTrace();
		}
			
		System.out.println("회원가입이 완료되었습니다.");
////////////////////////( 회원가입) //////////////////
		
		try {
			String ServerIP = "localhost";
			if (args.length > 0)
				ServerIP = args[0];
			Socket socket = new Socket(ServerIP,9999); //소켓 객체 생성
			System.out.println("서버와 연결이 되었습니다.");
			
			Thread receiver = new ReceiverP01(socket);
			receiver.start();
			
			new ChatWin(socket,ID);
			
		} catch(Exception e) {
			System.out.println("예외[MultiClient class]:"+e);
		}
		



	}

}
