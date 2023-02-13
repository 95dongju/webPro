<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="examPro.jsp" method="get" >
		<button value="1" name="btn">1번</button>
		<button value="2" name="btn">2번</button>
		<button value="3" name="btn">3번</button>
	</form>
	<div id="msg">
		<%
			String com = request.getParameter("com");
			String su = request.getParameter("su");
			if(com!=null){
				out.println("<h2>틀렸네요. 다시 해보세요<br> 입력한 수는 " +su+ ", 정답은 "+com+"</h2>");
			}
		%>
	</div>
</body>
</html>