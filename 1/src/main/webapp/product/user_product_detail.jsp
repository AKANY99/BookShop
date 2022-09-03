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
<link href="css/user_product_etc.css" rel="stylesheet">
<link href="css/productDetail.css" rel="stylesheet">
<script src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
function quanCount(){
	let quanVal = document.querySelector(".quanInput");
	// 입력된 값이 빈칸 이라면
	if(isNaN(parseInt(quanVal.value))){
		alert("값은 하나이상 입력하셔야 합니다.")
		quanVal.value = parseInt(1);
		return;
	}
	// 입력된 값이 0이하라면 1로 초기화
	if(parseInt(quanVal.value) < 1){
		alert("값은 하나이상 입력하셔야 합니다.")
		quanVal.value = parseInt(1);
	}
	// 입력된 값이 재고 이상이라면 재고수량으로 초기화
	if(quanVal.value > ${product.pd_quan}){
		alert("재고 이상으로 선택할수 없습니다.")
		quanVal.value = parseInt(${product.pd_quan});
		return;
	}
	
	quanVal.value = quanVal.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');
}

function quanPlus(current){
	let quanVal = document.querySelector(".quanInput");
	// 값이 하나 이상 없을 시 0으로 초기화
	if(isNaN(parseInt(quanVal.value))){
		quanVal.value = parseInt(0);
	}
	
	// 입력된 값 더함
	quanVal.value = parseInt(quanVal.value) +  parseInt(current);
	// 입력된 값이 0이하라면 1로 초기화
	if(parseInt(quanVal.value) < 1){
		quanVal.value = parseInt(1);
	}
	// 입력된 값이 재고 이상이라면 재고수량으로 초기화
	if(quanVal.value > ${product.pd_quan}){
		quanVal.value = parseInt(${product.pd_quan});
		return;
	}
}
</script>
</head>
<body>
<!-- 헤더 a -->
<jsp:include page="/inc/header.jsp"/>
<!-- 헤더 끝 -->

<!-- 상품 조회 시작 -->
<section class="productDetail">
	<h1><img src="images/product_img.png"></h1>
	
	<section class="productContentDetail">
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
				평점
				<div class="wrap-star">
				    <div class='star-rating'>
				        <span style ="width:${product.avg_score*10 }%"></span>
				    </div>
				</div>
				
			</div>
			<div class="productPrice">
				가격
				<em>${product.pd_price }원</em>
			</div>
			<!-- 수량 및 버튼 -->
			<form action="">
			<input type="hidden" name="pd_num" value=${product.pd_num }>
			<input type="hidden" name="sId" value=<%=sId %>>
				<div class="productQuan">
					판매중
					<c:choose>
						<c:when test="${sId eq 'admin'}">
							<div>
								<c:choose>
									<c:when test="${product.pd_quan gt 0 }">
										<h5>[남은재고 : ${product.pd_quan }]</h5>
									</c:when>
									<c:otherwise>
										<h5 style="color:red;">[품절]</h5>
									</c:otherwise>
								</c:choose>
							</div>
						</c:when>
						<c:when test="${empty sId}">
							<div>
								<!-- 수량 선택 -->
								<div class="productQuanButton">
									<span class="quanText">수량</span>
									<input type="button" value="-" class="quanButton" onclick="quanPlus(-1)">
									<input type="text" name="quantity" value="1" class="quanInput" maxlength="4" onkeyup="quanCount()" onchange="quanCount()">
									<input type="button" value="+" class="quanButton" onclick="quanPlus(1)">
								</div>
								<!-- 수량 선택 끝 -->
								<c:choose>
									<c:when test="${product.pd_quan gt 0 }">
										<h5>[남은재고 : ${product.pd_quan }]</h5><br>
										<div class="productButton">
											<input type="submit" value="비회원으로구매하기" formaction="">
										</div>
									</c:when>
									<c:otherwise>
										<h5 style="color:red;">[품절]</h5><br>
										<div class="productButton">
											<input type="submit" disabled="disabled" value="비회원으로구매하기" formaction="">
										</div>
									</c:otherwise>
								</c:choose>
								<br>
							</div>
						</c:when>
						<c:otherwise>
							<div>
								<c:choose>
									<c:when test="${product.pd_quan gt 0 }">
										<!-- 수량 선택 -->
										<div class="productQuanButton">
											<span class="quanText">수량</span>
											<input type="button" value="-" class="quanButton" onclick="quanPlus(-1)">
											<input type="text" name="quantity" value="1" class="quanInput" maxlength="4" onkeyup="quanCount()" onchange="quanCount()">
											<input type="button" value="+" class="quanButton" onclick="quanPlus(1)">
										</div>
										<!-- 수량 선택 끝 -->
										<h5>[남은재고 : ${product.pd_quan }]</h5>
										<br>
										<div class="productButton">
											<input type="submit" value="바로구매" formaction="CartToPayment.us">
											<input type="submit" value="장바구니" formaction="CartOn.us">
											<input type="submit" value="찜하기" formaction="InterestOn.us">
										</div>
									</c:when>
									<c:otherwise>
										<!-- 수량 선택 -->
										<div class="productQuanButton">
											<span class="quanText">수량</span>
											<input type="button" value="-" disabled="disabled" class="quanButton" onclick="quanPlus(-1)">
											<input type="text" name="quantity" value="1" class="quanInput" maxlength="4" onkeyup="quanCount()"onchange="quanCount()">
											<input type="button" value="+" disabled="disabled" class="quanButton" onclick="quanPlus(1)">
										</div>
										<!-- 수량 선택 끝 -->
										<h5 style="color:red;">[품절]</h5>
										<br>
										<div class="productButton">
											<input type="submit" value="바로구매" formaction="CartToPayment.us">
											<input type="submit" value="장바구니" formaction="CartOn.us">
											<input type="submit" value="찜하기" formaction="InterestOn.us">
										</div>
									</c:otherwise>
								</c:choose>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</form>
			<!-- 수량 및 버튼 끝 -->
		</section>
	</section>
	<section class="productContentImg">
		<img src="upload/${product.pd_content }">
	</section>
	
	<jsp:include page="/inc/user_product_etc.jsp"/>
	

	<section class="reviewSection">
		<h3>별점 및 리뷰</h3>
		<br>
		<section class="reviewListSection">
			<c:forEach var="reviewList" items="${reviewList }">
			<table>
				<tr>
					<td class="title">${reviewList.review_subject }</td>
				</tr>
				<tr>
					<td>
						<div class="wrap-star_review">
						    <div class='star-rating_review'>
						        <span style ="width:${reviewList.review_score*10 }%"></span>
						    </div>
						</div>
						<em>|</em> ${reviewList.user_name } 
						<em>|</em> ${reviewList.review_date }
					</td>
				</tr>
				<tr>
					<td> ${reviewList.review_content }</td>
				</tr>
			</table> 
			<br>
			</c:forEach>
			<c:if test="${empty reviewList}">
				<h2>아직 리뷰가 없습니다</h2>
			</c:if>
		</section>
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