<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% // 위에서 아래로 순서대로 실행되기 때문에 css 위에 scriptlet이 들어가야 함. scriptlet은 어디서나 넣을 수 있음.
	String color = request.getParameter("color");
	if(color==null){
		color = "white";
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		body{
			background-color: <%=color%>;
		}
	</style>
</head>
<body>
	<h1>배경색 바꾸기</h1>
	<form>
		<select name="color">
			<option value="red">빨강</option>
			<option value="orange">주황</option>
			<option value="yellow">노랑</option>
			<option value="green">초록</option>
			<option value="blue">파랑</option>
			<option value="navy">남색</option>
			<option value="violet">보라</option>
		</select>
		<input type="submit" value="적용">
	</form>
</body>
</html>