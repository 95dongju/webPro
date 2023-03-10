<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.ex.dto.MemberDto"%>
<%@page import="com.lec.ex.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>5. 회원정보 수정</h1>
	<%
		String mid = "aaa";
		MemberDao dao = MemberDao.getInstance();
		MemberDto member = dao.getMember(mid);
		out.println("<p>수정 전: " +member+ "</p>");
		member.setMname("나라");
		member.setMemail(null);
		member.setMaddress(null);
		dao.modifyMember(member);
		out.println("<p>수정 후: " +dao.getMember(mid)+ "</p>");
	%> 
	<h1>6. 회원 리스트</h1>
	<%
		ArrayList<MemberDto> members = dao.getMemberlist(4,6);
		for(MemberDto m : members){
			out.println(m+"<br>");
		}
	%>
	<h1>7. 회원수</h1>
	<%
		out.println("<p>"+dao.getMemberTotCnt()+"</p>");	
	%>
	<h1>8. 회원 탈퇴 (aaa)</h1>
	<%
	out.println("<p>"+dao.withdrawMember(mid)+"</p>");	
	%>
</body>
</html>