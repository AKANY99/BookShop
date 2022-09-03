<%@page import="java.util.ArrayList"%>
<%@page import="vo.ordDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String sId = (String)session.getAttribute("sId");
String startday = request.getParameter("startday");
String endday = request.getParameter("endday");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/header.css" rel="stylesheet">
<link href="css/sidebar.css" rel="stylesheet">
<link href="css/user_my_order.css" rel="stylesheet">
<script type="text/javascript">
function orderDetail(order_num, order_status){
    var url = "MyOrderDetail.us?order_num=" + order_num + "&order_status=" + order_status;
    var name = "";
    var option = "width = 450, height = 600, top = 100, left = 200, location = no"
    window.open(url, name, option);
}

function orderCancel(order_status, order_num, sId){
	
  	if(order_status == "결제완료" ){
   		if(!window.confirm("정말 " + order_num + "번 주문을 취소하시겠습니까?")){
   		}
   		else{
   			 location.href="MyOrderCancel.us?order_num=" + order_num + "&sId=" + sId; 
   		}
	}
  	else if(order_status == "결제취소"){
  		alert("이미 취소된 주문입니다!");
  	}
	else{  
		alert("결제완료 단계에서만 주문취소가 가능합니다!");
	}
}  
</script>
</head>
<body>
<!-- 헤더 a -->
<jsp:include page="/inc/header.jsp"/>
<!-- 헤더 끝 -->
<!-- 상품 주문 내역 확인 -->
<section class="myOrder">
	<h1>
		<img alt="주문/배송 내역" src="images/order_icon.png" height="40px">
		주문/배송 내역
	</h1>
	<br>
	<c:choose>
		<c:when test="${empty startday || empty endday}">
			<form action="MyOrder.us">
				기간조회 : 
				<input type="date" name="startday"> ~
				<input type="date" name="endday">
				<input type="hidden" name="sId" value="<%=sId %>">
				<input type="submit" value="조회">
				<input type="button" value="초기화" onclick="location.href='MyOrder.us?sId=<%=sId%>'">
			</form>
		</c:when>
		<c:otherwise>
			<form action="MyOrder.us">
				기간검색 : 
				<input type="date" name="startday" value="<%=startday %>"> ~
				<input type="date" name="endday" value="<%=endday %>">
				<input type="hidden" name="sId" value="<%=sId %>">
				<input type="submit" value="조회">
				<input type="button" value="초기화" onclick="location.href='MyOrder.us?sId=<%=sId%>'">
			</form>
		</c:otherwise>
	</c:choose>
	<br>
	<table border="1">
		<tr>
			<th width="110px">날짜</th>
			<th width="160px">상품 정보(주문번호)</th>
			<th width="200px">가격</th>
			<th width="100px">주문상태</th>
			<th width="330px">확인</th>
		</tr>
	<c:forEach var="ordlist" items="${ordlist }">
			<tr>
				<td class="orderDate">
					<b>${ordlist.order_date }</b>
				</td>
				
				<td><a onclick="orderDetail(${ordlist.order_num},'${ordlist.order_status }');">${ordlist.order_num }</a></td>
				<td>${ordlist.order_price }원</td>
				<c:choose>
					<c:when test="${ordlist.order_status eq '결제취소' }">
						<td style="color:red">${ordlist.order_status }</td>
					</c:when>
					<c:otherwise>
						<td style="color:green">${ordlist.order_status }</td>
					</c:otherwise>
				</c:choose>
<!--  				<td><input type ="button" value="주문 상세보기" onclick="location.href='MyOrderDetail.us?order_num=${ordlist.order_num}'"></td> -->
				<td class="orderButton">
					<input type ="button" value="주문 상세보기" onclick="orderDetail(${ordlist.order_num},'${ordlist.order_status }');">
					<input type ="button" value="주문취소" onclick="orderCancel('${ordlist.order_status}',${ordlist.order_num},'${sId}');">
					<input type ="button" value="문의하기" onclick="">
				</td>
			</tr>
	</c:forEach>
	</table>
</section>
<!-- 상품 주문 내역 확인 끝 -->

<section style="position: relative; clear: both;"></section>

<!-- 사이드바 -->
<jsp:include page="/inc/sidebar.jsp"/>
<!-- 사이드바 끝 -->

<section style="position: relative; clear: both;"></section>

<!-- 여백의 미 시작 -->
<section style="width:900px; height: 1000px; margin:0px auto;">
<h1 style="position:relative; top:50%; left:50%;">
여백의 미
</h1>
</section>
<!-- 여백의 미 끝 -->

<!-- 푸터 -->
<jsp:include page="/inc/footer.jsp"/>
<!-- 푸터 -->
</body>
</html>