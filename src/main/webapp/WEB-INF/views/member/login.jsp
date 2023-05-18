<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>2023. 4. 27.오후 12:18:51</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/login" >
		<input type="text" name="username" value="admin90">
		<input type="password" name="password" value="pw90">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<label><input type="checkbox" name="remember-me"></label>
		<button>로그인</button>
	</form>
	<p>${error}</p>
</body>
</html>