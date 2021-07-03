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
<c:set var="num" value="10" />

<c:choose>
	<c:when test="${num % 2 == 0}">
		even
	</c:when>
	<c:otherwise>
		odd
	</c:otherwise>
</c:choose>

</body>
</html>