package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BookVO;
import view.BookManagerView;

public class BookManagerDAOImpl implements BookManagerDAO {
	 
	static{
		    try {
		      Class.forName("oracle.jdbc.driver.OracleDriver");
		    } catch (Exception  e) {
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
	    }catch(SQLException e) {
	      throw new RuntimeException(e.getMessage());
	    }
	    return con;
	  }
	  
	  private void closeConnection(Connection con) {
	    if(con!=null) {
	      try{
	        con.close();
	      }catch(Exception e){
	        //nothing
	      }
	    }
	  }
	  
	  @Override // 
	  public ArrayList<BookVO> b_selectRecBooks() { //추천도서목록
		  Connection con = getConnection();
		  ArrayList<BookVO> b_RecBooks = new ArrayList<BookVO>();
		  String sql = "select * from tbl_book where b_recommend = 1";
		  try {
			  PreparedStatement ps = con.prepareStatement(sql);
			  ResultSet rs = ps.executeQuery();
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
				  BookVO vo = new BookVO(b_num, b_title, b_writer, b_category, b_company, 
						  b_inventory, b_rentdate, b_duedate,b_score, b_review, b_recommend,  b_m_num);
				  b_RecBooks.add(vo);				
			  }
		  } catch (Exception e) {
			  e.printStackTrace();
		  }finally {
			closeConnection(con);
		}		
		  return b_RecBooks;
	  }

	@Override
	public ArrayList<BookVO> b_selectAllBooks() {
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒                                                   전체 도서 목록                                                                                                     ▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println();
		String sql = "select * from tbl_book";
		ArrayList<BookVO> b_all = new ArrayList<BookVO>();
		Connection con = getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int b_num = rs.getInt("b_num");
				String b_title = rs.getString("b_title");
				String b_writer = rs.getString("b_writer");
				String b_category = rs.getString("b_category");
				String b_company = rs.getString("b_company");
				String b_inventory = rs.getString("b_inventory");
				int b_score = rs.getInt("b_score");
				String b_review = rs.getString("b_review");
				BookVO vo =  new BookVO(b_num, b_title, b_writer, b_category, b_company, b_inventory, b_score, b_review);
				b_all.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return b_all;
	}

	@Override // 
	public ArrayList<BookVO> b_selectedBook() { 
		System.out.print("	책 번호 선택:  ");
		//책번호
		int num = BookManagerView.printSelectBook();
		
		ArrayList<BookVO> b_Book = new ArrayList<BookVO>();
		Connection con = getConnection();
		String sql = "select b_num, b_title, b_writer, b_category, b_company, b_inventory, b_score, b_review from tbl_book where b_num=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
			int b_num = rs.getInt("b_num");
			String b_title = rs.getString("b_title");
			String b_writer = rs.getString("b_writer");
			String b_category = rs.getString("b_category");
			String b_company = rs.getString("b_company");
			String b_inventory = rs.getString("b_inventory");
			int b_score = rs.getInt("b_score");
			String b_review = rs.getString("b_review");
			
			BookVO vo = new BookVO(b_num, b_title, b_writer, b_category, b_company, b_inventory, b_score, b_review);
			b_Book.add(vo);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return b_Book;
	}

	@Override	//
	public ArrayList<BookVO> b_selectTitle(String title) {			
		ArrayList<BookVO> b_selTitle = new ArrayList<BookVO>();
		Connection con = getConnection();
		String sql = "select b_num, b_title, b_writer, b_category, b_company,  b_score, b_review, b_inventory from tbl_book where b_title like %?%";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, title); 
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			int b_num = rs.getInt("b_num");
			String b_title = rs.getString("b_title");
			String b_writer = rs.getString("b_writer");
			String b_company = rs.getString("b_company");
			String b_category = rs.getString("b_category");
			int b_score = rs.getInt("b_score");
			String b_review = rs.getString("b_review");
			String b_inventory = rs.getString("b_inventory");
			
			BookVO vo = new BookVO(b_num, b_title, b_writer, b_category, b_company, b_inventory, b_score, b_review);
			b_selTitle.add(vo);	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return b_selTitle;
	}


	@Override
	public void b_updateReview(int b_score, String b_review, int b_num) {
		Connection conn = null;
		conn = getConnection();
		String sql = "update tbl_book set b_score = ?, b_review = ? where b_num=?";
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, b_score);
			ps.setString(2, b_review);
			ps.setInt(3, b_num);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
