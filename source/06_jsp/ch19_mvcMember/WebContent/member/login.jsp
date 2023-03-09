<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<c:if test="${joinResult eq SUCCESS }">
		<script>
			alert('회원가입 축하드립니다! 로그인 후 이용해 주세요.');
		</script>
	</c:if>
	<c:if test="${idCheck eq FAIL && joinResult eq FAIL }">
		<script>
			alert('중복된 아이디입니다. 다시 입력해 주세요.');
			history.back();
		</script>
	</c:if>
	<c:if test="${idCheck eq SUCCESS && joinResult eq FAIL }">
		<script>
			alert('너무 긴 값을 입력하셨습니다. 다시 입력해 주세요.');
			history.back();
		</script>
	</c:if>
	<form action="${conPath}/login.do" method="post">
			<table>
				<caption>로그인</caption>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="mid" required="required" value="${getMember.mid }"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="mpw" required="required"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="로그인">
						<input type="button" value="회원가입" onclick="location.href='${conPath}/joinView.do'">
					</td>
				</tr>
			</table>
		</form>
</body>
</html>