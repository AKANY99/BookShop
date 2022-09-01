<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
String sId = (String)session.getAttribute("sId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품게시판</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/header.css" rel="stylesheet">
<link href="css/sidebar.css" rel="stylesheet">
<link href="css/productDetail.css" rel="stylesheet">
<script src="js/productDetail.js" type="text/javascript"></script>
</head>
<body>
<!-- 헤더 a -->
<jsp:include page="/inc/header.jsp"/>
<!-- 헤더 끝 -->


<!-- 상품 조회 시작 -->
<section class="productDetail">
	<h1>사용자 상품 상세 조회</h1>
	<section class="productImg">
		<img src="upload/${product.pd_file }">
	</section>
	<section class="productInfo">
		<div class="productTitle">
			책 제목
			<h1>${product.pd_subject }</h1>
		</div>
		<div class="productName">
			지은이 (작가명)
			<em>${product.pd_name }</em>
		</div>
		<div class="productType">
			분류
			<em>${product.pd_type }</em>
		</div>
		<div class="productContent">
			<em></em>
		</div>
		<div class="productPrice">
			가격
			<em>${product.pd_price }원</em>
		</div>
		<!-- 수량 및 버튼 -->
		<form action="">
			<div class="productQuan">
				판매중
				<div class="productQuanButton">
					<span class="quanText">수량</span>
					<input type="button" value="-" class="quanButton" onclick="quanPlus(-1)">
					<input type="text" name="quantity" value="1" class="quanInput" maxlength="4" onkeyup="quanCount()"onchange="quanCount()">
					<input type="button" value="+" class="quanButton" onclick="quanPlus(1)">
				</div>
			</div>
			<div class="productButton">
				
				<input type="hidden" name="pd_num" value="${product.pd_num }">
				<input type="hidden" name="sId" value="<%=sId %>">
					<input type="submit" value="바로구매" formaction="CartToPayment.us">
					<input type="submit" value="장바구니" formaction="CartOn.us">
					<input type="submit" value="찜하기" formaction="InterestOn.us">
			</div>
		</form>
		<!-- 수량 및 버튼 끝 -->
	</section>
	
	<section class="productContentImg">
		<img src="upload/${product.pd_content }">
	</section>
</section>
<!-- 상품 조회 시작 끝 -->
 
<section style="position: relative; clear: both;"></section>


<!-- 사이드바 -->
<jsp:include page="/inc/sidebar.jsp"/>
<!-- 사이드바 끝 -->

<section style="position: relative; clear: both;"></section>

<!-- 푸터 -->
<jsp:include page="/inc/footer.jsp"/>
<!-- 푸터 -->

</body>
</html>