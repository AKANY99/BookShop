package vo;

import java.sql.Date;

//CREATE TABLE ordDetail(
//		order_num int NOT NULL,
//		order_pd_num int NOT NULL,
//		order_quan int NOT NULL,
//		order_pd_price int NOT NULL,
//		constraint ord_num_fk foreign key(order_num) references ord(order_num),
//		constraint ord_pdn_fk foreign key(order_pd_num) references product(pd_num)
//);

//insert into ordDetail value(1,5,5,20000);

public class OrdDetailDTO {
	private int order_num;
	private int order_pd_num;
	private int order_quan;
	private int order_pd_price;
	
	//조인용 멤버
	private String pd_file;
	private String pd_subject;

	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public int getOrder_pd_num() {
		return order_pd_num;
	}
	public void setOrder_pd_num(int order_pd_num) {
		this.order_pd_num = order_pd_num;
	}
	public int getOrder_quan() {
		return order_quan;
	}
	public void setOrder_quan(int order_quan) {
		this.order_quan = order_quan;
	}
	public int getOrder_pd_price() {
		return order_pd_price;
	}
	public void setOrder_pd_price(int order_pd_price) {
		this.order_pd_price = order_pd_price;
	}


	
	// 조인용 get, set
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
	

	
	
}
