// 회원가입 유효성 검사
function joinChk() {
	var frm = document.memberJoinForm;
	var pwRule = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,16}$/; //조건1. 6~20 영문 대소문자 , 최소 1개의 숫자 혹은 특수 문자를 포함해야 함

	if (frm.mem_email.value.length == 0) {
		alert("이메일을 입력하세요.");
		frm.mem_email.focus();
		return false;
	} else if (frm.mem_password.value.length == 0) {
		alert("비밀번호를 입력하세요.")
		frm.mem_password.focus();
		return false;
	} else if (!pwRule.test(frm.mem_password.value)) {
		alert("패스워드는 숫자, 문자포함 6~16자리로 지정해주세요");
		return false;
	} else if (frm.mem_username.value.length == 0) {
		alert("이름을 입력하세요.")
		frm.mem_username.focus();
		return false;
	} else if (frm.mem_nickname.value.length == 0) {
		alert("닉네임을 입력하세요.")
		frm.mem_nickname.focus();
		return false;
	}
}

// 비밀번호 to 비밀번호확인 일치여부
function pwdCheck() {
	var frm = document.memberJoinForm;
	var msg = document.getElementById("chkmsg");

	if (frm.mem_password.value != frm.password_Chk.value) {
		msg.innerHTML = "비밀번호가 일치하지 않습니다.";
		msg.style.color = "red";
	} else {
		msg.innerHTML = "비밀번호가 일치합니다.";
		msg.style.color = "blue";
	}
}

//닉네임 중복확인
function nickNameChk() {
	var frm = document.memberJoinForm;

	$.ajax({
		url : "/devst/user/nickNameChk",
		type : "post",
		dataType : "json",
		data : {
			"memNickName" : frm.mem_nickname.value
		},
		success : function(data) {
			if (data == 1) {
				alert("중복된 닉네임 입니다.");
			} else {
				alert("사용가능한 닉네임 입니다.");
			}
		},error:function(request,status,error){
		    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);}

	})

}