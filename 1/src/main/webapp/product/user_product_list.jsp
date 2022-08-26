<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록</title>
<!-- CSS모음 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/header.css" rel="stylesheet">
<link href="css/productList.css" rel="stylesheet">
<link href="css/sidebar.css" rel="stylesheet">
<!-- CSS모음 끝 -->
</head>
<body>
	<!-- 헤더 a -->
	<jsp:include page="/inc/header.jsp"/>
	<!-- 헤더 끝 -->
	<!-- 검색 제목 -->
	<div class="productList_title">
		<h1>${param.pd_type }</h1>
	</div>
	<!-- 검색 제목 끝 -->
	
	<!-- 상품 전체 시작 -->
	<section class="productList_body">
		
		<!-- 왼쪽 통합 검색(분야)에 관한 메뉴 (국내, 해외, 베스트, 작가) -->
		<section class="productList_menu">
			<dl>
				<dt>
					<a>분야</a>
				</dt>
				<dd>
					<ul>
						<li><span class="txt">국내 도서 (x)</span></li>
						<li><span class="txt">해외 도서 (x)</span></li>
						<li><span class="txt">베스트 셀러 (x)</span></li>
						<li><span class="txt">작가명 (x)</span></li>
					</ul>
				</dd>
			</dl>
			
		</section>
		<!-- 왼쪽 통합 검색(분야)에 관한 메뉴 끝 -->
		
		
		<!-- 상품 목록 전체에 관한 내용 -->
		<section class="productList_content">
			<!-- productList_content_area -->
			<section class="productList_content_area">
			
			<!-- 상품이 몇개인지 알려주는 용도 -->
			<div class="contentInfo">
				<h3>상품 (x)</h3>
			</div>
			<!-- 상품이 몇개인지 알려주는 용도 끝 -->
			
			<!-- 정렬에 관한 메뉴 -->
			<div class="contentMenu">
				<a href="Search.us?sort=last&searchType=${param.searchType}&search=${param.search}">
					등록일순
				</a>
				<a href="Search.us?sort=price&searchType=${param.searchType}&search=${param.search}">
					가격낮은순
				</a>
				<a href="Search.us?sort=count&searchType=${param.searchType}&search=${param.search}">
					판매량순
				</a>
			</div>
			<!-- 정렬에 관한 메뉴 끝 -->
		
			<!-- 상품 목록 -->
			<div class="contentList">
				
				<ul>
					<!-- 상품 하나하나에 대한 FOR문 -->
					<c:forEach var="productList" items="${productList }">
					<li>
						<div class="contentUnit">
							<!-- 왼쪽 사진 -->
							<div class="content_img">
								<img src="upload/${productList.pd_file }">
							</div>
							<!-- 왼쪽 사진 끝 -->
							<!-- 오른쪽 정보란 -->
							<div class="content_info">
								<div class="info_subject">${productList.pd_subject }</div>
								<div class="info_name">${productList.pd_name }</div>
								<div class="info_price"><b>${productList.pd_price }</b>원</div>
								<div class="info_content">
									${productList.pd_content }
								</div>
								<div class="info_button">
									<input type="button" value="상품보기" onclick="location.href='UserProductDetail.us?pd_num=${productList.pd_num }&pageNum=${pageInfo.pageNum }'">
<!-- 									<input type="button" value="장바구니"> -->
<!-- 									<input type="button" value="바로구매"> -->
<!-- 									<input type="button" value="찜하기"> -->
								</div>
							</div>
							<!-- 오른쪽 정보란 끝 -->
							<!-- div class="content_controller"></div -->
						</div>
					</li>
					</c:forEach>
					<!-- 상품 하나하나에 대한 FOR문 끝 -->
				</ul>
			</div>
			<!-- 상품 목록 끝 -->
			
			<!-- 페이징 처리 -->
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
			<!-- 페이징 처리 -->
			
			</section>
			<!-- productList_content_area 끝 -->
		</section>
		<!-- 상품 목록 전체에 관한 내용 끝 -->
	</section>
	
	<table border="1">
		<tr>
			<td>정렬</td>
			<td>
				<input type="button" name="chk_sort" value="등록일순" onclick="location.href='UserProductList.us?sort_type=last&&pd_type=${param.pd_type}'">
			</td>
			<td>
				<input type="button" name="chk_sort" value="가격낮은순" onclick="location.href='UserProductList.us?sort_type=price&&pd_type=${param.pd_type}'">
			</td>
			<td>
				<input type="button" name="chk_sort" value="판매량순" onclick="location.href='UserProductList.us?sort_type=rate&&pd_type=${param.pd_type}'">
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
		<c:forEach var="productList" items="${productList }">
			<tr>
				<td><a href="UserProductDetail.us?pd_num=${productList.pd_num }&pageNum=${pageInfo.pageNum }"><img src="upload/${productList.pd_file }" width="100" height="150"></a></td>
				<td><a href="UserProductDetail.us?pd_num=${productList.pd_num }&pageNum=${pageInfo.pageNum }">${productList.pd_subject }</a></td>
				<td>${productList.pd_name }</td>
				<td>${productList.pd_price }</td>
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