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
<h1> 게시물 목록 </h1>
<a href="http://127.0.0.1:9000/JSP-example/jsp/day4/addForm.jsp">글쓰기</a><br>
<!-- 출력부 -->
<c:forEach items="${articles}" var="article">
	번호 : ${article.id} <br>
	제목 : ${article.title} <br>
	내용 : ${article.body} <br>
	<hr>
</c:forEach>

</body>
</html>