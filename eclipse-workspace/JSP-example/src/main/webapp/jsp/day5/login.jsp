<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="/JSP-example/article/doLogin">
		<div>
			아이디 : <input type="text" name="loginId" />
		</div>
		<div>
			비밀번호 : <input type="password" name="loginPw" />
		</div>
		<div>
			<input type="submit" value="로그인" />
		</div>
	</form>
</body>
</html>
