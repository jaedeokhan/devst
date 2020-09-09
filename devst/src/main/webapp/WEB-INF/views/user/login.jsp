<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
</head>
<body>
123
	<input type="hidden" value="${joinSuccesMsg }" id="joinToLogin">
	
	
	
	<script>
		window.onload = function(){
			if(joinToLogin.value != null && joinToLogin.value != ''){//가입하고 로그인화면으로 이동한경우 가입됐다고 알려줌
				alert(joinToLogin.value);
			}
		}
		
	
	</script>
</body>
</html>