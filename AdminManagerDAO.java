package admin.dao;
import java.util.List;
import admin.model.BookVO;

public interface AdminManagerDAO { //관리자 인터페이스
	public void insertNewBook(BookVO book); //책정보는 넣는 기능
	public void updateNewBook(BookVO book); //책정보 수정 기능
	public void deleteNewBook(BookVO book); //책 삭제기능
	public List<BookVO>selectAllBook(); //책 목록 보여주는 기능
	
	
}
