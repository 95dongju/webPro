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
		Cookie[] cs = request.getCookies();
		if(cs!=null){
			for(Cookie c : cs){
				String cookiesName = c.getName();
				if(cookiesName.equals("id")){
					// 방법 1) 'id'라는 이름의 쿠키 삭제 = 같은 이름으로 쿠키 덮어씌우기
					// 방법 2) 'id'라는 이름의 쿠키 유효 시간을 0초로 수정
					c.setMaxAge(0);
					response.addCookie(c);
					out.println("<h1>성공적으로 로그아웃 되었습니다</h1>");
				}else if(cookiesName.equals("name")){
					// 'name'이라는 이름의 쿠키의 유효시간을 -초로 수정
					c.setMaxAge(0);
					response.addCookie(c);
				}
			}
		}
	%>
	<p>
		<button onclick="location.href='login.html'">로그인</button>
		<button onclick="location.href='cookieList.jsp'">쿠키 확인</button>
		<button onclick="location.href='welcome.jsp'">메인페잊</button>
	</p>
</body>
</html>