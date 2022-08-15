<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세정보</title>
<script src="js/jquery-3.6.0.js"></script>
<script type='text/javascript'>
function userDelete(){
	let id = prompt("관리자 아이디를 입력하세요");
	let passwd = prompt("관리자 비밀번호를 입력하세요.");
	if(!confirm("${userDetail.user_email} 사용자를 삭제 합니다.")){
		alert("취소되었습니다.");
	}else{
		location.href="UserDelete.ad?id="+ id +"&passwd=" + passwd + "&user_num=${userDetail.user_num}"
	}
}
</script>
<link href="css/admin_user_detail.css" rel="stylesheet"/>
</head>
<body>
	<div class="subject">회원정보</div>
	<section>
	<div class="content">
		<div class="first">
			아이디
		</div>
		<div class="second">
			<textarea class="textarea1" readonly="readonly">${userDetail.user_email }</textarea>
		</div>
	</div>
	<div class="content">
		<div class="first">
			이름
		</div>
		<div class="second">
			<textarea class="textarea1" readonly="readonly">${userDetail.user_name }</textarea>
		</div>
	</div>
	<div class="content">
		<div class="first">
			연락처
		</div>
		<div class="second">
			<textarea class="textarea1" readonly="readonly">${userDetail.user_phone }</textarea>
		</div>
	</div>
	<div class="content">
		<div class="first">
			성별
		</div>
		<div class="second">
			<textarea class="textarea1" readonly="readonly">${userDetail.user_gender }</textarea>
		</div>
	</div>
	<div class="content">
		<div class="first">
			주민번호
		</div>
		<div class="second">
			<textarea class="textarea1" readonly="readonly">${userDetail.user_jumin }</textarea>
		</div>
	</div>
	<div class="content">
		<div class="first">
			주소
		</div>
		<div class="second">
			<textarea class="textarea1" readonly="readonly">${userDetail.user_address_code }</textarea>
		</div>
	</div>
	<div class="content">
		<div class="first">
			-
		</div>
		<div class="second2">
			<textarea class="textarea2" readonly="readonly">${userDetail.user_address }</textarea>
		</div>
	</div>
	<div class="content">
		<div class="first">
			가입일자
		</div>
		<div class="second">
			<textarea class="textarea1" readonly="readonly">${userDetail.user_date }</textarea>
		</div>
	</div>
	
	</section>
	<div class="line"></div>
	<div class="buttons">
		<div class="button" style="background: red; color: white;"onclick="userDelete()">회원정지</div>
		<div class="button" style="background: white;"></div>
		<div class="button" style="background: white;"></div>
	</div>
	
	
</body>
</html>