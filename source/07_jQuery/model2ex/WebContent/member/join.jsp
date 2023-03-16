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
	    $('#mid').keyup(function(){
	    	var mid = $(this).val();
	    	if(mid.length<2){
	    		$('#midConfirm').text('2글자 이상 입력해 주세요');
	    	}else{
	    		$.ajax({
	    			url: '${conPath}/midConfirm.do',
	    			type: 'get',
	    			data: 'mid='+mid,
	    			dataType: 'html',
	    			success: function(data){
	    				$('#midConfirm').html(data);
	    			},
	    		});
	    	}
	    });
	    $('#mpw, #mpwChk').keyup(function(){
	    	var mpw = $('#mpw').val();
	    	var mpwChk = $('#mpwChk').val();
	    	if(mpw == mpwChk){
	    		$('#mpwConfirm').text('비밀번호 일치');
	    	}else{
	    		$('#mpwConfirm').text('비밀번호 불일치');
	    	}
	    });
	    $('#memail').keyup(function(){
	    	var memail = $(this).val();
	    	function isEmail(memail) {
	    		var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	    		return regExp.test(memail);
	    	}
	    	if(isEmail(memail) == false){
	    		$('#memailConfirm').text('올바른 이메일 주소를 입력해 주세요');
	    	}else{
	    		$.ajax({
	    			url: '${conPath}/memailConfirm.do',
	    			type: 'get',
	    			data: 'memail='+memail,
	    			dataType: 'html',
	    			success: function(data){
	    				$('#memailConfirm').html(data);
	    			}
	    		});
	    	}
	    });
	    $('form').submit(function(){
	    	var midConfirm = $('#midConfirm').text().trim();
	    	var mpwConfirm = $('#mpwConfirm').text().trim();
	    	var memailConfirm = $('#memailConfirm').text().trim();
	    	if(midConfirm != '사용 가능한 아이디입니다'){
	    		alert('ID를 확인해 주세요');
	    		return false;
	    	}else if(mpwConfirm != '비밀번호 일치'){
	    		alert('비밀번호를 확인해 주세요');
	    		return false;
	    	}else if(memailConfirm != '사용 가능한 이메일입니다'){
	    		alert('이메일을 확인해 주세요');
	    		return false;
	    	}
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
					<input type="text" name="mid" id="mid" required="required">
					<br>
					<div id="midConfirm"> &nbsp; &nbsp; &nbsp; </div>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="mpw" id="mpw" required="required">
				</td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td>
					<input type="password" name="mpwChk" id="mpwChk" required="required">
					<br>
					<div id="mpwConfirm"> &nbsp; &nbsp; &nbsp; </div>
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="mname" id="mname" required="required">
				</td>
			</tr>
			<tr>
				<th>메일</th>
				<td>
					<input type="text" name="memail" id="memail" required="required">
					<br>
					<div id="memailConfirm"> &nbsp; &nbsp; &nbsp; </div>
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