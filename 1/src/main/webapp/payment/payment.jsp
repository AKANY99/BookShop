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
<link href="css/header.css" rel="stylesheet">
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> -->
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<!-- <meta name="viewport" content="width=device-width" , initial-scale="1"> -->
<link rel="shortcut icon" href="images/a.ico.jpg">
<!-- <script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script> -->
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script src="js/jquery-3.6.0.js"></script>
<script type='text/javascript'>

		function onload(){
			alert("")
		}
	
		function usePoint() {
			var point = + $("#usepoint").val()
			var userPoint = $("#userPoint").val()
			var totalPrice = $("#totalPrice").val()
			var 
		if(point > userPoint || point > totalPrice){
			alert("사용불가 : 보유하신 적립금 혹은 결제예상 금액보다 큽니다");
		}else{
			confirm(point+"원을 사용하시겠습니까?");
		
		}
	}

</script>


</head>
<body onload="onload()">
	<jsp:include page="/inc/header.jsp"/>
	<h1 align="center">결제</h1>
	<hr>

<!-- 	<form action="CartToPayment.us?sId=admin" method="post"> -->
		
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
					</tr>
					
					<c:forEach var="list" items="${list }">
						<tr>
							<td><a href="UserProductDetail.us?pd_num=${list.pd_num }"><img src="upload/${list.pd_file }" width="100" height="150"></a></td>
							<td><a href="UserProductDetail.us?pd_num=${list.pd_num }">${list.pd_subject }</a></td>
							<td>${list.pd_name }</td>
							<td>${list.pd_price }</td>
							<td>${list.cart_pd_quan }</td>
							<c:set var="totalPrice" value="${totalPrice + (list.pd_price * list.cart_pd_quan) }" />
							<c:set var="rTotalPrice" value="0" />
							<c:set var="points" value="0"/>
						</tr>
					</c:forEach>
				</table>
				<hr>
				
				<input type="number" id="usepoint"  min="0" max="${userPoint }"  placeholder="숫자만 입력해주세요">&nbsp;&nbsp;
				<input type="button"  value="사용" onclick="usePoint()">
				<span>보유적립금 : ${userPoint } 원</span>
				
				<input type="hidden" id="userPoint" value="${userPoint }">
            	<input type="hidden" id="totalPrice" value="${totalPrice }">
				<h3>
<%-- 				총 가격 : <c:out value="${totalPrice}"></c:out> --%>
            <c:choose>
            <c:when test="${totalPrice lt 30000}">
               <div id="ex">결제금액 :  ${totalPrice}  + 배송비 3000원 - 적립급 사용 =  ${totalPrice + 3000 } </div>
            </c:when>
            <c:otherwise>
               <div id="ex">결제금액 :  ${totalPrice}  + 배송비 무료 - 적립금 사용  =  ${totalPrice } 원</div>
            </c:otherwise>
				</c:choose>
					</h3>
				<br>
				
			</c:otherwise>
		</c:choose>
	<a href="#" role="button" id="check_module">결제하기</a>
	
	<script>
		$("#check_module").click(function() {
			var IMP = window.IMP; // 생략가능
			IMP.init("imp11426028");
			// 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
			// i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
			IMP.request_pay({
				pg : 'inicis' , // version 1.1.0부터 지원.
				/*
				 'kakao':카카오페이,
				 html5_inicis':이니시스(웹표준결제)
				 'nice':나이스페이
				 'jtnet':제이티넷
				 'uplus':LG유플러스
				 'danal':다날
				 'payco':페이코
				 'syrup':시럽페이
				 'paypal':페이팔
				 */

				pay_method : 'card',
				/*
				 'samsung':삼성페이,
				 'card':신용카드,
				 'trans':실시간계좌이체,
				 'vbank':가상계좌,
				 'phone':휴대폰소액결제
				 */
				merchant_uid : 'merchant_' + new Date().getTime(),
				/*
				 merchant_uid에 경우
				 https://docs.iamport.kr/implementation/payment
				 위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
				 참고하세요.
				 나중에 포스팅 해볼게요.
				 */
				name : '도서 금액',
				//결제창에서 보여질 이름
				amount : 100,
				//가격
				buyer_email : 'rffa@donate.com',
				buyer_name : '성민규',
				buyer_tel : '080-8916-1345',
				buyer_addr : 'Hokkido Sapporo-shi chuo-ward 1-15-5 KIBOU B/D 2F',
				buyer_postcode : '211-0005',
				m_redirect_url : 'www.naver.com'
			/*
			 모바일 결제시,
			 결제가 끝나고 랜딩되는 URL을 지정
			 (카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐)
			 */
			}, function(rsp) {
				console.log(rsp);
				if (rsp.success) {
					var msg = '결제가 완료되었습니다.';
					msg += '고유ID : ' + rsp.imp_uid;
					msg += '상점 거래ID : ' + rsp.merchant_uid;
					msg += '결제 금액 : ' + rsp.paid_amount;
					msg += '카드 승인번호 : ' + rsp.apply_num;
					location.href='./';
				} else {
					var msg = '결제에 실패하였습니다.';
					msg += '에러내용 : ' + rsp.error_msg;
					history.back();
				}
				alert(msg);
			});
		});
	</script>
	
</body>
</html>