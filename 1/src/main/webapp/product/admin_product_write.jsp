<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품게시판</title>
<link href="css/admin_product_write.css" rel="stylesheet">
</head>
<body>
	<!-- 헤더부분 -->
	<jsp:include page="../inc/admin_header.jsp"></jsp:include>
	<!-- 헤더부분 -->
	<div class="wrapper_subject">상품등록</div>
	<section class="admin_product">
	<form action="ProductWritePro.ad" method="post" enctype="multipart/form-data"> 
		<table class="myTable">
			<tr>
				<td class="td_left">도서제목</td>
				<td class="td_right"><input type="text" name="pd_subject" required="required"></td>
			</tr>
			<tr>
				<td class="td_left">도서분류</td>
				<td class="td_right">
					<input type="radio" name="pd_type" id="국내도서" value="국내도서"><label for="국내도서">국내도서</label>
					<input type="radio" name="pd_type" id="해외도서" value="해외도서"><label for="해외도서">해외도서</label>
					<input type="radio" name="pd_type" id="eBook" value="eBook"><label for="eBook">eBook</label>
				</td>
			</tr>
			<tr>
				<td class="td_left">작가명</td>
				<td class="td_right"><input type="text" name="pd_name" required="required"></td>
			</tr>
			<tr>
				<td class="td_left">도서가격</td>
				<td class="td_right"><input type="text" name="pd_price" required="required"></td>
			</tr>
			<tr>
				<td class="td_left">도서수량</td>
				<td class="td_right"><input type="text" name="pd_quan" required="required"></td>
			</tr>
			<tr>
				<td class="td_left">도서 표지</td>
				<td class="td_right"><input  type="file" name="pd_file" required="required"></td>
				
			</tr>
			<tr>
				<td class="td_left">도서 소개</td>
				<td class="td_right"><input type="file" name="pd_content" required="required"></td>
				
			</tr>
		</table>
		<br>
		<section class="buttonSection">
			<input type="button" value="상품목록" onclick="location.href='ProductList.ad?pd_quan=전체'">
			<input type="submit" value="등록하기">
			<input type="reset" value="초기화">
		</section>
	</form>
	</section>
</body>
</html>