<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리 게시판</title>
<link href="css/admin_order_detail.css" rel="stylesheet" />
<link href="css/admin_sidebar.css" rel="stylesheet" />

</head>
<body>
	<!-- 헤더부분 -->
	<jsp:include page="../inc/admin_header.jsp"></jsp:include>
	<!-- 헤더부분 -->
	
	<!-- 주문상세내용 -->
	<div id="wrapper_subject">주문상세내역</div>
	<div class="wrapper">
		<div class="product_info">
			
			<div class="product_desc">
				<div class="product_cell">
					도서번호 : ${product.pd_num }
					등록일 : ${product.pd_date }
				</div>
				<div class="product_cell">
					책 이름 : ${product.pd_subject } 
					작가 : ${product.pd_name }
				</div>
				<div class="product_cell">
					남은 수량 : ${product.pd_quan } 권
					판매 수량 : ${product.pd_count } 권
				</div>
				<div class="product_cell product_price">
					가격 : ${product.pd_price } 원
				</div>
			</div>
		</div>
		<!-- 오른쪽 고정 사이드바 -->
		<section id="sidebar_section">
			<div class="sidebar">
				<input type="button" value="111">
				<input type="button" value="222">
				<input type="button" value="333">
			</div>
		</section>
		<!-- 오른쪽 고정 사이드바 -->
	</div>
	<!-- 주문상세내용 -->
	
	
</body>
</html>