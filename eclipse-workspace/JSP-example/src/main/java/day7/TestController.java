package day7;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day6.Article;
import day6.ArticleDao;

@WebServlet("/article7/*")
public class TestController extends HttpServlet {

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
				list(request, response);
			}
			else if(action.equals("add")) {
				add(request, response);
			}
			else if(action.equals("detail")) {
				detail(request, response);
			}
			else if(action.equals("showUpdate")) {
				// 게시물 하나 같이 가져가야 함.
				showUpdate(request, response);

			}
			else if(action.equals("update")) {
				update(request, response);
			}
			else if(action.equals("delete")) {
				delete(request, response);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		adao.deleteArticle(id);
		response.sendRedirect("/JSP/article7/list");
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String body = request.getParameter("body");

		adao.updateArticle(id, title, body);

		response.sendRedirect("/JSP/article7/detail?articleId=" + id);
	}

	private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		int articleId = Integer.parseInt(request.getParameter("id"));
		Article article = adao.getArticleById(articleId);
		request.setAttribute("article", article);
		forwarding(request, response, "updateForm");

	}

	private void detail(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		// DB 접속
		String strId = request.getParameter("articleId");
		int id = Integer.parseInt(strId);
		Article article = adao.getArticleById(id);

		request.setAttribute("article", article);
		forwarding(request, response, "detail");

	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		String title = request.getParameter("title");
		String body = request.getParameter("body");

		adao.insertArticle(title, body);
		forwarding(request, response, "addForm");	
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		ArrayList<Article> articles = adao.getArticleList();
		request.setAttribute("articles", articles);

		forwarding(request, response, "list");		
	}

	public void forwarding(HttpServletRequest request, HttpServletResponse response, String fileName) throws ServletException, IOException {
		String prefix = "/jsp/day7/";
		String suffix = ".jsp";
		String path = prefix + fileName + suffix;

		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);

	}
}
