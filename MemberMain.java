package main;

import controller.AdminManager;
import controller.MemberManager;
import dao.AdminManagerDAO;
import dao.AdminManagerDAOImpl;
import dao.MemberManagerDAO;
import dao.MemberManagerDAOImpl;

public class MemberMain {

	public static void main(String[] args) {
		MemberManagerDAO dao = new MemberManagerDAOImpl();
		MemberManager manager = new MemberManager(dao);
		AdminManagerDAO adao = new AdminManagerDAOImpl();
		AdminManager amanager = new AdminManager(adao);
		
		manager.launchApplication();
		
		//MemberVO vo = new MemberVO(1, "¿Ø12", "1234", "¿Ø¡ˆ»∆", "jihoon@naver.com", "±§¡÷",
		//	"010-2323-2323", "April 13 1992");
		//dao.m_createMember(vo);
		//dao.m_deleteMember("010-2323-2323");
		//dao.m_updateMemberPassword("7777", "01023232323");
	}

}
//package kr.co.kosa.girls.main;
//
//import kr.co.kosa.girls.controller.GirlManager;
//import kr.co.kosa.girls.dao.GirlManagerDAO;
//import kr.co.kosa.girls.dao.GirlManagerDAOImpl;
// 
//public class GirlManagerMain {
// 
//  public static void main(String[] args) {
//    GirlManagerDAO dao = new GirlManagerDAOImpl();
//    GirlManager manager = new GirlManager(dao);
//    manager.launchApplication();
//  }
//}