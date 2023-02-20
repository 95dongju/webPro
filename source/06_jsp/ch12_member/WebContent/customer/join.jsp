<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 	String conPath = request.getContextPath(); 
	if(session.getAttribute("customer")!=null){
		response.sendRedirect("main.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href='<%=conPath %>/css/join.css' rel='stylesheet'>
	<script>
		window.onload = function(){
			document.querySelector('form').onsubmit = function(){
				var cpw = document.getElementById('cpw');
				var cpwChk = document.getElementById('cpwChk');
				var patternMail = /^[a-zA-Z0-9_\.]+@[a-zA-Z0-9_]+(\.\w+){1,2}$/; // macth함수 사용
				var cemail = document.getElementById('cemail');
				if(cpw.value != cpwChk.value){
					alert('비밀번호를 확인하세요');
					cpw.value = '';
					cpwChk.value = '';
					cpw.focus();
					return false;
				}else	if(!cemail.value.match(patternMail)){
		      alert('메일 형식을 확인하세요');
		      email.focus();
		      return false;
		    }
		};
	};
	</script>
</head>
<body>
	<jsp:include page="../customer/header.jsp"/>
	<div id="joinForm_wrap">
		<div id="join_title">회원가입</div>
		<form action="joinPro.jsp" method="post">
			<input type="hidden" name="hiddenParam" value="xx">
			<table>
				<tr>
					<th><label for="cid">아이디</label></th>
					<td><input type="text" name="cid" id="cid" class="cid" required="required" autofocus="autofocus"></td>
				</tr>
				<tr>
					<th><label for="cpw">비밀번호</label></th>
					<td><input type="password" name="cpw" id="cpw" class="cpw" required="required"></td>
				</tr>
				<tr>
					<th><label for="cpwChk">비밀번호확인</label></th>
					<td><input type="password" name="cpwChk" id="cpwChk" class="cpwChk" required="required"></td>
				</tr>
				<tr>
					<th><label for="cname">이름</label></th>
					<td><input type="text" name="cname" id="cname" class="cname" required="required"></td>
				</tr>
				<tr>
					<th><label for="ctel">전화번호</label></th>
					<td><input type="text" name="ctel" id="ctel" class="ctel"></td>
				</tr>
				<tr>
					<th><label for="cemail">이메일</label></th>
					<td><input type="text" name="cemail" id="cemail" class="cemail"></td>
				</tr>
				<tr>
					<th><label for="caddress">주소</label></th>
					<td><input type="text" name="caddress" id="caddress" class="caddress"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="cgender" value="m" checked="checked" id="m"><label for="m">남자</label>
						<input type="radio" name="cgender" value="f" id="f"><label for="f">여자</label>
					</td>
				<tr>
					<th><label for="tempBirth">생년월일</label></th>
					<td><input type="date" name="tempBirth" id="tempBirth" class=cbirth></td>
				</tr>
				<tr>
					<td colspan="2"> </td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="가입하기" class="joinBtn_style">
						<input type="reset" value="다시하기" class="joinBtn_style">
						<input type="button" value="로그인" class="joinBtn_style" 
											onclick="location.href='<%=conPath%>/login.jsp'">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../customer/footer.jsp"/>
</body>
</html>
