<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
</head>
<body>
	<h1>회원관리게시판</h1>
	<hr>
	<table border="1" align="center">
		<tr id="tr_top">
			<td>유저 번호</td>
			<td>유저 이름</td>
			<td>유저 이메일</td>
			<td>유저 비밀번호</td>
			<td>유저 성별</td>
			<td>유저 주민번호</td>
			<td>유저 우편번호</td>
			<td>유저 주소</td>
			<td>유저 전화번호</td>
		</tr>
		<c:forEach var="userList" items="${userList }">
			<tr>
				<td>${userList.user_num }</td>
				<td><a href="UserDetail.ad?user_num=${userList.user_num }&pageNum=${param.pageNum }">${userList.user_name }</a></td>
				<td>${userList.user_email }</td>
				<td>${userList.user_passwd }</td>
				<td>${userList.user_gender }</td>
				<td>${userList.user_jumin }</td>
				<td>${userList.user_address_code }</td>
				<td>${userList.user_address }</td>
				<td>${userList.user_phone }</td>
			</tr>
		</c:forEach>
	</table>
	<section align="center">
		<c:choose>
			<c:when test="${param.pageNum > 1}">
				<input type="button" value="이전" onclick="location.href='UserList.ad?pageNum=${pageInfo.pageNum - 1}'">
			</c:when>
			<c:otherwise>
				<input type="button" value="이전">
			</c:otherwise>
		</c:choose>
			
		<c:forEach var="i" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
			<c:choose>
				<c:when test="${param.pageNum eq i}">
					${i }
				</c:when>
				<c:otherwise>
					<a href="UserList.ad?page=${i }">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:choose>
			<c:when test="${param.pageNum < pageInfo.maxPage}">
				<input type="button" value="다음" onclick="location.href='UserList.ad?pageNum=${param.pageNum + 1}'">
			</c:when>
			<c:otherwise>
				<input type="button" value="다음">
			</c:otherwise>
		</c:choose>
	</section>
</body>
</html>