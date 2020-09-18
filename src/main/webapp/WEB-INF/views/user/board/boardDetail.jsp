<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/devst/user/ud" method="post">
		<div class="boardDetailTitle" ><label for="board_detail_title">제목</label><input type="text" value="${oneInfo.brd_title }" id="board_detail_title"></div>
		<div class="boardDetaiilContent"><textarea>${oneInfo.brd_content }</textarea></div>
	</form>
	
</body>
</html>