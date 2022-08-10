<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자용 QnA 리스트</title>
<link href="css/admin_qna_list.css" rel="stylesheet"/>
<script src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
$(function() {
	var qna_type = ${param.qna_type}
	if(qna_type){
		$.ajax({
			type:"get",
			url:"QnaGetList.ad?qna_type="+${param.qna_type}+"&order_by=DESC&qna_rep=repno",
			dataType:"text"
		}).done(function(data){
			$("#qna_search_result").html(response);
		}).fail(function(){
		alert("AJAX실패");
	});
	}
});



		$(function(){
			$("#search").on("click", function(){
			var formdata = $("form").serialize();
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
<jsp:include page="/inc/admin_header.jsp"/>

	<div class="qna_option">
		<div class="qna_option_subject">
			<h1>QnA관리</h1>
		</div>
		<form>
			<div class="qna_option_content">
					<div class="option_first">등록일</div>
					<div class="option_second">시작일 <input type="date"></div>
					<div class="option_third">종료일 <input type="date"></div>
					
					<div class="option_first">구분</div>
					<div class="option_second">
							답변대기<input type="radio" name="qna_rep" value ="repno" checked="checked">
							답변완료<input type="radio" name="qna_rep" value ="repok">
					</div>
					<div class="option_third"></div>
					
					<div class="option_first">분류</div>
					<div class="option_second">
							최신순<input type="radio" name="order_by" value ="DESC" checked="checked" >
							오래된순<input type="radio" name="order_by" value ="ASC"></div>
					<div class="option_third">
					</div>
					
					<div class="option_first">검색</div>
					<div class="option_second">
						<select name="qna_type">
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
		</form>
	</div>
	<div id="qna_search_result"><!-- AJAX로 출력할 QNA DB --></div>
	


	<div class="page"  style="text-align: center;">
		<c:choose>
			<c:when test="${pageInfo.pageNum > 1}">
				<input type="button" value="이전" onclick="location.href='QnaList.ad?pageNum=${pageInfo.pageNum - 1}'">
			</c:when>
			<c:otherwise>
				<input type="button" value="이전">
			</c:otherwise>
		</c:choose>
			
		<c:forEach var="i" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
			<c:choose>
				<c:when test="${pageInfo.pageNum eq i}">
					${i }
				</c:when>
				<c:otherwise>
					<a href="QnaList.ad?pageNum=${i }">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:choose>
			<c:when test="${pageInfo.pageNum < pageInfo.maxPage}">
				<input type="button" value="다음" onclick="location.href='QnaList.ad?pageNum=${pageInfo.pageNum + 1}'">
			</c:when>
			<c:otherwise>
				<input type="button" value="다음">
			</c:otherwise>
		</c:choose>
	</div>
	
</body>
</html>