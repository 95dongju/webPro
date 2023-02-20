<%@page import="com.lec.customer.CustomerDao"%>
<%@page import="com.lec.customer.CustomerDto"%>
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
	<jsp:useBean id="dto" class="com.lec.customer.CustomerDto" scope="page"/>
	<jsp:setProperty name="dto" property="*"/>
	<%
		String tempBirth = request.getParameter("tempBirth");
		if(!tempBirth.equals("")){
			dto.setCbirth(Date.valueOf(tempBirth));
		}
		CustomerDto customer = (CustomerDto)session.getAttribute("customer");
		String sessionPw = null;
		if(customer!=null){		
			sessionPw = customer.getCpw();
		}
		String oldPw = request.getParameter("oldPw");
		if(sessionPw.equals(oldPw)){
			if(customer.getCpw()==null){
				dto.setCpw(oldPw);
			}
			CustomerDao cDao = CustomerDao.getInstance();
			int result = cDao.modifyCustomer(dto);
			if(result == CustomerDao.SUCCESS){
				session.setAttribute("customer", dto);
			%>
				<script>
					alert('정보 수정이 완료되었습니다');
					location.href='main.jsp';
				</script>
			<%}else{ %>
			<script>
				alert('회원정보 수정이 실패되었습니다. 입력한 정보가 너무 깁니다.');
				location.href='modify.jsp';
			</script>
			<%} %>
		<%}else {%>
			<script>
				alert('비밀번호를 잘못 입력하셨습니다.');
				history.back();
			</script>
		<%} %>
</body>
</html>