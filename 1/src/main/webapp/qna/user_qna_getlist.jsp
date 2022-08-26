<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    	
    	<c:choose>
    		<c:when test="${empty sessionScope.sId and qna_accesspermission eq 'private'}">
    			
    					<div class="none_sid">
    						로그인이 필요한 기능입니다.<br>
    					<a href="UserLogin.us">로그인</a>
    					</div>
    		</c:when>
    		<c:when test="${qna_accesspermission eq 'private' }">
    		<c:choose>
    			<c:when test="${not empty qnaList }">
    				<div class="private_subject">${sessionScope.sId }님의 문의입니다</div>
		    			<div class="public_content_flex">
		    					<div class="private_qna_subject">이름</div>
		    					<div class="private_qna_subject">제목</div>
		    					<div class="private_qna_subject">등록 날짜</div>
		    					<div id="private_qna_subject01" class="private_qna_subject">상태</div>
		    			</div>
	    		</c:when>
	    		<c:otherwise>
	    			<div class="private_subject">${sessionScope.sId }님의 문의</div>
	    				<div class="public_content_flex"></div>
	    					<div class="none">${sessionScope.sId }님의 문의가 없습니다.</div>
	    					<div class="none"><a href="QnaWrite.us" >문의 하러 가기</a></div>
	    		</c:otherwise>
	    	</c:choose>
	    			<div class="wrap">
		    			<c:forEach var="qnaList" items="${qnaList }">
	    				<div class="private_flex" onclick="location.href='UserQnaDetail.us?qna_num=${qnaList.qna_num}'">
			    			<div class="private_content">
			    					${qnaList.qna_user }
			    			</div>
			    			<div class="private_content">
			    					${qnaList.qna_subject }
			    			</div>
			    			<div class="private_content">
			    					${qnaList.qna_date }
			    			</div>
				    		<c:choose>
				    			<c:when test="${not empty qna_rep }">
				    				<div id="private_content01" class="private_content">
				    					답변 완료
				    				</div>
				    			</c:when>
					    			<c:otherwise>
						    				<div id="private_content01" class="private_content">
						    					답변 대기중
						    				</div>
					    			</c:otherwise>
				    		</c:choose>
	    				</div>	
		    			</c:forEach>    		
    			</div>
    		</c:when>
    		<c:when test="${qna_accesspermission eq 'public' }">
    		<div class="public_subject">공개 문의 내역 입니다.</div>
    			<div class="public_subject_flex" >
    					<div class="public_qna_subject">이름</div>
    					<div class="public_qna_subject">제목</div>
    					<div class="public_qna_subject">문의 타입</div>
    					<div class="public_qna_subject">등록 날짜</div>
    			</div>
    			<c:forEach var="qnaList" items="${qnaList }">
    					    <div class="private_flex" onclick="location.href='UserQnaDetail.us?qna_num=${qnaList.qna_num}'">
			    			<div class="public_content">
			    					${qnaList.qna_user_email }
			    			</div>
			    			<div class="public_content">
			    					${qnaList.qna_subject }
			    			</div>
			    			<div class="public_content">
			    					${qnaList.qna_type }
			    			</div>
			    			<div class="public_content">
			    					${qnaList.qna_date }
			    			</div>
	    				</div>	
    			</c:forEach>    	
    		</c:when>
    	</c:choose>
 <c:choose>
 <c:when test="${qna_accesspermission eq 'public' }">
    <div class="page" >
		<c:choose>
			<c:when test="${qnaPageInfo.pageNum > 1}">
				<input type="button"  id="pageButton"value="이전" onclick="pageMovePublic(${qnaPageInfo.pageNum - 1})">
			</c:when>
			<c:otherwise>
				<input type="button"   id="pageButton"value="이전비">
			</c:otherwise>
		</c:choose>	
			
		<c:forEach var="i" begin="${qnaPageInfo.startPage }" end="${qnaPageInfo.endPage }">
			<c:choose>
				<c:when test="${qnaPageInfo.pageNum eq i}">
					${i }
				</c:when>
				<c:otherwise>
					<a href="javascript:void(0)" onclick="pageMovePublic(${i})">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:choose>
			<c:when test="${qnaPageInfo.pageNum < qnaPageInfo.maxPage}">
				<input type="button" value="다음"   id="pageButton" onclick="pageMovePublic(${qnaPageInfo.pageNum + 1})">
			</c:when>
			<c:otherwise>
				<input type="button"  id="pageButton" value="다음비">
			</c:otherwise>
		</c:choose>
	</div>
</c:when>
    
    
    
    <c:otherwise>
    <div class="page" >
		<c:choose>
			<c:when test="${qnaPageInfo.pageNum > 1}">
				<input type="button"  id="pageButton"value="이전" onclick="pageMovePrivate(${qnaPageInfo.pageNum - 1})">
			</c:when>
			<c:otherwise>
				<input type="button"   id="pageButton"value="이전비">
			</c:otherwise>
		</c:choose>	
			
		<c:forEach var="i" begin="${qnaPageInfo.startPage }" end="${qnaPageInfo.endPage }">
			<c:choose>
				<c:when test="${qnaPageInfo.pageNum eq i}">
					${i }
				</c:when>
				<c:otherwise>
					<a href="javascript:void(0)" onclick="pageMovePrivate(${i})">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:choose>
			<c:when test="${qnaPageInfo.pageNum < qnaPageInfo.maxPage}">
				<input type="button" value="다음"   id="pageButton" onclick="pageMovePrivate(${qnaPageInfo.pageNum + 1})">
			</c:when>
			<c:otherwise>
				<input type="button"  id="pageButton" value="다음비">
			</c:otherwise>
		</c:choose>
	</div>
 </c:otherwise>
 </c:choose>   