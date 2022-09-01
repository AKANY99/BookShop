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
<link href="css/user_my_cart.css" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
</head>
<body>
	<jsp:include page="/inc/header.jsp"/>
	<div class="cart">
	<img alt="카트" src="images/cart.png" >
	<h1 align="center"></h1>
	<hr>

<!-- 	<form action="CartToPayment.us?sId=admin" method="post"> -->
		
		<c:choose>
			<c:when test="${empty list }">
				<h3 style="width: 900px; text-align: center; margin-top: 50px; margin-bottom: 50px;">장바구니가 비었습니다</h3>
				<section style="position: relative; clear: both;"></section>
				<img alt="" src="images/shopping_icon.png" width="300px" style="margin: 0px 300px;">
				<section style="position: relative; clear: both;"></section>
			</c:when>
			<c:otherwise>
			
				<table class="jur"width="100%">
					<tr class="text">
						<td class="space" width="120px">표지</td>
						<td class="space" width="240px">제목</td>
						<td class="space" width="160px">작가</td>
						<td class="space" width="160px">가격</td>
						<td class="space" width="90px">수량</td>
						<td class="space" width="130px"></td>
					</tr>
					
					<c:set var="totalPrice" value="0" />	
					<c:forEach var="list" items="${list }">
						<tr class="text">
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
							 <div class="delete">
							  <input type="button" name="delete" value="삭제" onclick="location.href='DeleteCart.us?sId=<%=sId %>&pd_num=${list.pd_num }'">
							 </div>
							</td>
							<c:set var="totalPrice" value="${totalPrice + (list.pd_price * list.cart_pd_quan) }" />
						</tr>
					</c:forEach>
				</table>
				<hr>
				<h3>총 가격 : <c:out value="${totalPrice}"></c:out> 원</h3>
				<section style="position: relative; clear: both;"></section>
				<br>
				<section id="button2">
				<form action="CartToPayment.us?sId=admin" method="get">
					<input type="button" value="결제하기" class="button" onclick="location.href='CartToPayment.us?sId=<%=sId %>'">
				</form>
				<section style="position: relative; clear: both;"></section>
				</section>

			</c:otherwise>
		</c:choose>
	
	
	
	
	</div>
	
	<jsp:include page="/inc/footer.jsp"/>
</body>
</html>