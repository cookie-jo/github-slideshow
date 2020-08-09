package main;

import controller.BookManager;
import dao.BookManagerDAO;
import dao.BookManagerDAOImpl;

public class BookMain {

	public static void main(String[] args) {
	BookManagerDAO dao = new BookManagerDAOImpl();
//	ArrayList<BookVO> b_all = dao.b_selectAllBooks(); //전체 도서 목록 창
//	BookManagerView.printBookList(b_all);
//	
//	ArrayList<BookVO> b_RecBooks = dao.b_selectRecBooks();  //추천도서 고르는 창
//	BookManagerView.printBestBookList(b_RecBooks);
//	
//	ArrayList<BookVO> b_Book = dao.b_selectBook(); // 책을 고르는 출력창
//	BookManagerView.printSelectedBook(b_Book);
//	
//	ArrayList<BookVO> b_selTitle = dao.b_selectTitle(); //제목으로 검색 출력창
//	System.out.println(b_selTitle);
//	dao.b_updateReview();
	
//	BookManagerView.printRentReq();
//	BookManagerView.printInsertTitle();
	BookManager manager = new BookManager(dao);
	manager.launchBookSelect();
	
	

	
	
	}
	
	
}
