package admin.dao;
import java.util.List;

import admin.model.AdminVO;
import admin.model.BookVO;
import admin.model.MemberVO;

public interface AdminManagerDAO { //관리자 인터페이스
	public void insertNewBook(BookVO book); //책정보는 넣는 기능
	public void updateNewBook(BookVO book); //책정보 수정 기능
	public void deleteNewBook(BookVO book); //책 삭제기능
	public BookVO searchbookByNum(int num); //책 숫자입력시 보여주는 기능
	public List<BookVO>selectAllBook(); //책 목록 보여주는 기능
	
	public void a_createMember(AdminVO admin); //관리자 계정생성
	public int inputAdminLoginInfo(AdminVO admin); //관리자 로그인
	
	
}
