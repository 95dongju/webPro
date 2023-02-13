<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="join.css" rel="stylesheet">
</head>
<body>
	<form action="joinPro.jsp" method="post" id="joinForm_wrap">
		<table>
			<caption id="join_title">회원가입</caption>
			<tr>
			<td>이름</td><td><input type="text" name="name" class="name"></td>
			</tr>
			<tr>
			<td>아이디</td><td><input type="text" name="id" class="id"></td>
			</tr>
			<tr>
			<td>비밀번호</td><td><input type="password" name="pw" class="pw"></td>
			</tr>
			<tr>
			<td>비밀번호확인</td><td><input type="password" name="pwChk" class="pwChk"></td>
			</tr>
			<tr>
			<td>생년월일</td><td><input type="date" name="birth" class="birth"></td>
			</tr>
			<tr>
			<td>취미</td>
			<td><label><input type="checkbox" name="hobby" value="독서">독서</label>
				<label><input type="checkbox" name="hobby" value="요리">요리</label>
				<label><input type="checkbox" name="hobby" value="운동">운동</label>
				<label><input type="checkbox" name="hobby" value="취침">취침</label>
			</td>
			</tr>
			<tr>
			<td>취미</td>
			<td><label><input type="radio" name="gender" value="m">남자</label>
				<label><input type="radio" name="gender" value="f">여자</label>
			</td>
			</tr>
			<tr>
			<td>이메일</td><td><input type="text" name="email" class="email"></td>
			</tr>
			<tr>
			<td>메일수신</td>
			<td>
				<select class="mailSend" name="mailSend"size="3">
					<option class="mail">광고</option>
					<option class="mail">배송</option>
					<option class="mail">공지</option>
				</select>
			</td>
			</tr>
		</table>
		<input type="submit" class="joinBtn_style" value="가입하기">
		<input type="reset" class="joinBtn_style" value="다시하기">
		<button onclick="history.back()" class="joinBtn_style">뒤로가기</button>
	</form>
	<hr>
	<%@ include file="footer.jsp" %>
	<hr>
</body>
</html>