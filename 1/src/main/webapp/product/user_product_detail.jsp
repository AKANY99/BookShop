<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>상품게시판</title>
</head>
<body>
<h1>사용자 상품 상세 조회</h1>
	<table border="1">
		<tr>
			<td>도서 표지</td>
			<td>도서 분류</td>
			<td>도서 제목</td>
			<td>작가명</td>
			<td>도서 가격</td>
			<td>도서 소개</td>
		</tr>
		<tr>	
			<td><img src="upload/${product.pd_file }" width="150" height="200"></td>
			<td>${product.pd_type }</td>		
			<td>${product.pd_subject }</td>
			<td>${product.pd_name }</td>
			<td>${product.pd_price }</td>
			<td><img src="upload/${product.pd_content }" width="150" height="200"></td>
		</tr>
	</table>
	
	<form action="">
		수량 : 
		<input type="number" name="quantity" value="1" min="1" max="99">
<!--  	
		<input type=button value="+" onClick="javascript:this.form.quantity.value++;">
		<input type=button value="-" onClick="javascript:this.form.quantity.value--;"> 
-->
		<hr>
		<input type="submit" value="장바구니 담기" onclick="">
		<input type="submit" value="즉시 구매하기" onclick="">
		<input type="submit" value="찜하기" onclick="">
	</form>
</body>
</html>