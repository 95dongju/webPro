<%@page import="com.lec.member.MemberDaoConn"%>
<%@page import="java.sql.Date"%>
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
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.member.MemberDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String tempBirth = request.getParameter("tempBirth"); // ""
		if(!tempBirth.equals("")){
			dto.setBirth(Date.valueOf(tempBirth));
			// dto의 birth가 Timestamp형이면 : dto.setBirth(Timestamp.valueOf(tempBirth+" 00:00:00"));
		}
		MemberDaoConn mDao = new MemberDaoConn();
		int result = mDao.confirmId(dto.getId()); // id 중복체크 
		if(result == MemberDaoConn.MEMBER_NONEXISTENT){
			// 사용 가능한 id - 회원 가입 진행
			result = mDao.joinMember(dto);
			if(result == MemberDaoConn.SUCCESS){
				// 회원가입 성공
				session.setAttribute("id", dto.getId());
		%>
			<script>
				alert('회원가입 감사합니다');
				location.href='login.jsp';
			</script>
		<%		
			}else{
				// 회원가입 실패
		%>
			<script>
				alert ('회원가입이 실패되었습니다.');
				location.href='join.jsp';
			</script>
		<%
			}
		}else{%>
			// 중복된 id - join.jsp로
			<script>
				alert('중복된 id입니다. 다른 아이디를 사용하세요.');
				history.back();
			</script>
			
		<%}
	%>
</body>
</html>