<%@page import="java.util.ArrayList"%>
<%@page import="com.lect.dto.BookDto"%>
<%@page import="com.lec.dao.BookDao"%>
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
		BookDao bDao = BookDao.getInstance();
		BookDto book = new BookDto(0, "Spring", 30000, "noImg.png", "nothing.png", null, 10, null);
	%>
	<h1>책 등록</h1>
	<%
		int result = bDao.insertBook(book);
		if(result == BookDao.SUCCESS){
			out.println("성공");
		}else{
			out.println("실패" +book);
		}
	%>
	<h1>책 목록</h1>
	<%
		ArrayList<BookDto> books = bDao.bookList(4,6);
		for(int i=0; i<books.size(); i++){
			out.println(books.get(i)+"<br>");
		}
	%>
	<h1>등록된 책 갯수: <%=bDao.totalBook() %></h1>
	<h1>책 상세 보기: <%=bDao.getBook(1) %></h1>
</body>
</html>