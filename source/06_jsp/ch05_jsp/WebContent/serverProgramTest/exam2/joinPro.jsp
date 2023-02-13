<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="join.css" rel="stylesheet">
</head>
<body>
	<form action="joinPro.jsp" method="post" id="joinForm_wrap">
		<table>
			<caption id="join_title">회원가입 정보</caption>
	<%
		request.setCharacterEncoding("utf-8");
		out.println("<tr><td>");
		out.println("name : " + request.getParameter("name"));
		out.println("</td></tr><tr><td>");
		out.println("id : " + request.getParameter("id"));
		out.println("</td></tr><tr><td>");
		out.println("pw : " + request.getParameter("pw"));
		out.println("</td></tr><tr><td>");
		out.println("birth : " + request.getParameter("birth"));
		out.println("</td></tr><tr><td>");;
		String[] hobby = request.getParameterValues("hobby");
		out.println("hobby : " + Arrays.toString(hobby));
		out.println("</td></tr><tr><td>");
		out.println("gender : " + request.getParameter("gender"));
		out.println("</td></tr><tr><td>");
		out.println("email : " + request.getParameter("email"));
		out.println("</td></tr><tr><td>");
		String mailSend = request.getParameter("mailSend");
		String mail = (mailSend==null)? "모두 수신 거부" : mailSend;
		out.println("mailSend : " + mail);
		out.println("</td></tr><tr><td>");
		Date date 		= new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		out.println("가입일 : " + sdf.format(date));
		out.println("</td></tr><tr><td>");
		String ip = request.getRemoteAddr();
		out.println("가입IP : " + ip);
		out.println("</td></tr>");
		
	%>	
		</table>
	</form>
</body>
</html>