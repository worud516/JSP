<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.ljk.example.Dao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ljk.example.Article" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		Dao dao = new Dao();
		ArrayList<Article> list = dao.getArticleList();
		
		
		for(int i = 0; i < list.size(); i++) { %> 
			번호 : <%= list.get(i).getId() %>  <br>
			제목 : <%= list.get(i).getTitle() %> <br>
			내용 : <%= list.get(i).getRegDate() %> <br>
			작성일 : <%= list.get(i).getBody() %> <br>
			작성자 : <%= list.get(i).getName() %> <br>
			<hr>
		<% } %>
	
	
	
</body>
</html>