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
</head>
<body>
	<h3>"현재 총 <span>${cnt }</span>명"</h3>
	<form action="input.do" method="get">
		<table>
			<caption>개인정보 입력</caption>
			<tr><td>이름:</td><td><input type="text" name="name" required="required" placeholder="홍길동"></td></tr>
			<tr><td>국어:</td><td><input type="number" name="kor" min="1" max="100" placeholder="100"></td></tr>
			<tr><td>영어:</td><td><input type="number" name="eng" min="1" max="100" placeholder="100"></td></tr>
			<tr><td>수학:</td><td><input type="number" name="mat" min="1" max="100" placeholder="99"></td></tr>
			<tr><td colspan="2"><input type="submit" value="입력"></td></tr>
		</table>
	</form>
</body>
</html>