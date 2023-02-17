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
		<p>사원명 <input type="text" name="ename" 
		<%
			String enameParam = request.getParameter("ename");
			String enameInput = enameParam;
			if(enameParam == null){
				out.print("");
			}else {
				enameInput = enameParam.trim().toUpperCase();
				out.print("value='"+enameInput+"'");
			}
		%>>
		<input type="submit" value="검색"> </p>
		<table>
			<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th><th>입사일</th><th>급여</th><th>상여</th><th>부서번호</th></tr>
			<%
				Class.forName(driver);
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = "SELECT * FROM EMP WHERE ENAME LIKE ?||'%'";
				try{
					conn = DriverManager.getConnection(url, uid, upw);
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, enameInput);
					rs = pstmt.executeQuery();
					if (rs.next()){
						do{
							int empno = rs.getInt("empno");
							String ename = rs.getString("ename");
							String job = rs.getString("job");
							int mgr = rs.getInt("mgr");
							Date hiredate = rs.getDate("hiredate");
							int sal = rs.getInt("sal");
							int comm = rs.getInt("comm");
							int deptno = rs.getInt("deptno");
							out.println("<tr><td>"+empno+"</td><td>"+ename+"</td><td>"+job+"</td><td>"+mgr+"</td><td>"+hiredate+"</td><td>"+sal+"</td><td>"+comm+"</td><td>"+deptno+"</td></tr>");
						}while(rs.next());
					}else {
						out.println("<tr><td colspan='8'>해당 이름의 사원이 없습니다.</td></tr>");
					}
				}catch(Exception e){
					System.out.println(e.getMessage());
				}finally{
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				}
			%>
		</table>
	</form>
</body>
</html>