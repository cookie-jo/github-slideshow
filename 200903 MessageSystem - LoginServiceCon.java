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

@WebServlet("/LoginServiceCon")
public class LoginServiceCon extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("EUC-KR");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO(email, pw);
		MemberDTO info = dao.login(dto);
		
		if(info != null) {
			System.out.print("로그인 성공!");
			//세션객체 생성 후 info라는 이름의 dto를 받아옴.
			HttpSession session = request.getSession();
			session.setAttribute("info", info);
			
			
		}else {
			
			System.out.println("로그인 실패!");
			
		}
		//성공실패상관없이 main으로 왔으면 좋겠음.
		response.sendRedirect("main.jsp");
	}

}
