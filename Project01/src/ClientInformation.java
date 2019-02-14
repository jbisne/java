import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 유저 1.가입 2.로그인 3.삭제(탈퇴) 4.종료 되도록 만들기

class UserInfo
{
	String name;
	String id;
	String pwd;
	
	public UserInfo(String name, String id, String pwd)
	{
		this.name = name;
		this.id = id;
		this.pwd = pwd;
	}
	
	public void showUserInfo()
	{
		System.out.println("name : "+name);
		System.out.println("id : "+id);
		System.out.println("pwd : "+pwd);
		
		System.out.println(); //데이터 구분을 위해
	}
}

class UserManager
{
	public UserManager(String id, String pwd)
	{
	
	}
	
	public UserManager()
	{
		
	}
	
	UserInfo[] infoStorage = new UserInfo[0]; //☆뒤 유저인포에 0넣는거 맞는지 모르겟는데 일단 넣엇다!
	int curCnt = 0;
	
	public void inputData() // 회원가입
	{
		
		System.out.println("회원 가입을 시작합니다");
		
		System.out.println("이름 : ");
		String name = MenuViewer.sc.nextLine();
		
		System.out.println("사용할 ID : ");
		String id = MenuViewer.sc.nextLine();
		
		System.out.println("비밀번호 : ");
		String pwd = MenuViewer.sc.nextLine();
		
		try {
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
			
		} catch(SQLException sqle){
			System.out.println("Connection Error");
			sqle.printStackTrace();
		}
			
		System.out.println("회원가입이 완료되었습니다!");
		System.out.println("");
		
	}

	public void LogIn()
	{
		String id;
		String pwd;
	
		Scanner sc = new Scanner(System.in);
		System.out.println("로그인을 시작합니다.");
		System.out.println("");
		System.out.println("ID : ");
		id = sc.next();
		System.out.println("비밀번호 : ");
		pwd = sc.next();
		
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
			String sql = "select * from PERSON where ID = "+"'" +id+ "'";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			String UserID = rs.getString(1);
			String password = rs.getString(2);
			
			if(rs.next()) 
			{			
				if(UserID.equals(id) && password.equals(pwd)) {
					System.out.println("로그인 되었습니다");
					break;
				}
				else {
					System.out.println("비밀번호가 틀렸습니다.");
					System.out.println("다시 입력해주세요.");
					continue;
				}				
			}
			if(UserID.equals("") ) {
				System.out.println("아이디가 없습니다.");
				System.out.println("다시 입력해주세요.");
				continue;
			}
			
			rs.close();
			pstmt.close();
			con.close();
			break;
		
		}catch (Exception e) {
			e.printStackTrace();
			continue;
		} // if 로그인
	} //while 문
	
class MenuViewer
{
	public Scanner sc = new Scanner(System.in);
	
	public static void showMenu()
	{
		System.out.println("선택하세요.");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4.프로그램 종료");
		System.out.println("선택 :");
	}
}

public class ClientInformation 
{	
	public static void main(String[] args)
	{
		
		UserManager manager = new UserManager();
		int choice;
		
		while (true)
		{
			MenuViewer.showMenu();
			choice = MenuViewer.sc.nextInt();
			MenuViewer.sc.nextLine();
			
			switch (choice)
			{
			case 1:
				manager.inputData();
				break;
			case 2:
				manager.LogIn();
				break;
//			case 3:
//				manager.deleteData();
//				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				return;				
				
				
			}
		}
	}
}


