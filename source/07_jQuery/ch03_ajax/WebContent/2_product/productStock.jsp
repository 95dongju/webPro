<%@page import="com.lec.ex.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		String pname = request.getParameter("pname");
		ProductDao pDao = ProductDao.getInstance();
		int pstock = pDao.getProductStock(pname);
		if(pstock == -1){
			out.println("해당 상품이 없습니다");
		}else{
			out.println(pstock+"개 있습니다");
		}
	%>
</body>
</html>