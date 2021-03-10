package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.MemberVO;

public class DBClass {

	private String url = "jdbc:oracle:thin:@210.108.48.214:1521:xe";
	private String id = "six";
	private String pwd = "six1234";
	
	public void DBClass() {
		 try {
			 //오라클 관련된 기능을 사용하기 위해서는 제일 먼저 처리해줘야한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
}
	public void insertMember(MemberVO m) { //1.가입기능
		
	}
	
	public void getMember() { //2.로그인기능
		
	}
	
	public int deleteMember(String id) { //3.탈퇴 기능
		String sql = "delete from MEMBER where id =?";
		
		int result =0;
		Connection con;
		try {
			con = DriverManager.getConnection(url,this.id,pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int insertBoard(BoardVO b) { //4.글쓰기 기능
		int result = 0;
		
		return result;
				
	}
	
	public int modifyBoard(BoardVO b) { //5.글 수정 기능
		String sql ="UPDATE BOARD SET title =?, writer =?, content =? where num =?";
		int result = 0;
		Connection con;
		try {
			con = DriverManager.getConnection(url,id,pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(4,b.getNum());
			ps.setString(1,b.getTitle());
			ps.setString(2,b.getWriter());
			ps.setString(3,b.getContent());
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteBoard(int num) { //6.글 삭제 기능
		int result =0;
		return result;
	}
}
