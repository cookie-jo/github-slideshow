package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//메세지 테이블에 insert할 method 만드려고 이거 만듦
public class MessageDAO {
	
	Connection conn = null;
	PreparedStatement psmt = null;
	int cnt = 0;
	ResultSet rs = null;
	MessageDTO info = null;
	ArrayList<MessageDTO> list = null; //list = null 값으로 초기화
	
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

	 public int insert(MessageDTO dto) {
		 
		 try {
			 conn();
			 String sql = "insert into message values(num.nextval, ?, ?, ?, sysdate)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getSend());
			psmt.setString(2, dto.getReceive());
			psmt.setString(3, dto.getMessage());
			
			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 return cnt;
	 }
	 
	 //Resultset rs에 값이 있으니까 그걸로 반환해도 되지 않느냐 라는 질문에 대한 답. 되는데 안된다.
	 //Resultset 은 close로 닫아버리니까 쓰려면 열어야되는 모순이 생김. 결론은 안됨.
		public ArrayList<MessageDTO> select(String receive) {
			
			list = new ArrayList<MessageDTO>(); //위에서는 객체생성을 안해줬으니 쓰려면 객체생성해줘야함
			
			try {
				conn();
				
				String sql = "select * from message where receive = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, receive);
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					int num = rs.getInt(1);
					String send = rs.getString(2);
					String receive_email = rs.getString(3);
					String message = rs.getString(4);
					String date = rs.getString(5);
					
					info = new MessageDTO(num, send, receive_email, message, date);
					list.add(info);
				}

				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			
			return list;
		}


		public int deleteAll(String receive) {
			
			try {
				conn();
				String sql = "delete from message where receive = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, receive); //DB에서 값 변동이 있나 없나를 생각하면쉬움 update
				cnt=psmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return cnt;
		}
		
		public int deleteOne(String receive ,String num) {
			
			try {
				conn();
				String sql = "delete from message where receive = ? and num = ?"; //넘버값을 받아서 삭제하면 중복없이 삭제 가능
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, receive);//DB에서 값 변동이 있나 없나를 생각하면쉬움 update
				psmt.setString(2, num);
				cnt=psmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return cnt;
		}
}
