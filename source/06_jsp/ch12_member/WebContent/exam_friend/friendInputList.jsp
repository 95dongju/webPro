<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.friend.FriendDao"%>
<%@page import="com.lec.friend.FriendDto"%>
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
	<form action="friendInputListPro.jsp" name="frm">
	<p>
		친구이름 <input type="text" name="name" size="3">
		전화 <input type="text" name="tel" size="4">
			<input type="submit" value="추가">
	</p>
		<table>
			<tr><th>순번</th><th>이름</th><th>전화번호</th></tr>
			<%
				FriendDao dao = FriendDao.getInstance();
				ArrayList<FriendDto> dtos = dao.friendList();
				if(dtos.isEmpty()){
					out.println("<tr><td colspan='3'>친구가 없습니다</td></tr>");
				}else{
					for(FriendDto dto : dtos){
						int no = dto.getNo();
						String name = dto.getName();
						String tel = dto.getTel();
						out.println("<tr><td>"+no+"</td><td>"+name+"</td><td>"+(tel==null?"":tel)+"</td></tr>");
					}
				}
			%>
		</table>
	</form>
</body>
</html>