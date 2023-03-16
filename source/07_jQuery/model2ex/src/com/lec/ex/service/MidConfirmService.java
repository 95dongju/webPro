package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.MemberDao;

public class MidConfirmService implements Service {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.midConfirm(mid);
		if(result == MemberDao.EXISTENT) {
			request.setAttribute("midConfirm", "<b>중복된 아이디입니다</b>");
		}else {
			request.setAttribute("midConfirm", "사용 가능한 아이디입니다");
		}
	}
}