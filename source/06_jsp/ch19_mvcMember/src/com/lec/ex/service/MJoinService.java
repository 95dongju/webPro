package com.lec.ex.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;

public class MJoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		String mphoto = request.getParameter("mphoto");
		String mbirthStr = request.getParameter("mbirth");
		String maddress = request.getParameter("maddress");
		Date mbirth = null;
		if(! mbirthStr.equals("")) {
			mbirth = Date.valueOf(mbirthStr);
		}
		MemberDto member = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, null);
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.join(member);
		request.setAttribute("joinResult", result);
	}
}
