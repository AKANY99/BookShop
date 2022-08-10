<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	// 아이디 검색 후 결과를 다시 현재 페이지로 리다이렉트 했을 때
	// 검색 결과를 처리하기 위한 작업 수행
	// => 현재 페이지 로딩 완료 후 즉시 동작하기 위해 window.onload 이벤트 사용
	window.onload = function() { // body 영역 로딩 완료 후 실행할 익명 함수 정의
		// UserCheckDuplicateIdAction에서 request에 저장된 이메일을 EL로 가져옴
		var user_email = "${param.user_email}"; 
		// 가운데 @이가 있고 @를 기준으로 앞 뒤로 숫자나 소문자 대문자가 있어야 이메일로 체크
		// 이게 없다면 새로고침해서 넘어왓을때 이메일 판단을 못함
		var check_email_reguler = /^[a-zA-Z0-9]{1,}@{1,1}[a-zA-Z0-9]{1,}/;
	
		// 위에 만들어 둿던 정규식 사용
		if(check_email_reguler.test(user_email)) {
			// 이메일 아이디를 앞과 뒤로 나눠서 저장
			var emails = user_email.split('@');
			document.fr.user_email.value = emails[0];
			document.fr.user_email2.value = emails[1];
			
			if(${param.isDuplicate} == null){
				return false;
			}
			
			// 회원가입에 있는 id가 checkIdResult인 태그을 파싱
			var divCheckIdResult = document.getElementById("checkIdResult");
		
			// DAO에서 이메일 검색 결과가 중복이라면 false 만들 수 있다면 true
			var isDuplicate = "${param.isDuplicate}";
			if(isDuplicate == "true") { // 중복일 경우
				divCheckIdResult.innerHTML = user_email + "는 사용 불가능한 아이디 입니다<br>" ;
				divCheckIdResult.style.color = "RED";
			} else { // 중복이 아닐 경우
				divCheckIdResult.innerHTML = user_email + "는 사용 가능한 아이디 입니다<br>" 
								+ "<input type='button' value='아이디 사용' onclick='useId()'>";
				divCheckIdResult.style.color = "GREEN";
			}
		}
	}
	
	function useId() {
		// 아이디 사용 버튼 클릭 시
		// 부모창(join_form.html)의 폼 영역 내의 ID 입력창에 현재 입력된 아이디를 표시
		// => window.opener.document.폼이름.요소이름.value = 값; 형태로 표시 가능
		window.opener.document.fr.user_email.value = document.fr.user_email.value; // 부모창 ID 영역에 표시
		window.opener.document.fr.user_email2.value = document.fr.user_email2.value; // 부모창 ID 영역에 표시
		
		var spanCheckIdResult = window.opener.document.getElementById("duplicate");
		spanCheckIdResult.innerHTML = "중복체크 O";
		spanCheckIdResult.style.color = "GREEN";
		window.close(); // 창 닫기
	}
	
	// 이메일 도메인 선택 시 email2 영역에 선택된 도메인 표시
	function changeDomain() {
		document.fr.user_email2.value = document.fr.emailDomain.value;
	}
	
</script>
</head>
<body>
	<h1>ID 중복 체크</h1>
	<form action="CheckDuplicateId.us" name="fr" method="get">
		<input type="text" name="user_email" required="required" placeholder="이메일 입력">@<input type="text" name="user_email2" required="required">
		<select name="emailDomain" onchange="changeDomain()">
						<option value="">직접입력</option>
						<option value="naver.com">naver.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="nate.com">nate.com</option>
					</select>
		<input type="submit" value="중복확인">
		<div id="checkIdResult"></div>
	</form>
</body>
</html>











    