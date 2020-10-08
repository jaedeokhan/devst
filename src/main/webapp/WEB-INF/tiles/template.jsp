<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>devst</title>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
    <div style="width:100%; height:100%;">
    <div id="header"><tiles:insertAttribute name="header" /></div>
    <div id="main"><tiles:insertAttribute name="body" /> </div>
    <div id="footer"><tiles:insertAttribute name="footer" /></div>
    </div>
 
    <script type="text/javascript">
        $(function() {
        	$(window).scroll(function () {
       		var scrollTop = $(document).scrollTop();
       			if(scrollTop > 150){
       				$('#header > .headerWrap').css({
       					position:"fixed",
       					top:"0px",
       					backgroundColor:"rgba(5,195,157)",
       					fontWeight: "bold"
       				})
       			} else{
       				$('#header > .headerWrap').css({
       					position:"",
       					top:"",
       					backgroundColor:"",
       					fontWeight: ""
       				})
       			}
       		
        		
       		}); 
         });

          
    </script>    
</body>
</html>