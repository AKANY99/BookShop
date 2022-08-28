<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- AJAX로 인해 admin_order_list.jsp 의 검색결과 안에 표시될 정보들 -->
<div id="result_subject">
	<p>검색결과</p>
</div>
<div class="search_result">
	<div id="table_subject">
		<div class="table_subject">주문번호</div>
		<div class="table_subject">주문자(이메일)</div>
		<div class="table_subject">결제금액</div>
		<div class="table_subject">결제상태</div>
		<div class="table_subject">주문일</div>
		<div class="table_subject">상세정보</div>
	</div>
	<c:choose>
		<c:when test="${empty orderList }">
			<div id="none_table">
				<div class="none">조건에 맞는 검색결과가 없습니다</div>
			</div>
		</c:when>
		<c:otherwise>
			<c:forEach var="order" items="${orderList }">
				<div id="table_content">
					<div class="table_content">${order.order_num }</div>
					<div class="table_content">${order.order_user_email }</div>
					<div class="table_content">${order.order_price }</div>
					<div class="table_content">${order.order_status }</div>
					<div class="table_content">${order.order_date }</div>
					<div class="table_content">
						<input type="button" value="상세정보" onclick="location.href='OrderDetail.ad?pageNum=${ordPageInfo.pageNum }&order_num=${order.order_num }'">
					</div>
				</div>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</div>
<div class="page"  style="text-align: center;">
		<c:choose>
			<c:when test="${ordPageInfo.pageNum > 1}">
				<input type="button" value="이전" onclick="pageMove(${ordPageInfo.pageNum-1})">
			</c:when>
			<c:otherwise>
				<input type="button" value="이전">
			</c:otherwise>
		</c:choose>	
			
		<c:forEach var="i" begin="${ordPageInfo.startPage }" end="${ordPageInfo.endPage }">
			<c:choose>
				<c:when test="${ordPageInfo.pageNum eq i}">
					${i }
				</c:when>
				<c:otherwise>
					<a href="javascript:void(0)" onclick="pageMove(${i })">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:choose>
			<c:when test="${ordPageInfo.pageNum < ordPageInfo.maxPage}">
				<input type="button" value="다음" onclick="pageMove(${ordPageInfo.pageNum+1 })">
			</c:when>
			<c:otherwise>
				<input type="button" value="다음">
			</c:otherwise>
		</c:choose>
	</div>
<!-- AJAX로 인해 admin_product_list.jsp 의 검색결과 안에 표시될 정보들 -->
	
<!-- 페이지를 유지하기 위한 값 -->
<form class="form_page">
<input type="hidden" id="ordPageNum" name="ordPageNum" value="${ordPageInfo.pageNum }">
<input type="hidden" name="order_num" value="${order_num }">
<input type="hidden" name="start_date" value="${start_date }">
<input type="hidden" name="end_date" value="${end_date }">
<input type="hidden" name="min_price" value="${min_price }">
<input type="hidden" name="max_price" value="${max_price }">
<input type="hidden" name="order_status" value="${order_status }">
</form>
<!-- 페이지를 유지하기 위한 값 -->






