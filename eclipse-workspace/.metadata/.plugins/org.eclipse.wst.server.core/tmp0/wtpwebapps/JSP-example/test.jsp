<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%--   
	<%
	for(int i = 1; i <= 9; i++){ %>
		<!-- <% out.println(i); %> == <%= i %>-->
		2 X <% out.println(i); %> = <%= (2 * i) %> <br>
		
	<% 
	}
	%>
	--%>
	
	<% int age = 25; %>
	<% String name = "이재경"; %>
	
	안녕하세요 저는 <%= age %>살 <%= name %>입니다. <br>
	
	
	<% for(int i = 2; i <= 9; i++){ 
		for(int j = 1; j <= 9; j++){
			out.println(i + "*" + j + " = " + (i * j)); %> <br> <%
		}
		%> <br> <%
	} %>
	
	<% ArrayList<String> list = new ArrayList<String>(); 
		
		list.add("바나나");
		list.add("사과");
		list.add("체리");
		list.add("망고");
	
		for(int i = 0; i < list.size(); i++){
			out.println(list.get(i));
		}
	
	%>	
	
	
	
	
</body>
</html>