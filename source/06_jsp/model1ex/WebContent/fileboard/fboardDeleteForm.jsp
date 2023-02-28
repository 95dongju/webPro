<%@page import="com.lect.dto.FileboardDto"%>
<%@page import="com.lec.dao.FileboardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/content.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form" style="padding:40px;">
		<%
			String pageNum = request.getParameter("pageNum");
			int fnum = Integer.parseInt(request.getParameter("fnum"));
			FileboardDao fDao = FileboardDao.getInstance();
			FileboardDto fDto = fDao.
		%>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>