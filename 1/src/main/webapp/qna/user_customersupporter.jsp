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
		j += 4;
		$.ajax({
			type: "get",
			url: "qna/faq_json.txt",
			dataType: "json"
		})
		.done(function(data) {
			for(var i = j;i <= data.length-1 ;i+=4){
				$(".more").before(
					"<div class='content_flex'>"+
					"<div class='content''>"+data[i].name+
					"<div class='ex'>"+data[i].acceptedAnswer.text+"</div>"+
					"</div>"+
					"<div class='content'>"+data[i+1].name+
						"<div class='ex'>"+data[i+1].acceptedAnswer.text+"</div>"+
					"</div>"+
					"<div class='content'>"+data[i+3].name+
						"<div class='ex'>"+data[i+2].acceptedAnswer.text+"</div>"+
					"</div>"+
					"<div class='content'>"+data[i+3].name+
						"<div class='ex'>"+data[i+3].acceptedAnswer.text+"</div>"+
					"</div>"+
						"</div>"
				)
			}
			$(".more").hide();
		})
		.fail(function() {
			alert("json 실패");
		})
	};
	
	
	$(function() {
		$.ajax({
			type: "get",
			url: "qna/faq_json.txt",
			dataType: "json"
		})
		.done(function(data) { 
			for(var i = j;i < 4 ;i+=4){
				$(".subject").after(
					"<div class='content_flex'>"+
						"<div class='content''>"+data[i].name+
							"<div class='ex'>"+data[i].acceptedAnswer.text+"</div>"+
						"</div>"+
						"<div class='content'>"+data[i+1].name+
							"<div class='ex'>"+data[i+1].acceptedAnswer.text+"</div>"+
						"</div>"+
						"<div class='content'>"+data[i+3].name+
							"<div class='ex'>"+data[i+2].acceptedAnswer.text+"</div>"+
						"</div>"+
						"<div class='content'>"+data[i+3].name+
							"<div class='ex'>"+data[i+3].acceptedAnswer.text+"</div>"+
						"</div>"+
					"</div>"+
					"<div class='more' onclick='addFaq()'>더보기</div>"
				)
			}
		})
		.fail(function() {
			alert("json 실패");
		})
	});
	
	$(document).on("click",".content",function(){
		$(this).children("div").css("display","block");
		$(".modal").css("display","inline");
	});
	
	function hide() {
		$(".ex").css("display","none");
		$(".modal").css("display","none");
	}
	
</script>
</head>
<body>
<div class="modal" onclick="hide()"></div>
	<div id="wrapper">
		<div class="subject">
			자주 찾는 도움말
		</div>
	<div class="text"></div>
	</div>
	
	

	
	
	
	
	
	
	
</body>
</html>