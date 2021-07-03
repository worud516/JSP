<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL 테스트</h1>
<!-- 변수, 값, 조건문, 반복문 -->

<!-- 변수 선언 -->
<%
	int num = 1000;
%>
<!-- 속성 (속성명="속성값") -->
<c:set var="num" value="1123123123" /> 

<!-- 변수 사용 -->
<%= num %>
<c:out value="${num}" />

<%
	int num2 = 0;
	
	if(num2 > 0) {
		out.println("양수입니다.");
	}
	else if(num2 < 0) {
		out.println("음수입니다.");
	}
	else {
		out.println("0 입니다.");
	}
	
%>
<c:set var="num2" value="0" />

<c:choose>
	<c:when test="${num2 > 0}">
		양수입니다.
	</c:when>
	<c:when test="${num2 < 0}">
		음수입니다.
	</c:when>
	<c:otherwise>
		0입니다.
	</c:otherwise>
</c:choose>

<!-- 반복문 -->
<%
	for(int i = 0; i < 5; i++) {
		out.println(i);
	}
%>

<c:forEach var="i" begin="0" end="4" step="1">
	${ i }
</c:forEach>

<!-- 배열/리스트에서 꺼내는 구조 -->
<%
	ArrayList<String> strList = new ArrayList<String>();
	strList.add("사과");
	strList.add("배");
	strList.add("바나나");
	strList.add("오렌지");
	
	for(String str : strList) {
		out.println(str);
	}

%>

<c:set var="strList" value="${fn:split('사과, 배, 바나나, 오렌지',',')}"/>

<c:forEach items="${strList}" var="str" >
	${str}
</c:forEach>


</body>
</html>