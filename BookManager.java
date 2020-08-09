package controller;

import java.util.ArrayList;
import java.util.Scanner;

import dao.AdminManagerDAO;
import dao.AdminManagerDAOImpl;
import dao.BookManagerDAO;
import dao.MemberManagerDAO;
import dao.MemberManagerDAOImpl;
import model.BookVO;
import view.BookManagerView;
import view.MemberManagerView;

public class BookManager {
	BookManagerDAO bdao;
	Scanner scan = new Scanner(System.in);
	
	public BookManager(BookManagerDAO dao) {
		this.bdao = dao;		
	}
	
	
	
	public BookManager() {
		super();
	
	}



	MemberManagerDAO dao = new MemberManagerDAOImpl();
	AdminManagerDAO adao = new AdminManagerDAOImpl();
	AdminManager adminMan = new AdminManager(adao);
	MemberManagerView view = new MemberManagerView();
	
	
	public void launchBookSelect() {		 
selectBook :while (true) {			
			int num = BookManagerView.printBestBookList(); // 추천도서 출력하고 메뉴 선택 후 num 리턴

//			[1] 추천도서 선택 [2] 제목으로 검색 [3] 전체 목록 보기 [4] 뒤로 가기
//			switch (num) {
////			[1]추천 도서 선택 
//			case 1: 				
//				int num1 = MemberManagerView.rentOrAnother(); // 1권 출력 				  
//					if (num1 == 1) { // [1] 대출 신청
//						
//						// 대출 신청 기능 자리 
//						
//						int booknumber = view.searchBook();
//						int loginMemberNums2 = dao.loginMemberNumCheck();
//						
//						BookVO bookInfo = adao.searchbookByNum(booknumber);
//						//System.out.println(bookInfo); //입력받은 번호의 책 데이터 출력
//						
//						dao.m_rent(loginMemberNums2,booknumber);
//						System.out.println("대출이 완료 되었습니다.");
//						String pre = "";
//						//System.out.println("도서 신청 완료");
//						continue selectBook;
//					}else if (num1 == 2) { //[2] 다른 책 고르기
//						continue selectBook;
//					}else { // 다른 번호 입력시 
//						System.out.println("추천 도서 목록으로 돌아갑니다.");
//						System.out.println();
//						continue selectBook;
//					}
//				
//			//제목으로 검색
//			case 2:		
//				System.out.print("검색어 입력 >> ");
//				String title = scan.next();				
//				ArrayList<BookVO> b_selTitle = bdao.b_selectTitle(title);
//				System.out.println(b_selTitle);
//				
//				int num2 =BookManagerView.printSelectedBook();
//				if (num2 == 1) { // 책 번호 선택
//					// 대출 신청 기능 자리 
//					System.out.println("도서 신청 완료");
//					break;
//				}else if (num2 == 2) {
//					break;
//				}
//				
//				break;
//			//전체 목록으로 보기
//			case 3: 
//				int num3 = BookManagerView.printBookList();
//				if (num3 == 1) { //[1] 대여할 책 선택
//					BookManagerView.printSelectedBook(); // 책 1권 출력 
//					
//					// 대출 신청 기능 자리 
//					
//					System.out.println("도서 신청 완료");
//					continue selectBook;
//				}else if (num3 == 2 ) { //[2] 추천 도서 목록으로 이동 
//					
//					continue selectBook;
//				}else {
//					System.out.println("추천 도서 목록으로 이동합니다. ");
//					continue selectBook;
//				}
//				
//			// 뒤로 가기 (상단 회원 로그인 후 화면 ) 
//			case 4: 
//				
//				//메인메뉴로
//				continue selectBook; // 회원 선택창에 라벨 걸어주세요 . 
//
//			default:
//				System.out.println();
//				System.out.println("번호를 다시 입력해주세요.");
//				System.out.println();
//				break;
			}
		}
	}

