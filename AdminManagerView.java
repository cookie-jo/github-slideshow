package admin.view;
import java.util.List;
import java.util.Scanner;

import admin.model.BookVO;

public class AdminManagerView {
	  static Scanner scan = new Scanner(System.in);
	   
	  public static int adminScreen() {
	    int menu;
	    //관리자 메인화면
	    System.out.print("[1] 도서 관리 [2] 회원 관리 [3] 로그아웃"); //안내
	    System.out.print("번호입력 : ");
	    menu = scan.nextInt();
	    //메뉴 입력받기
	    return menu;
	  }
	  
	  //관리자 메뉴 - 도서관리
	  public static int adminBook() {
		  int menu;
		    System.out.println("[1]전체도서현황 [2]도서 정보 추가 [3]도서 정보수정 [4] 도서 삭제"); //안내
		    System.out.print("번호입력 : ");
		    menu = scan.nextInt();
		  return menu;
	  }	  
	  
	  public static BookVO inputBookInfo() {
		    BookVO book = new BookVO();
		    //스캐너로 책 정보 입력받아
		    //책객체에 저장하는 코드
		    System.out.print("책번호 : ");
		    book.setB_num(scan.nextInt());
		    System.out.print("책 제목 : ");
		    book.setB_title(scan.next());
		    System.out.print("작가 : ");
		    book.setB_writer(scan.next());
		    System.out.print("책 카테고리 : ");
		    book.setB_category(scan.next());
		    System.out.print("출판사 : ");
		    book.setB_company(scan.next());
		    System.out.print("평점 : ");
		    book.setB_score(scan.nextInt());
		    System.out.print("한 줄 평 : ");
		    book.setB_review(scan.next());
		    System.out.print("재고 현황 : ");
		    book.setB_inventory(scan.next());
		    return book;
		  }
	  

	  
	  //관리자 메뉴 - 회원관리
	  public static char adminMember() {
		  char menu;
		    System.out.println("[1]전체도서현황 [2]도서 정보 추가 [3]도서 정보수정 [4] 도서 삭제"); //안내
		    System.out.print("번호입력 : ");
		    menu = scan.nextLine().charAt(0);
		  return menu;
	  }
	  
	  
	  //책 정보를 출력하는 메서드
	  public static void printBookInfo(BookVO book) {
		  System.out.println(book);
	  }
	  
	 
}
