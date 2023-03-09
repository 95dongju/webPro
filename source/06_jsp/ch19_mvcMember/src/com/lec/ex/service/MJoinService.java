package com.lec.ex.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MJoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("memberPhotoUp");
		int maxSize = 1024*1024*5;
		String image = "";
		String originImage = "";
		MultipartRequest mRequest = null;
		try {
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> paramNames = mRequest.getFileNames();
			while(paramNames.hasMoreElements()) {
				String param = paramNames.nextElement();
				image = mRequest.getFilesystemName(param);
				if(image == null) {
					image = "NOIMG.png";
				}
				originImage = mRequest.getOriginalFileName(param);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		InputStream is = null;
		OutputStream os = null;
			try {
				File serverFile = new File(path + "/" + image);
				if(serverFile.exists()) {
					is = new FileInputStream(serverFile);
					os = new FileOutputStream("C:/JU/source/06_jsp/ch19_mvcMember/WebContent/memberPhotoUp/"+image);
					byte[] bs = new byte[(int)serverFile.length()];
					while(true) {
						int nReadCnt = is.read(bs);
						if(nReadCnt== -1) break;
						os.write(bs, 0, nReadCnt);
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(os!=null) os.close();
					if(is!=null) is.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		String mid = mRequest.getParameter("mid");
		String mpw = mRequest.getParameter("mpw");
		String mname = mRequest.getParameter("mname");
		String memail = mRequest.getParameter("memail");
		String mphoto = image;
		String mbirthStr = request.getParameter("mbirth");
		String maddress = request.getParameter("maddress");
		Date mbirth = null;
		if(mbirthStr != null) {
			mbirth = Date.valueOf(mbirthStr);
		}
		MemberDto member = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress);
		MemberDao mDao = MemberDao.getInstance();
		request.setAttribute("joinResult", mDao.join(member));
		request.setAttribute("idCheck", mDao.checkId(mid));
		request.setAttribute("getMember", mDao.getMember(mid));
	}
}
