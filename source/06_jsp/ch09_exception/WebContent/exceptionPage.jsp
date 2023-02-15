<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- 이 페이지는 ex2.jsp(NullPointException, 0으로 나눌 때 예외 - 500상태)에서 예외가 발생하면 오는 페이지 --%>
<%@ page isErrorPage="true" %>
<% response.setStatus(200); // 사용자가 어떤 웹 브라우저를 쓸지 모르기 때문에 반드시 세팅해 둬야 함 %>
<%--
	200: 정상 상태
	404: 해당 문서를 찾을 수 없을 때
	500: 문법 오류나 예외 발생 상태
	407: 자바가 서버에서 인증을 받지 못한 경우 (아이디/패스워드 잘못됐을 경우)
	400: 권한
 --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		console.log('예외 타입 :  + <%=exception.getClass().getName() %>');
		console.log('예외 메세지 :  + <%=exception.getMessage() %>');
	</script>
</head>
<body>
	<h1>공사 중입니다. 조속한 시일 내에 복구하겠습니다.</h1>
	<%
		System.out.println();
	%>
</body>
</html>