package vo;

/*
CREATE TABLE authInfo (
		auth_email VARCHAR(200) PRIMARY KEY,
		auth_code VARCHAR(200) NOT NULL
);
*/

//인증코드를 관리하는 클래스 정의
public class AuthInfoDTO {
	private String auth_email;
	private String auth_code;
	
	public String getAuth_email() {
		return auth_email;
	}
	public void setAuth_email(String auth_email) {
		this.auth_email = auth_email;
	}
	public String getAuth_code() {
		return auth_code;
	}
	public void setAuth_code(String authCode) {
		this.auth_code = authCode;
	}
	
}