//window.onload = function(){
//					if(joinToLogin.value != null && joinToLogin.value != ''){//가입하고 로그인화면으로 이동한경우 가입됐다고 알려줌
//						alert(joinToLogin.value);
//					}
//				}

// 로그인
function loginChk() {
	var frm = document.memberLoginForm;
	var reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;

	if (!reg_email.test(frm.mem_email.value)) {
		alert("이메일형식에 맞지 않습니다.");
		return false;
	} else if (frm.mem_email.value.length == 0) {
		alert("이메일을 입력하세요.");
		frm.mem_email.focus();
		return false;
	} else if (frm.mem_password.value.length == 0) {
		alert("비밀번호를 입력하세요.")
		frm.mem_password.focus();
		return false;
	}
}