<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
  <script>
	  $( function() {
	    $( "#datepicker" ).datepicker({
	    	dateFormat: "yy-mm-dd",
	    	monthNamesShort: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
				dayNamesMin: ["일", "월", "화", "수", "목", "금", "토"],
				changeMonth: true,
				changeYear: true,
				showMonthAfterYear: true,
				yearSuffer: '년',
				minDate: new Date(1950, 1 - 1, 1),
				showOtherMonths: true,
				yearRange: 'c-70:c+0'
	    });
	  });
  </script>
</head>
<body>
<jsp:include page="../main/header.jsp"></jsp:include>
	<form action="${conPath }/join.do" method="post" enctype="multipart/form-data" id="content_form">
		<table>
			<caption>회원가입</caption>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="mid" id="mid">
					<br>
					<span> &nbsp; &nbsp;&nbsp; </span>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="mpw" id="mpw">
				</td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td>
					<input type="password" name="mpwChk" id="mpwChk">
					<br>
					<span> &nbsp; &nbsp;&nbsp; </span>
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="mname" id="mname">
				</td>
			</tr>
			<tr>
				<th>메일</th>
				<td>
					<input type="text" name="memail" id="memail">
					<br>
					<span> &nbsp; &nbsp;&nbsp; </span>
				</td>
			</tr>
			<tr>
				<th>사진</th>
				<td>
					<input type="file" name="mphoto" id="mphoto">
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>
					<input type="text" name="mbirth" id="datepicker">
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text" name="maddress" id="maddress">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="회원가입" class="btn">
					<input type="button" value="로그인" class="btn" onclick="location.href='${conPath}/loginView.do'">
				</td>
			</tr>
		</table>
	</form>
<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>