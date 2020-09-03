package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	
	Connection conn = null;
	PreparedStatement psmt = null;
	int cnt = 0;
	ResultSet rs = null;
	MemberDTO info = null;
	ArrayList<MemberDTO> list = null; //list = null 값으로 초기화
	
	 public void conn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "hr";
			String db_pw = "hr";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
	 
	 
	 public void close() {
		 
		try {
			if(rs != null) {
				rs.close();
			}
			if(psmt != null) {
				psmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	 }
	 public int join(MemberDTO dto){
		conn();
		try {
			String sql = "insert into member values(?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getEmail());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getTel());
			psmt.setString(4, dto.getAddr());
			
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;

	 }


	public MemberDTO login(MemberDTO dto) {
		conn();
		
		try {
			String sql = "select * from member where email = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getEmail());
			psmt.setString(2, dto.getPw());
			
			rs = psmt.executeQuery(); //돌려받을 게 있음
			
			if(rs.next()) {
				String email = rs.getString(1);
				String pw = rs.getString(2); //생성자를 더 안만들기 위해서 함
				String tel = rs.getString(3);
				String addr = rs.getString(4);
				
				info = new MemberDTO(email, pw, tel, addr);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return info;
	}
	
	
	public int update(MemberDTO dto) {
		conn();
		try {
			String sql = "update member set pw = ?, tel = ?, addr = ? where email = ?"; 
			psmt =conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getPw());
			psmt.setString(2, dto.getTel());
			psmt.setString(3, dto.getAddr());
			psmt.setString(4, dto.getEmail());
			
			cnt = psmt.executeUpdate(); //update가 되면 0에서 양수로 바뀜 그래서 int cnt를 사용
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	
	public ArrayList<MemberDTO> select() {
		conn();
		
		try {
			String sql = "select * from member";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			//값을 몇번 가져와야하는지 모르니까 while
			
			list = new ArrayList<MemberDTO>(); //ArrayList 객체 생성
			
			while(rs.next()) {
				
				String email = rs.getString(1);
				String pw = rs.getString(2);
				String tel = rs.getString(3);
				String addr = rs.getString(4);
				
				//정보를 엄청 많이 가져오는건 MemberDTO 캡슐화도 소용없음. => MemberDTO를 담을 수 있는 ArrayList 필요
				info = new MemberDTO(email, pw, tel, addr);
				list.add(info);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return	list;
	
	}
	
}
