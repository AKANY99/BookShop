package vo;

import java.util.Date;

public class OrderDTO {
	private int order_num;
	private int order_pd_num;
	private int order_pd_quan;
	private int order_pd_price;
	private String order_user;
	private Date order_date;
	private String order_status; // 상품준비, 배송중, 배송완료
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
	public int getOrder_pd_quan() {
		return order_pd_quan;
	}
	public void setOrder_pd_quan(int order_pd_quan) {
		this.order_pd_quan = order_pd_quan;
	}
	public int getOrder_pd_price() {
		return order_pd_price;
	}
	public void setOrder_pd_price(int order_pd_price) {
		this.order_pd_price = order_pd_price;
	}
	public String getOrder_user() {
		return order_user;
	}
	public void setOrder_user(String order_user) {
		this.order_user = order_user;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	
}


