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
							<td><input type="button" value="보기"></td>
					</c:when>
					<c:otherwise>
							<td>답변 대기</td>
							<td><input type="button" value="답변 달기"></td>
					</c:otherwise>
			</c:choose>
		</tr>
		</c:forEach>
</table>
</body>
</html>








