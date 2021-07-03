package day2;

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
		
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String strLimit = request.getParameter("limit");
		int limit = Integer.parseInt(strLimit);
	
		
		out.println("<html>");
		out.println("<heat;d>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		
		for(int dan = 1; dan <= limit; dan++) {
			for(int i = 1; i <= 9; i++) {
				out.println(dan + " * " + i + " = " + dan * i + "\n");
			}			
		}
		
		out.println("</body>");
		out.println("</head>");
	}
}

