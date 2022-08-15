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
<link href="css/sidebar.css" rel="stylesheet">
<!-- CSS모음 끝 -->
<body>
<!-- 헤더 a -->
<jsp:include page="/inc/header.jsp"/>
<!-- 헤더 끝 -->

<!-- 메인 시작 -->
<section class="main">
	<!-- main_top  -->
	<section class="main_top">
		<!-- 제일 중요한 현재 페이지의 메인 HTML 태그들 -->
		<section class="main_content">
		<!-- 메인 슬라이더  -->
		<div class="mainContainer">
		
			<!-- 메인 슬라이더의 보여줄 화면들(여러개) -->
			<div class="mainSlides">
				<a href="">
					<img src="images/main/main_book1.jpg" style="width:100%">
				</a>
			</div>
		
			<div class="mainSlides">
				<a href="">
					<img src="images/main/main_book2.jpg" style="width:100%">
				</a>
			</div>
		
			<div class="mainSlides">
				<a href="">
					<img src="images/main/main_book3.jpg" style="width:100%">
				</a>
			</div>
			  
			<div class="mainSlides">
				<a href="">
					<img src="images/main/main_book4.jpg" style="width:100%">
				</a>
			</div>
			
			<div class="mainSlides">
				<a href="">
					<img src="images/main/main_book5.jpg" style="width:100%">
				</a>
			</div>
			  
			<div class="mainSlides">
				<a href="">
					<img src="images/main/main_book6.jpg" style="width:100%">
				</a>
			</div>
			<!-- 메인 슬라이더의 보여줄 화면들(여러개) 끝-->
			
			
			<!-- 메인 슬라이더의 보여줄 화면안의 화살표 오른쪽 왼쪽-->
			<a class="prev" onclick="plusMainSlides(-1)">❮</a>
			<a class="next" onclick="plusMainSlides(1)">❯</a>
			<!-- 메인 슬라이더의 보여줄 화면안의 화살표 오른쪽 왼쪽 끝-->
		
		
			
			<!-- 메인 슬라이더의 밑의 메뉴바 -->
			<div class="row">
			<!-- 메인 슬라이더의 보여줄 메뉴 텍스트들(여러개) -->
				<div class="column">
					<button class="mainDemo cursor" onmouseover="showMainSlides(1)">이 달의 신간</button>
				</div>
				<div class="column">
					<button class="mainDemo cursor" onmouseover="showMainSlides(2)">이 달의 베스트</button>
				</div>
				<div class="column">
					<button class="mainDemo cursor" onmouseover="showMainSlides(3)">XXX작가의 추천</button>
				</div>
				<div class="column">
					<button class="mainDemo cursor" onmouseover="showMainSlides(4)">20대 필독 도서</button>
				</div>
				<div class="column">
					<button class="mainDemo cursor" onmouseover="showMainSlides(5)">베스트 자기 계발서</button>
				</div>
				<div class="column">
					<button class="mainDemo cursor" onmouseover="showMainSlides(6)">작년도 베스트</button>
				</div>
			<!-- 메인 슬라이더의 보여줄 메뉴 텍스트들(여러개) 끝-->
			</div>
			<!-- 메인 슬라이더의 밑의 메뉴바 끝-->
		</div>
		<!-- 메인 슬라이더 끝 -->
		</section>
		<!-- 제일 중요한 현재 페이지의 메인 HTML 태그들 끝 -->
	</section>
	<!-- main_top 끝 -->
	<section style="position: relative; clear: both;"></section>
	
	<!-- main_middle  -->
	<section class="main_middle">
		<!-- 현재 페이지의 중간 HTML 태그들 -->
		<section class="middle_content">
		
			<h3><a href="">오늘의 책 ></a></h3>
			<!-- 책 메뉴 옮기기 1 -->
			<div class="todayBUnits" onmouseover="showMiddleSlides(1)">
				<div class="tBThumb">
					<a href="#">
						<img src="images/book/book_img1.jpg" width="51px">
					</a>
				</div>
				<div class="tBContent">
					<div class="tBImgArea">
						<a href="#">
							<img src="images/book/book_img1.jpg">
						</a>
					</div>
					<div class="tBInfo">
						<p class="book_subject">
							이별을 떠날 때
						</p>
						<p class="book_content">
							책 간단 내용1 책 간단 내용1 책 간단 내용1 책 간단 내용1 책 간단 내용1 책 간단 내용1 책 간단 내용1 책 간단 내용1 책 간단 내용1 
						</p>
						<p class="book_name">
							한창훈
						</p>
						<p class="book_price">
							11,700원
						</p>
					</div>
				</div>
			</div>
			<!-- 책 메뉴 옮기기 1 끝-->
			
			<!-- 책 메뉴 옮기기 2 -->
			<div class="todayBUnits" onmouseover="showMiddleSlides(2)">
				<div class="tBThumb">
					<a href="#">
						<img src="images/book/book_img2.jpg" width="51px">
					</a>
				</div>
				<div class="tBContent">
					<div class="tBImgArea">
						<a href="#">
							<img src="images/book/book_img2.jpg">
						</a>
					</div>
					<div class="tBInfo">
						<p class="book_subject">
							아름답고 죽은 그녀
						</p>
						<p class="book_content">
							책 간단 내용2 책 간단 내용2 책 간단 내용2 책 간단 내용2 책 간단 내용2 책 간단 내용2 책 간단 내용2 책 간단 내용2 책 간단 내용2 
						</p>
						<p class="book_name">
							책 지은이2
						</p>
						<p class="book_price">
							20,000원
						</p>
					</div>
				</div>
			</div>
			<!-- 책 메뉴 옮기기 2 끝-->
			
			<!-- 책 메뉴 옮기기 3 -->
			<div class="todayBUnits" onmouseover="showMiddleSlides(3)">
				<div class="tBThumb">
					<a href="#">
						<img src="images/book/book_img3.jpg" width="51px">
					</a>
				</div>
				<div class="tBContent">
					<div class="tBImgArea">
						<a href="#">
							<img src="images/book/book_img3.jpg">
						</a>
					</div>
					<div class="tBInfo">
						<p class="book_subject">
							마음 로그인
						</p>
						<p class="book_content">
							책 간단 내용3 책 간단 내용3 책 간단 내용3 책 간단 내용3 책 간단 내용3 책 간단 내용3 책 간단 내용3 책 간단 내용3 책 간단 내용3 
						</p>
						<p class="book_name">
							책 지은이3
						</p>
						<p class="book_price">
							30,000원
						</p>
					</div>
				</div>
			</div>
			<!-- 책 메뉴 옮기기 3 끝-->
			
			<!-- 책 메뉴 옮기기 4 -->
			<div class="todayBUnits" onmouseover="showMiddleSlides(4)">
				<div class="tBThumb">
					<a href="#">
						<img src="images/book/book_img4.jpg" width="51px">
					</a>
				</div>
				<div class="tBContent">
					<div class="tBImgArea">
						<a href="#">
							<img src="images/book/book_img4.jpg">
						</a>
					</div>
					<div class="tBInfo">
						<p class="book_subject">
							변화는 있어도 변함은 없기를
						</p>
						<p class="book_content">
							책 간단 내용4 책 간단 내용4 책 간단 내용4 책 간단 내용4 책 간단 내용4 책 간단 내용4 책 간단 내용4 책 간단 내용4 책 간단 내용4 
						</p>
						<p class="book_name">
							책 지은이4
						</p>
						<p class="book_price">
							40,000원
						</p>
					</div>
				</div>
			</div>
			<!-- 책 메뉴 옮기기 4 끝-->
		</section>
		<!-- 현재 페이지의 중간 HTML 태그들 끝 -->
	
		<!-- 현재 페이지의 중간 오른쪽 박스 -->
		<section class="middle_right_content">
			<div class="right_content_menu">
				<!-- 판매 순위 영역 클릭 -->
				<div class="right_sides" onclick="showMiddleRightSlides(1)">
					<div>
						<em>판매 순위</em>
					</div>
				</div>
				<!-- 판매 순위 영역 클릭 끝 -->
				<!-- 베스트셀러 영역 클릭 -->
				<div class="right_sides" onclick="showMiddleRightSlides(2)">
					<div>
						<em>베스트 셀러</em>
					</div>
				</div>
				<!-- 베스트셀러 영역 클릭 끝 -->
			</div>
			<section style="position: relative; clear: both;"></section>
			<div>
				<!-- 판매 순위 영역 콘텐츠 -->
				<div class="right_contents">
					<ol>
						<li class="ranking">
							<strong>1위</strong>
							<span class="ranking_image">
								<img src="images/book/book_img1.jpg" width="40" height="40">
							</span>
							<span class="ranking_infomation">
								<strong>1등 제목</strong>
								<em>1등 작가</em>
							</span>
							<a href="" class="ranking_link">
							
							</a>
						</li>
						<li class="ranking">
							<strong>2위</strong>
							<span class="ranking_image">
								<img src="images/book/book_img3.jpg" width="40" height="40">
							</span>
							<span class="ranking_infomation">
								<strong>콩 제목</strong>
								<em>폭풍저그</em>
							</span>
							<a href="" class="ranking_link">
							
							</a>
						</li>
						<li class="ranking">
							<strong>3위</strong>
							<span class="ranking_image">
								<img src="images/book/book_img4.jpg" width="40" height="40">
							</span>
							<span class="ranking_infomation">
								<strong>3연병</strong>
								<em>임</em>
							</span>
							<a href="" class="ranking_link">
							
							</a>
						</li>
						<li class="ranking">
							<strong>4위</strong>
							<span class="ranking_image">
								<img src="images/book/book_img2.jpg" width="40" height="40">
							</span>
							<span class="ranking_infomation">
								<strong>사구삼진</strong>
								<em>롯데</em>
							</span>
							<a href="" class="ranking_link">
							
							</a>
						</li>
						<li class="ranking">
							<strong>5위</strong>
							<span class="ranking_image">
								<img src="images/book/book_img3.jpg" width="40" height="40">
							</span>
							<span class="ranking_infomation">
								<strong>마자용</strong>
								<em>도레미</em>
							</span>
							<a href="" class="ranking_link">
							
							</a>
						</li>
						<li class="ranking">
							<strong>6위</strong>
							<span class="ranking_image">
								<img src="images/book/book_img3.jpg" width="40" height="40">
							</span>
							<span class="ranking_infomation">
								<strong>가주 마켙</strong>
								<em>roof top korean</em>
							</span>
							<a href="" class="ranking_link">
							
							</a>
						</li>
					</ol>
				</div>
				<!-- 판매 순위 영역 콘텐츠 끝 -->
				
				<!-- 베스트셀러 영역 콘텐츠 -->
				<div class="right_contents">
					<ol>
						<li class="ranking">
							<strong>1위</strong>
							<span class="ranking_image">
								<img src="images/book/book_img3.jpg" width="40" height="40">
							</span>
							<span class="ranking_infomation">
								<strong>마자용</strong>
								<em>도레미</em>
							</span>
							<a href="" class="ranking_link">
							
							</a>
						</li>
						<li class="ranking">
							<strong>2위</strong>
							<span class="ranking_image">
								<img src="images/book/book_img3.jpg" width="40" height="40">
							</span>
							<span class="ranking_infomation">
								<strong>마자용</strong>
								<em>도레미</em>
							</span>
							<a href="" class="ranking_link">
							
							</a>
						</li>
						<li class="ranking">
							<strong>3위</strong>
							<span class="ranking_image">
								<img src="images/book/book_img3.jpg" width="40" height="40">
							</span>
							<span class="ranking_infomation">
								<strong>마자용</strong>
								<em>도레미</em>
							</span>
							<a href="" class="ranking_link">
							
							</a>
						</li>
						<li class="ranking">
							<strong>4위</strong>
							<span class="ranking_image">
								<img src="images/book/book_img3.jpg" width="40" height="40">
							</span>
							<span class="ranking_infomation">
								<strong>마자용</strong>
								<em>도레미</em>
							</span>
							<a href="" class="ranking_link">
							
							</a>
						</li>
						<li class="ranking">
							<strong>5위</strong>
							<span class="ranking_image">
								<img src="images/book/book_img1.jpg" width="40" height="40">
							</span>
							<span class="ranking_infomation">
								<strong>마자용</strong>
								<em>도레미</em>
							</span>
							<a href="" class="ranking_link">
							
							</a>
						</li>
						<li class="ranking">
							<strong>6위</strong>
							<span class="ranking_image">
								<img src="images/book/book_img2.jpg" width="40" height="40">
							</span>
							<span class="ranking_infomation">
								<strong>마자용</strong>
								<em>도레미</em>
							</span>
							<a href="" class="ranking_link">
							
							</a>
						</li>
					</ol>
				</div>
				<!-- 베스트셀러 영역 콘텐츠 끝 -->
			</div>
				
		</section>
		<!-- 현재 페이지의 중간 오른쪽 박스 끝 -->
	</section>
	<!-- main_middle 끝 -->
</section>
<!-- 메인 끝 -->


<section style="position: relative; clear: both;"></section>


<!-- 여백의 미 시작 -->
<section style="width:900px; height: 1000px; margin:0px auto;">
<h1 style="position:relative; top:50%; left:50%;">
여백의 미
</h1>
</section>
<!-- 여백의 미 끝 -->






<!-- 사이드바 -->
<jsp:include page="/inc/sidebar.jsp"/>
<!-- 사이드바 끝 -->

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











