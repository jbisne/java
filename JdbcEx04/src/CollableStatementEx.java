import java.sql.*;

public class CollableStatementEx {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
			
			System.out.println("------ 프로시저 호출 전 salary 테이블 -----");
			String sql = "select name, pay from salary";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("name : " + rs.getString(1));
				System.out.println(", pay : " + rs.getInt(2));
			}
			System.out.println("-----------------------------------------");
			
			cstmt = con.prepareCall("{call adjust(?, ?)}");
			System.out.println("test1");
			rs = pstmt.executeQuery();
			System.out.println("test2");
			while(rs.next()) {
				cstmt.setString(1, rs.getString("name"));
				cstmt.setFloat(2,  (float)0.05);
				cstmt.executeUpdate();
			}
			
			System.out.println("------ 프로시저 호출 후 salary 테이블 ------");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.print("name : " + rs.getString(1));
				System.out.println(", pay : "+ rs.getInt(2));
			}
			System.out.println("--------------------------------------------");
			
		}catch (SQLException sqle) {
			sqle.printStackTrace();
		}finally {
			
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (cstmt != null) cstmt.close();
				if (con != null) con.close();
			} catch (SQLException sqle) {}
			
					
		}
	}

}
