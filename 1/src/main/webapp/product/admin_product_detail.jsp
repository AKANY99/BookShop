<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리 게시판</title>
<link href="css/admin_product_detail.css" rel="stylesheet" />
</head>
<body>
	<!-- 헤더부분 -->
	<jsp:include page="../inc/admin_header.jsp"></jsp:include>
	<!-- 헤더부분 -->
	
	<!-- 상품상세내용 -->
	<div id="wrapper_subject">상세정보</div>
	<div class="wrapper">
		<div class="product_info">
			<img src="upload/${product.pd_file }" align="left">
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
					남은 수량 : ${product.pd_quan }
					판매 수량 : ${product.pd_count }
				</div>
				<div class="product_cell product_price">
					가격 : ${product.pd_price }
				</div>
			</div>
		</div>
		<img src="upload/${product.pd_content }">
	</div>
	<!-- 상품상세내용 -->
	
	<!-- 오른쪽 고정 사이드바 -->
	<div>
		
	</div>
	<!-- 오른쪽 고정 사이드바 -->
	
	
</body>
</html>