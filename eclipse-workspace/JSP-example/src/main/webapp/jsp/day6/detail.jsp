<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시물 상세보기</h1>
	
	<%@ include file="topMenu.jsp" %>
		
	<div>
		제목 : <c:out value="${ article.title }"></c:out>
	</div>
	<hr>
	<div>
		내용 <br>
		<c:out value="${ article.body }"></c:out>
	</div>
	<hr>
	<div>
		작성자 : <c:out value="${ article.memberId }"></c:out>
	</div>
	<hr>
	


</body>
</html>