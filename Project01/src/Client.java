import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Client
{	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		while(true)
		{
			Scanner sc = new Scanner(System.in);
			
			System.out.println("선택하세요.");
			System.out.println("1. 회원 가입");
			System.out.println("2. 로그인");
			System.out.println("3. 계정 삭제");
			System.out.println("4.프로그램 종료");
			System.out.println("선택 :");
			int num = sc.nextInt();
		
			
			if(num==1)	
			{	
				Scanner s1 = new Scanner(System.in);
				String name;
				String id;
				String pwd;
				System.out.println("회원가입을 시작합니다.");
				System.out.println("이름 : ");	
				name = s1.next();
				System.out.println("ID : ");
				id = s1.next();
				System.out.println("PASSWORD : ");
				pwd = s1.next();
				
				try 
				{
					Connection con = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:xe",
							"scott",
							"tiger");
					Statement stmt = con.createStatement();			
					StringBuffer sb = new StringBuffer();
					
					sb.append("insert into PERSON	");
					sb.append(" values ('"+name+"','"+id+"' ,'"+pwd+"') ");
					stmt.executeUpdate(sb.toString());
					
					stmt.close();
					con.close();
					System.out.println("회원가입이 완료되었습니다!");
					System.out.println("");	
					
				} catch(Exception e) {
					System.out.println("회원가입을 실패했습니다.");
					System.out.println("아이디가 존재합니다.");
					System.out.println();
					continue;				
				}
			}
		
	
				
	///////////////////////////회원가입//////////////////////
		
			if(num==2)
			{
				Scanner s2 = new Scanner(System.in);
				String name;
				String id;
				String pwd;
				String UserID;
				String password;
				System.out.println("로그인을 시작합니다.");
				System.out.println("");
				System.out.println("ID : ");
				id = s2.next();
				System.out.println("비밀번호 : ");
				pwd = s2.next();
						
				try 
				{
					Connection con = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:xe",
							"scott",
							"tiger");
					
					String sql = "select * from PERSON where ID = "+"'" +id+ "'";
					PreparedStatement pstmt = con.prepareStatement(sql);				
					ResultSet rs = pstmt.executeQuery();
					
					if(rs.next())
					{
						UserID = rs.getString(2);
						password = rs.getString(3);
					
					
						if(UserID.equals(id) && password.equals(pwd)) 
						{
							System.out.println("로그인 되었습니다");
							try {
								String ServerIP = "localhost";
								if(args.length>0)
									ServerIP = args[0];
								Socket socket = new Socket(ServerIP, 9999);
								System.out.println("서버와 연결되었습니다.");
								
								Thread receiver = new ReceiverP01(socket);
								receiver .start();
								
								new ChatWin(socket,id);
								
							} catch (Exception e) {
								System.out.println("서버와 연결해주세요.");
							}
								break;
								
								
					
						} else {
							System.out.println("정보가 틀렸습니다.");
							System.out.println("다시 입력해주세요.");
							System.out.println();
							continue;
						}
						
					}
					
			
					if(id.equals("")) {
					System.out.println("아이디가 없습니다.");
					System.out.println("다시 입력해주세요.");
					continue;
					}
					
		
					rs.close();
					pstmt.close();
					con.close();
					break;
					
							
				} 
				catch (Exception e) {
						e.printStackTrace();
						continue;													
				}							
			}
			
//			try {
//				String ServerIP = "localhost";
//				if(args.length>0)
//					ServerIP = args[0];
//				Socket socket = new Socket(ServerIP, 9999);
//				System.out.println("서버와 연결되었습니다.");
//				
//				Thread receiver = new ReceiverP01(socket);
//				receiver .start();
//				
//				new ChatWin(socket,id);
//				
//			} catch (Exception e) {
//				System.out.println("서버와 연결해주세요.");
//			}	

		
			if(num==3)
			{
				Scanner s3 = new Scanner(System.in);
				String name;
				String id;
				String pwd;
				String UserName;
				String UserID;
				String password;
				System.out.println("계정을 삭제합니다.");
				System.out.println("이름 : ");
				name = s3.next();
				System.out.println("ID : ");
				id = s3.next();
				System.out.println("PASSWARD : ");
				pwd = s3.next();
				System.out.println();
			
			
			try 
			{
				Connection con = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"scott",
						"tiger");
				
				Statement stmt = con.createStatement();			
				StringBuffer sb = new StringBuffer();
				
				String sql = "select * from PERSON where id = '"+id+"'";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next())
				{
					UserName = rs.getString(1);
					UserID = rs.getString(2);
					password = rs.getString(3);
				
				
					if(UserName.equals(name) && UserID.equals(id) && password.equals(pwd)) 
					{
						sql = "delete from PERSON where ID = '"+id+"'";
						pstmt = con.prepareStatement(sql);
						rs = pstmt.executeQuery();
						sb.setLength(0);
						
						System.out.println("계정이 삭제되었습니다.");
						System.out.println();
							continue;
				
					} else {
						System.out.println("정보가 일치하지않습니다.");
						System.out.println("다시 입력해주세요.");
						System.out.println();
						continue;
					}
				}
				
				pstmt.close();
				stmt.close();
				con.close();
				System.out.println("삭제가 완료되었습니다!");
				System.out.println("");	
				
			} catch(Exception e) {
				System.out.println("삭제를 실패했습니다.");
				System.out.println();
				continue;				
			}
		}
						
///////// 회원탈퇴 			
			if(num==4)
			{
				System.out.println("프로그램을 종료합니다.");
				System.out.println();
				continue;
			}
			
			

			/////밑에 3개가 맨위에 클래스,while,메인 메서드 괄호///
		}
	}
}



		

