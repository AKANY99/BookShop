<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link href="css/admin_main_design.css" rel="stylesheet">
<script src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">

var main_ad_num = ${param.main_ad_num}


function pageMove(page){
	alert(page)
	let searchObject = $(".searchObject2").val()
		$.ajax({
			type:"get",
			url:"ChangeMainAd.ad",
			data:{"pdPageNum":page,
					   "productObject":searchObject,
					   "main_ad_num":${param.main_ad_num}},
			dataType:"text"
		}).done(function(fragment){
			$(".fragment").replaceWith(fragment);
		}).fail(function(){
			alert("실팽")
		})
}


$(function(){
	$(".button").on("click",function(){
		let searchObject = $(".searchObject").val()
		$.ajax({
			type:"get",
			url:"ChangeMainAd.ad",
			data:{"productObject":searchObject,
						"main_ad_num":${param.main_ad_num}},
			dataType:"text"
		}).done(function(fragment){
			$(".fragment").replaceWith(fragment);
		}).fail(function(){
			alert("실팽")
		})
	})
})


</script>
</head>
<body>
<div class="fragment">
<jsp:include page="/inc/admin_header.jsp"/>
<div><br><br></div>
<div class="wrapper">
	<div class="search">
		<input type="text" class="searchObject" placeholder="책 제목을 입력하세요.">
		 <input type="button" value="검색" class="button">
	</div>
<form action="ChangeMainAdPro.ad"  method="post" enctype="multipart/form-data">
<input type="hidden" name="ad_num" value=${ad_num }>
<div class="subject_top">
		<div id="subject01" class="subject">선택</div	>
		<div class="subject">No.</div>
		<div class="subject">제목</div>
		<div class="subject">이미지</div>
</div>
	<c:forEach var="pd" items="${pdList }">
	<div class="content_top">
		<div class="content"><input type="radio" name="ad_pd_num" value="${pd.pd_num }" required="required"></div>
		<div class="content">${pd.pd_num}</div>
		<div class="content">${pd.pd_subject }</div>
		<div class="content"><img src="upload/${pd.pd_file }"></div>
	</div>
	</c:forEach>
	
				<section id="page">
				<c:choose>
					<c:when test="${pdPageInfo.pageNum > 1}">
						<input type="button" value="이전" onclick="pageMove('${pdPageInfo.pageNum - 1}')">
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
							<a href="javascript:void(0)" onclick="pageMove(${i})">${i }</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<c:choose>
					<c:when test="${pdPageInfo.pageNum < pdPageInfo.maxPage}">
						<input type="button" value="다음" onclick="pageMove('${pdPageInfo.pageNum + 1}')">
					</c:when>
					<c:otherwise>
						<input type="button" value="다음">
					</c:otherwise>
				</c:choose>
			</section>
	<input type="hidden" class="searchObject2"  value="${searchObject2 }">
	
	
	
<div class="buttons">
	<input type="text" name="ad_subject"  placeholder="슬라이드에 표시될 제목" required="required">
	<input type="file" name="ad_file" required="required" >	
	<input type="submit">
</div>
</form>
</div>
</div>
</body>
</html>