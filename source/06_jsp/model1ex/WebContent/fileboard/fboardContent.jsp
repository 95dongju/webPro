<%@page import="com.lect.dto.CustomerDto"%>
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
	<link href="<%=conPath %>/css/content.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<%
			String pageNum = request.getParameter("pageNum");
			int fnum = Integer.parseInt(request.getParameter("fnum"));
			FileboardDao fDao = FileboardDao.getInstance();
			FileboardDto fDto = fDao.getFileboardOneLine(fnum); // 글 번호로 글 상세정보 가져오기
			fDao.hitcountUp(fnum); // 조회수 1 올리기
		%>
		<table>
			<caption><%=fnum %>번 글 상세보기</caption>
			<tr><th>글번호</th><td><%=fDto.getFnum() %></td></tr>
			<tr><th>글제목</th><td><%=fDto.getFsubject() %></td></tr>
			<tr>
				<th>작성자</th>
				<td>
					<%=fDto.getCname() %> : <%=fDto.getCid() %>
					<%if(fDto.getCemail()!=null){%>
						(<a href="mailto:<%=fDto.getCemail()%>">
							<%=fDto.getCemail() %>
						</a>)
					<%}else{ %>
						-
					<%} %>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<%if(fDto.getFfilename()==null){ %>
						첨부파일 없음
					<%}else{ %>
						<a href="<%=conPath %>/fileboardUpload/<%=fDto.getFfilename() %>">
							<%=fDto.getFfilename() %>
						</a>
					<%} %>
				</td>
			</tr>
			<tr>
				<th>본문</th>
				<td><pre><%=fDto.getFcontent() %></pre></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><%=fDto.getFrdate() %></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><%=fDto.getFhit() %></td>
			</tr>
			<tr>
				<th>IP</th>
				<td><%=fDto.getFip() %></td>
			</tr>
			<tr>	
				<td colspan="2">
				<%
					String cid = null;
					CustomerDto customer = (CustomerDto)session.getAttribute("customer");
					if(customer!=null){
						cid = customer.getCid();
					}
					if(fDto.getCid().equals(cid)){
				%>
					<button onclick="location.href='fboardUpdateForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">수정</button>
				<%}%>
				<%if(customer!=null){ %>
					<button onclick="location.href='fboardWriteForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">답변</button>
				<%} %>
					<button onclick="location.href='fboardDeleteForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">삭제</button>
					<button onclick="location.href='fboardList.jsp?pageNum=<%=pageNum%>'">목록</button>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>