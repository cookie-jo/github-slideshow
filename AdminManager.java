package admin.controller;
import java.util.List;
import admin.dao.AdminManagerDAO;
import admin.model.AdminVO;
import admin.model.BookVO;
import admin.view.AdminManagerView;

public class AdminManager {
	AdminManagerDAO dao;

	public AdminManager(AdminManagerDAO dao) {
		this.dao = dao;
	}

//[1] 도서 관리 [2] 회원 관리 [3] 로그아웃	
//[1]전체도서현황 [2]도서정보추가 [3]도서정보수정 [4]도서 삭제 [5]종료
	
	
	//관리자 회원가입
	public void createNewAccount() {
		AdminVO vo = AdminManagerView.adminMemberinfo();
		dao.a_createMember(vo);
		System.out.println("회원가입 완료");
	}
	
	
	
	//관리자 로그인기능
	public void loginAdmin() {
		int cnt = -1;
		AdminVO login = AdminManagerView.adminLogin();
		cnt = dao.inputAdminLoginInfo(login);
		if(cnt > 0 ) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
	}
	
	
	public void launchApplication() {

		while (true) {
			int menu = AdminManagerView.adminScreen();
			switch (menu) {
			case 1: //[1]도서관리
				String pre=""; //뒤로가기 기능 변수 초기화
				while(true) {
				int menu1 = AdminManagerView.adminBook();
				
				switch (menu1) {
				
				case 1: //[1]도서관리 - [1]전체도서현황
					List<BookVO> list = dao.selectAllBook();
					AdminManagerView.printBookList(list);
					break;
					
				case 2: //[1]도서관리 - [2]도서정보추가
					BookVO ibook = AdminManagerView.inputBookInfo();
					System.out.println(ibook);// 자료가 잘 들어갔는지 출력해서 확인.
					dao.insertNewBook(ibook); // 자료를 dao에 넣어줌.
					System.out.println("도서정보가 추가되었습니다.");
					break;

				case 3: //[1]도서관리 - [3]도서정보수정
					int num = AdminManagerView.inputsearchBookByNum(); // 책번호 입력시 출력
					BookVO vo = dao.searchbookByNum(num); // 데이터를 받아서 넘김
					if (vo != null) {
						System.out.println(vo);
						BookVO ubook = AdminManagerView.updateBookInfo();
						dao.updateNewBook(ubook);
						System.out.println("도서정보가 수정되었습니다.");
					} else {
						System.out.println("검색실패");
					}
					break;

				case 4: //[1]도서관리 -[4]도서 삭제
					BookVO dbook = AdminManagerView.deleteBookInfo();
					System.out.println(dbook);
					dao.deleteNewBook(dbook);
					System.out.println("도서가 삭제되었습니다.");
					break;

				case 5: //[1]도서관리 - [5]종료
					System.out.print("프로그램이 종료되었습니다.");
					System.exit(0);
					break;
					
				case 6 : 
					pre="PRE";
					break;
					
				default://[1]도서관리 - [잘못된값입력시 메세지출력]
					System.out.println("잘못된 값입니다.");
					break;
					
					}//_switch_case
				if(pre.equals("PRE")) break; //뒤로가기 기능. 어떤원리???? => while문에서 탈출 다시 바깥 while문으로 가는 것.
				}//_while()
			
			  break;//case1번 탈출하면 다시 큰 while문에서 반복
				
			case 2 : //[2]회원관리 //미구현
				
				
				
				int menu2 = AdminManagerView.adminMember();
				switch (menu2) {
				
				case 1: //[2]회원관리 - [1]회원정보
					
					
					
					
					break;
					
					
				case 2: //[2]회원관리 - [2]종료
					
					
					
					
					break;
					
					
					
					
				default://[2]회원관리 - [잘못된값입력시 메세지출력]
					System.out.println("잘못된 값입니다.");
					break;					
				
					
				}//_switch_case
			
				
				
			case 3 : //[3]로그아웃
				AdminManagerView.adminExit();
			}//_switch_case

		}

	}
}
