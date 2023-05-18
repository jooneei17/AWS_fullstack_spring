<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>2023. 4. 27.오전 11:10:55</title>
</head>
<body>
	<h2>member</h2>
	<a href="admin">admin</a>
	<a href="all">all</a>
	<br>
	${_csrf}
	<form action="logout" method="post">
<%-- 		<input type="hidden" name="_csrf" value="${_csrf.token}"> --%>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<button>로그아웃</button>
	</form>
</body>
</html>