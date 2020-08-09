package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AdminVO;
import model.BookVO;
import model.MemberVO;

public class AdminManagerDAOImpl implements AdminManagerDAO {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 로그인
	private Connection getConnection() {
		Connection con =null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
		String user = "scott";
		String password = "tiger";
	
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return con;
	}
	
	private void closeConnection(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (Exception e) {
				//nothing
			}
			
		}
	}

	@Override
	public void insertNewBook(BookVO book) { //책 정보를 넣는 기능 (구현)
		String sql = "insert into tbl_book (b_num, b_title, b_writer, b_category, b_company, b_score, b_review, b_inventory, b_recommend) values (?,?,?,?,?,?,?,?,?)"; 
		Connection conn = null;
		conn = getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, book.getB_num());
			ps.setString(2, book.getB_title());
			ps.setString(3, book.getB_writer());
			ps.setString(4, book.getB_category());
			ps.setString(5, book.getB_company());
			ps.setInt(6, book.getB_score());
			ps.setString(7, book.getB_review());
			ps.setString(8, book.getB_inventory());
			ps.setInt(9, book.getB_recommend());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateNewBook(BookVO book) {//책 정보 업데이트 기능(구현) book정보를 받아서
	      String sql = "update tbl_book set b_title=?, b_writer=?, b_category=?, b_company=?, b_score=?, b_review=?, b_inventory=?, b_recommend = ? where b_num=?"; 
	      
	       Connection conn = null;
	       conn = getConnection();
	       
	       try {
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ps.setString(1, book.getB_title());
	         ps.setString(2, book.getB_writer());
	         ps.setString(3, book.getB_category());
	         ps.setString(4, book.getB_company());
	         ps.setInt(5, book.getB_score());
	         ps.setString(6, book.getB_review());
	         ps.setString(7, book.getB_inventory());
	         ps.setInt(8, book.getB_recommend());
	         ps.setInt(9, book.getB_num());
	         ps.executeUpdate();
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }

	@Override
	public void deleteNewBook(BookVO book) { // 책정보를 지우는 기능 (구현)
		String sql = "delete from tbl_book where b_num = ?";
		Connection conn = null;
		conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, book.getB_num());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<BookVO> selectAllBook() { //책 전체 정보를 가져오는 기능(구현)
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒                                                 전체 도서 목록                                                                                                                  ");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		String sql = "select * from tbl_book";
		List<BookVO> book = new ArrayList<>();
		Connection conn = null;//연결
		conn = getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
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

	@Override
	public BookVO searchbookByNum(int num) { //책 번호 입력시 가져오는 기능 (구현)
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("	책 정보 출력");
		String sql = "select * from tbl_book where b_num = ?";
		BookVO vo =null;
		Connection conn = null;
		conn = getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
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
				vo = new BookVO(b_num, b_title, b_writer, b_category, b_company, b_inventory, b_rentdate, b_duedate, b_score, b_review, b_recommend, b_m_num);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	public BookVO searchbookByName(String name) { //책 번호 입력시 가져오는 기능 (구현)
		
		String sql = "select * from tbl_book where b_title = ?";
		BookVO vo =null;
		Connection conn = null;
		conn = getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
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
				vo = new BookVO(b_num, b_title, b_writer, b_category, b_company, b_inventory, b_rentdate, b_duedate, b_score, b_review, b_recommend, b_m_num);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	//관리자 회원가입 기능
	public void a_createMember(AdminVO admin) {
		String sql = "insert into tbl_admin (a_num, a_id, a_password, a_name, a_email) values (adminOrder.nextval,?, ?, ?, ?)";
		Connection conn = null;
		conn = getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, admin.getA_id());
			ps.setString(2, admin.getA_password());
			ps.setString(3, admin.getA_name());
			ps.setString(4, admin.getA_email());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	

	// 관리자 로그인 기능
	public int inputAdminLoginInfo(AdminVO admin) {
		int cnt = 0;
		String sql = "select * from tbl_admin where a_id=? and a_password=?";
		Connection conn = null;
		conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, admin.getA_id());
			ps.setString(2, admin.getA_password());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return -1; // 중복의미
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<MemberVO> selectAllMember() {
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒                                                    회원 정보 출력                                                                                                    ▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		String sql = "select * from tbl_member";
		List<MemberVO> member = new ArrayList<>();
		Connection conn = null;
		conn = getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int m_num = rs.getInt("m_num");
				String m_id = rs.getString("m_id");
				String m_password = rs.getString("m_password");
				String m_name = rs.getString("m_name");
				String m_email = rs.getString("m_email");
				String m_addr = rs.getString("m_addr");
				String m_tel = rs.getString("m_tel");
				String m_birthday = rs.getString("m_birthday");
				MemberVO vo = new MemberVO(m_num, m_id, m_password, m_name, m_email, m_addr, m_tel, m_birthday);
				member.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}
	
	public List<BookVO> selectAllMemberBook(int memNum) { //회원의 책 전체 정보를 가져오는 기능(구현)
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒                                                   회원 대출 현황                                                                                                      ▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		
		String sql = "select * from tbl_book where b_m_num=?";
		List<BookVO> book = new ArrayList<>();
		Connection conn = null;//연결
		conn = getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, memNum);
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
		

}

	



