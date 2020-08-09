package view;

import java.util.Scanner;

import model.MemberVO;

public class MemberManagerView {

	int m_num_cnt=1;
	static Scanner scan = new Scanner(System.in);

	public static int getMenu() { 
		int menu;
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒▒▒                                        조와유 도서관에 오신것을 환영 합니다!                                               ▒▒▒▒");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		
	    System.out.println("	[1]로그인, [2]회원/관리자 가입, [3]종료");
	    System.out.print("	입력 :  ");
	    menu = scan.nextInt();
	    return menu;
		}
	
	
	public static int mOrALogin() {
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("	[1]회원 로그인 [2]관리자 로그인");
		System.out.print("	입력 :  ");
		int  login = scan.nextInt();
		return login;
	}
	
	public static int mOrARegister() {
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("	[1]회원 가입 [2]관리자 가입");
		System.out.print("	입력 :  ");
		int  login = scan.nextInt();
		return login;
	
	}
	
	public static MemberVO inputMemberLoginInfo() {
		   // inputMemberInfo()이 함수생성
		      MemberVO member = new MemberVO();
		      // MemberVO 자료형태로 member 변수생성
		      System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

		       System.out.print("	ID : ");
		       member.setM_id(scan.next());
		       System.out.print("	Password : ");
		       member.setM_password(scan.next());
		       System.out.println();
		       return member;
		       // 나온 값을 member에 담아주겠다
		     }
	
	public static MemberVO inputMemberInfo() {
		//int m_num_cnt=1;
		MemberVO member = new MemberVO();
		
		//member.setM_num(m_num_cnt);
		//m_num_cnt++;
		 System.out.print("	ID를 입력하세요 : ");
		    member.setM_id(scan.next());
		    System.out.print("	비밀번호를 입력하세요 : ");
		    member.setM_password(scan.next());
		    System.out.print("	이름을 입력하세요 : ");
		    member.setM_name(scan.next());
		    System.out.print("	이메일을 입력하세요 : ");
		    member.setM_email(scan.next());
		    System.out.print("	주소를 입력하세요 : ");
		    member.setM_addr(scan.next());
		    System.out.print("	전화번호를 입력하세요 : ");
		    member.setM_tel(scan.next());
		    System.out.print("	생년월일을 입력하세요 : ");
		    member.setM_birthday(scan.next());
	    return member;
	    
	    
	  }
	
	public static int inputMemberGreet() {
		   // 000 회원님 환영합니다.
		//[1] 책 검색  [2] 대출현황 [3] 내 정보 [4] 로그아웃 종료 
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("	");
	    System.out.println("	[1] 책 검색  [2] 대출현황 [3] 내 정보 [4] 로그아웃 종료 ");
	    System.out.print("	입력 :  ");
		    int next = scan.nextInt();
		    return next;
		     }
	
	//[3]내정보
	//[1] 계정수정[2]계정삭제
	public static int inputMemberPage() {
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
	    System.out.print("	[1] 계정수정	[2]계정삭제 ");
	    System.out.print("	입력 :  ");
		    int next = scan.nextInt();
		    return next;
		     }
	
	public static int updateMemberPage() {
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.print("	[1]비밀번호 바꾸기 [2]이메일 바꾸기 [3]주소 바꾸기");
	    System.out.print("	입력 :  ");
	    int next = scan.nextInt();
	    return next;
	     }
	public static String updateMemberPasswordTel() {
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
	    System.out.print("	회원 확인을 위한 전화번호를 입력해주세요: ");
	    String next = scan.next();
	    return next;
	     }
	public static String updateMemberPasswordNewPass() {
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
	    System.out.print("	비밀번호를 입력해주세요: ");
	    String next = scan.next();
	    return next;
	     }
	
	public static String updateMemberEmail() {
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
	    System.out.print("	새로운 이메일을 입력해주세요: ");
	    String next = scan.next();
	    return next;
	     }
	public static String updateMemberEmailPass() {
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
	    System.out.print("	이메일을 변경 승인을 위해 비밀번호를 입력해주세요: ");
	    String next = scan.next();
	    return next;
	     }
	
	public static String updateMemberAddr() {
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
	    System.out.print("	새로운 주소를 입력해주세요: ");
	    String next = scan.next();
	    return next;
	     }
	public static String updateMemberAddrPass() {
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
	    System.out.print("	주소를 바꾸고싶으면 비밀번호를 입력해주세요: ");
	    String next = scan.next();
	    return next;
	     }
	
	public static int deleteMember() {
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
	    System.out.println("	계정을 삭제하시겠습니까? ");
	    System.out.println("	[1]네	[2]삭제 취소");
	    System.out.print("	입력 :  ");
	    int next = scan.nextInt();
	    return next;
	     }

	public static String deleteMemberPass() {
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
	    System.out.println("	비밀번호를 입력하시면 !!계정이 삭제!! 됩니다. ");
	    System.out.print("	비밀번호 입력 : ");
	    String next = scan.next();
	    return next;
	     }
	
	public static int searchBook() {
		 System.out.print("	책 번호 : ");
	    int next = scan.nextInt();
	    return next;
	     }
	
	public static int rentBook() {
		System.out.println("	[1]대출 신청	 [2]다른 책 고르기 ");
		System.out.print("	입력 : ");
		int next = scan.nextInt();
	    return next;
	     }
	
	public static int pickOrSearch() {
		System.out.println("	[1]대여할 책선택  [2]제목으로 검색  [3]전체목록보기  [4]뒤로가기  ");
	    System.out.print("	입력 : ");
	    int next = scan.nextInt();
	    return next;
	     }
	
	public static int rentOrAnother() {
		System.out.println("	[1]대출 신청	[2]다른 책 고르기");
		 System.out.print("	입력 : ");
	    int next = scan.nextInt();
	    return next;
	     }
	public static int rentAgainorMainMenu() {
		System.out.println("	[1]책 더 고르기	[2]메인 메뉴");
		 System.out.print("	입력 : ");
	    int next = scan.nextInt();
	    return next;
	     }
	
	public static int adminCodeScan() {
		System.out.println("	관리자 코드를 입력하세요 : ");
	    int next = scan.nextInt();
	    return next;
	     }
	public static int returnOrBack() {
	    System.out.print("[1]반납 할 책 선택  [2]종료");
	    int next = scan.nextInt();
	    return next;
	     }
	public static int returnBookNum() {
	    System.out.print("반납할 책 번호를 입려하세요: ");
	    int next = scan.nextInt();
	    return next;
	     }
	
	public static int addBookScore() {
	    System.out.print("평점을 남겨주세요(1~5): ");
	    int next = scan.nextInt();
	    return next;
	     }
	public static String addBookReview() {
	    System.out.print("한줄평을 남겨주세요: ");
	    String next = scan.next();
	    return next;
	     }
	
	
}
