<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		#mainForm_wrap{
			height: 400px;
			line-height: 400px;
			font-size: 32px;
			font-weight: bold;
			color: #D4A190;
			text-align: center;
			width: 700px;
			padding: 50px;
			margin: 0px auto;
			border: 1px solid #D4A190;
		}
	</style>
</head>
<body>
	<jsp:include page="../member/header.jsp"/>
	<div id="mainForm_wrap">
		main 화면
	</div>
	<jsp:include page="../member/footer.jsp"/>
</body>
</html>