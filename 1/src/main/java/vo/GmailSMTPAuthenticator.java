package vo;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

// 메일 서버(Gmail - SMTP) 인증을 위해 javax.mail.Authenticator 클래스를 상속받는 서브클래스 정의
public class GmailSMTPAuthenticator extends Authenticator {
	// 인증 정보(아이디, 패스워드)를 관리할 PasswordAuthentication 클래스 타입 멤버변수 선언
	PasswordAuthentication passwordAuthentication;
	
	// 기본 생성자 정의
	public GmailSMTPAuthenticator() {
		// 인증에 사용할 아이디와 패스워드를 갖는 PasswordAuthentication 객체 생성
		// => Gmail 의 2단계 인증 기능을 사용중일 경우 별도의 부가 작업 필요(앱비밀번호 발급 등)
		// new PasswordAuthentication("계정명", "비밀번호");
		passwordAuthentication = new PasswordAuthentication("tree6316p3", "ttikvarcvdzbhoji");
		// 주의! 2단계 인증 사용자의 경우 일반 계정 비밀번호 대신 앱비밀번호 사용
	}

	// 인증정보를 외부로 리턴하기 위해 getPasswordAuthentication() 메서드 오버라이딩 필수!
	// => 주의! Getter 메서드를 정의하는 것이 아니라 상속받은 메서드 오버라이딩(직접 호출 용도X)
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return passwordAuthentication;
	}
	
}













