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
</head>
<body>
	<jsp:include page="/inc/header.jsp"/>
	<h1 align="center"></h1>
	<hr>

		
		<c:choose>
		
			<c:when test="${empty list }">
				<h3>장바구니가 비었습니다</h3>
			</c:when>
			
			<c:otherwise>
			
				<table border="1">
					<tr>
						<td>표지</td>
						<td>제목</td>
						<td>작가</td>
						<td>가격</td>
						<td>수량</td>
						<td></td>
					</tr>
					<c:set var="totalPrice" value="0" />
					<c:forEach var="list" items="${list }">
						<tr>
							<td><a href="UserProductDetail.us?pd_num=${list.pd_num }"><img src="upload/${list.pd_file }" width="100" height="150"></a></td>
							<td><a href="UserProductDetail.us?pd_num=${list.pd_num }">${list.pd_subject }</a></td>
							<td>${list.pd_name }</td>
							<td>${list.pd_price }</td>
							<td>
								<select id="quan" onchange="location.href='CartQuanChange.us?sId=<%=sId %>&pd_num=${list.pd_num }&quan=' + this.value ">
									<c:forEach var="i" begin="1" end="99" step="1">
										<c:choose>
											<c:when test="${i eq list.cart_pd_quan }">
												<option selected="selected" value="${i }">${i }</option>
											</c:when>
											<c:otherwise>
												<option value="${i }">${i }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>	
								</select>
							</td>
							<td>
								<input type="button" name="delete" value="삭제" onclick="location.href='DeleteCart.us?sId=<%=sId %>&pd_num=${list.pd_num }'">
							</td>
							<c:set var="totalPrice" value="${totalPrice + (list.pd_price * list.cart_pd_quan) }" />
						</tr>
					</c:forEach>
				</table>
				<hr>
				<h3>총 가격 : <c:out value="${totalPrice}"></c:out> 원</h3>
				<br>
			</c:otherwise>
		</c:choose>
		<input type="button" value="결제하기" onclick="location.href='CartToPayment.us?sId=<%=sId %>'">
		
	
</body>
</html>