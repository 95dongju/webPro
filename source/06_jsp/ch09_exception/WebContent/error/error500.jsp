<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page isErrorPage = "true" %> exception 내부 객체를 쓰기 위해 선언 --%>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
<%-- 	<script>
		console.log('예외 메세지 : <%= exception.getMessage()%>');
		console.log('예외 타입 : <%= exception.getClass().getName()%>');
	</script> --%>
</head>
<body>
	<h2>공사 중입니다. 빠른 시일 내로 복구하겠습니다.</h2>
	<h2>(error500.jsp)</h2> <!-- NullPointerException은 우선 순위가 높음. 프로젝트 할 때는 500, 404 에러를 주로 많이 넣음 -->
</body>
</html>