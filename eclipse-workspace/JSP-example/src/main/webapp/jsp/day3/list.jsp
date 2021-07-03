<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="day2.ArticleDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="day2.Article" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArticleDao dao = new ArticleDao();
	ArrayList<Article> list = dao.getArticleList();
	
	request.setAttribute("list", list);
	
%>
<c:forEach items="${list}" var="article">
	번호 : ${article.id} <br>
	제목 : ${article.title} <br>
	내용 : ${article.body} <br>
	<hr>
</c:forEach>

</body>
</html>