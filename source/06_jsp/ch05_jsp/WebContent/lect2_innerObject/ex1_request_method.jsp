<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/footer">
</head>
<body> <%-- 127.255.0.1 : IPv4(IPv6) --%>
	<h2>요청한 곳의 주소: ★<%=request.getRemoteAddr() %></h2>
	<h2>컨텍스트Path :  ★<%=request.getContextPath() %><%-- css 적용할 때 루트 폴더 지정 --%></h2>
	<h2>요청 방식 : <%=request.getMethod() %></h2>
	<h2>세션 객체 :  ★<%=request.getSession() %> (ex. 로그인/로그아웃 기록)</h2>
	<h2>요청 URL : <%=request.getRequestURL() %></h2>
	<h2>요청 URI :  ★<%=request.getRequestURI() %></h2>
	<h2>해당 프로토콜 : <%=request.getProtocol() %></h2>
	<h2>서버 이름 : <%=request.getServerName() %></h2>
	<h2>포트 번호: <%=request.getServerPort() %></h2>
</body>
</html>