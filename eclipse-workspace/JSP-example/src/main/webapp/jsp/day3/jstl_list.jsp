<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
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