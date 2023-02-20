<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		body {
			background-color: #ECF8E0;
		}
		#mainForm_wrap{
			height: 600px;
			line-height: 630px;
			font-size: 32px;
			text-align: center;
			width: 400px;
			margin: 0px auto;
		}
	</style>
</head>
<body>
	<jsp:include page="../customer/header.jsp"/>
	<div id="mainForm_wrap">
		MAIN 화면
	</div>
	<jsp:include page="../customer/footer.jsp"/>
</body>
</html>