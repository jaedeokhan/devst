// 이메일 형식 체크
function emailChk() {
	var frm = document.emailCertifyForm;
	var chkMsg = document.getElementById("chk_msg");
	var regEmail = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
	
	if (!regEmail.test(frm.memEmail.value)) {
		chkMsg.innerHTML = "이메일형식에 맞지 않습니다.";
		chkMsg.style.color = "red";
		return false;
	} else {
		chkMsg.innerHTML = "";
	}
}


// 인증번호 보내기
function emailSend() {
	var frm = document.emailCertifyForm;
	console.log("입력이메일:" + frm.memEmail.value);
	
	$.ajax({
		url : "/devst/user/emailSend",
		type : "post",
		data : {
			memEmail : frm.memEmail.value
		},
		success : function(data) {
			if (data == 1) {
				alert("이미 가입된 이메일 입니다.");
			} else {
				alert("인증코드를 발송했습니다.");
			}
		},error:function(request,status,error){
		    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);}

	});
}

// 인증번호 확인
function emailCertify() {
	var memEmail = document.getElementById("mem_email").value;
	var inputNum = document.getElementById("certification_num").value;
//	var yn = document.getElementById("certification_YN");

	$.ajax({
		type: "post",
		url: "/devst/user/emailCertify",
		data: {
			"memEmail" : memEmail,
			"inputNum" : inputNum
		},
		async: false,
		success : function(data){
			console.log("result : " + data);
			
//			memEmail.onchange = function() {
//				yn.value = "false";
//			}
			
			if(data == true) {
				alert("인증되었습니다.");
				
//				yn.value = "true";
				location.href = "/devst/user/joinPage?memEmail=" + memEmail;
				
			} else {
//				if(yn.value == false) {
//					alert("입력한 이메일을 확인해주세요.");
//				} else {
					alert("인증번호를 다시 확인해주세요.");
//				}
			}
		}, error : function(request,status,error){
		    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);}
	});
}