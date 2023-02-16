<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="s" class="com.lec.ex.Student" scope="request"/>
	<jsp:setProperty property="*" name="s"/>
	<jsp:forward page="studentResult.jsp"></jsp:forward>
</body>
</html>