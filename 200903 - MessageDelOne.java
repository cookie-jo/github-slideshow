package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDTO;
import com.model.MessageDAO;
import com.model.MessageDTO;

@WebServlet("/MessageDelOne")
public class MessageDelOne extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String num = request.getParameter("num"); //삭제하고 싶은 메세지의 숫자 값을 받아오고
		
		HttpSession session = request.getSession();
		MemberDTO info = (MemberDTO)session.getAttribute("info"); //로그인된 이메일 값 받아오고
		MessageDAO dao = new MessageDAO();
		int cnt = dao.deleteOne(info.getEmail(), num); //매개변수에 두개를 받아서 delete 조건이 두개가 충족되면  삭제
		
		if(cnt > 0) {
			System.out.println("선택삭제 완료!");
		}else {
			System.out.println("선택삭제 실패!");
		}
		
		response.sendRedirect("main.jsp#contact");
	}


}
