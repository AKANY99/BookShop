package vo;

/*
CREATE TABLE auth_info (
		id VARCHAR(16) PRIMARY KEY,
		auth_code VARCHAR(50) NOT NULL
);
*/

//인증코드를 관리하는 클래스 정의
public class AuthInfoDTO {
	private String user_email;
	private String auth_code;
	
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String id) {
		this.user_email = id;
	}
	public String getAuth_code() {
		return auth_code;
	}
	public void setAuth_code(String authCode) {
		this.auth_code = authCode;
	}
	
}