//es5













//jquery
$(function(){
	$(".navItems").click(function(){
		var category = $(this).text();
		//alert(category)
		
		$.ajax({
			url:'/devst?category='+category,
			dataType:"json",
			type:'post',
			success:function(data){
				console.log(data.jsonData)
				console.log("타입 : "+ typeof data)
				console.log("크기 : "+ data.jsonData.length)
				
			},
			error:function(data){
				console.log("error")
			}
			
		})
	
		/*.done(function(data){
			
			console.log(data.toString())
			console.log("타입 : "+ typeof data)
			console.log("크기 : "+data.jsonData.size);*/
			//한 섹터 {brd_dislike_count=12, brd_title=일반test, brd_like_count=123, mem_nickname=SUSUJIN1, brd_id=5, mem_id=12, brd_category=일반, brd_create_date=2020-09-12 15:11:00.0, brd_content=일반test, brd_hashtag=#일반 #test1, brd_view_count=0, brd_update_date=2020-09-12 15:11:00.0}
			/*
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
		</div>*/
			
			
			
			
			
			
			
			
			
			
			
			
			

		
		
		
	})
})



