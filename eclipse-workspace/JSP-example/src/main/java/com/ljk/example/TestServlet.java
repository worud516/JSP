package com.ljk.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 여기 작성된 내용대로 응답을 하게 됨
		System.out.println("서블릿 요청 받음"); // 서버 콘솔에 출력.

		response.setCharacterEncoding("utf-8"); // utf-8 인코딩 세팅
		response.setContentType("text/html; charset=utf-8"); // utf-8 html문서로 응답하겠다.

		// 고색 브라우저에 출력 -> 문서 생성
		PrintWriter out = response.getWriter();
		out.println("Hello~ this is Servlet~");

		//html 그려야된다.


		// 클라이언트도 최소한의 데이터는 보내줘야한다.

		// 클라이언트에서 서버로 데이터 주고 받는 법.
		//http://localhost:9000/JSP-example/TestServlet?id=hong
		//http://localhost:9000/JSP-example/TestServlet?id=hong&pw=asdf
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");


		//String id = "hong";
		//String id = "hong2";

		String name = "";

		out.println("<h1>메인 페이지!!</h1>");

		if(id.equals("hong")) {
			name = "홍길동";
		} else if(id.equals("hong2")) {
			name = "홍길순";
		}

		out.println(name + "님!! 반갑습니다.");
		
		
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
