<%@page import="com.lec.dao.BoardDao"%>
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
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String pw = request.getParameter("pw");
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.deleteBoard(num, pw);
		if(result == BoardDao.SUCCESS){
	%>
			<script>
				alert('<%=num%>번 글 삭제 완료');
				location.href = '<%=conPath%>/board/list.jsp?pageNum=<%=pageNum%>';
			</script>
	<%	}else{ %>
			<script>
				alert('<%=num%>번 글 삭제 실패');
				history.back();
			</script>
	<%  } %>
</body>
</html>