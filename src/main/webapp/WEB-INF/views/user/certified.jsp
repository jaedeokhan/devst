<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.certifiedWrap{width:100%; height: 100%; position: relative; background-color: rgba(240,240,200,0.7); z-index: 999; margin-bottom: 200px;}
.certified{width: 500px; height: 200px; position: absolute; top:50%; left: 50%; transform:translate(-50%,-50%); border:1px solid #111;}
.cerCancle{cursor: pointer;}
.cerCancle i{font-size: 50px; float: right; margin:40px;}
</style>
</head>
<body>
	<div class="certifiedWrap">
		<div class="cerCancle">
			<i class="far fa-window-close"></i>
		</div>
		
		<div class="certified">
			<p>패스워드 확인후 접근가능</p>
			<input type="text"><span>패스워드 확인</span>
		</div>
	</div>
	
	<script>
	$(".cerCancle i").click(function() {
		$(".certifiedWrap").remove()
	})
	
	</script>
</body>
</html>