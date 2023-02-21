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
	<script>
		const search = function(){
			var name = frm.name.value;
			var tel = frm.tel.value;
			location.href = 'friendInputList2.jsp?name='+name+'&tel='+tel;
			// friendInputList2.jsp?name=길&tel=999;
		};
	</script>
</head>
<body>
	<form action="friendInputListPro2.jsp" name="frm">
	<p>
		친구이름 <input type="text" name="name" size="10"
				value='<%
					String name = request.getParameter("name");
					if(name!=null) out.print(name);
				%>'>
		전화 <input type="text" name="tel" size="10"
				value='<%
					String tel = request.getParameter("tel");
					if(tel!=null) out.print(tel);
				%>'>
			<input type="button" value="검색" onclick="search()">
			<input type="submit" value="추가">
	</p>
		<table>
			<tr><th>순번</th><th>이름</th><th>전화번호</th></tr>
			<%
				FriendDao dao = FriendDao.getInstance();
				ArrayList<FriendDto> dtos = dao.getSchFriends(name, tel);
				if(dtos.isEmpty()){
					out.println("<tr><td colspan='3'>친구가 없습니다</td></tr>");
				}else{
					for(FriendDto dto : dtos){
						out.println("<tr><td>"+dto.getNo()+"</td><td>"+dto.getName()+"</td><td>"+(dto.getTel()==null?"":dto.getTel())+"</td></tr>");
					}
				}
			%>
		</table>
	</form>
</body>
</html>