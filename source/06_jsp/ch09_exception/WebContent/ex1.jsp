<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%! int num1, num2; %>
	<%  num1 = Integer.parseInt(request.getParameter("num1"));
		num2 = Integer.parseInt(request.getParameter("num2"));
		out.println("<h2>num1 = " + num1 + "</h2>");
		out.println("<h2>num2 = " + num2 + "</h2>");
		out.println("<h2>num1+num2 = " + (num1+num2) + "</h2>");
		try{		
			out.println("<h2>num1/num2 = " + (num1/num2) + "</h2>");
		}catch(Exception E){
			out.print("<h3>0으로 나눌 수 없습니다</h3>");
		}
		out.println("<h2>num1*num2 = " + (num1*num2) + "</h2>");
		out.println("<h2>num1-num2 = " + (num1-num2) + "</h2>");
	%>
</body>
</html>