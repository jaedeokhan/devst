function emailChk() {
	var frm = document.memberJoinForm;
	var reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;

	if (!reg_email.test(frm.mem_email.value)) {
		return false;
	} else {
		$.ajax({
			url : "/user/emailChk",
			type : "post",
			dataType : "json",
			data : {
				"mem_email" : frm.mem_email.value
			},
			success : function(data) {
				if (data == 1) {
					alert("중복된 이메일 입니다.");
				} else {
					alert("사용가능한 이메일 입니다.");
				}
			}
		})
	}
}

function joinChk() {
	var frm = document.memberJoinForm;
	var pwRule = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/; //조건1. 6~20 영문 대소문자 , 최소 1개의 숫자 혹은 특수 문자를 포함해야 함

	if (frm.mem_email.value.length == 0) {
		alert("이메일을 입력하세요.");
		frm.mem_email.focus();
		return false;
	} else if (frm.mem_password.value.length == 0) {
		alert("비밀번호를 입력하세요.")
		frm.mem_password.focus();
		return false;
	} else if (!pwRule.test(frm.mem_password.value)) {
		alert("패스워드는 숫자, 문자포함 6~12자리로 지정해주세요");
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
