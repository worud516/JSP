<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- for나 사용자 정의 태그 만들어주는 태그 외부 라이브러리  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<!-- 변수 선언 -->

<%
	int num = 100;
%>

<!-- 앞에 접두어는 프리픽스값 따라감 -->
<!-- 속성(속성명 = "속성값") -->
<c:set var="num" value="100"></c:set>

<!-- 변수 사용 -->
<% out.println(num);%> <br>
<%= num %> <br>
<c:out value="100"></c:out> <br>
<c:out value="${num}"></c:out> <br>


<%
	int num2 = 10;
	if(num > 0){
		out.println("양수입니다.");		
	}
	else if(num2 < 0){
		out.println("음수입니다.");
	}
	else{
		out.println("0입니다.");
	}
%>
<br>

<c:set var="num2" value="10"></c:set>
<!-- 단독 if문 -->
<c:if test="${num2 > 0}">
	양수입니다.
</c:if>
<br>
<!-- 연속 if문 -->
<c:choose>
	<c:when test="${num2 > 0}">
		양수입니다.<br>
	</c:when>
	<c:when test="${num2 < 0}">
		음수입니다.<br>
	</c:when>
	<c:otherwise>
		0입니다.<br>
	</c:otherwise>
</c:choose>



<!-- 반복문 -->
<%
	for(int i = 0; i < 5; i++){
		out.println(i);
	}
%>
<br>

<c:forEach var="i" begin="0" end="4" step="1">
	${ i }
</c:forEach>
<br>

<!-- 배열/리스트에서 꺼내는 구조 -->

<%
	ArrayList<String> strList = new ArrayList<String>();
	strList.add("사과");
	strList.add("배");
	strList.add("바나나");
	strList.add("오렌지");
	
	for(String str : strList){
		out.println(str);
	}
%>
<br>

<c:set var="strList" value="${fn:split('사과, 배, 바나나, 오렌지 ',',')}"/>
<c:forEach items="${strList}" var="str">
	${str}
</c:forEach>

<br>
<br>

<hr>
<h1> 연습 문제 jstl로 작성할것 </h1>

<!-- 연습 jstl로 작성 -->
<!-- 홀짝 판별 -->
<c:set var="num3" value="100"></c:set>
<c:choose>
	<c:when test="${num3 % 2 == 0}">
		양수입니다. <br>
	</c:when>
	<c:otherwise>
		음수입니다. <br>
	</c:otherwise>
</c:choose>



<!-- 할인 대상인지 아닌지 출력 -->
<c:set var="age" value="61"></c:set>
<c:choose>
	<c:when test="${ age <= 19 }">
		할인 대상입니다. <br>
	</c:when>
	<c:when test="${ age >= 60 }">
		할인 대상입니다. <br>
	</c:when>
	<c:otherwise>
		할인 대상이 아닙니다.<br>
	</c:otherwise>
</c:choose>


<!-- 1~100까지 짝수만 출력 -->
<c:forEach var="i" begin="1" end="100" step="1">
	<c:if test="${ i % 2 == 0 }">
		${ i }
	</c:if>
</c:forEach>

<br>
<br>

<!-- 응용 구구단 -->
<!-- 구구단은 n단 ~ m단 중 홀수단만 1 ~ limit 까지 곱 중 짝수곱만 출력해주세요. -->
<c:set var="n" value="4"></c:set>
<c:set var="m" value="19"></c:set>
<c:set var="limit" value="11"></c:set>

<c:forEach var="i" begin="${n}" end="${m}" step="1">
	<c:if test="${ i % 2 == 1 }">
		<c:forEach var="j" begin="1" end="${limit}" step="1">
			<c:if test="${ j % 2 == 0 }">
				${i} * ${j} = ${ i*j } <br>
			</c:if>
		</c:forEach>
		<br>	
	</c:if>
</c:forEach>


<!-- 삼각형 만들기 -->
<c:set var="height" value="3"></c:set>
<c:forEach var="line" begin="1" end="${height}">
	<c:forEach var="star" begin="1" end="${line}">
		*	
	</c:forEach>
	<br>
</c:forEach>




</body>
</html>