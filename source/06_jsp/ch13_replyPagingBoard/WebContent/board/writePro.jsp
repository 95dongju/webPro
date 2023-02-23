<%@page import="com.lec.dto.BoardDto"%>
<%@page import="com.lec.dao.BoardDao"%>
<%@page import="java.sql.Timestamp"%>
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
		// num, ref, re_step, re_indent (0 or 원글의 정보)
		// writer, subject, content, email, pw (원글 or 답변글)
		request.setCharacterEncoding("utf-8"); 
		/* pageNum */
		String pageNum = request.getParameter("pageNum");
		
		
	%>
	<jsp:useBean id="dto" class="com.lec.dto.BoardDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		dto.setIp(request.getRemoteAddr()); // 클라이언트가 요청한 컴퓨터의 ip 주소
		// dto.setRdate(new Timestamp(System.currentTimeMillis()));
		BoardDao bDao = BoardDao.getInstance();
		int result;
		int num = dto.getNum();
		if(num==0){ // 원글쓰기
			result = bDao.insertBoard(dto);
		}else{
			result = bDao.reply(dto);
		}
		if(result == BoardDao.SUCCESS){
	%>
		<script>
			alert('<%=num==0?"글이" : "답변글이 "%> 등록되었습니다');
			location.href='<%=conPath%>/board/list.jsp?pageNum=<%=pageNum%>';
		</script>
	<%	}else{	%>
		<script>
			alert('<%=num==0? "글 " : "답변글 " %> 등록 실패');
			history.back();
		</script>
	<%	} %>
	<%=dto %>
</body>
</html>