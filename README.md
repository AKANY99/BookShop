테이터베이스와 테이블
create database bookshop;

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
	user_date date not null
);

create table product(
	pd_num int primary key,
	pd_type varchar(10) not null,
	pd_name varchar(10) not null,
	pd_price int not null,
	pd_quan int not null,
	pd_file varchar(100) not null,
	pd_subject varchar(50) not null,
	pd_content varchar(500) not null,
	pd_count int not null,
	pd_date date not null
);

create table review(
	 review_num int primary key,
	 review_pd_num int,
	 review_subject varchar(20),
	 review_content varchar(500),
	 review_score float
);

CREATE TABLE qna (
	qna_num INT PRIMARY KEY,
	qna_user VARCHAR(30),
	qna_subject VARCHAR(50) NOT NULL,
	qna_content VARCHAR(100) NOT NULL,
	qna_date DATE,
	qna_pd_num INT,
	qna_user_email VARCHAR(50) NOT NULL,
	qna_type VARCHAR(15) NOT NULL,
	qna_rep VARCHAR(200)
);

장바구니  
CREATE TABLE cart(
	cart_user_num int NOT NULL,
	cart_pd_num int NOT NULL,
	cart_pd_quan int NOT NULL,
	constraint user_num_fk FOREIGN KEY(cart_user_num) REFERENCES user(user_num),
	constraint pd_num_fk FOREIGN KEY(cart_pd_num) REFERENCES product(pd_num)
);

USER =추가
create table user(
	user_num int primary key,
	user_name varchar(10) not null,
	user_email varchar(50) unique not null,
	user_passwd varchar(30) not null,
	user_gender varchar(2) not null,
	user_jumin varchar(30) not null,
	user_address_code int not null,
	user_address varchar(100) not null,
	user_phone varchar(40) not null,
	user_date date not null
	user_points int default 0,
	user_purchased int default 0
);


관심목록(찜목록)
CREATE TABLE interest(
	inter_user_num int NOT NULL,
	inter_pd_num int NOT NULL,
	constraint int_user_num_fk FOREIGN KEY(inter_user_num) REFERENCES user(user_num),
	constraint int_pd_num_fk FOREIGN KEY(inter_pd_num) REFERENCES product(pd_num)
);

주문테이블 추가
CREATE TABLE ord(
	order_num int primary key,
	order_pd_num int not null,
	order_quan int not null,
	order_pd_price int not null,
	order_user_email varchar(50) not null,
	order_date date not null,
	order_status varchar(10) not null,
	constraint ord_pdn_fk foreign key(order_pd_num)
	references product(pd_num),
	constraint ord_u_fk foreign key(order_user_email)
	references user(user_email)
);





ex) 상품 등록
insert into product values(1, '국내도서', '사람1', 10000, 6, '역행자_표지.jpg', '책1', '역행자_소개.jpg', 0, now());
insert into product values(2, 'eBook', '사람1', 10000, 6, '역행자_표지.jpg', '책1', '역행자_소개.jpg', 0, now());
insert into product values(3, '해외도서', '사람1', 10000, 6, '역행자_표지.jpg', '책1', '역행자_소개.jpg', 0, now());
insert into product values(4, '국내도서', '사람1', 10000, 6, '역행자_표지.jpg', '책1', '역행자_소개.jpg', 0, now());
insert into product values(5, 'eBook', '사람1', 10000, 6, '역행자_표지.jpg', '책1', '역행자_소개.jpg', 0, now());
insert into product values(6, '해외도서', '사람1', 10000, 0, '역행자_표지.jpg', '책1', '역행자_소개.jpg', 0, now());
insert into product values(7, '국내도서', '사람1', 10000, 0, '역행자_표지.jpg', '책1', '역행자_소개.jpg', 0, now());
insert into product values(8, 'eBook', '사람1', 10000, 6, '역행자_표지.jpg', '책1', '역행자_소개.jpg', 0, now());
insert into product values(9, '해외도서', '사람1', 10000, 0, '역행자_표지.jpg', '책1', '역행자_소개.jpg', 0, now());
insert into product values(10, '국내도서', '사람1', 10000, 6, '역행자_표지.jpg', '책1', '역행자_소개.jpg', 0, now());
insert into product values(11, '해외도서', '사람1', 10000, 6, '역행자_표지.jpg', '책1', '역행자_소개.jpg', 0, now());
insert into product values(12, '국내도서', '사람1', 10000, 6, '역행자_표지.jpg', '책1', '역행자_소개.jpg', 0, now());
insert into product values(13, 'eBook', '사람1', 10000, 0, '역행자_표지.jpg', '책1', '역행자_소개.jpg', 0, now());
insert into product values(14, '해외도서', '사람1', 10000, 6, '역행자_표지.jpg', '책1', '역행자_소개.jpg', 0, now());
insert into product values(15, '국내도서', '사람1', 10000, 6, '역행자_표지.jpg', '책1', '역행자_소개.jpg', 0, now());
insert into product values(16, 'eBook', '인간1', 900000, 0, '역행자_표지.jpg', 'ㅁㅁ음음음ㅁㅁ', '역행자_소개.jpg', 0, '2022-08-01');

ex) 사용자 등록
INSERT INTO user VALUES (1, '관리자', 'admin', '12341234', '남', '123123-1234123', 1234, '부산언저리', '010-1234-1234', now());
INSERT INTO user VALUES (2, '멍멍이', 'mungmung@naver.com', '12341234', '남', '123123-1234123', 46586, '부산 뭐시기', '010-1234-1234', now());
INSERT INTO user VALUES (3, '냥냥이', 'myaymya@naver.com', '12341234', '남', '123123-1234123', 46586, '부산 뭐시기', '010-1234-1234', now());
INSERT INTO user VALUES (4, '냥냥이2', 'myaymya2@naver.com', '12341234', '남', '123123-1234123', 46586, '부산 뭐시기', '010-1234-1234',  now());
