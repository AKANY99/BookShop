package vo;

import java.sql.Date;

/*
create table product(
pd_num int primary key,
pd_type varchar(10) not null,
pd_name varchar(10) not null,
pd_price int not null,
pd_quan int not null,
pd_file varchar(100) not null,
pd_subject varchar(50) not null,
pd_content varchar(500) not null,
pd_date date not null,
pd_count int DEFAULT 0 not null
);
 */
public class ProductDTO {
	private int pd_num;
	private String pd_type;
	private String pd_name;
	private int pd_price;
	private int pd_quan;
	private String pd_file;
	private String pd_subject;
	private String pd_content;
	private Date pd_date;
	private int pd_count;
	
	public String getPd_type() {
		return pd_type;
	}
	public void setPd_type(String pd_type) {
		this.pd_type = pd_type;
	}
	public Date getPd_date() {
		return pd_date;
	}
	public void setPd_date(Date pd_date) {
		this.pd_date = pd_date;
	}
	public int getPd_num() {
		return pd_num;
	}
	public void setPd_num(int pd_num) {
		this.pd_num = pd_num;
	}
	public int getPd_price() {
		return pd_price;
	}
	public void setPd_price(int pd_price) {
		this.pd_price = pd_price;
	}
	public int getPd_quan() {
		return pd_quan;
	}
	public void setPd_quan(int pd_quan) {
		this.pd_quan = pd_quan;
	}
	public String getPd_name() {
		return pd_name;
	}
	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}
	public String getPd_file() {
		return pd_file;
	}
	public void setPd_file(String pd_file) {
		this.pd_file = pd_file;
	}
	public String getPd_subject() {
		return pd_subject;
	}
	public void setPd_subject(String pd_subject) {
		this.pd_subject = pd_subject;
	}
	public String getPd_content() {
		return pd_content;
	}
	public void setPd_content(String pd_content) {
		this.pd_content = pd_content;
	}
	public int getPd_count() {
		return pd_count;
	}
	public void setPd_count(int pd_count) {
		this.pd_count = pd_count;
	}
	
	@Override
	public String toString() {
		return "ProductDTO [pd_num=" + pd_num + ", pd_type=" + pd_type + ", pd_name=" + pd_name + ", pd_price="
				+ pd_price + ", pd_quan=" + pd_quan + ", pd_file=" + pd_file + ", pd_subject=" + pd_subject
				+ ", pd_content=" + pd_content + ", pd_date=" + pd_date + "]";
	}
	
	
}
