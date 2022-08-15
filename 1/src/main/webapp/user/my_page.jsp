<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/my_page.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
<%-- 	<h1>마이페이지</h1>
	<h3>회원번호 ${requestScope.user.user_num}</h3>
	<h3>이름 ${requestScope.user.user_name}</h3>
	<h3>이메일 ${requestScope.user.user_email}</h3>
	<h3>비밀번호 ${requestScope.user.user_passwd}</h3>
	<h3>성별 ${requestScope.user.user_gender}</h3>
	<h3>주민번호 ${requestScope.user.user_jumin}</h3>
	<h3>우편번호 ${requestScope.user.user_address_code}</h3>
	<h3>주소 ${requestScope.user.user_address}</h3>
	<h3>연락처 ${requestScope.user.user_phone}</h3>
	<h3>가입일 ${requestScope.user.user_date}</h3> --%>

	<h2 align="center">가입 정보</h2>
	<hr>
	<form action="" method="post" class="infofr" align="center">
	 
		 	회  원  명 : <input type="text" name="name" value="${requestScope.user.user_name}" readonly="readonly"><br>
			이  메  일 : <input type="text" name="email" value="${requestScope.user.user_email}" readonly="readonly"><br>
		 	비밀번호 : <input type="password" name="passwd" value="${requestScope.user.user_passwd}" readonly="readonly" ><br>
		 	성      별 : <input type="text" name="gender" value="${requestScope.user.user_gender}" readonly="readonly"><br>
			생년월일 : <input type="text" name="birth" value="${requestScope.user.user_jumin}" readonly="readonly"><br>
			주      소 : <input type="text" name="address" value="${requestScope.user.user_address}" readonly="readonly"><br>
			연  락  처 : <input type="text" name="phone" value="${requestScope.user.user_phone}" readonly="readonly"><br>
			가  입  일 : <input type="text" name="date" value="${requestScope.user.user_date}" readonly="readonly"><br>
	</form>
	<div id="dml" align="center">
		<input type="button" value="수정"><input type="button" value="회원탈퇴"><input type="button" value="메인으로">
	</div>
	
	

</body>
</html>