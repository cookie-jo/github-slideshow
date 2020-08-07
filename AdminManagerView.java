package admin.view;
import java.util.List;
import java.util.Scanner;

import admin.model.AdminVO;
import admin.model.BookVO;
public class AdminManagerView {
	  static Scanner scan = new Scanner(System.in);
	   
	  
	  public static int adminScreen() {
	    int menu;
	    //관리자 메인화면
	    System.out.println("[1]도서 관리 [2]회원 관리 [3]로그아웃");
	    System.out.print("번호입력 : ");
	    menu = scan.nextInt();
	    return menu;
	  }
	  
	  //관리자 메뉴 - [1]도서관리
	  public static int adminBook() {
		  int menu;
		    System.out.println("[1]전체도서현황 [2]도서 정보 추가 [3]도서 정보수정 [4]도서 삭제 [5]종료 [6]뒤로가기");
		    System.out.print("번호입력 : ");
		    menu = scan.nextInt();
		  return menu;
	  }	  
	  
	  //[1]전체도서현황
	  public static void printBookInfo(BookVO book) {
		  System.out.println(book);
	  }	  
	  
	  public static void printBookList(List<BookVO> list) {
		    for(BookVO vo : list) {
		      System.out.println(vo);
		    }
		  }
	  
	  //[2]도서 정보 추가
	  public static BookVO inputBookInfo() {
		    BookVO book = new BookVO();
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

	  //[3]도서정보 수정 // 수정할 번호 입력 - 수정내용 기입. 
	  	public static int inputsearchBookByNum() {
			System.out.println("=====도서정보수정=====");
			Scanner scan = new Scanner(System.in);
			System.out.print("번호 : ");
			int num = scan.nextInt();
			// 번호에 해당하는 도서정보(VO)를 가지고오는 부분
			
			return num;
	  	}
	  	
	  	//[3-1]도서정보 수정 -값입력 book으로 리턴
		public static BookVO updateBookInfo() {
		    BookVO book = new BookVO();
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
	  
	  	//[4]도서정보 삭제
		public static BookVO deleteBookInfo() {
			BookVO book = new BookVO();
			System.out.println("삭제할 도서번호 입력");
			book.setB_num(scan.nextInt());
		return book;
		}
		
		
	  //관리자 메뉴 - [2]회원관리
	  public static int adminMember() {
		  int menu;
		    System.out.println("[1]회원 정보 조회 [2]종료 "); //안내
		    System.out.print("번호입력 : ");
		    menu = scan.nextInt();
		  return menu;
	  }
	  
	  
	  //관리자메뉴 - [3]종료
	  public static void adminExit() {
		  int menu;
		  System.out.println("로그아웃되었습니다.");
		  System.exit(0);
	  }
	    
	  //관리자 가입, 로그인 기능.
	  
	  //관리자 회원가입 - 
	  public static AdminVO adminMemberinfo() {
		    AdminVO admin = new AdminVO(); //관리자 객체생성
		    System.out.print("아이디 입력 : ");
		    admin.setA_id(scan.next());
		    System.out.print("비밀번호 입력: ");
		    admin.setA_password(scan.next());
		    System.out.print("이름 입력 : ");
		    admin.setA_name(scan.next());
		    System.out.print("이메일 입력 : ");
		    admin.setA_email(scan.next());
		    return admin;
		}	  
		  
		  
	  //관리자 로그인 뷰
	  public static AdminVO adminLogin() {
		  AdminVO vo = new AdminVO();
		  System.out.println("id >> ");
		  vo.setA_id(scan.next());
		  System.out.println("Password >> ");
		  vo.setA_password(scan.next());
		return vo;
	  }


}
