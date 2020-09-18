<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
<link href="<c:url value="/resources/user/css/login.css" />" rel="stylesheet">
<script src="<c:url value="/resources/user/js/login.js" />"></script>
</head>
<body>
<div class="container">
	<!-- 헤더  -->
	<div id="login_container">
		<h2>로그인</h2>
		<input type="hidden" value="${joinSuccessMsg }" id="joinToLogin">

		<form name="memberLoginForm" action="/devst/user/login" method="post" onsubmit="return loginChk()">
			<div class="loginBox">
				<input type="email" name="memEmail" id="mem_email" placeholder="이메일" autofocus> 
				<input type="password" name="memPassword" placeholder="비밀번호"> 
				<input type="submit" value="로그인">
			</div>
		</form>
	</div>
	<!-- 푸터  -->
</div>
</body>
</html>