package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jo")//url mapping  default는 파일이름과 똑같음. 다른프로젝트라도 매핑 같은게 있으면 오류남.
public class Exam02 extends HttpServlet { //객체 상속
	private static final long serialVersionUID = 1L;
							//객체 생성 request, response
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//out을 통해 출력할 수 있게됨.  System.out.print는 우리가 보려고 만든 것이고, 이제는 웹을 통해 표현해야하니까. 출력스트림 획득해서 out.print로 출력하는 것임.
		//한글 입력시 한글이 깨지는데, encoding을 시켜줘야함. 그리고 순서가 출력스트림 위에 해줘야 출력.
		response.setCharacterEncoding("EUC-KR");
		PrintWriter out = response.getWriter();
		
		//servlet파일은 궁극적으로 웹콘텐츠 파일으로 이동해서 실행된다고 지금은 알고있으면 됨.
		
		String ip = request.getRemoteHost();//요청: 내 웹페이지에 들어오는 사용자의 IP주소를 얻어오겠다.
		
		if(ip.equals("221.156.60.80")) {
			out.print("<html>");
			out.print("<body>");
			out.print("<img src = 'bare.jpg'>");
			out.print("안녕하세요! 베어그릴스입니다.");
			out.print("</body>");
			out.print("</html>");
		}else if(ip.equals("211.227.114.39")) {
			out.print("<html>");
			out.print("<body>");
			out.print("<img src = 'bare.jpg'>");
			out.print("안녕하세요! 베어그릴스입니다.");
			out.print("</body>");
			out.print("</html>");
		}else {
			out.print("<html>");
			out.print("<body>");
			out.print("<img src = 'bare.jpg'>");
			out.print("안녕하세요! 베어그릴스입니다.");
			out.print("</body>");
			out.print("</html>");
		}
		
		
		
	}

}
