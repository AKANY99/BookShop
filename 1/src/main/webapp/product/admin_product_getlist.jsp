<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- AJAX로 인해 admin_product_list.jsp 의 검색결과 안에 표시될 정보들 -->
<p id="result_p">
	검색결과
	<input id="product_add" type="button" value="상품등록" onclick="location.href='ProductWrite.ad'">
</p>
<div class="search_result">
	<div id="table_subject">
		<div class="table_subject">도서번호</div>
		<div class="table_subject">도서표지</div>
		<div class="table_subject">도서명</div>
		<div class="table_subject">작가명</div>
		<div class="table_subject">재고수량</div>
		<div class="table_subject">상세관리</div>
	</div>
	<c:choose>
		<c:when test="${empty pdList }">
			<div id="none_table">
				<div class="none">조건에 맞는 검색결과가 없습니다</div>
			</div>
		</c:when>
		<c:otherwise>
			<c:forEach var="pdList" items="${pdList }">
				<div id="table_content">
					<div class="table_content">${pdList.pd_num }</div>
					<div class="table_content"><img src="upload/${pdList.pd_file }" width="60" height="75"></div>
					<div class="table_content">${pdList.pd_subject }</div>
					<div class="table_content">${pdList.pd_name }</div>
					<div class="table_content">${pdList.pd_quan }</div>
					<div class="table_content">
						<input type="button" value="상세정보" onclick="location.href='ProductInfo.ad?pd_num=${pdList.pd_num }'">
					</div>
				</div>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</div>
<div class="page"  style="text-align: center;">
		<c:choose>
			<c:when test="${pdPageInfo.pageNum > 1}">
				<input type="button" value="이전" onclick="pageMove(${pdPageInfo.pageNum-1})">
			</c:when>
			<c:otherwise>
				<input type="button" value="이전">
			</c:otherwise>
		</c:choose>	
			
		<c:forEach var="i" begin="${pdPageInfo.startPage }" end="${pdPageInfo.endPage }">
			<c:choose>
				<c:when test="${pdPageInfo.pageNum eq i}">
					${i }
				</c:when>
				<c:otherwise>
					<a href="javascript:void(0)" onclick="pageMove(${i })">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:choose>
			<c:when test="${pdPageInfo.pageNum < pdPageInfo.maxPage}">
				<input type="button" value="다음" onclick="pageMove(${pdPageInfo.pageNum+1 })">
			</c:when>
			<c:otherwise>
				<input type="button" value="다음">
			</c:otherwise>
		</c:choose>
	</div>
<!-- AJAX로 인해 admin_product_list.jsp 의 검색결과 안에 표시될 정보들 -->
	
<!-- 페이지를 유지하기 위한 값 -->
<form class="form_page">
<input type="hidden" id="pdPageNum" name="pdPageNum" value="${pdPageInfo.pageNum }">
<input type="hidden" name="start_date" value="${start_date }">
<input type="hidden" name="end_date" value="${end_date }">
<input type="hidden" name="pd_quan" value="${pd_quan }">
<input type="hidden" name="pd_type" value="${pd_type }">
<input type="hidden" name="search_input" value="${search_input }">
</form>
<!-- 페이지를 유지하기 위한 값 -->






