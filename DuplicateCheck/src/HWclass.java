import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HWclass 
{
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;		
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(
					  "jdbc:oracle:thin:@localhost:1521:xe",
					  "scott",
					  "tiger");
			stmt = con.createStatement();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("아이디를 입력하세요.");			
			String sID = sc.next();
			
			System.out.println("비밀번호를 입력하세요.");
			String sPWD = sc.next();

			//-----------------------------------------------
			String sql = "select * from PERSON where id = '"+sID+"'";
			//System.out.println(sql);
			//-> 여기아래를 전부 주석 풀엇다걸엇다하면서 제대로 출력되는지확인용
			//밑에 주석넣을때는 syso(sql)저기를 출력해봄.
			
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				System.out.println("중복된 아이디입니다. \n다시 입력해 주세요.");
			} else {
				System.out.println("신규 가입 가능");
				// 인서트
				String sql2 = "insert into test3     " +
							  "values ('"+sID+"', '"+sPWD+"')";
				int uadateCount = stmt.executeUpdate(sql2);
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
}
