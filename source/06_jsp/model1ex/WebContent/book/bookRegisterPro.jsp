<%@page import="com.lect.dto.BookDto"%>
<%@page import="com.lec.dao.BookDao"%>
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
		String path = request.getRealPath("bookImg");
		// out.println(path);
		int maxSize = 1024*1024*5;
		String[] images = {"", ""};
		MultipartRequest mRequest = null;
		try{		
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> paramNames = mRequest.getFileNames(); // 파라미터 이름들
			int idx = 0;
			while(paramNames.hasMoreElements()){
				String param = paramNames.nextElement();
				images[idx] = mRequest.getFilesystemName(param);
				System.out.println(idx+"번째 처리한 파라미터 : " +param+ " / 파일 이름 : " +images[idx]);
				idx++;
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		// 서버로 올려진 파일을 소스폴더로 복사
		for(String imgfile : images){
			InputStream is = null;
			OutputStream os = null;
			File serverFile = new File(path+"/"+imgfile);
			if(serverFile.exists()){
				try{
					is = new FileInputStream(serverFile);
					os = new FileOutputStream("D:\\JU\\source\\06_jsp\\model1ex\\WebContent\\bookImg\\"+imgfile);
					byte[] bs = new byte[(int)serverFile.length()];
					while(true){
						int readByteCnt = is.read(bs);
						if(readByteCnt == -1) break;
						os.write(bs, 0, readByteCnt);
					}
				}catch(Exception e){
					System.out.println(e.getMessage());
				}finally{
					try{
						if(os!=null) os.close();
						if(is!=null) is.close();
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
				}
			}
		}
		//book 테이블(db)에 저장
		String btitle = mRequest.getParameter("btitle");
		int bprice = Integer.parseInt(mRequest.getParameter("bprice"));
		String bimage1 = images[1]!=null? images[1]: "noImg.png";
		String bimage2 = images[0]!=null? images[0]: "NOTHING.JPG";
		String bcontent = mRequest.getParameter("bcontent");
		int bdiscount = Integer.parseInt(mRequest.getParameter("bdiscount"));
		// String ip = mRequest.getRemoteAddr(); // XX ip가 필요한 경우 request 객체 이용 / 파라미터 받을 때만 MultipartRequest 사용
		BookDto dto = new BookDto(0, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, null);
		BookDao bDao = BookDao.getInstance();
		int result = bDao.insertBook(dto);
		if(result == BookDao.SUCCESS){
		%>
			<script>
				alert('책 등록 성공');
				location.href='<%=conPath%>/book/bookList.jsp';
			</script>
		<%}else{%>
			<script>
				alert('책 등록 실패');
				history.go(-1);
			</script>
			
		<%}%>
</body>
</html>