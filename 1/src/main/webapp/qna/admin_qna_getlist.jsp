<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
<div class="table">
	<div class="table_subject">
		<div class="table_1">No.</div>
		<div class="table_1">상품 번호</div>
		<div class="table_1">제목</div>
		<div class="table_1">이름</div>
		<div class="table_1">등록일</div>
		<div class="table_1">상태</div>
		<div class="table_1">관리</div>
	</div>
	<c:choose>
		<c:when test="${empty qnaList }">
			<div class="none">검색결과가 없습니다</div>
		</c:when>
		<c:otherwise>
			<c:forEach var="qnaList" items="${qnaList }">
				<div class="table_content" onclick="window.open('Qnarep.ad?qna_num=${qnaList.qna_num }','repok','width=1000px, height=500px');">
					<div class="table_2">${qnaList.qna_num }</div>
					<div class="table_2">${qnaList.qna_pd_num }</div>
					<div class="table_2">${qnaList.qna_subject }</div>
					<div class="table_2">${qnaList.qna_user }</div>
					<div class="table_2">${qnaList.qna_date }</div>
				<c:choose>
					<c:when test="${not empty qnaList.qna_rep }">
						<div class="table_2">답변 완료</div>
						<div class="table_2">
							<input type="button" value="보기" onclick="window.open('Qnarep.ad?qna_num=${qnaList.qna_num }','repok','width=1000px, height=500px');">
						</div>
					</c:when>
					<c:otherwise>
						<div class="table_2">답변 대기</div>
						<div class="table_2">
							<input type="button" value="답변 달기"onclick="window.open('Qnarep.ad?qna_num=${qnaList.qna_num }','repok','width=1000px, height=500px');">
						</div>
					</c:otherwise>
				</c:choose>
				</div>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</div>
<div class="page"  style="text-align: center;">
		<c:choose>
			<c:when test="${qnaPageInfo.pageNum > 1}">
				<input type="button" value="이전" onclick="pageMove(${qnaPageInfo.pageNum - 1})">
			</c:when>
			<c:otherwise>
				<input type="button" value="이전">
			</c:otherwise>
		</c:choose>	
			
		<c:forEach var="i" begin="${qnaPageInfo.startPage }" end="${qnaPageInfo.endPage }">
			<c:choose>
				<c:when test="${qnaPageInfo.pageNum eq i}">
					${i }
				</c:when>
				<c:otherwise>
					<a href="javascript:void(0)" onclick="pageMove(${i})">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:choose>
			<c:when test="${qnaPageInfo.pageNum < qnaPageInfo.maxPage}">
				<input type="button" value="다음" onclick="pageMove(${qnaPageInfo.pageNum + 1})">
			</c:when>
			<c:otherwise>
				<input type="button" value="다음">
			</c:otherwise>
		</c:choose>
	</div>
	
<!-- 페이지를 유지하기 위한 value 값 -->
<input type="hidden" id="qnaPageNum" name="qnaPageNum" value="${qnaPageInfo.pageNum }">
<input type="hidden" name="qna_rep" value="${qna_rep }">
<input type="hidden" name="qna_type" value="${qna_type }">
<input type="hidden" name="order_by" value="${order_by }">
<input type="hidden" name="searchObject" value="${searchObject }">
<input type="hidden" name="startDate" value="${startDate }">
<input type="hidden" name="endDate" value="${endDate }">


