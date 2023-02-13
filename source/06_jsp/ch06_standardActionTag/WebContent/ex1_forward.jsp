<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- 요청 url: ex1_forward.jsp?n=1 -->
	<h2>ex1_forward.jsp입니다</h2>
	<jsp:forward page="ex2_forward.jsp"/> <!-- 주소창의 url 보존 = 화면만 변경됨 (새로운 request 객체가 만들어지지 않고 보존됨) -->
	<%--
		response.sendRedirect("ex2_forward.jsp"); // 주소창의 url이 바뀜= 새로운 요청이 server에 들어감(새로운 request 객체)
	--%>
</body>
</html>