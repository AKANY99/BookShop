<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<div id="result_subject">
		<p>주문상세내역</p>
	</div>
	<div class="search_result">
		<div id="table_subject">
			<div class="table_subject">도서번호</div>
			<div class="table_subject">도서표지</div>
			<div class="table_subject">도서명</div>
			<div class="table_subject">작가명</div>
			<div class="table_subject">재고수량</div>
			<div class="table_subject">상세관리</div>
		</div>
		<c:forEach var="order" items="${orderList }">
				<div id="table_content">
					<div class="table_content">${order.order_pd_num }</div>
					<div class="table_content"><img src="upload/${order.pd_file }" width="60" height="75"></div>
					<div class="table_content">${order.pd_subject }</div>
					<div class="table_content">${order.order_quan }</div>
					<div class="table_content">${order.order_pd_price }</div>
				</div>
			</c:forEach>
	</div>
	<!-- 주문상세내용 -->
	
	
</body>
</html>