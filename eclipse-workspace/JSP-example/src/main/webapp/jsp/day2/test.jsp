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
	<% 
		
	ArrayList<String> list = new ArrayList<String>();
	
	list.add("바나나");
	list.add("사과");
	list.add("체리");
	list.add("망고");
	
	
	for(int i = 0; i < list.size(); i++) { 
		out.println(list.get(i));
	}
	%>
</body>
</html>