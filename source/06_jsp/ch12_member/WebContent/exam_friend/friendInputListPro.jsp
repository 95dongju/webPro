<%@page import="com.lec.friend.FriendDao"%>
<%@page import="com.lec.friend.FriendDto"%>
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
	<%
		request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.friend.FriendDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%	FriendDao dao = FriendDao.getInstance();
		int result = dao.addFriend(dto);
		if(result == FriendDao.FAIL){%>
		<script>
			alert('너무 긴 값은 입력이 불가능합니다.');
			history.back();
		</script>	
			
	<% }else{%>
		
		<script>
			alert('추가되었습니다.');
			location.href='friendInputList.jsp';
		</script>
		
	<% }%>
</body>
</html>