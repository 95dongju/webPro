<%@page import="com.lec.ex.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
</head>
<body>
	<%
		//midConfirm.jsp?mid=aaa
		String mid = request.getParameter("mid");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.midConfirm(mid);
		if(result == MemberDao.EXISTENT){
			out.println("중복된 ID입니다.");
		}else{
			out.println("사용 가능한 ID입니다.");
		}
	%>
</body>
</html>