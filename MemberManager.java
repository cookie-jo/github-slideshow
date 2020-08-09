package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.AdminManagerDAO;
import dao.AdminManagerDAOImpl;
import dao.BookManagerDAO;
import dao.BookManagerDAOImpl;
import dao.MemberManagerDAO;
import model.AdminVO;
import model.BookVO;
import model.MemberVO;
import view.AdminManagerView;
import view.BookManagerView;
import view.MemberManagerView;

public class MemberManager {
	MemberManagerDAO dao;
	BookManagerDAO bdao = new BookManagerDAOImpl();
	AdminManagerDAO adao = new AdminManagerDAOImpl();
	AdminManager adminMan = new AdminManager(adao);
	BookManager bManager = new BookManager();

	
	public MemberManager(MemberManagerDAO dao) {
		this.dao = dao;
	}

//	public BookManager(BookManagerDAO bdao) {
//		this.bdao = bdao;
//	}

//	public AdminManager adao(AdminManagerDAO adao) {
//		this.adao = adao;
//	}

	MemberManagerView view = new MemberManagerView();
	BookManagerView bView = new BookManagerView();
	AdminManagerView aView = new AdminManagerView();

	int adminCode = 5292;
	
	Scanner sc = new Scanner(System.in);
	
	
//-------------------------------------------------------------------------	
	public void launchApplication() {
		// 스마트 도서관에 오신것을 환영합니다.
		while (true) {
			int menu1 = MemberManagerView.getMenu();
			switch (menu1) {

//------------------------------------------------------------------------------
			case 1: // 로그인

				int mOrALogin = view.mOrALogin(); // 회원 또는 관리자 로그인
				switch (mOrALogin) {
				case 1:// 회원 로그인 
					while (true) {
						MemberVO member = MemberManagerView.inputMemberLoginInfo();
						dao.m_selectMemberLogin(member);
						boolean loginCheck = dao.m_selectMemberLogin(member);
						if (loginCheck == true) {
							System.out.println();
							System.out.println("	♪ ♪ 회원 로그인 성공 ♪ ♪");
							System.out.println();
							break;
						} else {
							System.out.println();
							System.out.println("	♨회원 로그인 실패♨");
							System.out.println("	아이디와 비밀번호를 다시 입력해주세요.");
							System.out.println();
						}
					}
					// [1] 책 검색 [2] 대출현황 [3] 내 정보 [4] 로그아웃 종료
					while (true) {
						
						int memberGreet = view.inputMemberGreet();
						
						switch (memberGreet) {
						
						//[1]책검색
						case 1:
							
							List<BookVO> b_Recbooks = bdao.b_selectRecBooks();		
							System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
							System.out.println("                                                   추천 도서 목록");
							System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
							AdminManagerView.printBookList(b_Recbooks);
						
							//bManager.launchBookSelect();
							
							//[1]대여할 책선택 [2]제목으로 검색 [3]전체목록보기 [4]뒤로가기
							//while
							while(true) {
							int pickOrSearch = view.pickOrSearch();
							switch(pickOrSearch) {
							case 1://[1]대여할 책선택
								int booknumber = view.searchBook();
								int loginMemberNums2 = dao.loginMemberNumCheck();
								
								
								//대출신청
								BookVO bookInfo = adao.searchbookByNum(booknumber);
								System.out.println(bookInfo); //입력받은 번호의 책 데이터 출력
								//오류
								int rentOrAnother = view.rentOrAnother(); //[1]대출 신청 [2]다른 책 고르기
								
								switch(rentOrAnother) {
									case 1: //[1]대여할 책선택-[1]대출 신청
										dao.m_rent(loginMemberNums2,booknumber);
										System.out.println("	대출이 완료 되었습니다.");
										String pre = "";
										
										int rentAgainorMainMenu = view.rentAgainorMainMenu();
										
										switch(rentAgainorMainMenu) {
										case 1://[1]책 더 고르기
											continue; 
											
											
										case 2:
											break;
											//[2]메인 메뉴
										}
							break;//12:53 break
									case 2: //[1]대여할 책선택 -[2]다른 책 고르기
										break;
										
								}
							break;//12:53 break
							
							//[1]책검색-[2]제목으로 검색
							case 2:
								//String searchTitle = 
								
								System.out.print("	검색어 입력 : ");
								String title = aView.scanBookName();
								BookVO book1 = adao.searchbookByName(title);
							
								int loginMemberNums3 = dao.loginMemberNumCheck();
								
								BookVO bookInfo2 = adao.searchbookByName(title);
								System.out.println(bookInfo2); //입력받은 번호의 책 데이터 출력
								
								int bookInfo2num = bookInfo2.getB_num();
								int rentOrAnother2 = view.rentOrAnother(); //[1]대출 신청 [2]다른 책 고르기
								
								switch(rentOrAnother2) {
									case 1: //[1]대여할 책선택-[1]대출 신청
										dao.m_rent(loginMemberNums3,bookInfo2num);
										System.out.println("	대출이 완료 되었습니다.");
										String pre = "";
										
										int rentAgainorMainMenu = view.rentAgainorMainMenu();
										
										switch(rentAgainorMainMenu) {
										case 1://[1]책 더 고르기
											continue; //problem 4:11
											
											
										case 2:
											break;
											//[2]메인 메뉴	problem 4:11
										}
							break;//1:58break
									case 2: //[1]대여할 책선택 -[2]다른 책 고르기
										break;
										
								}
								break;
								
								
							//[1]책검색-[3]전체목록보기
							case 3:
								//adao.selectAllBook();
								List<BookVO> list2 = adao.selectAllBook();
								AdminManagerView.printBookList(list2);
								
								int booknumber3 = view.searchBook();
								int loginMemberNums4 = dao.loginMemberNumCheck();
								
								BookVO bookInfo3 = adao.searchbookByNum(booknumber3);
								System.out.println(bookInfo3); //입력받은 번호의 책 데이터 출력
								//오류
								int rentOrAnother3 = view.rentOrAnother(); //[1]대출 신청 [2]다른 책 고르기
								
								switch(rentOrAnother3) {
									case 1: //[1]대여할 책선택-[1]대출 신청
										dao.m_rent(loginMemberNums4,booknumber3);
										System.out.println("	대출이 완료 되었습니다.");
										String pre = "";
										
										int rentAgainorMainMenu = view.rentAgainorMainMenu();
										
										switch(rentAgainorMainMenu) {
										case 1://[1]책 더 고르기
											continue; 
											
											
										case 2:
											continue;
											//[2]메인 메뉴
										}
							
									case 2: //[1]대여할 책선택 -[2]다른 책 고르기
										continue;//로그인 창으로 감
										
								}
								
								
								break; //2:42
							
							
								
							//[1]책검색-[4]뒤로가기
							case 4:
								
								//continue;
								break; //4:10 break
									
							}//_switch
							break;
						//continue; 4:11
						}//_while
						continue;
							//break; 2:47
							
							//int b_num = bview.
							
						
						
						case 2://[2] 대출현황
							List<BookVO> list3 = dao.selectAllMemberBook();
							AdminManagerView.printBookList(list3);
							
							//1]반납 할 책 선택  [2]종료
							int returnOrBack = view.returnOrBack();
							
							switch(returnOrBack) {
							
							case 1://1]반납 할 책 선택 
								int returnBookNum = view.returnBookNum();
								int loginMemberNums5 = dao.loginMemberNumCheck();
								
								int addBookScore = view.addBookScore();
								String addBookReview = view.addBookReview();
								
								bdao.b_updateReview(addBookScore, addBookReview, returnBookNum);
								
								dao.m_return(loginMemberNums5,returnBookNum);
								System.out.println("	반납이 완료 되었습니다.");
								System.out.println("	리뷰를 남겨주셔서 감사합니다!");
								String pre = "";
								/////////////
								break;
							case 2://[2]종료
								System.exit(1);
							}
							
							break;
							
							
							
							
							
							
						case 3:// 내정보
								// [1] 계정수정[2]계정삭제
							int inputMemberPage = view.inputMemberPage();
							switch (inputMemberPage) {
							case 1:// [1] 계정수정
								int updateMemberPage = view.updateMemberPage();
								// [1]비밀번호 바꾸기 [2]이메일 바꾸기 [3]주소 바꾸기
								switch (updateMemberPage) {
								case 1:// [1]비밀번호 바꾸기
									String m_tel = view.updateMemberPasswordTel();
									String m_password = view.updateMemberPasswordNewPass();
									dao.m_updateMemberPassword(m_password, m_tel);
									break;
								case 2:// [2]이메일 바꾸기
									String m_password2 = view.updateMemberEmailPass();
									String m_email = view.updateMemberEmail();
									dao.m_updateMemberEmail(m_email, m_password2);
									break;
								case 3:// [3]주소 바꾸기
									String m_password3 = view.updateMemberAddrPass();
									String m_addr = view.updateMemberAddr();
									dao.m_updateMemberAddr(m_addr, m_password3);
									break;
								}
								break;
							case 2:// [2]계정삭제
									// 계정을 삭제하시겠습니까? [1]네 [2]삭제 취소
								int delete = view.deleteMember();
								switch (delete) {
								case 1:// 비밀번호를 입력하시면 계정이 삭제됩니다:
									String delPass = view.deleteMemberPass();
									dao.m_deleteMember(delPass);
									break;
								case 2://2]삭제 취소
									continue;
								}
								break;
							}
						break;
						case 4://[4] 로그아웃 종료
							System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
							System.out.println("▒▒▒▒                                        조와유 도서관을 이용해주셔서 감사합니다.                                             ▒▒▒▒");
							System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
							System.exit(1);
							break;
						}
						
						break;
					}//메인 메뉴
				break;
//-----------------------------------------------------------------------------	
				
				case 2://관리자 로그인
					while (true) {
						AdminVO member = AdminManagerView.adminLogin();
						dao.a_selectAdminLogin(member);
						boolean loginCheck = dao.a_selectAdminLogin(member);
						if (loginCheck == true) {
							System.out.println("	관리자 로그인 성공");
							
							adminMan.launchAdminMenu();
							
							break;
						} else {
							System.out.println("	관리자 로그인 실패.");
							System.out.println("	아이디와 비밀번호를 다시 입력해주세요.");
							continue;
						}
					
					}
					
				}
				
				break;
				
//------------------------------------------------------------------------------
				
			case 2: // 회원가입
				int register = view.mOrARegister(); // [1]회원 가입 [2]관리자 가입
				switch (register) {
				case 1:// [1]회원 가입
					MemberVO member2 = MemberManagerView.inputMemberInfo();
					//System.out.println(member2);
					dao.m_createMember(member2);
					break;
				case 2: //[2]관리자 가입
					while(true) {
					AdminVO admin3 =AdminManagerView.adminMemberinfo();
					int adminCodeScan = view.adminCodeScan();
					if (adminCodeScan == adminCode) {
						adao.a_createMember(admin3);
						System.out.println("	관리자 가입이 완료되었습니다.");
						break;
					}else {
						System.out.println("	관리자 코드가 틀렸습니다.");
						continue;
					}
					}
					break;
				}

				break;
			case 3: // 종료
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("▒▒▒▒                                        5조유 도서관을 이용해주셔서 감사합니다.                                             ▒▒▒▒");
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.exit(1);
				break;
//			
//			case 4: // 찾아오시는 길
////				MemberVO member = MemberManagerView.inputMemberInfo();
////				dao.m_createMember(member);
////				// member에 담긴 변수를 m_createMember이쪽으로 보내 주겠다 
//				break;
				
				}
			
			continue;
			
		} // 메인 메뉴

//		while(true) {
//			char menu2 = MemberManagerView.
//		

}

}
