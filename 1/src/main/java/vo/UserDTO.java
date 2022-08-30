package vo;

import java.sql.Date;

/*
create table user(
user_num int primary key,
user_name varchar(10) not null,
user_email varchar(50) unique not null,
user_passwd varchar(30) not null,
user_gender varchar(1) not null,
user_jumin varchar(30) not null,
user_address_code int not null,
user_address varchar(100) not null,
user_phone varchar(40) not null,
user_date date not null,
user_points int,
user_purchased int,
user_auth varchar(1) not null
);
 */
public class UserDTO {
	private int user_num;
	private String user_name;
	private String user_email;
	private String user_passwd;
	private String user_gender;
	private String user_jumin;
	private int user_address_code;
	private String user_address;
	private String user_phone;
	private Date user_date;
	private int user_points;
	private int user_purchased;
	private String user_auth;
	
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_passwd() {
		return user_passwd;
	}
	public void setUser_passwd(String user_passwd) {
		this.user_passwd = user_passwd;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public String getUser_jumin() {
		return user_jumin;
	}
	public void setUser_jumin(String user_jumin) {
		this.user_jumin = user_jumin;
	}
	public int getUser_address_code() {
		return user_address_code;
	}
	public void setUser_address_code(int user_address_code) {
		this.user_address_code = user_address_code;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public Date getUser_date() {
		return user_date;
	}
	public void setUser_date(Date user_date) {
		this.user_date = user_date;
	}
	public int getUser_points() {
		return user_points;
	}
	public void setUser_points(int user_points) {
		this.user_points = user_points;
	}
	public int getUser_purchased() {
		return user_purchased;
	}
	public void setUser_purchased(int user_purchased) {
		this.user_purchased = user_purchased;
	}
	public String getUser_auth() {
		return user_auth;
	}
	public void setUser_auth(String user_auth) {
		this.user_auth = user_auth;
	}
	@Override
	public String toString() {
		return "UserDTO [user_num=" + user_num + ", user_name=" + user_name + ", user_email=" + user_email
				+ ", user_passwd=" + user_passwd + ", user_gender=" + user_gender + ", user_jumin=" + user_jumin
				+ ", user_address_code=" + user_address_code + ", user_address=" + user_address + ", user_phone="
				+ user_phone + ", user_date=" + user_date + ", user_points=" + user_points + ", user_purchased="
				+ user_purchased + ", user_auth=" + user_auth + "]";
	}
	
}
