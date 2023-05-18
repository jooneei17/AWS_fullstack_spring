<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>2023. 4. 27.오전 11:10:55</title>
</head>
<body>
	<h2>all</h2>
	<sec:authorize access="isAuthenticated()">
		<h3>로그인 상태</h3>
<%-- 		<h3><sec:authentication property="principal.member"/></h3> --%>
	</sec:authorize>
	<sec:authorize access="isAnonymous()">
		<h3>비 로그인 상태</h3>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<h3>관리자</h3>
	</sec:authorize>
	${principal}
	<a href="member">member</a>
	<a href="admin">admin</a>
	
</body>
</html>