<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <html>태그 없이 header만 넣음(include할 jsp이기 때문) -->
<header>
	
	<!-- 헤더 중간 부분 a -->
	<section class="header_mid">
	<nav>
		<ul>
			<li><a href=""><img alt="로고" src="images/BookShopLogo2.png"  style="width: 200px"></a></li>
			<li>
			<div class="serch_area">
			<form action="Search.bo" method="post">
			    <input type="text" class="serch_input" placeholder="Search.." name="search">
			    <button type="submit" class="serch_submit"><i class="fa fa-search"></i></button>
		    </form>
		    </div>
			</li>
			
			<!-- 로그인 버튼 회원가입 버튼 부분 & 로그인 시 로그인 폼 -->
			<c:choose>
				<c:when test="${empty sessionScope.sId}">
					<!-- 유저 로그인 안되어 있을 시, 로그인과 회원가입 a태그-->
					<li class="logoff">
						<div>
							<a href="UserLogin.us"><img src="images/login.png" width="100" height="100"></a>
							<a href="UserTerms.us"><img src="images/join.png" width="100" height="100"></a>
						</div>
					</li>
					<!-- 유저 로그인 안되어 있을 시 끝-->
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${sessionScope.sId eq 'admin'}">
							<!-- 관리자 로그인 일 시 -->
							<li class="user_area">
								<div class="info_area">
									<!--  로그아웃 하이퍼링크 -->
									<a href="UserLogoutPro.us" class="btn_logout">로그아웃</a>
									<!-- 사용자 아이콘 -->
									<a href="" class="user_thumb"><img alt="" src="images/myInfo.gif" width="56" height="56"></a>
									<!-- 유저 ID, 이메일, 등등 -->
									<div class="user_info">
										<a href="" class="id">${sessionScope.sName}</a>
										<div class="email">${sessionScope.sId}</div>
									</div>
								</div>
								<div class="tab_area">
									<div class="tab_box">
										<a href="./AdminPage.ad" class="tab">관리자페이지</a>
										<a href="" class="tab">메뉴1</a>
										<a href="" class="tab">메뉴2</a>
										<a href="" class="tab">메뉴3</a>
									</div>
								</div>
							</li>
							<!-- 관리자 로그인 일 시 끝 -->
						</c:when>
						<c:otherwise>
							<!-- 유저 로그인 일 시 -->
							<li class="user_area">
								<div class="info_area">
									<!--  로그아웃 하이퍼링크 -->
									<a href="UserLogoutPro.us" class="btn_logout">로그아웃</a>
									<!-- 사용자 아이콘 -->
									<a href="" class="user_thumb"><img alt="" src="images/myInfo.gif" width="56" height="56"></a>
									<!-- 유저 ID, 이메일, 등등 -->
									<div class="user_info">
										<a href="" class="id">${sessionScope.sName}</a><br>
										<div class="email">${sessionScope.sId}</div>
									</div>
								</div>
								<div class="tab_area">
									<div class="tab_box">
										<a href="MyPage.us?sId=${sessionScope.sId}" class="tab">마이페이지</a>
										<a href="" class="tab">메뉴1</a>
										<a href="" class="tab">메뉴2</a>
										<a href="" class="tab">메뉴3</a>
									</div>
								</div>
							</li>
							<!-- 유저 로그인 일 시 끝 -->
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
			<!-- 로그인 버튼 회원가입 버튼 부분 & 로그인 시 로그인 폼 끝 -->
		</ul>
	</nav>
	</section>
	<!-- 헤더 중간 부분 끝 -->
	
	<!-- 헤더 밑 부분 -->
	<section class="header_bot">
	<nav>
		<ul>
			<li><a href="ProductList.po">전체 상품조회</a></li>
			<li><a href="">메뉴2</a></li>
			<li><a href="">메뉴3</a></li>
			<li><a href="">메뉴4</a></li>
		</ul>
	</nav>
	</section>
	<!-- 헤더 밑 부분 끝 -->
</header>