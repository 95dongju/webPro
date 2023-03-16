package com.lec.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MModifyService implements Service {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("memberPhotoUp");
		int maxSize = 1024*1024;
		String mphoto = "";
		int result = MemberDao.FAIL;
		try {
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			String param = params.nextElement();
			mphoto = mRequest.getFilesystemName(param);
			String dbMpw = mRequest.getParameter("dbMpw");
			String dbMphoto = mRequest.getParameter("dbMphoto");
			HttpSession session = request.getSession();
			String sessionMpw = null, sessionMphoto = null;
			MemberDto sessionMember = (MemberDto)session.getAttribute("member");
			if(sessionMember!=null) {
				sessionMpw = sessionMember.getMpw();
				sessionMphoto = sessionMember.getMphoto();
			}
			String mid = mRequest.getParameter("mid");
			String oldMpw = mRequest.getParameter("oldMpw");
			if(!oldMpw.equals(dbMpw)) {
				request.setAttribute("modifyErrorMsg", "현 비밀번호를 확인하세요");
				return;
			}
			String mpw = mRequest.getParameter("mpw");
			if(mpw.equals("")) {
				mpw = dbMpw;
			}
			String mname = mRequest.getParameter("mname");
			String memail = mRequest.getParameter("memail");
			mphoto = mphoto == null ? dbMphoto : mphoto;
			String mbirthStr = mRequest.getParameter("mbirth");
			Date mbirth = null;
			if(!mbirthStr.equals("")) {
				mbirth = Date.valueOf(mbirthStr);
			}
			String maddress = mRequest.getParameter("maddress");
			MemberDao mDao = MemberDao.getInstance();
			MemberDto member = new MemberDto(mid, mpw, mname, memail, sessionMphoto, mbirth, maddress, null);
			result = mDao.modifyMember(member);
			if(result == MemberDao.SUCCESS) {
				session.setAttribute("modifyResult", "회원 정보 수정 성공");
			}else {
				session.setAttribute("modifyErrorMsg", "회원 정보 수정 실패");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		File serverFile = new File(path + "/" +mphoto);
		if(!mphoto.equals("NOIMG.JPG") && result == MemberDao.SUCCESS) {
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("C:\\JU\\source\\07_jQuery\\model2ex\\WebContent\\memberPhotoUp\\"+mphoto);
				byte[] bs = new byte[(int)serverFile.length()];
				while(true) {
					int readByteCnt = is.read(bs);
					if(readByteCnt == -1) break;
					os.write(bs, 0, readByteCnt);
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(os!=null) os.close();
					if(is!=null) is.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}