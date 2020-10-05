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
 <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
	.boardWrap{width:800px; margin:0 auto;}
	.boardItem{width:100%; height:120px; border:1px solid #ddd; position:relative; margin:20px;}
	.boardCategoryNm{font-size:24px;}
	.itemDesc{width:50%; heght:100%;  padding-top:30px; text-align:center;}
	.itemDescTitle{margin:5px 0; font-size:18px;  text-align: left; margin-left: 150px; width:250px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;}
	.itemDescDate, .itemDescWriter, .itemDescDate, .itemDescContent{font-size:12px; overflow:hidden; vertical-align:top; text-overflow: ellipsis; word-break:break-all; -webkit-box-orient:vertical; display: -webkit-box;  -webkit-line-clamp:2}
	.itemDescContent{margin-top:10px; text-align: left; margin-left: 150px;}
	.itemDescBtn{position:absolute; right:0; bottom:0;}
	.itemDescBtn i{font-size:20px;}
	.itemDescInfo{margin: 15px 0 0 0;}
	.boardItem > *{float:left;}
	.boardItem{overflow:hidden;}
	.profileWrap{width:100px; height:100px; overflow:hidden; border-radius:25px;}
	.profileWrap > img{  width: 100%; height: 100%; object-fit: cover;}
	.itemWriterNm{text-align:center; margin-top:3px; height:18px; line-height: 18px; width:100px;overflow:hidden; text-overflow: ellipsis; white-space:nowrap;}
	.boardCaterogy{width:80px; height:40px;  float:right;}
	.boardNew, .boardBest{float:right; width:40px; height:40px; display:none;}
	.boardNew.active{background-color:#FF4646; color:#fff; line-height: 40px; text-align: center; display:block;}
	.boardBest.active{background-color:blue; color:#fff; line-height: 40px; text-align: center; display:block;}
	.pageNumWrap{width:400px; margin:0 auto;  overflow:hidden;}
	.pageNum{float:left;  width:80px; text-align:center;}
	.pageNum.active{color:red;}
	.pageNumBox{width:3000px;  overflow:hidden;}
	.pagingNum{cursor:pointer; width:70%;}
	.pageArrow{width:500px; height:53px; position:absolute; left:50%; transform:translateX(-50%); }
	.pageArrow  i{line-height: 53px; font-size:28px; cursor:pointer; position:relative; bottom:53px; color:#666}
	.pageLeftArrow{float:left;}
	.pageArrow i {top:-36px;}

	.pageRightArrow{float:right;}
	.pageNav{position:relative;}
	.fas.fa-arrow-right{padding-right:24px;}
	.boardItem{cursor:pointer;}
	 .boardItem:hover{background-color:#ddd;} 

</style>
<script>
	$(function(){
		var pageMaxNum = $("#pageMaxNum").val();//최대페이지수
		if(pageMaxNum < 5) {pageMaxNum = 5;}//레이아웃용
		var currentPageNum = $('#pageNum').val();//현재페이지
		var pageNumWidth = $('.pageNum').width();
		 $(".pageNumBox").css({
			 
			width:pageMaxNum*pageNumWidth+"px"
		}); 
		$(".pageNumWrap")
		
	
		
		$(".pageNum").eq(currentPageNum-1).addClass('active');
		
		
		//5, 9, 13, 17, 21, ...시 페이징 버튼 change
		var pageArr = new Array();
		for(var i = 1; i <= pageMaxNum;i++){
			
			if((i-1)%4 == 0|| (i-1)%4 == 1 || (i-1)%4 == 2 || (i-1)%4 == 3 && i>4){
				
				pageArr[i] = i;
				console.log(pageArr[i])
				$(".pageNum").eq(i-1).addClass("next");
				var classNm = $(".pageNum").eq(i-1).attr("class")
				
				if(classNm == 'pageNum active next'){
					let cnt = 0;	
					let index = currentPageNum;
					while(index > 4){
						
						index-=4;
						
						cnt++;
					} 
					
					$(".pageNumBox").css({
						marginLeft: - pageNumWidth*4*cnt+"px"
					});
				}
			}
			
		}
		
		$(".boardItem").mouseover(function(){
			$(".itemWriterInfo").css({
				backgroundColor:"#fff"
			})
		})
		
		$(".pageLeftArrow").click(function(){
			if(currentPageNum==1){
				return;
			}
			pageChange(--currentPageNum);
		})
		
		$(".pageRightArrow").click(function(){
			pageChange(++currentPageNum);
		})
	/* pageChange */
	})
</script>
	

</head>
<body>	
	<div class="boardWrap">
		
		<div class="boardCategoryNm">${category } </div>
		<!-- 기본 레이아웃 html ajax시 사용할수도? 삭제 ㄴㄴ -->
	<!-- 	<div class="boardItem">
			<div class="boardCaterogy">
				<div class="boardNew active">New</div>
				<div class="boardBest">Best</div>
			</div>
		
			<div class="itemWriterInfo">
				<div class="profileWrap">
					<img src="https://placehold.it/120x120">
				</div>
				<p class="itemWriterNm">김나라</p>
			</div>
			<div class="itemDesc">
				<h3 class="itemDescTitle">포트폴리오 만드실분</h3>
				<p class="itemDescContent">안녕하세요 저는 어디대구에 살고있고 같이 개..</p>
				
				<div class="itemDescBtn">
					<i class="far fa-thumbs-up">54</i>
					<i class="far fa-thumbs-down">3</i>
					<i class="far fa-comment">36</i>
				</div>
			</div>
			
		</div> -->
		<!--  -->
	
		
		<c:forEach var="list" items="${list }">
			<div class="boardItem" onclick="itemDetail(${list.brd_id})">
			<div class="boardCaterogy">
			<!-- 에러 발생 :: Cannot convert [20. 9. 12 오후 3:11] of type [class java.sql.Timestamp] to [class java.lang.Long]  -->
 			<c:if test="${list.brd_update_date >= currentTime -1 }"><!--날짜비교해서 new 카테고리 addClass할꺼  -->
				<div class="boardNew active">New</div>
			</c:if> 
				
				<div class="boardBest ative">Best</div>
			</div>
		
			<div class="itemWriterInfo">
				<div class="profileWrap">
					<img src="https://placehold.it/120x120">
				</div>
				<p class="itemWriterNm">${list.mem_nickname }</p>
			</div>
			<div class="itemDesc">
				<h3 class="itemDescTitle">${list.brd_title }</h3>
				<p class="itemDescContent">${list.brd_content }</p>
				
				<div class="itemDescBtn">
					<i class="far fa-thumbs-up">${list.brd_like_count }</i>
					<i class="fas fa-eye">${list.brd_view_count }</i>
					<i class="far fa-comment">36</i>
				</div>
			</div>
			
		</div>
		
		</c:forEach>
	</div>

	<input type="hidden" value="${pageMaxNum }" id="pageMaxNum">
	<div class="pageNav">
		<div class="pageNumWrap">
			<%-- <c:forEach begin="1" end="${pageMaxNum }" step="1" var="i"> --%>
			<div class="pageNumBox">
			<!--페이징 레이아웃 맞추기  -->
				<c:set value="${pageMaxNum }" var="pagingDummyNum" />
				<c:if test="${pageMaxNum < 5 }">
					<c:set value="5" var="pagingDummyNum" />
				</c:if>
			<!--  -->
				<c:forEach begin="1" end="${pagingDummyNum }" step="1" var="i">
					<div class="pageNum" onclick="pageChange(${i})"><p class="pagingNum"><c:out value="${i }" /></p></div> 
				</c:forEach>
			</div>
		</div>
		<div class="pageArrow">
				<div class="pageLeftArrow"><i class="fas fa-arrow-left"></i></div>
				<div class="pageRightArrow"><i class="fas fa-arrow-right"></i></div>
		</div>
		
	</div>
	
	
	
	<!--서버단에서 클라이언트 페이지 판단하기위한 input  -->
	<input type="text" value="${pageNum }" id="pageNum">
	<input type="hidden" value="${error }" id="errorMsg"><!--잘못된 접근시  -->
	<input type="hidden" value="${no }" id="no">	<!--카테고리 1 일반, 2 스터디  -->
	
	

	<script>
		if(errorMsg.value!=''){
			alert(errorMsg.value);
		}
		
		
		function pageChange(pageNum){
			var no = document.getElementById("no").value;
			console.log("pageChg")
			if(pageNum > document.getElementById("pageMaxNum").value){
				alert('마지막 페이지입니다.')
				return;
			}
			console.log("pageNum : "+pageNum)
			console.log("ss : "+document.getElementById("pageMaxNum").value)		
			location.href="/devst/board/category?no="+no+"&pageNum="+pageNum;
			
		}
		
		function itemDetail(item_id){
			var no = document.getElementById("no").value;
			location.href="/devst/board/detail/category?id="+item_id+ "&no="+no;
			
			
		}
		
	
	</script>
	
</body>
</html>
