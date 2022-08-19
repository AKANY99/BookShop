<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품게시판</title>
</head>
<body>
<h1>상품등록란</h1>
	<form action="ProductWritePro.ad?pageNum=${param.pageNum }" method="post" enctype="multipart/form-data"> 
	<table border="1">
	<tr>
		<td class="td_left">도서제목</td>
		<td class="td_right"><input type="text" name="pd_subject" required="required"></td>
	</tr>
	<tr>
		<td class="td_left">도서분류</td>
		<td class="td_right">
			<input type="radio" name="pd_type" value="국내도서">국내도서
			<input type="radio" name="pd_type" value="해외도서">해외도서
			<input type="radio" name="pd_type" value="e-Book">e-Book
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
	<input type="button" value="글목록" onclick="location.href='ProductList.ad?pageNum=${param.pageNum}'">
	<input type="submit" value="등록">
	<input type="reset" value="다시 쓰기">
</form>
</body>
</html>