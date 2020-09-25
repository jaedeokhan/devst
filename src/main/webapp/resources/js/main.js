


$(function(){
	
	$(".navItems").eq(0).addClass('active');
	
	
	
	
	$(document).on('click', '.navItems', function(){
		var category = $(this).text();
		var idx = $(this).index();
				$('.navItems').removeClass('active');
				$(".navItems").eq(idx).addClass('active');
		//alert(category)
		$.ajax({
			url:'/devst/ajax?category='+category,
			type:'get',
			dataType:'json',
			
			success:function(data){
				
				
				
				var categoryColorBlue = '<div class="categoryColorBlue"></div>';
				//console.log(data.jsonData)
				$('.mainItems').remove();
				for(var i=0; i<data.jsonData.length;i++){
					//brd_category 일반 -> 파랑  rgba(102,141,246,0.7); className categoryColorBlue
					//brd_category 스터디구인 -> 초록 rgba(5,195,157,0.7); className categoryColorGreen
				var items = '<div class="mainItems">'
								+'<div class="categoryColor"></div>'
								+'<h3 class="mainItemsTitle">'+data.jsonData[i].brd_title+'</h3>'
								+'<div class="mainItemsMid">'
								+'<div class="mainItemsMidLeft">'
									+'<div class="mainItemsMidLeftTop">'
										+'<div class="mainItemsGood"><i class="far fa-thumbs-up"></i><p class="goodCnt">'+data.jsonData[i].brd_like_count+'</p></div>'
									+'</div>'
									+'<div class="mainItemsMidLeftBot">'
										+'<div class="mainItemsComment"><i class="far fa-comment"></i><p class="comment">10</p></div>'
										+'<div class="mainItemsBad"><i class="fas fa-eye"></i><p class="viewCnt">'+data.jsonData[i].brd_view_count+'</p></div>'
									+'</div>'
								+'</div>'
								+'<div class="mainItmesMidRight">'
									+'<div class="mainItmesNm"><img src="https://placehold.it/35x35"><p>'+data.jsonData[i].mem_nickname+'</p></div>'
									+'<div class="mainItmesDate"><p>'+data.jsonData[i].brd_update_date+'</p></div>'
								+'</div>'
							+'</div>'
								+'<div class="mainItemsDescWrap">'
								+'<p class="mainItemsDesc">'
									+'이번에 제가 서울에서 리엑트 모입을 하려고...'
								+'</p>'
							+'</div>'
							+'</div>';
				
					$('.mainWrap').append(items);
					if(data.jsonData[i].brd_category =="일반"){
						$(".mainItems  .categoryColor").eq(i).addClass("categoryColorBlue");
					} else if(data.jsonData[i].brd_category == "스터디구인"){
						$(".mainItems  .categoryColor").eq(i).addClass("categoryColorGreen");
					}
				}
				
				
				
				
				
				
			},
			error:function(data){
				console.log('실패')
			}
		})
		
		
	})
	
	
})