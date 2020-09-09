<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#msg{color:#f00}
</style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<form method="post" action="/devst/join" id="frm" onsubmit="return joinChk()">
	
		<input type="text" placeholder="id" name="id" id="id">
		<input type="password" placeholder="password(문자6자리이상, 최소 1개의 숫자 혹은 특수 문자를 포함)" name="pw" id="pw" maxlength="20">
		<input type="password" placeholder="비밀번호확인(문자6자리이상, 최소 1개의 숫자 혹은 특수 문자를 포함)" id="rePw" maxlength="20">
		<input type="text" placeholder="이름" name="name" id="name">
		<input type="text" placeholder="닉네임" name="nick" id="nick">
		<input type="submit" value="가입">
	</form>
		<p id="msg"></p>
	
	<script>
	var pwRule =/^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/; //조건1. 6~20 영문 대소문자 , 최소 1개의 숫자 혹은 특수 문자를 포함해야 함
	
	
	
		function joinChk(){
			if(eleChk(frm.id)){
				return false;
			} else if(eleChk(frm.pw)){
				return false;
			} else if(!pwRule.test(frm.pw.value)) {
				msg.innerHTML = "패스워드는 숫자, 문자포함 6~12자리로 지정해주세요"
			    return false;
			} else if(eleChk(frm.name)){
				return false;
			} else if(eleChk(frm.nick)){
				return false;
			} else if(msg.innerHTML == "비밀번호가 일치하지 않습니다."){
				alert('비밀번호를 일치시켜 주세요.')
				return false;
			}
		}
	
	
	
	
	
	
		
		function eleChk(ele){ //엘리먼트에대한 값 체크
			if(ele.value.length == 0){
				ele.focus();
				msg.innerHTML = ele.placeholder + "을(를) 입력해 주세요";
				return true;
			}
		}
		
		$("#rePw").keyup(function(){
			var $pw = $("#pw").val();
			var $rePw = $("#rePw").val();
			
			if($pw != $rePw){
				$("#msg").html("비밀번호가 일치하지 않습니다.")
				$("#pw, #rePw").css("color","red");
			} else {
				$("#msg").html('');
				$("#pw, #rePw").css("color","");
			}
		})
		
		
		$("#id, #name, #nick").click(function(){
			if($("#msg").html() == "비밀번호가 일치하지 않습니다."){
				alert('비밀번호를 일치시켜 주세요');
				$("#rePw").focus();
			}
			
		})
		
		
	
	
	</script>

</body>
</html>