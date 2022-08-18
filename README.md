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

ex) 상품 등록
insert into product values(1, '국내도서', '사람1', 10000, 6, '역행자_표지.jpg', '책1', '역행자_소개.jpg', now());
insert into product values(2, 'eBook', '사람1', 10000, 6, '역행자_표지.jpg', '책1', '역행자_소개.jpg', now());
insert into product values(3, '해외도서', '사람1', 10000, 6, '역행자_표지.jpg', '책1', '역행자_소개.jpg', now());
insert into product values(4, '국내도서', '사람1', 10000, 6, '역행자_표지.jpg', '책1', '역행자_소개.jpg', now());
insert into product values(5, 'eBook', '사람1', 10000, 6, '역행자_표지.jpg', '책1', '역행자_소개.jpg', now());
insert into product values(6, '해외도서', '사람1', 10000, 0, '역행자_표지.jpg', '책1', '역행자_소개.jpg', now());
insert into product values(7, '국내도서', '사람1', 10000, 0, '역행자_표지.jpg', '책1', '역행자_소개.jpg', now());
insert into product values(8, 'eBook', '사람1', 10000, 6, '역행자_표지.jpg', '책1', '역행자_소개.jpg', now());
insert into product values(9, '해외도서', '사람1', 10000, 0, '역행자_표지.jpg', '책1', '역행자_소개.jpg', now());
insert into product values(10, '국내도서', '사람1', 10000, 6, '역행자_표지.jpg', '책1', '역행자_소개.jpg', now());
insert into product values(11, '해외도서', '사람1', 10000, 6, '역행자_표지.jpg', '책1', '역행자_소개.jpg', now());
insert into product values(12, '국내도서', '사람1', 10000, 6, '역행자_표지.jpg', '책1', '역행자_소개.jpg', now());
insert into product values(13, 'eBook', '사람1', 10000, 0, '역행자_표지.jpg', '책1', '역행자_소개.jpg', now());
insert into product values(14, '해외도서', '사람1', 10000, 6, '역행자_표지.jpg', '책1', '역행자_소개.jpg', now());
insert into product values(15, '국내도서', '사람1', 10000, 6, '역행자_표지.jpg', '책1', '역행자_소개.jpg', now());
insert into product values(16, 'eBook', '인간1', 900000, 0, '역행자_표지.jpg', 'ㅁㅁ음음음ㅁㅁ', '역행자_소개.jpg', '2022-08-01');

ex) 사용자 등록
INSERT INTO user VALUES (1, '관리자', 'admin', '12341234', '남', '123123-1234123', 1234, '부산언저리', '010-1234-1234', now());
INSERT INTO user VALUES (2, '멍멍이', 'mungmung@naver.com', '12341234', '남', '123123-1234123', 46586, '부산 뭐시기', '010-1234-1234', now());
INSERT INTO user VALUES (3, '냥냥이', 'myaymya@naver.com', '12341234', '남', '123123-1234123', 46586, '부산 뭐시기', '010-1234-1234', now());
INSERT INTO user VALUES (4, '냥냥이2', 'myaymya2@naver.com', '12341234', '남', '123123-1234123', 46586, '부산 뭐시기', '010-1234-1234',  now());
