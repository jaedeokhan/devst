<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/reset.css" />"  rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<link href="<c:url value="/resources/css/main.css" />"  rel="stylesheet">
<style>
	.headerWrap{margin:0 auto; width: 100%; overflow:hidden; background-color:rgba(5,195,157,0.7);}
	.headerLeft{float:left;}
	.headerLeft > .headerLeftItems{float:left; color:#fff;font-size: 18px; line-height: 64px; margin: 0 20px 0 20px;}
	.headerRight{float:right;}
	.headerRight > .headerRightItems{float:left; color:#fff; font-size: 18px;line-height: 64px;  margin: 0 20px 0 20px;}
	#logo{width:164px; height: 64px;}
	.search{float:left; line-height: 64px;}
	.search.headerRightItems > input{height:26px; width: 200px; margin-right:10px;}
	.search.headerRightItems > i{cursor:pointer;}
	
	.headerLeft > .headerLeftItems:hover{color:yellow;}
	.headerRight > .headerRightItems:hover{color:yellow;}
	#header{margin-bottom:100px;}
	.navWrap{width: 1400px; margin:0 auto; overflow:hidden;}
	.navItems{width:120px; border: 1px solid #ddd; border-radius: 25px; float:left; height: 50px; line-height: 50px; text-align: center; cursor:pointer; margin: 0 15px; font-weight: bolder;}
	#nav{margin-bottom:50px;}
	
	.mainWrap{overflow: hidden;}
	.mainItems{float:left; margin:20px;} 
	.mainItems:nth-child(5n-4){margin-left: 0;}/*1 6 11 16  */
	.mainItems:nth-child(5n){margin-right: 0;}
	.mainWrap{width:1400px; margin:0 auto;}
	.mainItems{border:1px solid #ddd; width:calc( 1240px / 5 ); box-sizing: border-box;}
	.mainItemsTitle{text-align: center; font-size: 24px; margin:10px 0;}
	.mainItemsMid{overflow:hidden;}
	.mainItemsMidLeft{float:left; width:60%; overflow: hidden;}
	.mainItmesMidRight{float:right; width: 40%; overflow: hidden;}
	.mainItemsMid{margin-bottom: 20px; }
	.mainItmesNm, .mainItmesDate{overflow: hidden;}
	.mainItmesDate{line-height: 35px;}
	.mainItmesDate > p{text-align: center;}
	.mainItmesNm p {line-height: 35px;}
	.mainItmesNm > *{float:left;  margin:5px 0;}
	.mainItemsMidLeftTop  *{float:left;}
	.mainItemsMidLeftTop{overflow: hidden; margin-left:10px;}
	.mainItemsMidLeft{overflow: hidden;}
	.mainItemsMidLeft * {float:left;}
	.mainItemsDesc{width: 90%; margin:0 auto; padding:30px 0;}
	.categoryColor{background-color:rgba(102,141,246,0.7); height: 5px; width: 100%;}
	.mainItemsDescWrap{background-color:#f4f4f4;}
	.mainItemsViews{margin-left:10px; margin-bottom: 10px;}
	.viewCnt, .goodCnt, .badCnt{line-height: 35px;}
	.mainItemsBad{margin-right: 10px;}
	#main{margin-bottom: 100px;}
</style>
</head>
<body>
	<header id="header">
		<div class="headerWrap">
			
			<div class="headerLeft">
				<img src="/resources/img/logo.png"  id="logo" class="headerLeftItems">
				<a href="#" class="headerLeftItems">Teach Q&A</a>
				<a href="#" class="headerLeftItems">스터디 구인</a>
				<a href="#" class="headerLeftItems">알고리즘 스터디</a>
			</div>
			<div class="headerRight">
				<div class="search headerRightItems"><input type="text" placeholder="내용을 입력하세요"><i class="fas fa-search"></i></div>
				<a href="#" class="headerRightItems">로그인</a>
				<a href="#" class="headerRightItems">회원가입</a>
				<img src="https://placehold.it/64x64" class="headerLeftItems">
			</div>
			</div>
		
	</header>
	
	<nav id="nav">
		<ul class="navWrap">
			<li class="navItems">인기순</li>
			<li class="navItems">조회순</li>
			<li class="navItems">댓글순</li>
			<li class="navItems">날짜순</li>
		</ul>
	</nav>
	
	
	<main id="main">
		<div class="mainWrap">
			
			<div class="mainItems">
				<div class="categoryColor"></div>
				<h3 class="mainItemsTitle">리엑트 스터디 구함</h3>
				<div class="mainItemsMid">
					<div class="mainItemsMidLeft">
						
						<div class="mainItemsViews"><img src="https://placehold.it/35x35"><p class="viewCnt">0</p></div>
						<div class="mainItemsMidLeftTop">
							<div class="mainItemsBad"><img src="https://placehold.it/35x35"><p class="badCnt">15</p></div>
							<div class="mainItemsGood"><img src="https://placehold.it/35x35"><p class="goodCnt">45</p></div>
						</div>
					</div>
					<div class="mainItmesMidRight">
						<div class="mainItmesNm"><img src="https://placehold.it/35x35"><p>닉네임</p></div>
						<div class="mainItmesDate"><p>20/09/12</p></div>
					</div>
				</div>
				<div class="mainItemsDescWrap">
				<p class="mainItemsDesc">
					이번에 제가 서울에서 리엑트 모입을 하려고...
				</p>
			</div>
			</div>
			
			<!--여러개 테스트  start-->
				<div class="mainItems">
				<div class="categoryColor"></div>
				<h3 class="mainItemsTitle">리엑트 스터디 구함</h3>
				<div class="mainItemsMid">
					<div class="mainItemsMidLeft">
						
						<div class="mainItemsViews"><img src="https://placehold.it/35x35"><p class="viewCnt">0</p></div>
						<div class="mainItemsMidLeftTop">
							<div class="mainItemsBad"><img src="https://placehold.it/35x35"><p class="badCnt">15</p></div>
							<div class="mainItemsGood"><img src="https://placehold.it/35x35"><p class="goodCnt">45</p></div>
						</div>
					</div>
					<div class="mainItmesMidRight">
						<div class="mainItmesNm"><img src="https://placehold.it/35x35"><p>닉네임</p></div>
						<div class="mainItmesDate"><p>20/09/12</p></div>
					</div>
				</div>
				<div class="mainItemsDescWrap">
				<p class="mainItemsDesc">
					이번에 제가 서울에서 리엑트 모입을 하려고...
				</p>
			</div>
			</div>
				<div class="mainItems">
				<div class="categoryColor"></div>
				<h3 class="mainItemsTitle">리엑트 스터디 구함</h3>
				<div class="mainItemsMid">
					<div class="mainItemsMidLeft">
						
						<div class="mainItemsViews"><img src="https://placehold.it/35x35"><p class="viewCnt">0</p></div>
						<div class="mainItemsMidLeftTop">
							<div class="mainItemsBad"><img src="https://placehold.it/35x35"><p class="badCnt">15</p></div>
							<div class="mainItemsGood"><img src="https://placehold.it/35x35"><p class="goodCnt">45</p></div>
						</div>
					</div>
					<div class="mainItmesMidRight">
						<div class="mainItmesNm"><img src="https://placehold.it/35x35"><p>닉네임</p></div>
						<div class="mainItmesDate"><p>20/09/12</p></div>
					</div>
				</div>
				<div class="mainItemsDescWrap">
				<p class="mainItemsDesc">
					이번에 제가 서울에서 리엑트 모입을 하려고...
				</p>
			</div>
			</div>
				<div class="mainItems">
				<div class="categoryColor"></div>
				<h3 class="mainItemsTitle">리엑트 스터디 구함</h3>
				<div class="mainItemsMid">
					<div class="mainItemsMidLeft">
						
						<div class="mainItemsViews"><img src="https://placehold.it/35x35"><p class="viewCnt">0</p></div>
						<div class="mainItemsMidLeftTop">
							<div class="mainItemsBad"><img src="https://placehold.it/35x35"><p class="badCnt">15</p></div>
							<div class="mainItemsGood"><img src="https://placehold.it/35x35"><p class="goodCnt">45</p></div>
						</div>
					</div>
					<div class="mainItmesMidRight">
						<div class="mainItmesNm"><img src="https://placehold.it/35x35"><p>닉네임</p></div>
						<div class="mainItmesDate"><p>20/09/12</p></div>
					</div>
				</div>
				<div class="mainItemsDescWrap">
				<p class="mainItemsDesc">
					이번에 제가 서울에서 리엑트 모입을 하려고...
				</p>
			</div>
			</div>
				<div class="mainItems">
				<div class="categoryColor"></div>
				<h3 class="mainItemsTitle">리엑트 스터디 구함</h3>
				<div class="mainItemsMid">
					<div class="mainItemsMidLeft">
						
						<div class="mainItemsViews"><img src="https://placehold.it/35x35"><p class="viewCnt">0</p></div>
						<div class="mainItemsMidLeftTop">
							<div class="mainItemsBad"><img src="https://placehold.it/35x35"><p class="badCnt">15</p></div>
							<div class="mainItemsGood"><img src="https://placehold.it/35x35"><p class="goodCnt">45</p></div>
						</div>
					</div>
					<div class="mainItmesMidRight">
						<div class="mainItmesNm"><img src="https://placehold.it/35x35"><p>닉네임</p></div>
						<div class="mainItmesDate"><p>20/09/12</p></div>
					</div>
				</div>
				<div class="mainItemsDescWrap">
				<p class="mainItemsDesc">
					이번에 제가 서울에서 리엑트 모입을 하려고...
				</p>
			</div>
			</div>
			<div class="mainItems">
				<div class="categoryColor"></div>
				<h3 class="mainItemsTitle">리엑트 스터디 구함</h3>
				<div class="mainItemsMid">
					<div class="mainItemsMidLeft">
						
						<div class="mainItemsViews"><img src="https://placehold.it/35x35"><p class="viewCnt">0</p></div>
						<div class="mainItemsMidLeftTop">
							<div class="mainItemsBad"><img src="https://placehold.it/35x35"><p class="badCnt">15</p></div>
							<div class="mainItemsGood"><img src="https://placehold.it/35x35"><p class="goodCnt">45</p></div>
						</div>
					</div>
					<div class="mainItmesMidRight">
						<div class="mainItmesNm"><img src="https://placehold.it/35x35"><p>닉네임</p></div>
						<div class="mainItmesDate"><p>20/09/12</p></div>
					</div>
				</div>
				<div class="mainItemsDescWrap">
				<p class="mainItemsDesc">
					이번에 제가 서울에서 리엑트 모입을 하려고...
				</p>
			</div>
			</div>
			<div class="mainItems">
				<div class="categoryColor"></div>
				<h3 class="mainItemsTitle">리엑트 스터디 구함</h3>
				<div class="mainItemsMid">
					<div class="mainItemsMidLeft">
						
						<div class="mainItemsViews"><img src="https://placehold.it/35x35"><p class="viewCnt">0</p></div>
						<div class="mainItemsMidLeftTop">
							<div class="mainItemsBad"><img src="https://placehold.it/35x35"><p class="badCnt">15</p></div>
							<div class="mainItemsGood"><img src="https://placehold.it/35x35"><p class="goodCnt">45</p></div>
						</div>
					</div>
					<div class="mainItmesMidRight">
						<div class="mainItmesNm"><img src="https://placehold.it/35x35"><p>닉네임</p></div>
						<div class="mainItmesDate"><p>20/09/12</p></div>
					</div>
				</div>
				<div class="mainItemsDescWrap">
				<p class="mainItemsDesc">
					이번에 제가 서울에서 리엑트 모입을 하려고...
				</p>
			</div>
			</div>
			<div class="mainItems">
				<div class="categoryColor"></div>
				<h3 class="mainItemsTitle">리엑트 스터디 구함</h3>
				<div class="mainItemsMid">
					<div class="mainItemsMidLeft">
						
						<div class="mainItemsViews"><img src="https://placehold.it/35x35"><p class="viewCnt">0</p></div>
						<div class="mainItemsMidLeftTop">
							<div class="mainItemsBad"><img src="https://placehold.it/35x35"><p class="badCnt">15</p></div>
							<div class="mainItemsGood"><img src="https://placehold.it/35x35"><p class="goodCnt">45</p></div>
						</div>
					</div>
					<div class="mainItmesMidRight">
						<div class="mainItmesNm"><img src="https://placehold.it/35x35"><p>닉네임</p></div>
						<div class="mainItmesDate"><p>20/09/12</p></div>
					</div>
				</div>
				<div class="mainItemsDescWrap">
				<p class="mainItemsDesc">
					이번에 제가 서울에서 리엑트 모입을 하려고...
				</p>
			</div>
			</div>
			
			<!--여러개 테스트 end  -->
		</div>
	
	</main>




	<a href="/devst/board/category?no=1">일반게시판</a>
	<a href="/devst/board/category?no=2">스터디게시판</a>
	<a href="/devst/board/category?no=3">~~게시판</a>
	<a href="/devst/board/category?no=4">~~게시판</a>
	
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
			<td>${list.brdId }</td>
			<td>${list.brdTitle }</td>
			<td>${list.brdHashtag }</td>
			<td>${list.brdCategory }</td>
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
			<td>${list.brdId }</td>
			<td>${list.brdTitle }</td>
			<td>${list.brdHashtag }</td>
			<td>${list.brdCategory }</td>
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
			<td>${list.brdId }</td>
			<td>${list.brdTitle }</td>
			<td>${list.brdHashtag }</td>
			<td>${list.brdCategory }</td>
		</tr>
		
		</c:forEach>
	</table>
</body>
</html>