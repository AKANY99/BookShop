<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="css/admin_header.css" rel="stylesheet" />  
<link href="css/admin_side.css" rel="stylesheet"/>
<header>
	<!-- 사이드바 버튼 (JOA(조아)의 웹스토리 : 홈페이지 & 웹루션개발) 활용 -->
	<span style="font-size:20px;cursor:pointer" onclick="openNav()">&#9776; 메뉴</span>
	<!-- 사이드바 버튼 (JOA(조아)의 웹스토리 : 홈페이지 & 웹루션개발) 활용 -->
	
	<!-- 관리자화면 메인 -->
	<div class="top">
		<div class="header_cell">
			<!-- 로고 들어갈 자리 -->
			<a href="AdminPage.ad">
				<img alt="로고" src="images/logoN2.png" height="70px" width="70px">
			</a>
			<!-- 로고 들어갈 자리 -->
			
			<!-- 메인으로 / 로그아웃 들어갈 자리 -->
			<a href="./" class="to_main header_btn">메인으로</a>
			<a href="UserLogoutPro.us" class="admin_logout header_btn">로그아웃</a>
			<!-- 메인으로 / 로그아웃 들어갈 자리 -->
		</div>
	</div>
	<!-- 관리자화면 메인 -->
	
	<!-- 사이드바 메뉴 자리 (JOA(조아)의 웹스토리 : 홈페이지 & 웹루션개발) 활용 -->
	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<div>
			<a href="#">매출조회</a>
			<a href="#">주문내역</a>
			<a href="ProductList.ad?pageNum=1">상품관리</a>
			<a href="QnaList.ad?pageNum=1">고객문의</a>
			<a href="#">회원관리</a>
		</div>
	</div>
	<!-- 사이드바 메뉴 자리(JOA(조아)의 웹스토리 : 홈페이지 & 웹루션개발) 활용 -->
	
	<!-- 사이드바 자바스크립트(JOA(조아)의 웹스토리 : 홈페이지 & 웹루션개발) 활용 -->
	<script>
		function openNav() {
		  document.getElementById("mySidenav").style.width = "200px";
		}
		
		function closeNav() {
		  document.getElementById("mySidenav").style.width = "0";
		}
	</script>
	<!-- 메뉴 사이드바 자바스크립트(JOA(조아)의 웹스토리 : 홈페이지 & 웹루션개발) 활용 -->
</header>