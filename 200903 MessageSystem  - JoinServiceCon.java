package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;
import com.model.MemberDTO;

@WebServlet("/JoinServiceCon")
public class JoinServiceCon extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//값 받아와서 콘솔창에 띄어보세요.
		
		request.setCharacterEncoding("EUC-KR");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO(email, pw, tel, addr);
		int cnt = dao.join(dto);
		
		if(cnt > 0) {
			System.out.println("회원가입 성공!");
			HttpSession session = request.getSession();
			session.setAttribute("email", email); //키값 밸류값
			response.sendRedirect("join_success.jsp");
			
		}else {
			System.out.println("회원가입 실패!");
			response.sendRedirect("main.jsp");
		}
	}

}
