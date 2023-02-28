<%@page import="com.lect.dto.CustomerDto"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/join.css" rel="stylesheet" type="text/css">
	<script>
	</script>
</head>
<body>
	<%! String cid, cpw, cname, ctel, cemail, caddress, cgender; 
		Date cbirth; %>
	<jsp:include page="../main/header.jsp"/>
	<%
		CustomerDto customer = (CustomerDto)session.getAttribute("customer");
		if(customer==null){
			response.sendRedirect("login.jsp?method=modify");
		}else{
			cid = customer.getCid();
			cpw = customer.getCpw();
			cname = customer.getCname();
			ctel = customer.getCtel();
			cemail = customer.getCemail();
			caddress = customer.getCaddress();
			cgender = customer.getCgender();
			cbirth = customer.getCbirth();
		}
	%>
	<div id="joinForm_wrap">
	<div id="join_title">정보수정</div>
	<form action="modifyPro.jsp" method="post" name="join_frm">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="cid" class="cid" value="<%=cid %>" readonly="readonly"></td>
			</tr>
			<tr>
				<th>현재 비밀번호</th>
				<td><input type="password" name="oldPw" class="oldPw" required="required"></td>
			</tr>
			<tr>
				<th>새 비밀번호</th>
				<td><input type="password" name="cpw" class="cpw"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="cname" class="cname" value="<%=cname %>" required="required"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<input type="text" name="ctel" class="ctel" value='<%=ctel==null? "" : ctel %>'>
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<%if("m".equals(cgender)){%>
						<input type="radio" name="cgender" class="cgender" value="m" checked="checked">남
						<input type="radio" name="cgender" class="cgender" value="f">여
					<%}else if("f".equals(cgender)){ %>
						<input type="radio" name="cgender" class="cgender" value="m">남
						<input type="radio" name="cgender" class="cgender" value="f" checked="checked">여
					<%}else{%>
						<input type="radio" name="cgender" class="cgender" value="m">남
						<input type="radio" name="cgender" class="cgender" value="f">여
					<%}%>
				</td>
			</tr>
			<tr>
				<th>메일</th>
				<td><input type="text" name="cemail" class="cemail" value='<%= cemail==null? "" : cemail %>'></td>
			</tr>
			<tr>
				<th>생일</th>
				<td><input type="date" name="tempBirth" class="tempBirth" value='<%= cbirth==null? "" : cbirth.toString() %>'></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="caddress" class="caddress" value='<%= caddress==null? "" : caddress %>'></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="저장" class="joinBtn_style">
					<input type="reset" value="취소" onclick="history.back()" class="joinBtn_style">
					<input type="button" value="로그아웃" onclick="location.href='logout.jsp'" class="joinBtn_style">
				</td>
			</tr>
		</table>
	</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>