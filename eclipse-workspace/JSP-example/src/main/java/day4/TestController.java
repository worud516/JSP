package day4;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day2.Article;
import day2.ArticleDao;

@WebServlet("/TestController/*")
public class TestController extends HttpServlet {
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
		
		ArticleDao dao = new ArticleDao();
		try {
			
			if(action.equals("list")) {
				ArrayList<Article> articles = dao.getArticleList();
				request.setAttribute("articles", articles);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/day4/list.jsp");
				dispatcher.forward(request, response);				
				
			}
			else if(action.equals("add")) {
				
				String title = request.getParameter("title");
				String body = request.getParameter("body");
				
				dao.insertArticle(title, body);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/day4/addForm.jsp");
				dispatcher.forward(request, response);
				
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}
}
