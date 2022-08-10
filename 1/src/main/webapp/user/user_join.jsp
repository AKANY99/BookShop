<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 다음 우편번호 API 포함시키기 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	// check_id.jsp 파일을 새창에서 열기
	function checkDuplicateId() {
		// 파라미터 넘겨줘서 아이디 바로 기입되게 만들기
		window.open("UserCheckIdForm.us?user_email="+document.fr.user_email.value+'@'+document.fr.user_email2.value+"&isDuplicate=null", "check_id", "width=600,height=400");
	}
	
	// 중복체크 - 아이디 조금이라도 바뀌면 X 표시
	function checkIdOnkeydown() {
		var spanCheckIdResult = document.getElementById("duplicate");
		spanCheckIdResult.innerHTML = "중복체크 X";
		spanCheckIdResult.style.color = "RED";
	}
	
	// 비밀번호 길이 판별
	function checkPasswdLength() {
		// 입력된 패스워드가 8자리 ~ 16자리 사이가 아닐 경우
		if(document.fr.user_passwd.value.length < 8 || document.fr.user_passwd.value.length > 16) {
			alert("패스워드는 8~16자리 필수!");
			document.fr.user_passwd.select();
		}
	}
	
	// 비밀번호 & 비밀번호확인란이 같은지 판별(패스워드확인란 글자 입력할 때마다 호출 = onkeyup)
	function checkConfirmPasswd() {
		// 결과를 표시할 span 태그 영역 객체 가져오기
		let confirmPasswdResult = document.getElementById("confirmPasswdResult");
		// 입력된 두 패스워드 가져오기
		let passwd = document.fr.user_passwd.value;
		let passwd2 = document.fr.user_passwd2.value;
		
		// 두 패스워드 비교
		if(passwd == passwd2) {
			confirmPasswdResult.innerHTML = "비밀번호 일치";
			confirmPasswdResult.style.color = "GREEN";
		} else {
			confirmPasswdResult.innerHTML = "비밀번호 불일치";
			confirmPasswdResult.style.color = "RED";
		}
	}
	
	// ------------------------------------------------------------------------------------
	// 다음 우편번호 API 추가
	function execDaumPostcode() {
		 new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
//                 document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
            }
		 
        }).open();
	}
	
	// 회원가입 완료 시 확인용
	function checkSubmit(){
		// 중복이면 가입 X
		if(document.getElementById("duplicate").innerHTML == "중복체크 X"){
			alert("이메일 중복체크를 하지않았습니다!");
			document.fr.user_email.select();
			return false;
		}
		// 비밀번호가 일치하지 않으면 가입 X
		if(document.getElementById("confirmPasswdResult").innerHTML == "비밀번호 불일치"){
			alert("비밀번호가 다릅니다!");
			document.fr.user_passwd.select();
			return false;
		}
		return true;
		
	}
	
</script>
</head>
<body>
	<h1>회원가입</h1>
	<form action="UserJoinPro.us" onsubmit="return checkSubmit()" method="post" name="fr">
		<table border="1">
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="name" required="required">
				</td>
			</tr>			
			<tr>
				<td>이메일</td>
				<td>
					<input type="text" name="user_email" required="required" onkeydown="checkIdOnkeydown()">@
					<input type="text" name="user_email2" required="required" onkeydown="checkIdOnkeydown()">
					<select name="emailDomain" onchange="changeDomain()">
						<option value="">직접입력</option>
						<option value="naver.com">naver.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="nate.com">nate.com</option>
					</select>
					<input type="button" onclick="checkDuplicateId()" value="중복체크">
					<span id="duplicate" style="color: red;">중복체크 X</span>
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="user_passwd" placeholder="8 ~ 16글자 사이 입력" 
							onchange="checkPasswdLength()" required="required" maxlength="16">
				</td>
			</tr>
			<tr>
				<td>비밀번호확인</td>
				<td>
					<input type="password" name="user_passwd2" placeholder="8 ~ 16글자 사이 입력" 
							onchange="checkConfirmPasswd()" required="required" maxlength="16">
					<span id="confirmPasswdResult"></span>
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type="radio" name="user_gender" required="required" value="남">남
					<input type="radio" name="user_gender" required="required" value="여">여
				</td>
			</tr>
			<tr>
				<td>주민번호</td>
				<td>
					<input type="text" name="user_jumin" required="required" maxlength="6">-
					<input type="text" name="user_jumin2" required="required" maxlength="7">
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					<input type="text" id="sample4_postcode" name="user_address_code" placeholder="우편번호" required="required" readonly="readonly" onclick="execDaumPostcode()">
					<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
					<input type="text" id="sample4_roadAddress" name="user_address"  placeholder="도로명주소" required="required" readonly="readonly" onclick="execDaumPostcode()">
					<input type="text" id="sample4_detailAddress" name="user_address2"  placeholder="상세주소" required="required">
				</td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td>
					<input type="text" name="user_phone" maxlength="11" placeholder="-없이 숫자만 입력" required="required">
				</td>
			</tr>
		</table>
		<input type="submit" value="가입">
		<input type="reset" value="초기화">
		<input type="button" value="돌아가기" onclick="history.back()">
	</form>
</body>
</html>

















    