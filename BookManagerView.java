package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.BookManagerDAO;
import dao.BookManagerDAOImpl;
import model.BookVO;

public class BookManagerView {
	static Scanner scan = new Scanner(System.in);
	static BookManagerDAO dao = new BookManagerDAOImpl();

	// 책 선택시 초기화면
	public static int printBestBookList() {
		// 추천 도서 목록 출력
//		ArrayList<BookVO> b_Recbooks = new ArrayList<BookVO>(bdao.b_selectRecBooks());		
//		System.out.println("======추천 도서 목록=====");
//		System.out.println(b_Recbooks + "\n");
		System.out.print("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.print("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println();
		System.out.println("[1] 추천도서 선택" + "\t" + "[2] 제목으로 검색" + "\t" + "[3] 전체 목록 보기" + "\t" + "[4] 뒤로 가기");
		System.out.print("입력 :  ");
		int num = scan.nextInt();
		return num;
	}
	
	

	// 책 번호 선택
	public static int printSelectBook() {
		// [1] 대여할 책 선택해서 나온 출력 창 - 선택한 도서 출력		
		int num = scan.nextInt();
		return num;
	}
	// 선택한 책 1권 출력 후 선택
	public static int printSelectedBook() {  		
		ArrayList<BookVO> book = new ArrayList<BookVO>(dao.b_selectedBook());
		System.out.print("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.print("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println();
		System.out.println(book); // 책 1권 출력 
		System.out.println();
		System.out.println("[1] 대출 신청" + "\t" + "[2] 다른 책 고르기");
		int num = scan.nextInt();
		return num;
	}
	
	public static int printBookList() {
		// 전체 도서 목록 출력
		ArrayList<BookVO> book = new ArrayList<BookVO>(dao.b_selectAllBooks());
		for (BookVO vo : book) {
			System.out.println(vo);
		}
		System.out.println();
		System.out.println("[1] 대여할 책 선택" + "\t" + "[2] 추천 도서 목록 보기");
		int num = scan.nextInt();
		return num;
	}	
	
	// 대출 완료 
//	public static int printRentReq() {		
//		System.out.println();
//		System.out.println("\t" + "도서 대출이 완료되었습니다.");
//		System.out.println();
//		System.out.println("[1] 책 더 고르기" + "\t" + "[2] 돌아가기");
//		int menuRentselec = scan.nextInt();
//		return menuRentselec;
//	}
	

	public static String printSearchTitle() { // 제목으로 검색
		System.out.print("검색할 제목 입력:  ");
		String book = scan.next();		
		return book;
	}
//	public static int resultSearch() {
//		System.out.println("[1] 대출 신청" + "\t" + "[2] 다른 책 고르기");
//		int num = scan.nextInt();
//		return num;
//	}
	

	
}
