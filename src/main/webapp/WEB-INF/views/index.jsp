<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>모든게시물</h1>
	<table>
		<tr>
			<td>게시번호</td>
			<td>제목</td>
			<td>해시테그</td>
			<td>카테고리</td>
			
			
			
		</tr>
		<c:forEach var="list" items = "${boardList }" >
		
		<tr>
			<td>${list.board_pk }</td>
			<td>${list.title }</td>
			<td>${list.hashtag }</td>
			<td>${list.category }</td>
		</tr>
		
		</c:forEach>
	</table>
	
	<h1>일반게시물</h1>
	
	<table>
		<tr>
			<td>게시번호</td>
			<td>제목</td>
			<td>해시테그</td>
			<td>카테고리</td>
			
			
			
		</tr>
		<c:forEach var="list" items = "${nomalList }" >
		
		<tr>
			<td>${list.board_pk }</td>
			<td>${list.title }</td>
			<td>${list.hashtag }</td>
			<td>${list.category }</td>
		</tr>
		
		</c:forEach>
	</table>
	
	<h1>스터디구인 게시물</h1>
	
	<table>
		<tr>
			<td>게시번호</td>
			<td>제목</td>
			<td>해시테그</td>
			<td>카테고리</td>
			
			
			
		</tr>
		<c:forEach var="list" items = "${studyList }" >
		
		<tr>
			<td>${list.board_pk }</td>
			<td>${list.title }</td>
			<td>${list.hashtag }</td>
			<td>${list.category }</td>
		</tr>
		
		</c:forEach>
	</table>
</body>
</html>