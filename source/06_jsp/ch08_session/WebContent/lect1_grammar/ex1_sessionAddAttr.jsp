<%@page import="com.lec.ex.Member"%>
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
		Member member = new Member("aaa", "111", "홍길동");
		// 세션에 데이터를 저장 = 세션에 속성을 추가
		session.setAttribute("sessionName", "sessionValue"); // 세션속성이름, 세션속성값
		session.setAttribute("sessionNum", 123); // String만 저장할 수 있는 쿠키와는 다르게 타입 제한 없음 객체도 넣을 수 있음
		// session.setAttribute("sessionNum", new Integer (123)); 
		session.setAttribute("member", member);
		// jsp 파일에서는 session이 내장 객체라서 바로 사용 가능. 자바(서블릿)에서는 session을 사용하려면 다음과 같이 사용
		HttpSession session2 = request.getSession();
		
	%>
	<h2>session의 sessionName 속성값 : <%=session.getAttribute("sessionName") %></h2>
	<h2>session의 sessionNum 속성값: <%=session.getAttribute("sessionNum") %></h2>
	<h2>session의 member 속성값: <%=session.getAttribute("member") %></h2>
	<hr>
	<h2>세션 고유 ID: <%=session.getId() %></h2>
	<h2>세션 유효 시간: <%=session.getMaxInactiveInterval() %></h2>
	<hr>
	<a href="ex1_sessionAddAttr.jsp">세션 데이터 추가</a><br>
	<a href="ex2_sessionGet.jsp">특정 세션 가져오기</a><br>
	<a href="ex3_sessionList.jsp">세션의 속성 리스트</a><br>
	<a href="ex4_sessionRemove.jsp">세션 삭제 (특정 세션이나 모든 세션 데이터)</a>
</body>
</html>