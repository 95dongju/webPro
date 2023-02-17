<%@page import="java.sql.Date"%>
<%@page import="com.lec.dto.EmpDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.EmpDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); 
	String searchName = request.getParameter("searchName");
	if(searchName==null){
		searchName = "";
	}
	%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="">
		<p>
			사원명<input type="text" name="searchName" value="<%=searchName.toUpperCase().trim() %>">
			<input type="submit" value="검색">
		</p>
			<table>
				<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th><th>입사일</th><th>급여</th><th>부서번호</th><th>부서명</th></tr>
				<%
					EmpDao empDao = EmpDao.getInstance();
					ArrayList<EmpDto> empDtos = empDao.searchNameEmpList(searchName);
					if(empDtos.isEmpty()){
						out.println("<tr><td colspan='8'>해당 이름의 사원이 없습니다</td></tr>");
					}else{
						for(EmpDto empDto : empDtos){
							int empno = empDto.getEmpno();
							String ename = empDto.getEname();
							String job = empDto.getJob();
							int mgr = empDto.getMgr();
							Date hiredate = empDto.getHiredate();
							int sal = empDto.getSal();
							int deptno = empDto.getDeptno();
							String dname = empDto.getDname();
							out.println("<tr><td>"+empno+"</td><td>"+ename+"</td><td>"+job+"</td><td>"+mgr+"</td><td>"+hiredate+"</td><td>"+sal+"</td><td>"+deptno+"</td><td>"+dname+"</td></tr>");
						}
					}
				%>
			</table>
	</form>
</body>
</html>