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
	<h2>모든 요청에서 cnt, list 출력 가능</h2>
	<h3>cnt : ${cnt }</h3>
	<h3>list : ${list }</h3>
	<h2>result5.jsp페이지입니다 (member/join5결과)</h2>
	<h3>이름: ${memberDTO.name }</h3>
	<h3>아이디: ${memberDTO.id }</h3>
	<h3>비밀번호: ${memberDTO.pw }</h3>
	<h3>나이: ${memberDTO.age }</h3>
	<h3>이메일: ${memberDTO.email }</h3>
	<h3>주소: ${memberDTO.address }</h3>
	<button onclick="history.go(-1)">뒤로가기</button>
	<button onclick="location.href='${conPath}/'">다시 입력받기</button>
</body>
</html>