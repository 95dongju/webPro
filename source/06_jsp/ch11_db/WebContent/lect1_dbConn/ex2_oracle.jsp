<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
	<table>
	<%
		Connection	conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EMP";
		try{
			Class.forName(driver); // 1단계
			conn = DriverManager.getConnection(url, uid, upw); // 2단계 : DB연결
			stmt = conn.createStatement(); // 3단계 : SQL문 전송 객체
			rs = stmt.executeQuery(sql); // 4단계 : SQL문 전송 + 5단계 : SQL 결과 rs로 받기
			if(rs.next()){ // rs.next() = true 데이터가 있는 경우
				out.println("<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th><th colspan='3'>입사일</th><th>급여</th><th>상여</th><th>부서번호</th></tr>");
				do{ // while을 하면 첫 번째 줄은 출력이 안 되기 때문에 do while 사용
					// 6단계 : 결과 받아 적당한 로직 수행
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					int mgr = rs.getInt("mgr");
					Date hiredateD = rs.getDate("hiredate");
					// java에서 date는 시간이 포함되지 않음. oracle에는 date에 시간까지 포함되어 있기 때문에 시간 값이 있다면 timestamp로 가져와야 함
					Timestamp hiredateT = rs.getTimestamp("hiredate");
					String hiredateS = rs.getString("hiredate");
					int sal = rs.getInt("sal");
					int comm = rs.getInt("comm");
					int deptno = rs.getInt("deptno");
					out.println("<tr><th>"+empno+"</th><th>"+ename+"</th><th>"+job+"</th><th>"+mgr+"</th><th>"+hiredateS+"</th><th>"+hiredateD+"</th><th>"+hiredateT+"</th><th>"+sal+"</th><th>"+comm+"</th><th>"+deptno+"</th></tr>");
				}while(rs.next());
			}else{ // = false 데이터가 없는 경우
				out.println("<tr><td>입력된 데이터가 없습니다</td></tr>");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			// 7단계 : 연결 해제
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}
	%>
	</table>
</body>
</html>