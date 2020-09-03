package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Logout")
public class Logout extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//세션을 제거하고 메인 페이지로 돌아가면 로그아웃 기능 완성!
		
		HttpSession session = request.getSession(); //세션안에 get set remove 등등 기능이 들어가있음. 
		session.removeAttribute("info"); //info라는 키값 지우고 싶음 영역이 공유되어있어서 main에서도 찾을 수 없게됨
		
		response.sendRedirect("main.jsp");
		
	}

}
