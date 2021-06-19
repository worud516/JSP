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
		// ���� �ۼ��� ������ ������ �ϰ� ��
		System.out.println("������ ��û ����"); // ���� �ֿܼ� ���.
		
		response.setCharacterEncoding("utf-8"); // utf-8 ���ڵ� ����
		response.setContentType("text/html; charset=utf-8"); // utf-8 html������ �����ϰڴ�.
		
		// ���� �������� ��� -> ���� ����
		PrintWriter out = response.getWriter();
		out.println("Hello~ this is Servlet~");
		
		//html �׷��ߵȴ�.
		
		
		// Ŭ���̾�Ʈ�� �ּ����� �����ʹ� ��������Ѵ�.
		
		// Ŭ���̾�Ʈ���� ������ ������ �ְ� �޴� ��.
		//http://localhost:9000/JSP-example/TestServlet?id=hong
		//http://localhost:9000/JSP-example/TestServlet?id=hong&pw=asdf
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		//String id = "hong";
		//String id = "hong2";
		
		String name = "";
		
		out.println("<h1>���� ������!!</h1>");
		
		if(id.equals("hong")) {
			name = "ȫ�浿";
		} else if(id.equals("hong2")) {
			name = "ȫ���";
		}
		
		out.println(name + "��!! �ݰ����ϴ�.");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}