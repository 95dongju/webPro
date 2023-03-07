package com.lec.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;

public class MemberlistService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// list 로직
		MemberDao mDao = MemberDao.getInstance();
		ArrayList<MemberDto> memberList = mDao.listMember();
		request.setAttribute("memberList", memberList);
	}
}
