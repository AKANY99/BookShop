<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/user_login.css" rel="stylesheet" type="text/css">
<title>로그인</title>
</head>
<body>
	<section class="login">
	
	   <h2>로그인</h2>
		
		<form action="UserLoginPro.us" method="post" id="join">
			<div class="log_tit">
		 		<input type="text" name="user_email" placeholder="이메일" title="아이디입력">
		 		<input type="password" name="user_passwd" placeholder="비밀번호" title="비밀번호입력">
			</div>
		 <input type="checkbox" id="chk_id"><label for="chk_id">아이디 저장</label>
		 <div class="buttons">
		 <input type="submit" value="로그인" class="submit">
		 </div> 
		</form>
		<nav>
			<a href="">아이디 찾기</a> |
			<a href="">비밀번호 찾기</a>
		</nav>
		<nav id =no_member>
			<a href="">비회원 주문 조회</a>
		</nav>
	</section>
</body>
</html>