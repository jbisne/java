import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

public class UserManage extends ChatServer{
	
	private static DBConnector oracleDBConnector = DBConnector.getInstance();
	
	ResultSet rs;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;

	private String UserID;
	private String password;
	
	Socket socket;
	PrintWriter out;
	UserManage guest;
	BufferedReader in;
	Map<String, PrintWriter> clientMap;
		
	public UserManage()
	{
		
	}
	public UserManage(Socket socket, PrintWriter out, BufferedReader in, Map<String, PrintWriter> clientMap) 
	{ 
		this.clientMap = clientMap;
		this.socket = socket;
		this.out = out;
		this.in = in;

	}
	
	public UserManage(String userID, String password) 
	{
		this.UserID = userID;
		this.password = password;
	}
	

	public void showConnectMenu(UserManage userInfo) throws IOException
	{		
		String choice;
		while(true) {
				try {
				out.println("┌────────────────────┐");
				out.println("│ 1. 회원가입        │");
				out.println("│ 2. 회원탈퇴        │");
				out.println("│ 3. 로그인          │");
				out.println("└────────────────────┘");
				choice = in.readLine();			
				out.println(" ▶ 선택 : " + choice);
				if(choice.contentEquals("1"))
				{
					registerID();
					continue;
				}
				else if(choice.contentEquals("2"))
				{
					deleteID();
					continue;
				}
				else if(choice.contentEquals("3"))
				{
					logIn(userInfo);
					break;
				}
				else
				{
					out.println(" ▶ 잘못된 선택입니다 ");
					continue;
				}
			} 
			catch (Exception e) 
			{
				in.close();
				out.close();
				socket.close();
				break;
			}
		}
	}
	
	public void registerID () 
	{
		String userID;
		String password;
		String sql = null;
		int count = 0;
		while(true) {
			try 
			{	
				count = 0;
				con = oracleDBConnector.getConnection();
				out.println("┌──────────────────────────┐");
				out.println("│          SIGN UP         │");
				out.println("└──────────────────────────┘");
				out.println(" ▶ 사용하실 ID를 입력하세요 ");
				userID = in.readLine();
				out.println(" ▶ 입력 : " + userID);
				sql =  "select * from CLIENT";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();				
				while(rs.next())					
				{
					if(rs.getString(1).equals(userID))
					{

						out.println(" ▶ 이미 존재하는 ID 입니다 ");
						out.println("   다른 ID를 사용해 주세요 ");

						count++;
					}
				}
				if (count > 0) continue;
				out.println(" ▶ 비밀번호를 입력하세요 ");
				password = in.readLine();
				out.println(" ▶ 입력 : " + password);
				sql = "INSERT INTO CLIENT (ID, PASSWORD, IPBLACK, IDBLACK, IP , YELLOWCARD , ISADMIN) VALUES ('" + userID + "', '" + password + "', 'X', 'X', '" + this.socket.getInetAddress() + "', 0, 0)";

				stmt = con.createStatement();
				stmt.executeUpdate(sql);
				
				pstmt.close();
				rs.close();	
				stmt.close();	
				con.close();
				break;
			} catch(Exception e) {	return; }
		}
		out.println(" ▶  회원가입 완료 ");
	}
			
	public void deleteID()
	{
		String id;
		String pwd;
		String sql;
		out.println("┌──────────────────────────┐ ");
		out.println("│        WITHDRAWAL        │");
		out.println("└──────────────────────────┘");
		con = oracleDBConnector.getConnection();
		while(true)
		{		
			try 
			{									
				out.println(" ▶ 탈퇴할 ID를 입력하세요 ");
				id = in.readLine();
				out.println(" ▶ 입력 : " + id );
				sql = "select * from CLIENT where ID = '" + id + "'";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					if(rs.getString(1).equals(id))
					{
						out.println(" ▶ 비밀번호를 입력하세요 ");
						pwd = in.readLine();
						out.println(" ▶ 입력 : " + pwd);
						if(rs.getString(2).equals(pwd))
						{
							sql = "delete from CLIENT where ID = '" + rs.getString(1) + "'";
							stmt = con.createStatement();
							stmt.executeUpdate(sql);
							break;
						}
						else
						{
							out.println(" ▶ 비밀번호가 틀렸습니다 ");
							continue;
						}
					}
					else
					{
						out.println(" ▶ 존재하지 않는 ID 입니다 ");
						continue;
					}
				}
				rs.close();
				stmt.close();
				pstmt.close();
				con.close();
			} catch(Exception e) {
				e.printStackTrace();
				try {
					in.close();
					out.close();
					socket.close();
					break;
				} catch (Exception e1) {
					e1.printStackTrace();
					System.out.println(" ▷ 사용자가 접속을 종료하였습니다.");
					break;
				}
			}
		}
		out.println(" ▶ 탈퇴되었습니다 ");
	}
			
	public void logIn(UserManage userInfo)
	{
		String id;
		String pwd;
		String sql;
		while(true)
		{
			try 
			{	
				con = oracleDBConnector.getConnection();
				out.println("┌─────────────────────────┐");
				out.println("│          LOGIN          │");
				out.println("└─────────────────────────┘");
				out.println(" ▶ ID를 입력하세요 ");

				id = in.readLine();
				
				if(isLoggedIn(id)) 
				{
					out.println(" ▶ 이미 접속중인 ID 입니다 ");
					continue;
				}
				out.println(" ▶ 비밀번호를 입력하세요 ");
				pwd = in.readLine();	
				
				sql = "select * from CLIENT where ID = '" + id + "'";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();		
				if(rs.next()) 
				{			
					String UserID = rs.getString(1);
					String password = rs.getString(2);
					
					if(UserID.equals(id) && password.equals(pwd))
					{
						if(rs.getString(4).equals("O"))
						{
							out.println(" ▶ 차단된 ID 입니다 ");
							userInfo.setUserID("BlackList");
							userInfo.setPassword(password);
							break;
						}
						userInfo.setUserID(UserID);
						userInfo.setPassword(password);
						break;
					}
					else
					{
						out.println(" ▶ 로그인 정보가 잘못되었습니다 ");
						continue;
					}
				}
			
				rs.close();
				pstmt.close();
				con.close();
			} catch(Exception e) {
				try {
					in.close();
					out.close();
					socket.close();
					break;
				} catch (Exception e1) { 
					System.out.println(" ▷ 사용자가 접속을 종료하였습니다.");
					break;
				}
			}			
		}
	}
	
	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn(String userID)
	{
		Iterator<String> it = clientMap.keySet().iterator();
		while(it.hasNext())
		{
			if(it.next().contentEquals(userID))
				return true;
		}
		return false;
	}
}