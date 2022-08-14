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
<script src="js/jquery.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="js/bootstrap-datepicker.kr.min.js"></script>
<script src="js/jquery-3.6.0.js"></script>
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
	
	$(function(){
		if("${param.pd_type}" == ""){
		var productform = $(".form_product").serialize();
			$.ajax({
				type:"get",
				url:"QnaGetList.ad",
				data: productform,
				dataType:"text",
			}).done(function(response) {
					$("#qna_search_result").html(response);
			}).fail(function () {
					alert("AJAX 실패");
			});
		}
		else if("${param.pd_type}" == ""){
		var normalform = $(".form_normal").serialize();
			$.ajax({
				type:"get",
				url:"QnaGetList.ad",
				data: normalform,
				dataType:"text",
			}).done(function(response) {
					$("#qna_search_result").html(response);
			}).fail(function () {
					alert("AJAX 실패");
			});
		}
		
		
		
		$("#search").on("click", function(){
		var formdata = $(".form_search").serialize();
			$.ajax({
				type:"get",
				url:"QnaGetList.ad",
				data: formdata,
				dataType:"text",
			}).done(function(response) {
					$("#qna_search_result").html(response);
			}).fail(function () {
					alert("AJAX 실패");
				});
			});
		});
</script>

	
</head>
<body>
	<!-- 헤더 넣는 자리 -->
	<jsp:include page="/inc/admin_header.jsp"/>
	<!-- 헤더 넣는 자리 -->
	
	<!-- 검색란  -->
		<p>상품관리</p>
		<div class="product_seach">
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
					타입
				</div>
				<input type="radio" name="pd_subject" value="전체" class="type_select">전체&nbsp;&nbsp;
				<input type="radio" name="pd_subject" value="국내도서" class="type_select">국내도서&nbsp;&nbsp;
				<input type="radio" name="pd_subject" value="해외도서" class="type_select">해외도서&nbsp;&nbsp;
				<input type="radio" name="pd_subject" value="eBook" class="type_select">eBook&nbsp;&nbsp;
			</div>
			
			<div class="cell">
				<div id="req_subject">
					검색
				</div>
				<input type="text" class="search_input">
			</div>
			<hr>
			<div class="cell2">
				<input type="button" value="검색" class="search_submit">
			</div>
		</div>
	<!-- 검색란  -->
	
	<!-- 상품표시란 -->
	<div id="pd_search_result">
		<!-- AJAX로 검색결과표시 -->
		
		<!-- AJAX로 검색결과표시 -->
	</div>
	<!-- 상품표시란 -->
</body>
</html>