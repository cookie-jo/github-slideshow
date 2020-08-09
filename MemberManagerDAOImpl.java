package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.AdminVO;
import model.BookVO;
import model.MemberVO;

public class MemberManagerDAOImpl implements MemberManagerDAO {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() {
		Connection con = null;

		String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
		String user = "scott";
		String password = "tiger";

		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return con;
	}

	private void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				// nothing
			}
		}
	}
	
//	public MemberVO setLoginMemberVO() {
//		
//	}
	
	//로그인된 사람의 개체
	MemberVO loginMember = new MemberVO();
	
	int loginMemberNumCheck=0;
	
	public boolean m_selectMemberLogin(MemberVO member) {
		boolean check = false;
		while (check == false) {
			String DBm_id = "";
			String DBm_password = "";
			int DBm_num = 0;
			//System.out.println("로그인 함수 실행");
			String sql = "select * from tbl_member where m_id=?and m_password=?";
			Connection conn = null;
			conn = getConnection();

			String id = member.getM_id();
			String password = member.getM_password();

			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, member.getM_id());
				ps.setString(2, member.getM_password());
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					DBm_num = rs.getInt("m_num");
					DBm_id = rs.getString("m_id");
					DBm_password = rs.getString("m_password");
					
				}

				loginMemberNumCheck= DBm_num;
				if (id.equals(DBm_id) && password.contentEquals(DBm_password)) {
					//System.out.println("login good");
					check = true;
					
//					while (rs.next()) {
//					loginMemberNum= rs.getInt("m_num");
//					}
//					loginMember.setM_id(rs.getString("m_id"));
//					loginMember.setM_password(rs.getString("m_password"));
//					loginMember.setM_name(rs.getString("m_name"));
//					loginMember.setM_email(rs.getString("m_email"));
//					loginMember.setM_addr(rs.getString("m_addr"));
//					loginMember.setM_tel(rs.getString("m_tel"));
//					loginMember.setM_birthday(rs.getString("m_birthday"));
					
					break;
				} else {
					//System.out.println("login bad");
					check = false;
					break;
				}
				//continue;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return check;
	}
	
	/////////////////관리자 로그인 함수
	int loginAdminNumCheck = 0;
	
	public boolean a_selectAdminLogin(AdminVO member) {
		boolean check2 = false;
		while (check2 == false) {
			String DBm_id = "";
			String DBm_password = "";
			int DBm_num = 0;
			//System.out.println("로그인 함수 실행");
			String sql = "select * from tbl_admin where a_id=?and a_password=?";
			Connection conn = null;
			conn = getConnection();

			String id = member.getA_id();
			String password = member.getA_password();

			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, member.getA_id());
				ps.setString(2, member.getA_password());
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					DBm_num = rs.getInt("a_num");
					DBm_id = rs.getString("a_id");
					DBm_password = rs.getString("a_password");
					
				}

				loginAdminNumCheck= DBm_num;
				if (id.equals(DBm_id) && password.contentEquals(DBm_password)) {
					//System.out.println("login good");
					check2 = true;
					
//					while (rs.next()) {
//					loginMemberNum= rs.getInt("m_num");
//					}
//					loginMember.setM_id(rs.getString("m_id"));
//					loginMember.setM_password(rs.getString("m_password"));
//					loginMember.setM_name(rs.getString("m_name"));
//					loginMember.setM_email(rs.getString("m_email"));
//					loginMember.setM_addr(rs.getString("m_addr"));
//					loginMember.setM_tel(rs.getString("m_tel"));
//					loginMember.setM_birthday(rs.getString("m_birthday"));
					
					break;
				} else {
					//System.out.println("login bad");
					check2 = false;
					break;
				}
				//continue;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return check2;
	}
	
	public int loginUser() {
		int vo = loginMember.getM_num();
		return vo;
	}
	
	public int loginMemberNumCheck() {
		int x = loginMemberNumCheck;
		return x;
	}
	
		
	

//	@Override
	public void m_createMember(MemberVO member) {
		// 회원 가입
		System.out.println("──────────");
        System.out.println("§회원가입 완료§");
        System.out.println("──────────");
		//System.out.println("회원가입 완료.");
		String sql = "insert into tbl_member (m_num,m_id,m_password,m_name,m_email,m_addr,m_tel,m_birthday) values (memberOrder.nextval,?,?,?,?,?,?,?)";
		Connection conn = null;
		conn = getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
		
			ps.setString(1, member.getM_id());
			ps.setString(2, member.getM_password());
			ps.setString(3, member.getM_name());
			ps.setString(4, member.getM_email());
			ps.setString(5, member.getM_addr());
			ps.setString(6, member.getM_tel());
			ps.setString(7, member.getM_birthday());
			
			
			
			
			//			ps.setInt(1, member.getM_num());
//			ps.setString(2, member.getM_id());
//			ps.setString(3, member.getM_password());
//			ps.setString(4, member.getM_name());
//			ps.setString(5, member.getM_email());
//			ps.setString(6, member.getM_addr());
//			ps.setString(7, member.getM_tel());
//			ps.setString(8, member.getM_birthday());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	@Override
	public void m_updateMemberPassword(String m_password, String m_tel) {
		// 계정 수정
		System.out.println("	수정확인");
		String sql = "update tbl_member set m_password=? where m_tel=?";
		Connection conn = null;
		conn = getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, m_password);
			ps.setString(2, m_tel);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void m_updateMemberEmail(String m_email, String m_password) {
		// 계정 수정
		System.out.println("	수정확인");
		String sql = "update tbl_member set m_email=? where m_password=?";
		Connection conn = null;
		conn = getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, m_email);
			ps.setString(2, m_password);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void m_updateMemberAddr(String m_addr, String m_password) {
		// 계정 수정
		System.out.println("	수정확인");
		String sql = "update tbl_member set m_addr=? where m_password=?";
		Connection conn = null;
		conn = getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, m_addr);
			ps.setString(2, m_password);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Override
	public void m_deleteMember(String m_password) {
		System.out.println("	회원님 계정이 삭제되었습니다.");
		String sql = "delete from tbl_member where m_password=?";
		Connection conn = null;
		conn = getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, m_password);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	@Override
//	public void m_search(BookVO book) {
//		// 추천도서 목록 나오고 
//			
//	}

//	@Override
	public void m_rent(int b_m_num, int b_num) {
		//int memberNum = member.getM_num();
		
		System.out.println("	대여확인");
		String sql="update tbl_book set b_m_num=?, b_rentdate=sysdate, b_duedate=sysdate+7 where b_num=?";
		Connection conn = null;
		conn = getConnection();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, b_m_num);
			ps.setInt(2, b_num);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

//	@Override
	public void m_return(int b_m_num, int b_num) {
		System.out.println("	반납확인");
		String sql="update tbl_book set b_m_num=? where b_num=?";
		Connection conn = null;
		conn = getConnection();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.setInt(2, b_num);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public List<BookVO> selectAllMemberBook() { //회원의 책 전체 정보를 가져오는 기능(구현)
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("													회원님 대출 현황");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		String sql = "select * from tbl_book where b_m_num=?";
		List<BookVO> book = new ArrayList<>();
		Connection conn = null;//연결
		conn = getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, loginMemberNumCheck);
			ResultSet rs = ps.executeQuery(); //결과집합 출력
			while(rs.next()) {
				int b_num = rs.getInt("b_num");
				String b_title = rs.getString("b_title");
				String b_writer = rs.getString("b_writer");
				String b_category = rs.getString("b_category");
				String b_company = rs.getString("b_company");
				String b_inventory = rs.getString("b_inventory");
				String b_rentdate = rs.getString("b_rentdate");
				String b_duedate = rs.getString("b_duedate");
				int b_score = rs.getInt("b_score");
				String b_review = rs.getString("b_review");
				int b_recommend = rs.getInt("b_recommend");
				int b_m_num = rs.getInt("b_m_num");				
				
				BookVO vo = new BookVO(b_num, b_title, b_writer, b_category, b_company, b_inventory, b_rentdate, b_duedate, b_score, b_review, b_recommend, b_m_num);
				book.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}

//	@Override
//	public void m_extendDate(BookVO book) {
//		System.out.println("연장확인");
//		String sql="update tbl_book set m_num=? where b_num=?";
//		Connection conn = null;
//		conn = getConnection();
//		PreparedStatement ps;
//		try {
//			ps=conn.prepareStatement(sql);
//			ps.setString(1, m_num);
//			ps.setString(2, b_num);
//			ps.executeUpdate();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//
//	}

}
