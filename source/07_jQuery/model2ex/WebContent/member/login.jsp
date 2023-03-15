<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<c:if test="${not empty joinResult }">
		<script>
			alert('${joinResult}');
		</script>
	</c:if>
	<c:if test="${not empty joinErrorMsg }">
		<script>
			alert('${joinErrorMsg}');
			history.back();
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
		<form action="${conPath }/login.do" method="post" class="content_form" id="content_form">
			<table>
				<caption>사용자님 로그인</caption>
				<tr>
					<th>ID</th><td><input type="text" name="mid" id="mid" value="${mid }"></td>
				</tr>
				<tr>
					<th>PW</th><td><input type="password" name="mpw" id="mpw"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="로그인" class="btn">
						<input type="button" value="회원가입" class="btn" onclick="location.href='${conPath }/joinView.do'">
					</td>
				</tr>
			</table>
		</form>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>