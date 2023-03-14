<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/join.css" rel="stylesheet">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
  <script>
  	$(function(){
  		$('input[name="mid"]').keyup(function(){
  			var mid = $(this).val();
  			if(mid.length<2){
  				$('#idConfirmResult').text('아이디는 2글자 이상');
  			}else{
  				$.ajax({
  					url: '${conPath}/1_get_post_ajax/midConfirm.jsp',
  					type: 'get',
  					data: 'mid='+mid,
  					dataType: 'html',
  					success: function(data){
  						$('#idConfirmResult').html(data);
  					},
  					error: function(code){
  						$('#idConfirmResult').html(code);
  					}
  				});
  			}
  		});
  		$('#pw, #pwChk').keyup(function(){
  			var pw = $('#pw').val();
  			var pwChk = $('#pwChk').val();
  			if(pw == pwChk){
  				$('#pwConfirmResult').text('비밀번호가 일치합니다');
  			}else{
  				$('#pwConfirmResult').text('비밀번호가 일치하지 않습니다');
  			}
  		});
  		$('form').submit(function(){
  			var idConfirmResult = $('#idConfirmResult').text().trim();
  			var pwChkResult = $('#pwChkResult').text().trim();
  			if(idConfirmResult != '사용 가능한 ID입니다.'){
  				alert('ID를 확인해 주세요');
  				$('#id').focus();
  				return false;
  			}else if(pwChkResult != ''){
  				alert('비밀번호를 확인해 주세요');
  				$('#pw').focus();
  				return false;
  			}
  		});
  	});
  </script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker({
			dateFormat: "yy-mm-dd",
			monthNamesShort: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
			dayNamesMin: ["일", "월", "화", "수", "목", "금", "토"],
			changeMonth: true, // 월을 바꿀수 있는 셀렉트 박스를 표시한다.
			changeYear: true,
			showMonthAfterYear: true,
			yearSuffer: '년',
			// minDate: '-100y', // 현재날짜로부터 100년이전까지 년을 표시한다.
			minDate: new Date(1950, 1 - 1, 1), // 1950년 1월 1일을 최소 날짜로 세팅
			showOtherMonths: true,
			yearRange: 'c-70:c+0', // 년도 선택 셀렉트박스를 현재 년도에서 이전, 이후로 얼마의 범위를 표시할것인가.
			
    });
  });
  </script>
</head>
<body>
	<div id="joinForm_wrap">
		<form>
			<div id="join_title">회원가입</div>
			<table>
				<tr>
					<th>
						<label for="id">아이디 </label>
					</th>
					<td>
						<input type="text" name="mid" id="id" class="id" required="required">
						<div id="idConfirmResult"> &nbsp; &nbsp; &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th>
						<label for="pw">비밀번호 </label>
					</th>
					<td>
						<input type="password" name="pw" id="pw" class="pw" required="required">
					</td>
				</tr>
				<tr>
					<th>
						<label for="pwChk">비밀번호 </label>
					</th>
					<td>
						<input type="password" name="pwChk" id="pwChk" class="pwChk" required="required">
						<div id="pwConfirmResult"> &nbsp; &nbsp; &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th>
						<label for="name">이름 </label>
					</th>
					<td>
						<input type="text" name="name" id="name" class="name" required="required">
					</td>
				</tr>
				<tr>
					<th>
						생년월일 
					</th>
					<td>
						<input type="text" name="birth" id="datepicker" class="birth">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="가입하기" class="joinBtn_style">
						<input type="reset" value="다시하기" class="joinBtn_style">
						<input type="button" value="로그인" class="joinBtn_style">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>