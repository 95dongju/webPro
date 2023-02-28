<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		// 첨부한 파일을 서버에 저장하고 파일 이름 가져오기
		String path = request.getRealPath("fileboardUpload");
		int maxSize = 1024*1024*5;
		String ffilename = null;
		MultipartRequest mRequest = null;
		try{
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> paramNames = mRequest.getFileNames();
			String param = paramNames.nextElement();
			ffilename = mRequest.getFilesystemName(param);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		// 서버에서 소스 폴더로 파일 복사
		if(ffilename!=null){
			InputStream is = null;
			OutputStream os = null;
			try{
				File serverFile = new File(path+"/"+ffilename);
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:\\JU\\source\\06_jsp\\model1ex\\WebContent\\fileboardUpload");
				byte[] bs = new byte[(int)serverFile.length()];
				int readByteCnt;
				while((readByteCnt = is.read(bs))!=-1){
					os.write(bs,0,readByteCnt);
				}
				System.out.println(ffilename+"복사함");
			}catch(Exception e){
				System.out.println(e.getMessage());
			}finally{
				if(os!=null) os.close();
				if(is!=null) is.close();
			}
		}
		// ffilename 외 다른 파라미터들 받기 (pageNum, dbfilename, fnum, fsubject, fcontent, fpw)
		// 파라미터 이용하여 dto 객체 생성
		// (ffilename이 null이면 ffilename 대신 dbfilename으로 dto의 ffilename을 셋팅)
		// dao 통해 update
	%>
</body>
</html>