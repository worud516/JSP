package day1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day2.ArticleDao;


@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	
	MemberDao dao = new MemberDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello world"); // �ý����� �ֿܼ� ���
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");		
		
		// Ŭ���̾�Ʈ �������� ���.
		PrintWriter out = response.getWriter();
		out.println("<h1 style=\"color:red\">안녕하세요</h1>");
		
		String loginId = request.getParameter("loginId");  
		String loginPw = request.getParameter("loginPw"); 
		
		Member member;
		
		try {
			
			member = dao.login(loginId, loginPw);
			if(member == null) {
				out.print("�߸��� ȸ�������Դϴ�.");			
			}
			else {
				out.println(member.getName() +" �� �ȳ��ϼ���!");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
