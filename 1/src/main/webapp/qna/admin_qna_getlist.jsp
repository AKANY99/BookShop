<%@page import="vo.QnaDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
		<tr>
			<th>No.</th>
			<th>상품 번호</th>
			<th>제목</th>
			<th>이름</th>
			<th>등록일</th>
			<th>상태</th>
			<th>관리</th>
		</tr>
<c:choose>
	<c:when test="${empty qnaList }">
		<tr>
			<th colspan="7">검색 결과가 없습니다.</th>
		</tr>			
	</c:when>
	<c:otherwise>
		<c:forEach var="qnaList" items="${qnaList }">
			<tr>
				<td>${qnaList.qna_num }</td>
				<td>${qnaList.qna_pd_num }</td>
				<td>${qnaList.qna_subject }</td>
				<td>${qnaList.qna_user }</td>
				<td>${qnaList.qna_date }</td>
			<c:choose>
				<c:when test="${not empty qnaList.qna_rep }">
					<td>답변 완료</td>
					<td><input type="button" value="보기" onclick="window.open('Qnarep.ad?qna_num=${qnaList.qna_num }','repok','width=1000px, height=500px');"></td>
				</c:when>
				<c:otherwise>
					<td>답변 대기</td>
					<td><input type="button" value="답변 달기"onclick="window.open('Qnarep.ad?qna_num=${qnaList.qna_num }','repok','width=1000px, height=500px');"></td>
				</c:otherwise>
			</c:choose>
			</tr>
		</c:forEach>
	</c:otherwise>
</c:choose>
</table>

<div class="page"  style="text-align: center;">
		<c:choose>
			<c:when test="${qnaPageInfo.pageNum > 1}">
				<input type="button" value="이전" onclick="location.href='QnaList.ad?qnaPageNum=${qnaPageInfo.pageNum - 1}'">
			</c:when>
			<c:otherwise>
				<input type="button" value="이전">
			</c:otherwise>
		</c:choose>	
			
		<c:forEach var="i" begin="${qnaPageInfo.startPage }" end="${qnaPageInfo.endPage }">
			<c:choose>
				<c:when test="${qnaPageInfo.pageNum eq i}">
					${i }
				</c:when>
				<c:otherwise>
					<a href="?qnaPageNum=${i }">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:choose>
			<c:when test="${qnaPageInfo.pageNum < qnaPageInfo.maxPage}">
				<input type="button" value="다음" onclick="location.href='?qnaPageNum=${qnaPageInfo.pageNum + 1}'">
			</c:when>
			<c:otherwise>
				<input type="button" value="다음">
			</c:otherwise>
		</c:choose>
	</div>
<input type="hidden" name="qnaPageNum" value="${qnaPageInfo.pageNum }">
</body>
</html>








