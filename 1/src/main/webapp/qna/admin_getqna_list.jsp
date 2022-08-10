<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

//DB 작업에 필요한 문자열 선언
String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/bookshop";
String user = "root";
String password = "1234";

// 1단계. 드라이버 로드
Class.forName(driver);

// 2단계. DB 연결
Connection con = DriverManager.getConnection(url, user, password);

// 3단계. SQL 작성 및 전달
String sql = "SELECT * FROM qna WHERE ";
PreparedStatement pstmt = con.prepareStatement(sql);

ResultSet rs = pstmt.executeQuery();




%>