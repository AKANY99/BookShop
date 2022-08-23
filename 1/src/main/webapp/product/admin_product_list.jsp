<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookShop_Admin</title>
<link href="css/admin_product_list.css" rel="stylesheet"/>
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
		if("${param.pd_quan}" == "false") {
		var soldOut_form = $(".soldOut_form").serialize();
			$.ajax({
				type:"get",
				url:"ProductGetList.ad",
				data:soldOut_form,
				dataType:"text",
			}).done(function(response) {
				$("#pd_search_result").html(response);
			}).fail(function () {
				alert("AJAX 실패");
			});
		} else if("${param.pd_quan}" == "all") {
			var all_form = $(".all_form").serialize();
			$.ajax({
				type:"get",
				url:"ProductGetList.ad",
				data:all_form,
				dataType: "text",
			}).done(function(response) {
				$("#pd_search_result").html(response);
			}).fail(function () {
				alert("AJAX 실패");
			});
		}
		
		$(".search_submit").on("click", function() {
		var search_form = $(".search_form").serialize();
			$.ajax({
				type:"get",
				url:"ProductGetList.ad",
				data:search_form,
				dataType:"text",
			}).done(function(response) {
				$("#pd_search_result").html(response);
			}).fail(function () {
				alert("AJAX 실패");
			});
		});
		
	});
	function pageMove(pageNum) {
		$("#pdPageNum").val(pageNum);
		var form_page = $(".form_page").serialize();
		$.ajax({
			type:"get",
			url:"ProductGetList.ad",
			data: form_page,
			dataType:"text",
		}).done(function(response) {
				$("#pd_search_result").html(response);
		}).fail(function () {
				alert("AJAX 실패");
		});
	};
	
</script>

<body>




	<!-- pd_quan 이 "전체"일 경우 넘겨줄 파라미터 -->
	<form class="all_form">
		<input type="hidden" name="start_date">
		<input type="hidden" name="end_date">
		<input type="hidden" name="pd_quan" value="all">
		<input type="hidden" name="pd_type" value="all">
		<input type="hidden" name="search_input">
	</form>	
	<!-- pd_quan 이 "전체"일 경우 넘겨줄 파라미터 -->
	
	<!-- pd_quan 이 "품절"일 경우 넘겨줄 파라미터 -->
	<form class="soldOut_form">
		<input type="hidden" name="start_date">
		<input type="hidden" name="end_date">
		<input type="hidden" name="pd_quan" value="false">
		<input type="hidden" name="pd_type" value="all">
		<input type="hidden" name="search_input">
	</form>	
	<!-- pd_quan 이 "품절"일 경우 넘겨줄 파라미터 -->
	
	<!-- 헤더 넣는 자리 -->
	<jsp:include page="/inc/admin_header.jsp"/>
	<!-- 헤더 넣는 자리 -->
	
	<!-- 검색란  -->
	<form class="search_form">
		<p>상품관리</p>
		<div class="product_search">
			<div class="search_requirement">
				검색조건
			</div>
			<div class="cell">
				<div id="req_subject">
					등록일
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
					상태
				</div>
				<input type="radio" name="pd_quan" value="all" class="type_select" checked="checked">전체&nbsp;&nbsp;
				<input type="radio" name="pd_quan" value="true" class="type_select">재고있음&nbsp;&nbsp;
				<input type="radio" name="pd_quan" value="false" class="type_select">품절&nbsp;&nbsp;
			</div>
			
			<div class="cell">
				<div id="req_subject">
					타입
				</div>
				<input type="radio" name="pd_type" value="all" class="type_select" checked="checked">전체&nbsp;&nbsp;
				<input type="radio" name="pd_type" value="domestic" class="type_select">국내도서&nbsp;&nbsp;
				<input type="radio" name="pd_type" value="overseas" class="type_select">해외도서&nbsp;&nbsp;
				<input type="radio" name="pd_type" value="eBook" class="type_select">eBook&nbsp;&nbsp;
			</div>
			
			<div class="cell">
				<div id="req_subject">
					검색
				</div>
				<input type="text" class="search_input" name="search_input">
			</div>
			<hr>
			<div class="cell2">
				<input type="button" value="검색" class="search_submit">
			</div>
		</div>
	</form>
	<!-- 검색란  -->
	
	<!-- 상품표시란 -->
	
		<div id="pd_search_result">
		<!-- AJAX로 검색결과표시 -->
		
		<!-- AJAX로 검색결과표시 -->
		</div>
	<!-- 상품표시란 -->
</body>
</html>