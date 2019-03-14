import java.io.*;
import java.net.Socket;
import java.sql.*;

public class AdminMenu {
	private static DBConnector oracleDBConnector = DBConnector.getInstance();
	ResultSet rs;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	
	Socket socket;
	PrintWriter out;
	BufferedReader in;
	
	public AdminMenu(Socket socket, BufferedReader in, PrintWriter out) {
		this.socket = socket;
		this.out = out;
		this.in = in;
	}
	
	public void showClientInfo()
	{
		int colIndex = 0;
		try {
			rs = selectAll();
			
			out.println(" ─────────────────────   회원 정보  ───────────────────────  ");
			while(rs.next())
			{
				if(rs.findColumn("ID") == 1) {
					colIndex++;
					out.printf(" ▶  %d. [%s] \n       ID Black(%s) | IP Black(%s) | IP_%s | 경고 누적 %d회", 
							colIndex, rs.getString(1), rs.getString(3),rs.getString(4), rs.getString(5).substring(1), rs.getInt(6));
					out.println();
				}
			}
			out.println(" ──────────────────────────────────────────────────────────  ");
		} catch (Exception e) { out.println(" ▶ 회원 목록 불러오기 실패 "); return; }
	}
	
	public void showBannedWords()
	{
		String sql = "select * from BADWORDS";
		try {
			con = oracleDBConnector.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int i = 1;
			out.println(" ─────────────────────  금칙어 목록 ───────────────────────  ");
			while(rs.next()) {	
				out.println(" ▶ " + i + ": " + rs.getString(1));	
				i++;				
			}
		} catch (Exception e) { this.out.println(" ▶ 금칙어 목록 불러오기 실패 "); return; }
	}
	
	public void addBannedWords(String word)
	{
		String sql = "insert into BADWORDS VALUES('" + word + "')";
		int updateCount = 0;
		try {
			con = oracleDBConnector.getConnection();
			stmt = con.createStatement();
			updateCount = stmt.executeUpdate(sql);
			if(updateCount > 0)
				out.println(" ▶ [" + word + "] 를 금칙어로 추가하였습니다.");
			else
				out.println(" ▶ 금칙어 추가 실패");
			
		} catch (Exception e) { out.println(" ▶ 금칙어 추가 중 오류 발생"); }
	}
	
	public void addIDBlackList(String userID)
	{
		String sql = "update CLIENT set IDBLACK = O where ID ='" + userID + "'";
		int updateCount = 0;
		try {
			con = oracleDBConnector.getConnection();
			stmt = con.createStatement();
			updateCount = stmt.executeUpdate(sql);
			if(updateCount > 0)
				out.println(" ▶ [" + userID + "] 님을 블랙리스트 ID에 추가하였습니다.");
			else
				out.println(" ▶ 블랙리스트 ID 추가 실패");
			
		} catch (Exception e) { out.println(" ▶ 블랙리스트 ID 추가 중 오류 발생"); }
	}
		
	public void addIPBlackList(String userID)
	{
		String sql = "update CLIENT set IPBLACK = O, IDBLACK = O where ID ='" + userID + "'";
		int updateCount = 0;
		try {
			con = oracleDBConnector.getConnection();
			stmt = con.createStatement();
			updateCount = stmt.executeUpdate(sql);
			if(updateCount > 0)
				out.println(" ▶ [" + userID + "] 님을 블랙리스트 IP에 추가하였습니다.");
			else
				out.println(" ▶ 블랙리스트 IP 추가 실패");
			
		} catch (Exception e) { out.println(" ▶ 블랙리스트 IP 추가 중 오류 발생"); }
	}
	
	public ResultSet selectAll()
	{
		String sql = "select * from CLIENT";
		con = oracleDBConnector.getConnection();
		rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (Exception e) { out.println(" ▶ 데이터베이스 조회 중 오류 발생"); return rs;}		
		return rs;
	}
}
