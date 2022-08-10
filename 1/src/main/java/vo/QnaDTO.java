package vo;

import java.sql.Date;

public class QnaDTO {
	
	private int qna_num;
	private String qna_user;
	private String qna_subject;
	private String qna_content;
	private Date qna_date;
	private int qna_pd_num;
	private String qna_user_email;
	private String qna_type;
	private String qna_rep;
	public Date getQna_date() {
		return qna_date;
	}
	public void setQna_date(Date qna_date) {
		this.qna_date = qna_date;
	}
	public int getQna_num() {
		return qna_num;
	}
	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}
	public String getQna_user() {
		return qna_user;
	}
	public void setQna_user(String qna_user) {
		this.qna_user = qna_user;
	}
	public String getQna_subject() {
		return qna_subject;
	}
	public void setQna_subject(String qna_subject) {
		this.qna_subject = qna_subject;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public int getQna_pd_num() {
		return qna_pd_num;
	}
	public void setQna_pd_num(int qna_pd_num) {
		this.qna_pd_num = qna_pd_num;
	}
	public String getQna_user_email() {
		return qna_user_email;
	}
	public void setQna_user_email(String qna_user_email) {
		this.qna_user_email = qna_user_email;
	}
	public String getQna_type() {
		return qna_type;
	}
	public void setQna_type(String qna_type) {
		this.qna_type = qna_type;
	}
	public String getQna_rep() {
		return qna_rep;
	}
	public void setQna_rep(String qna_rep) {
		this.qna_rep = qna_rep;
	}
	@Override
	public String toString() {
		return "QnaDTO [qna_num=" + qna_num + ", qna_user=" + qna_user + ", qna_subject=" + qna_subject
				+ ", qna_content=" + qna_content + ", qna_date=" + qna_date + ", qna_pd_num=" + qna_pd_num
				+ ", qna_user_email=" + qna_user_email + ", qna_type=" + qna_type + ", qna_rep=" + qna_rep + "]";
	}
	
	

}
