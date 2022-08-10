<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인화면</title>
<!-- CSS모음 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/header.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<!-- CSS모음 끝 -->
<body>
<!-- 헤더 -->
<jsp:include page="/inc/header.jsp"/>
<!-- 헤더 끝 -->

<!-- 제일 중요한 현재 페이지의 메인 HTML 태그들 -->
<section class="main_content">


<!-- 메인 슬라이더  -->
<div class="container">

	<!-- 메인 슬라이더의 보여줄 화면들(여러개) -->
	<div class="mySlides">
		<div class="numbertext">1 / 6</div>
			<a href="">
			<img src="images/img_woods_wide.jpg" style="width:100%">
		</a>
	</div>

	<div class="mySlides">
		<div class="numbertext">2 / 6</div>
			<a href="">
			<img src="images/img_5terre_wide.jpg" style="width:100%">
		</a>
	</div>

	<div class="mySlides">
		<div class="numbertext">3 / 6</div>
			<a href="">
			<img src="images/img_mountains_wide.jpg" style="width:100%">
		</a>
	</div>
	  
	<div class="mySlides">
		<div class="numbertext">4 / 6</div>
			<a href="">
			<img src="images/img_lights_wide.jpg" style="width:100%">
		</a>
	</div>
	
	<div class="mySlides">
		<div class="numbertext">5 / 6</div>
			<a href="">
			<img src="images/img_nature_wide.jpg" style="width:100%">
		</a>
	</div>
	  
	<div class="mySlides">
		<div class="numbertext">6 / 6</div>
			<a href="">
			<img src="images/img_snow_wide.jpg" style="width:100%">
		</a>
	</div>
	<!-- 메인 슬라이더의 보여줄 화면들(여러개) 끝-->
	
	
	<!-- 메인 슬라이더의 보여줄 화면안의 화살표 오른쪽 왼쪽-->
	<a class="prev" onclick="plusSlides(-1)">❮</a>
	<a class="next" onclick="plusSlides(1)">❯</a>
	<!-- 메인 슬라이더의 보여줄 화면안의 화살표 오른쪽 왼쪽 끝-->


	
	<!-- 메인 슬라이더의 밑의 메뉴바 -->
	<div class="row">
	<!-- 메인 슬라이더의 보여줄 메뉴 텍스트들(여러개) -->
		<div class="column">
			<button class="demo cursor" onmouseover="currentSlide(1)">이 달의 신간</button>
		</div>
		
		<div class="column">
			<button class="demo cursor" onmouseover="currentSlide(2)">이 달의 베스트</button>
		</div>
			<div class="column">
		<button class="demo cursor" onmouseover="currentSlide(3)">XXX작가의 추천</button>
		</div>
		
		<div class="column">
			<button class="demo cursor" onmouseover="currentSlide(4)">20대 필독 도서</button>
		</div>
		
		<div class="column">
			<button class="demo cursor" onmouseover="currentSlide(5)">베스트 자기 계발서</button>
		</div>   
		 
		<div class="column">
			<button class="demo cursor" onmouseover="currentSlide(6)">작년도 베스트</button>
		</div>
	<!-- 메인 슬라이더의 보여줄 메뉴 텍스트들(여러개) 끝-->
	</div>
	<!-- 메인 슬라이더의 밑의 메뉴바 끝-->
</div>
<!-- 메인 슬라이더 끝 -->




</section>
<!-- 제일 중요한 현재 페이지의 메인 HTML 태그들 끝 -->

<!-- 푸터 -->
<jsp:include page="/inc/footer.jsp"/>
<!-- 푸터 -->
</body>
<!-- 
	슬라이드에 필요한 JS라 BODY가 모두 로딩되었을 때 슬라이드가 작동되게 만들어서 
	오류(로딩 안된 태그 건드리는 오류) 없앰 
-->
<script src="js/main.js" type="text/javascript"></script>
<!-- 자바스크립트 실행 구역 끝-->
</html>











