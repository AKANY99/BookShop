<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리 게시판</title>
<link href="css/admin_product_detail.css" rel="stylesheet" />
<link href="css/admin_sidebar.css" rel="stylesheet" />
<script type="text/javascript">
	function deleteProduct() {
		var checkDelete = confirm("정말로 삭제하시겠습니까?");
		if(checkDelete == true) {
			location.href="ProductDelete.ad?pd_num=${param.pd_num}";
		}
	}
</script>
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
					도서번호
					<em title="${product.pd_num }">${product.pd_num }</em>
				</div>
				<div class="product_cell">
					등록일
					<em title="${product.pd_date }">${product.pd_date }</em>
				</div>
				<div class="product_title">
					책 이름
					<em title="${product.pd_subject }">${product.pd_subject }</em>
				</div>
				<div class="product_cell">
					작가
					<em title="${product.pd_name }" >${product.pd_name }</em>
				</div>
				<div class="product_cell">
					남은 수량
					<em title="${product.pd_quan }">${product.pd_quan } 권</em>
				</div>
				<div class="product_cell">
					판매 수량
					<em title="${product.pd_count }">${product.pd_count } 권</em>
				</div>
				<div class="product_cell product_price">
					가격
					<em title="${product.pd_price }">${product.pd_price } 원</em>
				</div>
			</div>
		</div>
		<img src="upload/${product.pd_content }">
		<!-- 오른쪽 고정 사이드바 -->
		<section id="sidebar_section">
			<div class="sidebar">
				<input type="button" value="상품목록" onclick="location.href='ProductList.ad?pd_quan=all'">
				<input type="button" value="상품수정" onclick="location.href='ProductUpdate.ad?pageNum=${param.pageNum }&pd_num=${param.pd_num}'">
				<input type="button" value="상품삭제" onclick="deleteProduct()">
			</div>
		</section>
		<!-- 오른쪽 고정 사이드바 -->
	</div>
	<!-- 상품상세내용 -->
	
	
</body>
</html>