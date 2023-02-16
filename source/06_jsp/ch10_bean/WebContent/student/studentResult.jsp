<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="s" class="com.lec.ex.Student" scope="request"/>
	<h2>입력한 학생 정보</h2>
	<p>학번: <jsp:getProperty property="noStudent" name="s"/></p>
	<p>이름: <jsp:getProperty property="sName" name="s"/></p>
	<p>학년: <jsp:getProperty property="sGrade" name="s"/></p>
	<p>반 : <jsp:getProperty property="sClass" name="s"/></p>
	<p>점수: <jsp:getProperty property="score" name="s"/></p>
	
</body>
</html>