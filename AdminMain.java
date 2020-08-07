package admin.main;
import admin.controller.AdminManager;
import admin.dao.AdminManagerDAO;
import admin.dao.AdminManagerDAOImpl;
import admin.model.AdminVO;
import admin.view.AdminManagerView;
public class AdminMain {

	public static void main(String[] args) {
		AdminManagerDAO dao = new AdminManagerDAOImpl(); //인터페이스 객체생성
		AdminManager manager = new AdminManager(dao);  //컨트롤러 객체생성

		
		manager.launchApplication();
		
		

	}

}
