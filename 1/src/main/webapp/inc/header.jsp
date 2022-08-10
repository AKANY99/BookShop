<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <html>태그 없이 header만 넣음(include할 jsp이기 때문) -->
<header>
	<!-- 헤더 위에 부분 -->
	<section class="header_top">
	<nav>
	<c:choose>
	<c:when test="${empty sessionScope.sId}">
	<ul>
		<li><a href="UserLogin.us">로그인</a></li>
		<li>|</li>
		<li><a href="UserJoinForm.us">회원가입</a></li>
	</ul>
	</c:when>
	<c:otherwise>
		<c:choose>
		<c:when test="${sessionScope.sId eq 'admin'}">
		<ul>
			<li>관리자 님</li>
			<li>|</li>
			<li><a href="AdminPage.ad">관리자 페이지</a></li>
			<li>|</li>
			<li><a href="UserLogoutPro.us">로그아웃</a></li>
		</ul>
		</c:when>
		<c:otherwise>
		<ul>
			<li>${sessionScope.sId } 님</li>
			<li>|</li>
			<li><a href="UserMyPage.us">마이페이지</a></li>
			<li>|</li>
			<li><a href="UserLogoutPro.us">로그아웃</a></li>
		</ul>
		</c:otherwise>
		</c:choose>
	</c:otherwise>
	</c:choose>
	</nav>
	</section>
	<!-- 헤더 위에 부분 끝-->
	
	
	<!-- 헤더 중간 부분 -->
	<section class="header_mid">
	<nav>
		<ul>
			<li><a href=""><img alt="로고" src="images/logoN2.png"  style="height: 120px"></a></li>
			<li>
			<div class="serch_area">
			<form action="Search.bo" method="post">
			    <input type="text" class="serch_input" placeholder="Search.." name="search">
			    <button type="submit" class="serch_submit"><i class="fa fa-search"></i></button>
		    </form>
		    </div>
			</li>
			<c:choose>
			<c:when test="${empty sessionScope.sId}">
			<li>
			<form action="UserLoginPro.us" method="post" class="login_form">
			<table>
			<tr>
				<td>
				<input type="text" name="user_email" placeholder="ID"><br>
				<input type="password" name="user_passwd" placeholder="PASS">
				</td>
				<td>
					<input type="submit" value="로그인">
				</td>
			</tr>
			</table>
		    </form>
		    </li>
		    </c:when>
		    <c:otherwise>
		    <li>
			<form action="UserLoginPro.us" method="post" class="login_form">
			<table>
			<tr>
				<td>
					<h1>${sessionScope.sId } 님</h1>
				</td>
				<td>
					<img alt="회원모양" src="images/humanShadow.png" height="50px">
				</td>
			</tr>
			</table>
		    </form>
		    </li>
		    </c:otherwise>
		    </c:choose>
		</ul>
	</nav>
	</section>
	<!-- 헤더 중간 부분 끝 -->
	
	<!-- 헤더 밑 부분 -->
	<section class="header_bot">
	<nav>
		<ul>
			<li><a href="ProductList.us">전체 상품조회</a></li>
			<li><a href="QnaList.us">고객센터(임시)</a></li>
			<li><a href="">메뉴3</a></li>
			<li><a href="">메뉴4</a></li>
		</ul>
	</nav>
	</section>
	<!-- 헤더 밑 부분 끝 -->
</header>