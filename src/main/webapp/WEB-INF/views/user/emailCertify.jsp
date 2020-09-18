<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 인증</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="<c:url value="/resources/user/js/emailCertify.js" />"></script>
</head>
<body>
<div class="container">
	<div id="certify_container">
		<h2>이메일 인증</h2>
		<form name="emailCertifyForm" method="post">
			<div class="certifyBox">
				<table>
					<tr>
						<td>
							<input type="email" name="memEmail" placeholder="이메일" id="mem_email" onkeyup="emailChk()" autofocus> 
						</td>
						<td>
							<input type="button" value="인증번호받기" onclick="emailSend()"> 
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<small id="chk_msg"></small>
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" name="certificationNum" id="certification_num" placeholder="인증번호"> 
						</td>
						<td>
							<input type="button" value="인증하기" onclick="emailCertify()">
							<input type="hidden" id="certification_YN" value="false"> 
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</div>
</body>
</html>