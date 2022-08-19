<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/user_customersupporter.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	var j = 0;
	function addFaq() {
		j += 5;
		$.ajax({
			type: "get",
			url: "qna/faq_json.txt",
			dataType: "json"
		})
		.done(function(data) { 
			for(var i = j;i <= 4+j ;i++){
				$("#addfaq").before(
					"<a href=location.href='javascript:void(0)' onclick='location.href='>"+
					"<div class='content'>" + data[i].name + "</div>"+
					"</a>"
				)
			}
		})
		.fail(function() {
			alert("json 실패");
		})
	}
	
	
	$(function() {
		$.ajax({
			type: "get",
			url: "qna/faq_json.txt",
			dataType: "json"
		})
		.done(function(data) { 
			for(var i = j;i <= 4 ;i++){
				$("#faq").after(
					"<a href=location.href='javascript:void(0)' onclick='location.href='>"+
					"<div class='content'>" + data[i].name + "</div>"+
					"</a>"
				)
			}
		})
		.fail(function() {
			alert("json 실패");
		})
	});
	
	
	
</script>




</head>
<body>


	<div id="wrapper">
		<div class="FAQ">
			<div id="faq" class="subject">FAQ</div>
			
			
			<div id="addfaq" class="content" onclick="addFaq()">더보기 </div>
		</div>
	</div>
</body>
</html>