package dao;
import java.util.List;

import model.BookVO;
import model.MemberVO;
import model.AdminVO;

public interface AdminManagerDAO { //관리자 인터페이스
	public void insertNewBook(BookVO book); //책정보는 넣는 기능
	public void updateNewBook(BookVO book); //책정보 수정 기능
	public void deleteNewBook(BookVO book); //책 삭제기능
	public BookVO searchbookByNum(int num); //책 숫자입력시 보여주는 기능
	public BookVO searchbookByName(String name);
	public List<BookVO>selectAllBook(); //책 목록 보여주는 기능
	//public void launchAdminMenu();
	
	public void a_createMember(AdminVO admin); //관리자 계정생성
	public int inputAdminLoginInfo(AdminVO admin); //관리자 로그인
	
	public List<MemberVO>selectAllMember(); //회원정보조회
	
	public List<BookVO> selectAllMemberBook(int memNum);
	
}

//
//번호 /    제목      / 작가   / 카테고리 / 출판사    / 대출현황    / 반납기한 
//3 / 놀림의 미학 / 조명성 /  제왕학 / 명성출판사 /  대출중 / 2020.08.13
//87 / 수면의 정석 / 조은비 / 최면술 /명성출판사 / 대출중 / 2020.08.13

//책이 반납 되었습니다. 
//[1] 평점 입력  [2] 돌아가기