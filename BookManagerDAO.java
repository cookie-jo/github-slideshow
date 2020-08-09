package dao;

import java.util.ArrayList;

import model.BookVO;

public interface BookManagerDAO {
	public ArrayList<BookVO> b_selectRecBooks(); // 추천 도서 목록
	public ArrayList<BookVO> b_selectedBook();	// 1권 출력
	//public void launchBookSelect();
	public ArrayList<BookVO> b_selectAllBooks(); // 전체 책 목록 출력
	public ArrayList<BookVO> b_selectTitle(String title);	// 제목으로 검색
	public void b_updateReview(int b_score, String b_review, int b_num); //북 객체로 스캐너해서 받아와야 함.  // 한줄평 업데이트

}
