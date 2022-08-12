<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/adminrep.css" rel="stylesheet"/>
</head>
<body>
<form action="QnaRepModify.ad" method="post">
	<div class="qna">
		<div class="subject">
			Question
		</div>
		<div class="content">
			${rep.qna_content }
		</div>
	</div>
	<div class="qna">
		<div class="subject">
			Answer	
		</div>
		<div class="content">
			<textarea rows="9px" cols="100" name="rep_content">${rep.qna_rep }</textarea>
		</div>
	</div>
	<div class="button">
		<input type="hidden" name="qna_num" value="${rep.qna_num }">
		<!-- 처음쓰는 답변일시 답글달기 표시 -->
		<c:choose>
			<c:when test="${not empty rep.qna_rep }">
				<input type="submit" value="수정">
			</c:when>
			<c:otherwise>
				<input type="submit" value="답글 달기">
			</c:otherwise>
		</c:choose>
			<input type="button" value="닫기" onclick="window.close();">
	</div>
</form>

</body>
</html>