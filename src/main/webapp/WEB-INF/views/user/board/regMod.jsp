<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.boardWrap{width:1200px;  margin:0 auto;}
	.boardBox{margin:0 auto; width:800px;}
	.boardCategory, .boardTitle, .boardHashtag{width:800px; height:30px; margin: 10px 0;}
	.boardCategory{width:810px;}
	.boardContent{width:800px; height:600px;}
	.doBtn{position:absolute; bottom:-61px;right:0;}
	.cancleBtn{position:absolute; bottom:-60px; left:0;}
	.btnBox{width:800px;position:relative;}
	#msg{color:red;}
</style>
</head>
<body>
	
	<div class="boardWrap">
		<div class="boardBox">
			<form action="/devst/board/regmod" id="frm" method="post" enctype="multipart/form-data">
			<select name="category" class="boardCategory">
			    <option value="스터디구인">스터디구인</option>
			    <option value="일반">일반게시판</option>
			    <option value="abc">lorem</option>
			    <option value="123">lorem</option>
			</select>
				<input type="text" placeholder="제목을 입력해주세요" name="title" class="boardTitle">
				<input type="text" placeholder="hashtag" name="hashtag" class="boardHashtag">
				<textarea name="content" class="boardContent"></textarea>
				<div class="btnBox">
					<input type="file" name="multiFile" class="boardImg" accept="image/*">
					<button type="submit" class="btn btn-dark doBtn">&nbsp 작성 &nbsp</button>
					<button type="button" class="btn btn-success cancleBtn" onclick="doCancle()">&nbsp 취소 &nbsp</button>
				</div>
			</form>
			
		</div>
		
	</div>
	<p id="msg">${msg }</p>
	<script>
		function doCancle(){
			if(confirm('정말 취소하시겠습니까?')){
				location.href='/devst';
			}	
		}
	
	</script>
</body>
</html>
