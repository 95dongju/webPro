package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.AdminDao;
import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.AdminDto;
import com.lec.ex.dto.MemberDto;

public class ALoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String aid = request.getParameter("aid");
		String apw = request.getParameter("apw");
		AdminDao aDao = new AdminDao();
		int result = aDao.loginAdmin(aid, apw);
		if(result == MemberDao.LOGIN_SUCCESS) {
			HttpSession session = request.getSession();
			AdminDto admin = aDao.getAdmin(aid);
			session.setAttribute("admin", admin);
		}else {		
			request.setAttribute("loginErrorMsg", "관리자 계정으로 로그인이 실패되었습니다.");
		}
	}
}
