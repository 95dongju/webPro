<%@page import="java.util.ArrayList"%>
<%@page import="com.lect.dto.CustomerDto"%>
<%@page import="com.lec.dao.CustomerDao"%>
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
	<h1>회원가입 테스트</h1>
	<%
		CustomerDao cDao = CustomerDao.getInstance();
		String cid = "aaa";
		int result = cDao.confirmId(cid);
		if(result == CustomerDao.CUS_EXISTENT){
			out.println(cid+"는 중복된 아이디입니다.");
		}else{
			out.println(cid+"는 사용 가능한 아이디입니다.");
			CustomerDto customer = new CustomerDto(cid, "1", "김", null, null, null, null, null, null);
			result = cDao.joinCustomer(customer);
			out.println(result == CustomerDao.SUCCESS ? "회원가입 성공":"회원가입 실패");
		}
	%>
	<h1>로그인 테스트</h1>
	<%	
		result = cDao.loginCustomer("aaa", "222");
		out.println(result == CustomerDao.SUCCESS ? "회원가입 성공":"회원가입 실패");
	%>
	<h1>dto (회원정보) 가져오기</h1>
	<%
		CustomerDto customer = cDao.getCustomer(cid);
		out.println(customer);
	%>
	<h1>회원정보 수정</h1>
	<%
		customer.setCtel("010-1234-1234");
		customer.setCemail("test@test.com");
		customer.setCaddress("테스트");
		result = cDao.modifyCustomer(customer);
		out.println(result == CustomerDao.SUCCESS ? "수정 성공" : "수정 실패");
		customer = cDao.getCustomer(cid);
		out.println("수정 후 : " +customer);
	%>
	<h1>5. 회원목록</h1>
	<%
		ArrayList<CustomerDto> customers = cDao.CustomerList(1, 5);
		for(int i=0 ; i<customers.size() ; i++){
			out.println(i + "번째 : " + customers.get(i) + "<br>");
		}
	%>
</body>
</html>