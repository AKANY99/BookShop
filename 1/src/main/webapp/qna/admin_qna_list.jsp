<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookShop_Admin</title>
<link href="css/admin_qna_list.css" rel="stylesheet"/>
<script src="../js/jquery-3.6.0.js"></script>
<script type="text/javascript">
// 		$(function(){
// 			$("#id").on("change", function(){
// 				$.ajax({
// 					type:"post",
// 					url:"admin_getqna_list.jsp",
// 					data: {id: $("#id").val()},
// 					dataType:"text",
// 					success: function(response) {
// 						$("#checkIdResult").html(response);
// 					}
					
// 				});
// 			});
// 		});
</script>

</head>
<body>
<jsp:include page="/inc/admin_header.jsp"/>

	<div class="qna_option">
		<div class="qna_option_subject">
			<h1>QnA관리</h1>
		</div>
			<div class="qna_option_content">
					<div class="option_first">등록일</div>
					<div class="option_second">시작일 <input type="date"></div>
					<div class="option_third">종료일 <input type="date"></div>
					
					<div class="option_first">구분</div>
					<div class="option_second"><input type="button" value="답변대기"> <input type="button" value="답변완료"></div>
					<div class="option_third"></div>
					
					<div class="option_first">분류</div>
					<div class="option_second"></div>
					<div class="option_third"></div>
					
					<div class="option_first">검색</div>
					<div class="option_second"></div>
					<div class="option_third"></div>
			</div>
	</div>
	
	<div class="qna_content"><!-- AJAX로 출력할 QNA DB --></div>
	


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