package com.ljk.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TestServlet2")
public class TestServlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("서블릿 요청 받음"); // 서버 콘솔에 출력.

		PrintWriter out = response.getWriter();
		
		for(int i = 0; i <=9; i++) {
			out.println(i);
		}
		
		
		
	}
	
}