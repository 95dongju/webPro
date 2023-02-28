<%@page import="com.lect.dto.FileboardDto"%>
<%@page import="com.lec.dao.FileboardDao"%>
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
	<%
		FileboardDao fDao = FileboardDao.getInstance();
		FileboardDto fDto = new FileboardDto();
		for(int i=0; i<=70; i++){
			if(i%3==0){
				fDto.setCid("aaa");
			}else if(i%3==1){
				fDto.setCid("bbb");
			}else{
				fDto.setCid("ccc");
			}
			fDto.setFsubject("for문으로 입력"+i);
			fDto.setFcontent("본문");
			if(i%5==0){
				fDto.setFfilename("1.docx");
			}else{
				fDto.setFfilename(null);
			}
			fDto.setFpw("111");
			fDto.setFip("192.1.1."+i);
			System.out.println(fDao.insertFileboard(fDto)==1 ? i+"번째 성공":i+"번째 실패");
		}
		response.sendRedirect("fboardList.jsp");
	%>
</body>
</html>