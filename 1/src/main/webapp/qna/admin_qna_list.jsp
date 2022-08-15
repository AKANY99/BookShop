<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자용 QnA 리스트</title>
<link href="css/admin_qna_list.css" rel="stylesheet"/>

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
	
		$(function(){
			if("${param.qna_type}" == "상품"){
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
			else if("${param.qna_type}" == "일반"){
			$(".qna_type").val("일반").prop("selected",true);
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
		
		function pageMove(pageNum) {
			$("#qnaPageNum").val(pageNum);
			var formdata = $(".form_page").serialize();
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
			};
</script>
</head>
<body>
<jsp:include page="/inc/admin_header.jsp"/>

<!-- 파라미터가 상품일경우 넘겨줄 파라미터 정의 -->
	<form class="form_product">
		<input type="hidden" name="startDate">
		<input type="hidden" name="endDate">
		<input type="hidden" name="searchObject">
		<input type="hidden" name="qna_rep" value="repno">	
		<input type="hidden" name="order_by" value="ASC">	
		<input type="hidden" name="qna_type" value="상품">	
	</form>
<!-- ------------------------------ -->
<!-- 파라미터가 일반일경우 넘겨줄 파라미터 정의 -->
	<form class="form_normal">
		<input type="hidden" name="startDate">
		<input type="hidden" name="endDate">
		<input type="hidden" name="searchObject">
		<input type="hidden" name="qna_rep" value="repno">	
		<input type="hidden" name="order_by" value="ASC">	
		<input type="hidden" name="qna_type" value="일반">	
	</form>
<!-- ------------------------------ -->
<form class="form_search">
<p>QnA관리</p>
	<div class="qna_option">
		<div class="qna_option_subject">
		검색 조건
		</div>
			<div class="qna_option_content">
					<div class="option_first">등록일</div>
					<div class="option_second">시작일 <input type="text" id="datePicker1" name="startDate"></div>
					<div class="option_third">종료일 <input type="text" id="datePicker2" name="endDate"></div>
					
					<div class="option_first">구분</div>
					<div class="option_second">
							답변대기<input type="radio" name="qna_rep" value ="repno" checked="checked">
							답변완료<input type="radio" name="qna_rep" value ="repok">
					</div>
					<div class="option_third"></div>
					
					<div class="option_first">분류</div>
					<div class="option_second">
							오래된순<input type="radio" name="order_by" value ="ASC" checked="checked" >
							최신순<input type="radio" name="order_by" value ="DESC">
					</div>
					<div class="option_third">
					</div>
					
					<div class="option_first">검색</div>
					<div class="option_second">
						<select name="qna_type" class="qna_type">
							<option value="전체">전체</option>
							<option value="상품">상품</option>
							<option value="일반">일반</option>
							<option value="계정">계정</option>
						</select>
						 <input type="text" name="searchObject">
					</div>
					<div class="option_third"></div>
					<input type="button" value="찾기" id="search">
			</div>
	</div>
</form>
<form class="form_page">
	<div id="qna_search_result"><!-- AJAX로 출력할 QNA DB --></div>
</form>
	
</body>
</html>