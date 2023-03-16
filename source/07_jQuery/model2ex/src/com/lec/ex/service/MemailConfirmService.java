package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.MemberDao;

public class MemailConfirmService implements Service {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String memail = request.getParameter("memail");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.memailConfirm(memail);
		if(result == MemberDao.EXISTENT) {
			request.setAttribute("memailConfirm", "<b>중복된 이메일입니다</b>");
		}else {
			request.setAttribute("memailConfirm", "사용 가능한 이메일입니다");
		}
	}
}