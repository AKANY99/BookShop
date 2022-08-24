<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<section class="sidebar">
	<!-- 리모콘 영역 시작 -->
	<section class="remote_area">
		<div class="remote_title" onclick="showSideSlides(1)">
			<a>최근 본 상품</a>
		</div>
		<!-- 최근 본 상품 -->
		<div class="remote_product" style="display: none;">
			<div class="remote_list">
				<ul>
					<li class="recent_product">
						<a href="#">
							<img src="images/book/book_img1.jpg">
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
							<img src="images/book/book_img2.jpg">
						</a>
						<span class="remote_info">
							<p class="product_title">
								<a href="">마요네즈</a>
							</p>
							<p class="product_price">9,900원</p>
						</span>
					</li>
					<li class="recent_product">
						<a href="">
							<img src="images/book/book_img3.jpg">
						</a>
						<span class="remote_info">
							<p class="product_title">
								<a href="">행잉 레그레이즈</a>
							</p>
							<p class="product_price">20,000원</p>
						</span>
					</li>
				</ul>
			</div>
			
		</div>
		<!-- 최근 본 상품 끝 -->
		<!-- 장바구니 -->
		<div class="remote_title" onclick="showSideSlides(2)">
			<a>장바구니</a>
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
		
	</section>
	<!-- 리모콘 영역 끝 -->
</section>
<script type="text/javascript" src="js/sidebar.js"></script>