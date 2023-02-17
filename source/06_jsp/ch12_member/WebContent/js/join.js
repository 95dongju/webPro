const infoConfirm = function(){
	var patternMail = /^[a-zA-Z0-9_\.]+@[a-zA-Z0-9_]+(\.\w+){1,2}$/;
	if(join_frm.id.value.length<3){
		alert('아이디는 반드시 3글자 이상이어야 합니다.');
		join_frm.id.focus();
		return;
	}
	if(! join_frm.pw.value){
		alert('비밀번호를 입력하세요');
		join_frm.pw.focus();
		return;
	}
	if(join_frm.pw.value != join_frm.pwChk.value){
		alert('비밀번호를 확인하세요');
		join_frm.pw.value = '';
		join_frm.pwChk.value = '';
		join_frm.pw.focus();
		return;
	}
	if(!join_frm.name.value){
		alert('이름을 입력하세요');
		join_frm.name.focus();
		return;
	}
	if(join_frm.email.value && !join_frm.email.value.match(patternMail)){
		alert('유효한 이메일을 입력해 주세요');
		join_frm.email.focus();
		return;
	}
	join_frm.submit(); // 강제로 submit 이벤트 발생
}