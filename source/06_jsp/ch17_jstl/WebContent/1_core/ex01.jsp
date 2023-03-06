<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>core 라이브러리 태그</h2>
	<c:forEach var="i" begin="1" end="3" step="1">
		<p>${i }번째 안녕하세요</p>
	</c:forEach>
	<hr>
	<%-- i 변수 지정하지 않아도 가능 --%>
	<c:forEach begin="1" end="3" step="1">
		<p>안녕하세요</p>
	</c:forEach>
	<h2>fmt(formatting) 라이브러리 : 날짜/숫자 format, 다국어 지원</h2>
	<fmt:formatNumber value="3333.149" pattern="#,###.##"/>
	<h2>그외 라이브러리 (functions) : fn 라이브러리는 el표기법과 함께 사용</h2>
	id 파라미터를 대문자로 : ${fn:toUpperCase(param.id) }
	id 파라미터를 대문자로 : ${param.id.toUpperCase() } <%-- 자바 라이브러리 이용 --%>
</body>
</html>