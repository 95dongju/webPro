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
	<h1>특정 쿠키(쿠키 이름이 cookieName인 쿠키) 찾고 값 확인</h1>
	<%
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			int idx;
			for(idx=0; idx<cookies.length; idx++){
				String name = cookies[idx].getName(); // idx번째의 쿠키 이름
				if(name.equals("cookieName")){					
					String value = cookies[idx].getValue(); // 쿠키값
					out.println("<h3>찾고자 하는 쿠키의 이름: " +name+", 값" +value+ "</h3>");
					break;
				}
			}
		}else{
			out.println("<h3>생성된 쿠키가 없습니다</h3>");
		}
	%>
</body>
</html>