package day5;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import day1.Member;
import day1.MemberDao;
import day2.Article;
import day2.ArticleDao;

@WebServlet("/article/*")
public class TestController extends HttpServlet {
	
	MemberDao mdao = new MemberDao();
	ArticleDao adao = new ArticleDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		System.out.println("공통코드 수행");
		
		// Controller 요청 -> 응답, 요청 분석.
		// url 분석
		String uri = request.getRequestURI();
		
		String[] uriBits = uri.split("/");
		
		if(uriBits.length < 4) {
			return;
		}
		
		String action = uriBits[3];
		
		
		try {
			
			if(action.equals("list")) {
				ArrayList<Article> articles = adao.getArticleList();
				request.setAttribute("articles", articles);
				
				forwarding(request, response, "list");		
				
			}
			else if(action.equals("add")) {
				
				String title = request.getParameter("title");
				String body = request.getParameter("body");
				
				adao.insertArticle(title, body);
				forwarding(request, response, "addForm");
				
			}
			else if(action.equals("login")) {
				forwarding(request, response, "login");
			}
			else if(action.equals("doLogin")) {
				
				String loginId = request.getParameter("loginId");
				String loginPw = request.getParameter("loginPw");
				
				Member target = mdao.login(loginId, loginPw);
							
				//성공 -> list
				if(target != null) {
					
					HttpSession session = request.getSession();
					session.setAttribute("loginedUser", target);
					
					// 리다이렉트
					response.sendRedirect("http://localhost:9000/JSP-example/article/list");
					
					
				}
				else {
					forwarding(request, response, "loginError");
				}
				
				
				//실패 -> 에러페이지
				
				
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public void forwarding(HttpServletRequest request, HttpServletResponse response, String fileName) throws ServletException, IOException {
		String prefix = "/jsp/day5/";
		String suffix = ".jsp";
		String path = prefix + fileName + suffix;
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
	}
}
