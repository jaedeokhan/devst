<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link href="<c:url value="/resources/user/css/join.css" />" rel="stylesheet">
<script src="<c:url value="/resources/user/js/join.js" />"></script>
</head>
<body>
<div class="container">
	<!-- 헤더 들어갈 곳-->
	<div id="join_container">
	<h2>회원가입</h2>
	<form name="memberJoinForm" action="/devst/user/join" method="post" onsubmit="return joinChk()">
	    <font color="red">* 필수 입력 항목</font>
		<table class="join_table">
			<tr>
	            <td class="label_row"><label for="mem_email">이메일*</label></td>
	        </tr>
	        <tr>
	            <td class="small_input">
	                <input type="email" name="memEmail" id="mem_email" autofocus>
	                <input type="button" class="checkBtn" value="중복확인" onclick="emailChk()">
	            </td>
	        </tr>
	        <tr>
	            <td class="label_row"><label for="mem_password">비밀번호*</label></td>
	        </tr>
	        <tr>
	            <td class="big_input"><input type="password" name="memPassword" id="mem_password"  onkeyup="pwdCheck()"></td>
	        </tr>
	        <tr>
	            <td class="label_row"><label for="password_Chk">비밀번호 확인*</label> 
	            <small id="chkmsg"></small></td>
	        </tr>
	        <tr>
	            <td class="big_input"><input type="password" name="password_Chk" placeholder="비밀번호를 한번 더 입력해주세요." onkeyup="pwdCheck()"></td>
	        </tr>
	        <tr>
	            <td class="label_row"><label for="mem_username">이름*</label></td>
	       	</tr>
	        <tr>
	            <td class="big_input"><input type="text" name="memUsername" id="mem_username"></td>
	        </tr>
	        <tr>
	            <td class="label_row"><label for="mem_nickname">닉네임*</label></td>
	       	</tr>
	        <tr>
	            <td class="big_input"><input type="text" name="memNickname" id="mem_nickname"></td>
	        </tr>
<!-- 			<tr> -->
<!-- 			    <td class="label_row"><label for="mem_profile_image">프로필 사진*</label></td> -->
<!-- 			</tr> -->
		</table>
		<div class="btn">
			<input type="submit" value="회원가입" id="joinbtn">
		</div>
	</form>
	</div>
	 <!-- 푸터 들어갈 곳-->
</div>
</body>
</html>