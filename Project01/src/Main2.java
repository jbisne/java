//보험용으로 일단 2 저장해놈.
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class Main2 {
//
//	static {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (ClassNotFoundException cnfe) {
//			cnfe.printStackTrace();
//		}
//	}
//	
//	public static void main(String args[])  {
//		try {
//			Connection con = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe",
//					"scott",
//					"tiger");
//			Statement stmt = con.createStatement();
//			
//			//-------------------------------------
//			StringBuffer sb = new StringBuffer();
//			sb.append("create table PERSON ( ");
//			sb.append("  NAME varchar(20),	");
//			sb.append("  ID varchar(20),	");
//			sb.append("  PASSWORD varchar(20) )");
//			
//			int updateCount =
//					stmt.executeUpdate(sb.toString());
//			System.out.println("createCount : " + updateCount);
//			
//			//--------------------------------------------
//			sb.setLength(0);
//			sb.append("insert into PERSON ");
//			sb.append("values ('aaaa', 'aaaa', 1234) ");
//			updateCount = stmt.executeUpdate(sb.toString());
//			System.out.println("insertCount : " + updateCount);
//			
//			//----------------------------------------------
//			sb.setLength(0);
//			sb.append("select * from PERSON ");
//			ResultSet rs = stmt.executeQuery(sb.toString());
//			while(rs.next()) {
//				System.out.println("NAME : " + rs.getString(1) + ", ");
//				System.out.println("ID : " + rs.getString("ID"));
//				System.out.println("PASSWORD : " + rs.getString("PASSWORD"));
//			}
//			
//			//-------------------------------------------
////			sb.setLength(0);
////			sb.append("update PERSON ");
////			sb.append("  set id='bbbb', ");
////			sb.append("      name='bbbb'      ");
////			sb.append(" where NAME='aaaa' ");
////			updateCount = stmt.executeUpdate(sb.toString());
////			System.out.println("updateCount : " + updateCount);
////			
//			//-----------------------------------------------
////			sb.setLength(0);
////			sb.append("select * from PERSON ");
////			rs = stmt.executeQuery(sb.toString());
////			while(rs.next()) {
////				System.out.println("NAME : " + rs.getString(1) + ", ");
////				System.out.println("ID : " + rs.getString("ID"));
////				System.out.println("PASSWORD : " + rs.getString("PASSWORD"));
////			}
////			
//			//---------------------------------------------
////			sb.setLength(0);
////			sb.append("delete from PERSON ");
////			updateCount = stmt.executeUpdate(sb.toString());
////			System.out.println("deleteCount : " + updateCount);
////			
////			//-----------------------------------------------
////			sb.setLength(0);
////			sb.append("drop table PERSON ");
////			updateCount = stmt.executeUpdate(sb.toString());
////			System.out.println("dropCount : " + updateCount);
////			
//			//-----------------------------------------------
//			rs.close();
//			stmt.close();
//			con.close();
//			
//		} catch (SQLException sqle) {
//			System.out.println("Connection Error");
//			sqle.printStackTrace();
//		}
//	}
//}
