<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
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
<%!
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String uid = "scott";
	String upw = "tiger";
%>
	<form action="">
		<p>사원명 <input type="text" name="ename"> <input type="submit" value="검색"> </p>
		<table>
			<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th><th>입사일</th><th>급여</th><th>상여</th><th>부서번호</th></tr>
			<%
				String enameParam = request.getParameter("ename");
				if(enameParam == ename){
					
				}
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = "SELECT * FROM EMP WHERE ENAME LIKE ?";
				try{
					Class.forName(driver);
					conn = DriverManager.getConnection(url, uid, upw);
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if (rs.next()){
						do{
							int empno = rs.getInt("empno");
							String ename = rs.getString("ename");
							Date hiredate = rs.getDate("hiredate");
						}while(rs.next());
					}
				}catch(Exception e){
					System.out.println(e.getMessage());
				}finally{
					
				}
			%>
		</table>
	</form>
</body>
</html>