<%@page import="com.lect.dto.CustomerDto"%>
<%@page import="com.lect.dto.FileboardDto"%>
<%@page import="com.lec.dao.FileboardDao"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
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
		//파라미터 정보 (pageNum, fnum, fsubject, fcontent, fpw, fref, fre_step, fre_level)
		String pageNum = mRequest.getParameter("pageNum");
		int fnum =  Integer.parseInt(mRequest.getParameter("fnum"));
		String cid = ((CustomerDto)session.getAttribute("customer")).getCid();
		String fsubject = mRequest.getParameter("fsubject");
		String fcontent = mRequest.getParameter("fcontent");
		String fpw = mRequest.getParameter("fpw");
		int fref =  Integer.parseInt(mRequest.getParameter("fref"));
		int fre_step =  Integer.parseInt(mRequest.getParameter("fre_step"));
		int fre_level =  Integer.parseInt(mRequest.getParameter("fre_level"));
		String fip = request.getRemoteAddr();
		FileboardDao fDao = FileboardDao.getInstance();
		FileboardDto fDto = new FileboardDto(fnum, cid, fsubject, fcontent, ffilename, fpw,
				fref, fre_level, fre_step, fip);
		int result;
		if(fnum==0){
			result = fDao.insertFileboard(fDto);
		}else{
			result = fDao.reply(fDto);
		}
		if(result == FileboardDao.SUCCESS){%>
			<script>
				alert('<%=fnum==0?"글쓰기 완료":"답글쓰기 완료"%>');
				location.href='<%=conPath%>/fileboard/fboardList.jsp?pageNum=<%=pageNum%>';
			</script>
		<%}else{%>
			<script>
				alert('<%=fnum==0?"글쓰기 실패":"답글쓰기 실패"%> (데이터 길이를 확인하세요)');
				history.back();
			</script>
		<%}
	%>
</body>
</html>