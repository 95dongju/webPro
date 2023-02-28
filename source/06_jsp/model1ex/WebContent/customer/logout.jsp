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
				height: 400px;
				line-height: 400px;
				font-size: 15px;
				font-weight: bold;
				color: #005500;
				text-align: center;
				width: 700px;
				padding: 50px;
				margin: 0px auto;
				border: 1px solid #005500;
			}
	</style>
	<script>
		setTimeout(function(){
			location.href = '<%=conPath%>/main/main.jsp';
		}, 3000);
	</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
		<div id="mainForm_wrap">
		<% if(session.getAttribute("customer")!=null){		
			session.invalidate();
			out.println("<h2>로그아웃 되었습니다. 잠시 후 메인 페이지로 이동합니다</h2>");
		}else{
			out.println("<h2>로그인 상태가 아닙니다. 잠시 후 메인 페이지로 이동합니다</h2>");
		}
		%>
		</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>