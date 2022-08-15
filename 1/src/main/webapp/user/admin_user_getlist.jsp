<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="table">
	<div class="table_subject">
		<div class="table_1">No.</div>
		<div class="table_1">이름</div>
		<div class="table_1">이메일</div>
		<div class="table_1">성별</div>
		<div class="table_1">가입날짜</div>
	</div>
	<c:choose>
		<c:when test="${empty userList }">
			<div class="none">검색 결과가 없습니다.</div>
		</c:when>
		<c:otherwise>
			<c:forEach var="userlist" items="${userList }">
				<div class="table_content" onclick="window.open('UserDetail.ad?user_num=${userlist.user_num }','repok','width=1000px, height=800px');">
					<div class="table_2">${userlist.user_num }</div>
					<div class="table_2">${userlist.user_name }</div>
					<div class="table_2">${userlist.user_email }</div>
					<div class="table_2">${userlist.user_gender }</div>
					<div class="table_2">${userlist.user_date }</div>
				</div>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</div>

			<div class="page"  style="text-align: center;">
		<c:choose>
			<c:when test="${userPageInfo.pageNum > 1}">
				<input type="button" value="이전" onclick="pageMove(${userPageInfo.pageNum - 1})">
			</c:when>
			<c:otherwise>
				<input type="button" value="이전">
			</c:otherwise>
		</c:choose>	
			
		<c:forEach var="i" begin="${userPageInfo.startPage }" end="${userPageInfo.endPage }">
			<c:choose>
				<c:when test="${userPageInfo.pageNum eq i}">
					${i }
				</c:when>
				<c:otherwise>
					<a href="javascript:void(0)" onclick="pageMove(${i})">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:choose>
			<c:when test="${userPageInfo.pageNum < userPageInfo.maxPage}">
				<input type="button" value="다음" onclick="pageMove(${userPageInfo.pageNum + 1})">
			</c:when>
			<c:otherwise>
				<input type="button" value="다음">
			</c:otherwise>
		</c:choose>
	</div>
<input type="hidden" id="userPageNum" name="userPageNum" value="${userPageInfo.pageNum }">
<input type="hidden" name="startDate" value="${startDate }">
<input type="hidden" name="endDate" value="${endDate }">
<input type="hidden" name="gender" value="${gender }">
<input type="hidden" name="searchType" value="${searchType }">
<input type="hidden" name="searchObject" value="${searchObject }">


