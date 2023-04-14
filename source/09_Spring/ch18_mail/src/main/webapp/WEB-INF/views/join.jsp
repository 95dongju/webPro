<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script>
		$(document).ready(function(){
			
		});
	</script>
</head>
<body>
	<form action="textMail" method="post">
		<p>이름<input type="text" name="name" required="required">
		<p>메일<input type="email" name="email" required="required">
		<input type="submit" value="회원가입(TEXT 단순 메일 발송)">
	</form>
	<form action="htmlMail" method="post">
		<p>이름<input type="text" name="name" required="required">
		<p>메일<input type="email" name="email" required="required">
		<input type="submit" value="회원가입(HTML 단순 메일 발송)">
	</form>
</body>
</html>