<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#footer{background-color:rgb(48, 55, 64,0.7)}
	#footer p,h4,span{color:#fff;}
	#footer *{text-align: center;}
	.footerWrap{width:1700px; margin:0 auto; overflow: hidden;}
	.footerLogo{width:250px; margin-bottom:20px; height:95px;}
	.footerLeftBot > * {margin:10px 0;}
	.footerTitle{color:#fff; text-align: center; font-size:36px; font-weight: bold; margin-top:20px;}
	.footerLeft, .footerMid, .footerRight{float:left;width: calc(1700px / 3)}
	.footerDurmmy{width:350px; height:95px; margin-bottom:20px; text-align: center;}
	.footerMid > *{margin:10px 0;}
	.footerRight > .footerDurmmy > h4{font-size:30px; font-weight: bold;}
	.mobileImg > span > *{width:120px; height: 60px; cursor:pointer; margin:10px;}
	.follow > i{font-size: 40px; cursor:pointer; color:#fff; margin: 15px;}
	.follow h4{font-size: 30px; font-weight: bold;}
</style>
</head>
<body>
	<div id="footer">
		<div class="footerWrap">
			<h4 class="footerTitle">About devst</h4>
			<div class="footerLeft">
				<img class="footerLogo" src="/resources/img/logo.png">
				<div class="footerLeftBot">
					<p>상호명 : devel</p>
					<div class="footerTel">
						<span>문의전화 : 053-761-7254</span>
					</div>
					<div class="footerEmail">
						<span>이메일 : devst@gmail.com</span>
					</div>
				</div>
			</div>
			<div class="footerMid">
			<div class="footerDurmmy"></div>
				<p>대구광역시 중구 동성로2길 49-3 아조빌딩4층</p>
				<p>사업자번호 : 154-08-602491</p>
				<p>팩스번호 : 123-153-6382</p>
			</div>
			<div class="footerRight">
				<div class="footerDurmmy">
					<h4>Mobile App</h4>
					<div class="mobileImg">
						<span><img src="/resources/img/androidDown.png"></span>
						<span><img src="/resources/img/appleDown.png"></span>
					</div>
					<div class="follow">
						<h4>Follow Us</h4>
						<i class="fab fa-facebook-square"></i>
						<i class="fab fa-instagram"></i>
						<i class="fab fa-twitter-square"></i>
					
					</div>
				</div>
			
			</div>
		
		
		</div>
		
	
	</div>
</body>
</html>