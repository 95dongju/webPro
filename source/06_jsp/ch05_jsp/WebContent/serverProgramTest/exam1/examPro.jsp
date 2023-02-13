<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		String suStr = request.getParameter("btn");
		if(suStr==null){
			out.println("<h2>버튼을 누르지 않으셨습니다.</h2>");
		}else{			
			Random random = new Random();
			int com = random.nextInt(3-1+1)+1;
			int su = Integer.parseInt(suStr);
			if (su!=com){
				response.sendRedirect("exam.jsp?com="+com+"&su="+su);
			}
		}
	%>
	<h2>
		정답입니다! <br> 동전이 있던 곳은 <%=suStr %>
	</h2>
	<button onclick="location.href='exam.jsp'">다시 도전</button>
</body>
</html>