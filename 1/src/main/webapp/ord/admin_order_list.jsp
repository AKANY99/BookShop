<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookShop_Admin</title>
<link href="css/admin_order_list.css" rel="stylesheet"/>
<link href="css/bootstrap-datepicker3.css" rel="stylesheet"/>
<link href="css/bootstrap-datepicker3.standalone.css" rel="stylesheet"/>
<script src="js/jquery-3.6.0.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="js/bootstrap-datepicker.kr.min.js"></script>
<script type='text/javascript'>
	$(function(){
		$('#datePicker1').datepicker({
			calendarWeeks: false,
			todayHighlight: true,
			autoclose: true,
			format: "yyyy-mm-dd",
			language: "kr"
		});
	});
	$(function(){
		$('#datePicker2').datepicker({
			calendarWeeks: false,
			todayHighlight: true,
			autoclose: true,
			format: "yyyy-mm-dd",
			language: "kr"
		});
	});
	
	$(function() {
		if("${param.order_status}" == "false") {
		var orderFalse_form = $(".orderFalse_form").serialize();
			$.ajax({
				type:"get",
				url:"OrderGetList.ad",
				data:orderFalse_form,
				dataType:"text",
			}).done(function(response) {
				$("#ord_search_result").html(response);
			}).fail(function () {
				alert("AJAX 실패");
			});
		} else if("${param.order_status}" == "all") {
			var all_form = $(".all_form").serialize();
			$.ajax({
				type:"get",
				url:"OrderGetList.ad",
				data:all_form,
				dataType: "text",
			}).done(function(response) {
				$("#ord_search_result").html(response);
			}).fail(function () {
				alert("AJAX 실패");
			});
		} else if("${param.order_status}" == "true") {
			var orderTrue_form = $(".orderTrue_form").serialize();
			$.ajax({
				type:"get",
				url:"OrderGetList.ad",
				data:orderTrue_form,
				dataType: "text",
			}).done(function(response) {
				$("#ord_search_result").html(response);
			}).fail(function () {
				alert("AJAX 실패");
			});
		}
		
		$(".search_submit").on("click", function() {
		var search_form = $(".search_form").serialize();
			$.ajax({
				type:"get",
				url:"OrderGetList.ad",
				data:search_form,
				dataType:"text",
			}).done(function(response) {
				$("#ord_search_result").html(response);
			}).fail(function () {
				alert("AJAX 실패");
			});
		});
	});
	
	function pageMove(pageNum) {
		$("#ordPageNum").val(pageNum);
		var form_page = $(".form_page").serialize();
		$.ajax({
			type:"get",
			url:"OrderGetList.ad",
			data: form_page,
			dataType:"text",
		}).done(function(response) {
				$("#ord_search_result").html(response);
		}).fail(function () {
				alert("AJAX 실패");
		});
	};
</script>

<body>




	<!-- order_status 이 all일 경우 넘겨줄 파라미터 -->
	<form class="all_form">
		<input type="hidden" name="start_date">
		<input type="hidden" name="end_date">
		<input type="hidden" name="min_price">
		<input type="hidden" name="max_price">
		<input type="hidden" name="order_status" value="all">
	</form>	
	<!-- order_status 이 all일 경우 넘겨줄 파라미터 -->
	
	<!-- order_status 가 true일 경우 넘겨줄 파라미터 -->
	<form class="orderTrue_form">
		<input type="hidden" name="start_date">
		<input type="hidden" name="end_date">
		<input type="hidden" name="min_price">
		<input type="hidden" name="max_price">
		<input type="hidden" name="order_status" value="true">
	</form>	
	<!-- order_status 이 true일 경우 넘겨줄 파라미터 -->
	
	<!-- order_status 가 false일 경우 넘겨줄 파라미터 -->
	<form class="orderFalse_form">
		<input type="hidden" name="start_date">
		<input type="hidden" name="end_date">
		<input type="hidden" name="min_price">
		<input type="hidden" name="max_price">
		<input type="hidden" name="order_status" value="false">
	</form>	
	<!-- order_status 이 false일 경우 넘겨줄 파라미터 -->
	
	<!-- 헤더 넣는 자리 -->
	<jsp:include page="/inc/admin_header.jsp"/>
	<!-- 헤더 넣는 자리 -->
	
	<!-- 검색란  -->
	<form class="search_form">
		<p>주문관리</p>
		<div id="search_div">
			<div class="product_search">
				<div class="search_requirement">
					검색조건
				</div>
				<div class="cell">
					<div id="req_subject">
						주문일
					</div>
					<div class="start_date">
						시작일
						<input type="text" id="datePicker1" name="start_date">
					</div>
					<div class="end_date">
						종료일
						<input type="text" id="datePicker2" name="end_date">
					</div>
				</div>
				
				<div class="cell">
					<div id="req_subject">
						금액
					</div>
					<div class="min_price">
						최소금액
						<input type="text" name="min_price">
					</div>
					<div class="max_price">
						최대금액
						<input type="text" name="max_price">
					</div>
				</div>
							
				<div class="cell">
					<div id="req_subject">
						상태
					</div>
					<input type="radio" name="order_status" value="all" class="status_select" checked="checked">전체&nbsp;&nbsp;
					<input type="radio" name="order_status" value="true" class="status_select">결제완료&nbsp;&nbsp;
					<input type="radio" name="order_status" value="false" class="status_select">결제취소&nbsp;&nbsp;
				</div>
				
				<div class="cell2">
					<input type="button" value="검색" class="search_submit">
				</div>
			</div>
		</div>
	</form>
	<!-- 검색란  -->
	
	<!-- 주문표시란 -->
	
		<div id="ord_search_result">
		<!-- AJAX로 결과표시 -->
		
		<!-- AJAX로 결과표시 -->
		</div>
	<!-- 주문표시란 -->
</body>
</html>