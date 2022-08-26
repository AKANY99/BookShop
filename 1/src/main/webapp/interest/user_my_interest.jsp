<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String sId = request.getParameter("sId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>[찜 목록]</h1>
	<hr>
		<c:choose>
			<c:when test="${empty list }">
				<h3>찜목록이 비었습니다</h3>
			</c:when>
			<c:otherwise>
				<table border="1">
					<tr>
						<td>표지</td>
						<td>제목</td>
						<td>작가</td>
						<td>가격</td>
						<td></td>
					</tr>
					<c:forEach var="list" items="${list }">
						<tr>
							<td><a href="UserProductDetail.us?pd_num=${list.pd_num }"><img src="upload/${list.pd_file }" width="100" height="150"></a></td>
							<td><a href="UserProductDetail.us?pd_num=${list.pd_num }">${list.pd_subject }</a></td>
							<td>${list.pd_name }</td>
							<td>${list.pd_price }</td>
							<td>
							<input type="button" name="deleteInterest" value="삭제" onclick="location.href='DeleteInterest.us?sId=<%=sId %>&pd_num=${list.pd_num }'">
							</td>
						</tr>
					</c:forEach>
			</table>
			</c:otherwise>
		</c:choose>

</body>
</html>