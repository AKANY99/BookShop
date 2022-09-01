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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/header.css" rel="stylesheet">
<link href="css/user_my_interest.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/inc/header.jsp"/>

<section class="interest">
	<h1><img src="images/like_img.png" width="30px"> 찜 목록</h1>
	<hr>
		<c:choose>
			<c:when test="${empty list }">
				<h3 style="width: 900px; text-align: center; margin-top: 50px; margin-bottom: 50px;">찜 목록이 비었습니다</h3>
				<section style="position: relative; clear: both;"></section>
				<img alt="" src="images/shopping_icon.png" width="300px" style="margin: 0px 300px;">
				<section style="position: relative; clear: both;"></section>
			</c:when>
			<c:otherwise>
				<table class="jur">
					<tr class="text">
						<td width="120px">표지</td>
						<td width="240px">제목</td>
						<td width="160px">작가</td>
						<td width="160px">가격</td>
						<td width="220px"></td>
					</tr>
					<c:forEach var="list" items="${list }">
						<tr class="text">
							<td><a href="UserProductDetail.us?pd_num=${list.pd_num }"><img src="upload/${list.pd_file }" width="100" height="150"></a></td>
							<td><a href="UserProductDetail.us?pd_num=${list.pd_num }">${list.pd_subject }</a></td>
							<td>${list.pd_name }</td>
							<td>${list.pd_price }</td>
							<td>
							<div class="delete">
								<input type="button" name="deleteInterest" value="삭제" onclick="location.href='DeleteInterest.us?sId=<%=sId %>&pd_num=${list.pd_num }'">
							</div>
							</td>
						</tr>
					</c:forEach>
			</table>
			</c:otherwise>
		</c:choose>
</section>
<jsp:include page="/inc/footer.jsp"/>
</body>
</html>