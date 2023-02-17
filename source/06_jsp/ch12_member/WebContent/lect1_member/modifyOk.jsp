<%@page import="com.lec.member.MemberDao"%>
<%@page import="com.lec.member.MemberDto"%>
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
	<%-- modifyOk.jsp에서 전달 받은 파라미터 : 
		id, pw(바꾸고 싶은 새 비번), name, phone1, phone2, phone3, gender, email, address (MemberDto) 
		tempBirth, oldPw(현재 비번) (dto에 없는 파라미터 변수)
	--%>
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.member.MemberDto" scope="page"/>
	<jsp:setProperty name="dto" property="*"/>
	<%
		String tempBirth = request.getParameter("tempBirth");
		if(!tempBirth.equals("")){
			dto.setBirth(Date.valueOf(tempBirth));
			// dto.setBirth(Timestame.valueOf(tempBirth + "00:00:00"));
		}
		MemberDto member = (MemberDto)session.getAttribute("member"); // 세션의 pw가 필요
		String sessionPw = null;
		if(member!=null){		
			sessionPw = member.getPw(); // 세션 -> member -> pw
		}
		String oldPw = request.getParameter("oldPw");
		if(sessionPw.equals(oldPw)){
			// 비밀번호를 맞게 입력한 경우 정보 수정 진행
			if(dto.getPw()==null){
				// 새 비밀번호를 현 비밀번호로
				dto.setPw(oldPw);
			}
			MemberDao mDao = MemberDao.getInstance();
			int result = mDao.modifyMember(dto);
			if(result == MemberDao.SUCCESS){
				// 정보 수정 성공
				session.setAttribute("member", dto); // 수정된 정보를 세션 속성으로 변경
			%>
				<script>
					alert('정보 수정이 완료되었습니다');
					location.href='main.jsp';
				</script>
			<%}else{
				// 수정 실패 %>
			<script>
				alert('회원정보 수정이 실패되었습니다. 입력한 정보가 너무 깁니다.');
				location.href='modify.jsp';
			</script>
			<%} %>
		<%}else {
			// 비밀번호가 틀렸을 경우 modify.jsp로 넘김%>
			<script>
				alert('비밀번호를 잘못 입력하셨습니다.');
				history.back();
			</script>
		<%} %>
</body>
</html>