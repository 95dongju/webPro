package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.MemberDao;

public class MLoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		MemberDao mDao = MemberDao.getInstance();
		request.setAttribute("loginResult", mDao.loginCheck(mid, mpw));
		request.setAttribute("getMember", mDao.getMember(mid));
	}
}
