package com.lec.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class JoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String path = request.getRealPath("memberPhotoUp");
		int maxSize = 1024*1024;
		String mphoto = "";
		int result = 0;
		System.out.println(0);
		try {
			System.out.println(1);
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize,
					"utf-8", new DefaultFileRenamePolicy());
			System.out.println(2);
			Enumeration<String> params = mRequest.getFileNames();
			String param = params.nextElement();
			mphoto = mRequest.getFilesystemName(param);
			String mid = mRequest.getParameter("mid");
			String mpw = mRequest.getParameter("mpw");
			String mname = mRequest.getParameter("mname");
			String memail = mRequest.getParameter("memail");
			mphoto = mphoto == null? "NOIMG.JPG" : mphoto;
			String mbirthStr = mRequest.getParameter("mbirth");
			Date mbirth = null;
			if(!mbirthStr.equals("")) {
				mbirth = Date.valueOf(mbirthStr);
			}
			String maddress = mRequest.getParameter("maddress");
			String mrdateStr = mRequest.getParameter("mrdate");
			Timestamp mrdate = Timestamp.valueOf(mrdateStr);
			MemberDao mDao = MemberDao.getInstance();
			result = mDao.midConfirm(mid);
			if(result == MemberDao.NONEXISTENT) {
				MemberDto member = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, mrdate);
				result = mDao.joinMember(member);
				if(result == MemberDao.SUCCESS) {
					HttpSession session = request.getSession();
					session.setAttribute("mid", mid);
					request.setAttribute("joinResult", "회원가입이 완료되었습니다");
				}else {
					request.setAttribute("joinErrorMsg", "회원가입이 실패되었습니다. 너무 긴 값을 입력하지 마세요.");
				}
			}else {
				request.setAttribute("joinErrorMsg", "중복된 ID입니다. ID를 확인해 주세요.");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			request.setAttribute("joinErrorMsg", "첨부파일의 용량이 너무 큽니다. 1M 이내의 파일을 업로드 하세요.");
		}
		File serverFile = new File(path + "/" +mphoto);
		if(serverFile.exists() && !mphoto.equals("NOIMG.JPG") && result == MemberDao.SUCCESS) {
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("C:/JU/source/07_jQuery/model2ex/WebContent/memberPhotoUp/"+mphoto);
				byte[] bs = new byte[(int) serverFile.length()];
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
