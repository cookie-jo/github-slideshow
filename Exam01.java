package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Exam01")
public class Exam01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String ip = request.getRemoteHost();//요청: 내 웹페이지에 들어오는 사용자의 IP주소를 얻어오겠다.
		System.out.println(ip);
		
		
	}
	
}

//220.93.165.169 이 pc IP를 붙이면 ip가 찍힘.