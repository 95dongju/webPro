<%@page import="com.lec.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.BoardDao"%>
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
	<table>
		<caption>게시판</caption>
		<tr><td><a href="<%=conPath %>/board/writeForm.jsp">글쓰기</a></td></tr>
	</table>
	<table>
		<tr><th>글번호</th><th>작성자</th><th>글제목</th><th>메일</th><th>조회수</th></tr>
		<%
			/*
				list.jsp 또는 list.jsp?pageNum=19
			*/
			String pageNum = request.getParameter("pageNum");
			if(pageNum==null) pageNum = "1"; // 전달 받은 pageNum 파라미터가 없으면 1 page로 전환
			int currentPage = Integer.parseInt(request.getParameter("pageNum"));
			final int PAGESIZE = 10, BLOCKSIZE = 10;
			int startRow = (currentPage - 1) * PAGESIZE + 1;
			int endRow = startRow + PAGESIZE - 1;
			out.print("<tr><td>startRow: " +startRow + ", endRow : " +endRow + "</td></tr>");
			BoardDao bDao = BoardDao.getInstance();
			int totalCnt = bDao.getBoardTotalCnt(); // 글 갯수
			if(totalCnt == 0){
				// out.println("<tr><td colspan='5'>등록된 글이 없습니다</td></tr>");
			}else{
				ArrayList<BoardDto> dtos = bDao.listBoard(startRow, endRow);
				for(BoardDto dto : dtos){
					// 글 번호
					out.println("<tr><td>"+dto.getNum()+"</td>");
					// 작성자
					out.println("<td>"+dto.getWriter()+"</td>");
					// 글제목(조회수가 10 이상 -> hot 이미지와 같이 제목 출력, 글 제목 클릭 -> 상세 보기 페이지로 이동)
					out.println("<td class='left'>");
					if(dto.getReadcount() > 10){
						out.println("<img src='"+conPath+"/img/hot.gif'>");
					}
					out.println("<a href='"+conPath+"/board/content.jsp?num="+dto.getNum()+"'>"+dto.getSubject()+"</a></td>");
					
					
					// 메일
					out.println("<td>" + (dto.getEmail()==null?"-":dto.getEmail()) + "</td>");
					// 조회수
					out.println("<td>"+dto.getReadcount()+"</td></tr>");
				}
			}
		%>
	</table>
</body>
</html>