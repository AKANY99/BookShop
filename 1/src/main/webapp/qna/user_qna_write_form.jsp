<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/sidebar.css" rel="stylesheet">
<link href="css/header.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/user_qna_write.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	$(".type_select").on("change",function(){
		let type = $(".type_select").val();
		if(type == "상품"){
			window.name = "parentQna";
			childQna = window.open("UserQnaSelectProduct.us", "chilsQna", "width=800px, height=850px ");
		}else {
			$("#pd_subject").val('');
		}
	})
	$("#pd_subject").on("click",function(){
		let type = $(".type_select").val();
		if(type == "상품"){
			window.name = "parentQna";
			childQna = window.open("UserQnaSelectProduct.us", "chilsQna", "width=800px, height=850px ");
		}else{
			$("#pd_subject").val('');
		}
	})
});



</script>
</head>
<body>
<jsp:include page="/inc/header.jsp"/>
	<form name="fr" action="QnaWritePro.us" method="post">
	<input type="hidden" value="${sessionScope.sId }" name="email">
	<div id="write_section">
		<div class="qna_subject">
			제 목 : <input type="text" placeholder="50자 제한" name="subject" id="subject_write" maxlength="50"  required="required">
		</div>
		<div class="qna_subject">
			작성자 : <input type="text" name="name" id="subject_write" maxlength="50"  required="required">
		</div>
		<div class="qna_subject" >아이디 : ${sessionScope.sId }</div>
		<div class="qna_disclosure">공개 여부 :	
			공개<input type="radio" value="public" name="disclosure" checked="checked">
			비공개<input type="radio" value="private" name="disclosure">
		</div>
		<div id="qna_type">문의 분류
			<select name="qna_type" class="type_select" required>
				<option value="" selected="selected" disabled="disabled">선택해주세요</option>
				<option value="상품" class="product_select">상품</option>
				<option value="계정">계정</option>
			</select>
			<div class="selected_product">
				<input type="text" readonly="readonly" value="" name="pd_subject" placeholder="상품 선택란" id="pd_subject">
				<input type="hidden" name="pd_num" value="" id="pd_num">
			</div>
			
		</div>
		
		<textarea name="content">문의 내용을 입력해주세요.</textarea><br>
		<div class="submit">
			<input type="submit" value="작성" class="submit_button">
		</div>
	</div>
	</form>
</body>
</html>