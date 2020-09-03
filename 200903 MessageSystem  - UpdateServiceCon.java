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

@WebServlet("/UpdateServiceCon")
public class UpdateServiceCon extends HttpServlet {


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDTO info = (MemberDTO)session.getAttribute("info"); //이메일은 세션으로 받음
		
		request.setCharacterEncoding("EUC-KR"); //post 방식 한글 인코딩
		String email = info.getEmail(); //이메일은 세션으로 받아옴. 수정할때 pw tel addr 바꾸는데 받아오는 이메일에있는걸 바꾸는 거니까.
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr"); //값을 받아와서 업데이트 시켜준다.DB연동 필요
		
		MemberDAO dao = new MemberDAO(); //이미 만들어 둔 클래스가 있어서 가져다 사용. (재활용)
		MemberDTO dto = new MemberDTO(email, pw, tel, addr);
		int cnt = dao.update(dto); //update된 값을 cnt로 받아와서 
		
		if(cnt > 0) { // 업데이트 되면 0보다 큰 양수가 나오기때문에 업데이트가 되었다면 출력.
			System.out.print("업데이트 성공!");
			//업데이트가 성공했을 때 세션을 다시만들어주면 바로 최신화가 됨.
			
			session.setAttribute("info", dto); //변수명에 집착하지말고 기준을 잘 잡기.
		}else {
			System.out.print("업데이트 실패!"); //안되면 실패
		}
		
		//업데이트가 되었든 되지 않았든  main 창으로 돌아감.
		response.sendRedirect("main.jsp");
	}

}
