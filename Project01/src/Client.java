import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public static void main(String[] args) throws Exception, UnknownHostException, IOException
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
				Connection con = null;
				Statement stmt = null;		
				ResultSet rs = null;
				String id;
				String pwd;
				String name;
				
				try {
					con = DriverManager.getConnection(
							  "jdbc:oracle:thin:@localhost:1521:xe",
							  "scott",
							  "tiger");
					stmt = con.createStatement();
					
					System.out.println("이름을 입력하세요.");
					name = s1.next();
										
					System.out.println("아이디를 입력하세요.");			
					id = s1.next();
					
					System.out.println("비밀번호를 입력하세요.");
					pwd = s1.next();

					//-----------------------------------------------
					String sql = "select * from PERSON where id = '"+id+"'";
					//System.out.println(sql);
					//-> 여기아래를 전부 주석 풀엇다걸엇다하면서 제대로 출력되는지확인용
					//밑에 주석넣을때는 syso(sql)저기를 출력해봄.
					
					rs = stmt.executeQuery(sql);
					if(rs.next()) {
						System.out.println("중복된 아이디입니다. \n다시 입력해 주세요. \n");
					} else {
						System.out.println("가입되셨습니다. \n");
						// 인서트
						String sql2 = "insert into PERSON     " +
									  "values ('"+name+"','"+id+"', '"+pwd+"')";
						int updateCount = stmt.executeUpdate(sql2);
					}
					
					//-----------------------------------------------
					rs.close();
					stmt.close();
					con.close();
					
				} catch (SQLException sqle) {
					System.out.println("Connection Error");
					sqle.printStackTrace();
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