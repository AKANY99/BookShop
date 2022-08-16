<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/user_terms.css" rel="stylesheet" type="text/css">
<script type="text/javascript">


	function checkAll() {
		if(document.fr.check_all.checked) {
			for(let item of document.fr.terms) {
				item.checked = true;
			}
		} else {
			//전체 도으이 체크 해제시
			for(let item of document.fr.terms){
				// 다른 모든 버튼에 체크를 해제함
				item.checked = false;
			}
		}//모든 버튼이 체크되어있는지 확인하는 함수
	}
	
	function buttonAllChecked(){
		let terms = document.fr.terms;
		//terms에 있는 배열을 모두 돌려서
		for(let i = 0; i < terms.length; i++){
			if(!terms[i].checked){
				document.fr.check_all.checked = false;
				return;
			}
		}
		document.fr.check_all.checked = true;
	}
	
	function checkTerms(){
		if(document.fr.check_all.checked){
			return true;
		}
		alert("다 체크해주세요!");
		return false;
	}


</script>
</head>
<body>
	<div class="terms_header">
		<a href="./" class=book_logo1><img alt="로고" src="images/BookShopLogo2.png" width="400px"></a>
	</div>
	<section class="terms">
	<form class="form_area" action="MyInfoDelPro.us?sId=${param.sId }" onsubmit="return checkTerms()" method="post" name="fr">
		<!-- 전체 동의 -->
		
		<section class="agree">
			<span id="checkAll">
				<b>
					*주의! 북샵 탈회 시 기존 보유 포인트와 적립금은 소멸되며, 진행중인 주문과 문의내역이 있으시면 사용에 불편함을 겪을 수 있습니다.
					<input type="checkbox" name="check_all" value="전체선택" onclick="checkAll()">
				</b>
			</span>
		</section>
		<!--이용 약관 동의  -->
		<section class="agree">
			<br>
			<b>북샵 이용해지 약관 동의<input type="checkbox" name="terms" value="북샵 이용약관 동의" onclick="buttonAllChecked()"></b><br>
			<div class="text_area">
 
제7조(회원 탈퇴 및 자격 상실 등) 
 
  ① 회원은 “몰”에 언제든지 탈퇴를 요청할 수 있으며 “몰”은 즉시 회원탈퇴를 처리합니다.
 
  ② 회원이 다음 각 호의 사유에 해당하는 경우, “몰”은 회원자격을 제한 및 정지시킬 수 있습니다.
 
    1. 가입 신청 시에 허위 내용을 등록한 경우
    2. “몰”을 이용하여 구입한 재화 등의 대금, 기타 “몰”이용에 관련하여 회원이 부담하는 채무를 기일에 지급하지 않는 경우
    3. 다른 사람의 “몰” 이용을 방해하거나 그 정보를 도용하는 등 전자상거래 질서를 위협하는 경우
    4. “몰”을 이용하여 법령 또는 이 약관이 금지하거나 공서양속에 반하는 행위를 하는 경우
 
  ③ “BookShop”이 회원 자격을 제한․정지 시킨 후, 동일한 행위가 2회 이상 반복되거나 30일 이내에 그 사유가 시정되지 아니하는 경우 “몰”은 회원자격을 상실시킬 수 있습니다.
 
  ④ “BookShop”이 회원자격을 상실시키는 경우에는 회원등록을 말소합니다. 이 경우 회원에게 이를 통지하고, 회원등록 말소 전에 최소한 30일 이상의 기간을 정하여 소명할 기회를 부여합니다.
 

 
 </div>
 		<!-- 개인정보 수집 및 이용동의 -->
		</section>
		<section class="agree">
			<br><b>개인정보 파기 계획 확인 및 동의<input type="checkbox" name="terms" value="개인정보 수집이용 동의" onclick="buttonAllChecked()"></b><br>
			<div class="text_area"> 제4장 계약 해지
제11조 (계약 해지)
회원이 서비스 이용 계약을 해지 하고자 할 때는 개인정보수정의 '회원탈퇴' 메뉴에서 회원탈퇴를 신청하시면 됩니다. 탈퇴를 신청하시면 즉시 탈퇴처리가 완료되며, 탈퇴후 7일 동안은 회사에 다시 가입하실 수 없습니다.

제12조 (탈퇴 회원의 개인정보 이용)
1.회사는 회원정보를 회원이 탈퇴하는 시점으로부터 1년까지 보유할 수 있습니다.
2.회사가 보관하고 있는 탈퇴 회원의 정보는 회원의 가입이력관리와 지적재산권 관리,개인정보보호를 위해서만 활용할 수 있습니다.
3.단, 관계법령의 규정에 의하여 보존할 필요가 있는 경우 회사는 아래와 같이 관계법령에서 정한 일정한 기간 동안 회원정보를 보관합니다.
-표시/광고에 관한 기록 : 6개월
-계약 또는 청약철회 등에 관한 기록 : 5년
-대금결제 및 재화 등의 공급에 관한 기록 : 5년
제13조 (자격상실)
다음 각 항의 사유에 해당하는 경우 회사는 사전 통보 없이, 이용계약을 해지하거나 기간을 정하여 서비스 이용을 중지 또는 이용계약 해지 후 무기한 가입제한 할 수 있습니다.

1.가입시 또는 정보변경시 제6조 3항의 회원정보를 누락시키거나 허위 기재한 경우
2.미풍양속을 저해하는 비속한 아이디, 필명, 별명을 사용한 경우
3.타인의 아이디와 비밀번호, 주민등록번호 등 회원정보를 수집, 저장, 도용한 경우
4.회사 임직원, 운영자 등을 포함한 타인을 사칭하는 행위
5.회사, 다른 회원 또는 제3자의 지적재산권을 침해하는 경우
6.사회의 안녕과 질서, 미풍양속을 해치는 행위를 하는 경우
7.타인의 명예를 훼손, 모욕, 스톡 등 괴롭히거나 불이익을 주는 행위를 한 경우
8.정보통신망에 장애를 일으킬 수 있는 행위를 하는 경우
9.회사의 허락 없이 회사의 서비스를 이용해 영리행위를 하는 경우
10.회사가 허락하지 않은 방법으로 회사가 운영, 관리하는 포인트를 취득한 경우
11.전기통신기본법, 전기통신사업법, 정보통신 윤리강령, 정보통신 윤리위원회 심의규정, 프로그램 보호법 및 기타관련 법령과 약관이 금지하는 행위를 한 경우</div>
		<!-- 위치 정보동의 -->
		</section>
		<section class="agree">
			<br><b>주요 확인 내용<input type="checkbox" name="terms" value="위치기반 서비스 이용약관 동의" onclick="buttonAllChecked()"></b><br>
			<div class="text_area"> 1. 회원 탈회 시 사용했던 아이디(이메일)은 60일간 사용이 불가합니다.<br>
			2. 기 보유중 포인트 및 적립금은 소멸되며, 주문 및 문의 등 관련된 모든정보는 6개월 간 보호 후 파기됩니다.<br>
			3. 2번에 해당하는 연락은 따로 드리지 않습니다.<br>
			4. 탈회 시 취소는 불가하며 관련 문의는 고객센터로 유선 연락 바랍니다.<br>
			5. 지금까지 본 사이트를 이용해주셔서 감사합니다. 모든 약관 및 주요 확인 사항에 동의하신다면 동의 버튼을 눌러주시고 탈회를 진행해주세요.<br>
			6. 더 나은 서비스로 고객님을 다시 만날 수 있길 고대합니다.<br>
				
</div>
		</section>
		<input type="submit" value="탈회 확정" class="submit">
	</form>
 	</section>
 	<!-- 푸터 -->
	<jsp:include page="/inc/footer.jsp"/>
	<!-- 푸터 -->
</body>
</html>