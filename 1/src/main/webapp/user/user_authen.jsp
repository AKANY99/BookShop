<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/user_authen.css" rel="stylesheet" type="text/css">
<title>로그인</title>
</head>
<body>
	<section class="user_check">
	
	   <h2>회원정보 확인</h2>
		
		<form action="MyInfoMod.us?sId=${param.sId}" method="post" id="join">
			<div class="check">
		 		<input type="text" name="user_email" value="${param.sId}" readonly="readonly">
		 		<input type="password" name="user_passwd" placeholder="비밀번호">
			</div>
		
		 <div class="buttons">
		 <input type="submit" value="확인" class="submit">
		 </div> 
		</form>
		<nav>
			<a href="">비밀번호 찾기</a>
		</nav>
	</section>
</body>
</html>