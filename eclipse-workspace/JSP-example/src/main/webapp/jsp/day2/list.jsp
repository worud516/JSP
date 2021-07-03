<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="day2.ArticleDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="day2.Article" %>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	
	<%
	
		ArticleDao dao = new ArticleDao();
		ArrayList<Article> list = dao.getArticleList();
		
		for(int i = 0; i < list.size(); i++) { %>
			번호 : <%= list.get(i).getId() %>
			제목 : <%= list.get(i).getTitle() %><br>
			내용 : <%= list.get(i).getBody() %><br>
			작성일 : <%= list.get(i).getRegDate() %><br>
			작성자 : <%= list.get(i).getName() %><br>
			<hr>
	<%
		}
	%>
	
	<div></div>
	<div></div>
	<div></div>
	<div></div>
	<div></div>
	
	<% 
		// .......
	%>
	
	
	<div></div>
	<div></div>
	<div></div>
	
	<% 
		// .......
	%>

</body>
</html>