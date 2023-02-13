<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>ageInput.html(나이 입력) -> agePro.jsp(나이 확인 후 분기)</h2>
	<%
		int age = Integer.parseInt(request.getParameter("age"));
	%>
	<h2><%=age %>살 미성년자이므로 주류 구매 불가합니다</h2>
	<button onclick="history.back()">뒤로 가기</button>
	<button onclick="location.href='ex4_ageInput.html'">새로 입력</button>
</body>
</html>