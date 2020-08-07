package admin.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import admin.model.AdminVO;
import admin.model.BookVO;
import admin.model.MemberVO;

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
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
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
		System.out.println("추가할 책 정보 입력 : ");
		String sql = "insert into tbl_book (b_num, b_title, b_writer, b_category, b_company, b_score, b_review, b_inventory) values (?,?,?,?,?,?,?,?)"; 
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
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateNewBook(BookVO book) {//책 정보 업데이트 기능(구현) book정보를 받아서
	      System.out.println("updateBookInfo");
	      String sql = "update tbl_book set b_title=?, b_writer=?, b_category=?, b_company=?, b_score=?, b_review=?, b_inventory=? where b_num=?"; 
	      
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
	         ps.setInt(8, book.getB_num());
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
		System.out.println("책 정보 출력");
		String sql = "select * from tbl_book";
		List<BookVO> book = new ArrayList<>();
		Connection conn = null;
		conn = getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int b_num = rs.getInt("b_num");
				String b_title = rs.getString("b_title");
				String b_writer = rs.getString("b_writer");
				String b_category = rs.getString("b_category");
				String b_company = rs.getString("b_company");
				int b_score = rs.getInt("b_score");
				String b_review = rs.getString("b_review");
				String b_inventory = rs.getString("b_inventory");
				String b_date = rs.getString("b_date");
				BookVO vo = new BookVO(b_num, b_title, b_writer, b_category, b_company, b_score, b_review, b_inventory, b_date);
				book.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return book;
	}

	@Override
	public BookVO searchbookByNum(int num) { //책 번호 입력시 가져오는 기능 (구현)
		System.out.println("책 정보 출력");
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
				int b_score = rs.getInt("b_score");
				String b_review = rs.getString("b_review");
				String b_inventory = rs.getString("b_inventory");
				String b_date = rs.getString("b_date");
				vo = new BookVO(b_num, b_title, b_writer, b_category, b_company, b_score, b_review, b_inventory, b_date);
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

	   
	
		
}

	



