<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지[상품관리]</title>
</head>
<body>
	<!-- 헤더부분 -->
	<jsp:include page="../inc/admin_header.jsp"></jsp:include>
	<!-- 헤더부분 -->
	<h1>상품수정</h1>
	<form action="ProductUpdatePro.ad?pageNum=${param.pageNum }&pd_num=${param.pd_num }" method="post" enctype="multipart/form-data"> 
		<table border="1">
			<tr>
				<td class="td_left">도서제목</td>
				<td class="td_right"><input type="text" name="pd_subject" value="" required="required"></td>
			</tr>
			<tr>
				<td class="td_left">도서분류</td>
				<td class="td_right">
					<input type="radio" name="pd_type" value="국내도서">국내도서
					<input type="radio" name="pd_type" value="해외도서">해외도서
					<input type="radio" name="pd_type" value="eBook">eBook
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
		<input type="submit" value="수정하기">
		<input type="button" value="취소">
		<input type="reset" value="초기화">
	</form>
</body>
</html>