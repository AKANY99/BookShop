<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록</title>
</head>
	<table border="1">
		<tr>
			<td>정렬</td>
			<td>
					<input type="button" name="chk_sort" value="등록일순" onclick="location.href='Search.us?sort=last&searchType=${param.searchType}&search=${param.search}'">
			</td>
			<td>
					<input type="button" name="chk_sort" value="가격낮은순" onclick="location.href='Search.us?sort=price&searchType=${param.searchType}&search=${param.search}'">
			</td>
			<td>
					<input type="button" name="chk_sort" value="판매량순" onclick="location.href='Search.us?sort=count&searchType=${param.searchType}&search=${param.search}'">
			</td>
		</tr>
	</table>

	<table border="1">
		<tr id="tr_top">
			<td>책 사진</td>
			<td>책 제목</td>
			<td>책 작가</td>
			<td>책 가격</td>
		</tr>
		<c:forEach var="searchProductList" items="${searchProductList }">
			<tr>
				<td><a href="UserProductDetail.us?pd_num=${searchProductList.pd_num }&pageNum=${pageInfo.pageNum }"><img src="upload/${searchProductList.pd_file }" width="100" height="150"></a></td>
				<td><a href="UserProductDetail.us?pd_num=${searchProductList.pd_num }&pageNum=${pageInfo.pageNum }">${searchProductList.pd_subject }</a></td>
				<td>${searchProductList.pd_name }</td>
				<td>${searchProductList.pd_price }</td>
			</tr>
		</c:forEach>
	</table>
	<section>
		<c:choose>
			<c:when test="${pageInfo.pageNum > 1}">
				<input type="button" value="이전" onclick="location.href='UserProductList.us?pageNum=${pageInfo.pageNum - 1}'">
			</c:when>
			<c:otherwise>
				<input type="button" value="이전">
			</c:otherwise>
		</c:choose>
			
		<c:forEach var="i" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
			<c:choose>
				<c:when test="${pageInfo.pageNum eq i}">
					${i }
				</c:when>
				<c:otherwise>
					<a href="UserProductList.us?page=${i }">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:choose>
			<c:when test="${pageInfo.pageNum < pageInfo.maxPage}">
				<input type="button" value="다음" onclick="location.href='UserProductList.us?pageNum=${pageInfo.pageNum + 1}'">
			</c:when>
			<c:otherwise>
				<input type="button" value="다음">
			</c:otherwise>
		</c:choose>
	</section>
</body>
</html>