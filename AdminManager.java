package admin.controller;
import java.util.List;
import admin.dao.AdminManagerDAO;
import admin.model.BookVO;
import admin.view.AdminManagerView;

public class AdminManager {
	AdminManagerDAO dao;
	public AdminManager(AdminManagerDAO dao) {
		this.dao = dao;
	}

//[1]전체도서현황 [2]도서정보추가 [3]도서정보수정 [4]도서 삭제
public void launchApplication() {
	while(true) {
		int menu = AdminManagerView.adminBook();
		switch(menu) {
		case 2 : //도서정보추가
			BookVO book = AdminManagerView.inputBookInfo();
			System.out.println(book);
			dao.insertNewBook(book);
		break;
		
		
			
			}
		}
	}
}
