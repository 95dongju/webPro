<%@page import="java.io.IOException"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.Reader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		String conPath = request.getContextPath(); // "/ch05_jsp" 일반적으로는 conPath 사용
		String appPath = application.getContextPath(); // "/ch05_jsp"
		String absolutePath = application.getRealPath("."); // 절대 경로 -> 현재 프로젝트가 실행되는 절대 경로(tomcat)
	%>
	<h2>conPath : <%=conPath %></h2>
	<h2>appPath : <%=appPath %></h2>
	<h2>absolutePath : <%=absolutePath %></h2>
	<%
		String filePath = application.getRealPath("WEB-INF/test.txt");
		out.println(filePath + "의 내용입니다<br><br>");
		// 1. 스트림 객체 생성 (파일 Open 기본스트림 -> 보조스트림) 2. 읽고 화면 출력 3. 스트림 객체 닫기 (파일 Close)
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		while(true){
			String line = br.readLine();
			if(line == null) break;
			out.println(line+"<br>");
		}
		out.println("파일 출력 끝");
		br.close();
// 		Reader reader = null;
// 		BufferedReader br = null;
// 		try {
// 			reader = new FileReader(filePath); // 기본 스트림 생성
// 			br = new BufferedReader(reader); //  보조 스트림 생성 (기본 스트림 통해서 생성)
// 			while(true){
// 				String line = br.readLine(); // 한줄씩 읽기. 파일의 끝이면 null 반환
// 				if(line==null) break;
// 				out.println(line+"<br>");
// 			}
// 			out.println("파일 출력 끝");
// 		}catch(Exception e){
// 			out.println("파일이 존재하지 않거나 읽을 수 없습니다"); 
// 		}finally{
// 			try{
// 				if(br != null) br.close();
// 				if(reader != null) reader.close();
// 			}catch(IOException e){
				
// 			}
// 		}
	%>
</body>
</html>