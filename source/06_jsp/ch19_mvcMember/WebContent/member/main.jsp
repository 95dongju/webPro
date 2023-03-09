<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<c:if test="${loginResult eq SUCCESS}">
		<script>
			alert('${getMember.mname}님 환영합니다!');
		</script>
	</c:if>
	<c:if test="${loginResult eq FAIL}">
		<script>
			alert('아이디/비밀번호를 확인해 주세요');
			history.back();
		</script>
	</c:if>
	<c:if test="${joinResult eq SUCCESS}">
		<script>
			alert('환영합니다!');
		</script>
	</c:if>
	<c:if test="${param.mid != null }">
		<div>
			<p>${getMember.mname }(${param.mid })님 어서오세요</p>
			<hr>
			<button onclick="location.href='${conPath}/logout.do'">로그아웃</button>
		</div>
	</c:if>
	<c:if test="${param.mid eq null }">
		<div>
			<p>로그인 상태가 아닙니다</p>
			<hr>
			<button onclick="location.href='${conPath}/loginView.do'">로그인</button>
			<button onclick="location.href='${conPath}/joinView.do'">회원가입</button>
		</div>
	</c:if>
</body>
</html>