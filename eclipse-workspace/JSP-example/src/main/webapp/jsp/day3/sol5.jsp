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

<% 

	int height = Integer.parseInt(request.getParameter("height"));
	
	// 저장소가 왜 4개???
	pageContext.setAttribute("height", 1);
	request.setAttribute("height", 2);
	session.setAttribute("height", 3);
	application.setAttribute("height", 4);

%>

<c:out value="${ height }"/>

<c:forEach var="line" begin="1" end="${height}">
	<c:forEach var="star" begin="1" end="${line}">
	    *
	</c:forEach>
	<br>
</c:forEach> 

</body>
</html>