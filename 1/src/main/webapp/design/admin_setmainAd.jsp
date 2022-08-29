<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">



</script>
</head>
<body>
<form action="ChangeMainAdPro.ad"  method="post" enctype="multipart/form-data">
<input type="hidden" name="ad_num" value=${ad_num }>
	<table border="1">
	<tr>
		<th>선택</th>
		<th>No.</th>
		<th>제목</th>
		<th>img</th>
	</tr>
	<c:forEach var="pd" items="${pdList }">
		<tr>
		<td><input type="radio" name="ad_pd_num" value="${pd.pd_num }" required="required"></td>
		<td>pd.pd_num</td>
		<td>${pd.pd_subject }</td>
		<td><img src="upload/${pd.pd_file }"></td>
		</tr>
	</c:forEach>
	</table>
<input type="text" name="ad_subject" width="auto" placeholder="슬라이드에 표시될 제목" required="required">
<input type="file" name="ad_file" required="required">	
<input type="submit">
</form>


</body>
</html>