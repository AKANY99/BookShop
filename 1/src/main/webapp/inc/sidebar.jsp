<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="sidebar">
	<!-- 리모콘 영역 시작 -->
	<section class="remote_area">
	
		
		<!-- 마이페이지 -->
		<div class="remote_title">
		<c:choose>
				<c:when test="${empty sessionScope.sId}">
					<!-- 로그인 상태가 아닐 시 로그인 페이지로 -->
					<a href="UserLogin.us">마이페이지</a>
					<!-- 로그인 상태가 아닐 시 로그인 페이지로 끝-->
				</c:when>
				<c:otherwise>
					<!-- 로그인 상태일 시 마이 페이지로 -->
					<a href="MyPage.us?sId=${sessionScope.sId}" class="tab">마이페이지</a>
					<!-- 로그인 상태일 시 마이 페이지로 -->
				</c:otherwise>
		</c:choose>
		</div>
		<!-- 마이페이지 끝 -->
		<!-- 장바구니 -->
		<div class="remote_title" onclick="showSideSlides(1)">
			<a>최근 본 상품</a>
		</div>
		<div class="remote_product" style="display: none;">
			<div class="remote_list">
				<ul>
					<li class="recent_product">
						<a href="">
							<img src="images/book/book_img4.jpg">
						</a>
						<span class="remote_info">
							<p class="product_title">
								<a href="">피지컬</a>
							</p>
							<p class="product_price">12,000원</p>
						</span>
					</li>
					<li class="recent_product">
						<a href="">
							<img src="images/book/book_img3.jpg">
						</a>
						<span class="remote_info">
							<p class="product_title">
								<a href="">피지컬</a>
							</p>
							<p class="product_price">12,000원</p>
						</span>
					</li>
				</ul>
			</div>
		</div>
		<!-- 장바구니 끝 -->
		<!-- 찜 -->
		<div class="remote_title">
			<c:choose>
				<c:when test="${empty sessionScope.sId}">
					<!-- 로그인 상태가 아닐 시 찜 목록 삭제 -->
					<!-- 로그인 상태가 아닐 시 찜 목록 삭제 끝-->
				</c:when>
				<c:otherwise>
					<!-- 로그인 상태일 시 찜 페이지로 -->
					<a href="MyInterest.us?sId=${sessionScope.sId }" class="tab">찜</a>
					<!-- 로그인 상태일 시 찜 페이지로 -->
				</c:otherwise>
			</c:choose>
		</div>
		<!-- 찜 끝 -->
		
	</section>
	<!-- 리모콘 영역 끝 -->
</section>
<script type="text/javascript" src="js/sidebar.js"></script>