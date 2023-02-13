package com.lec.ex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MVC 패턴에서 컨트롤러 역할을 하는 Servlet
 */
@WebServlet("*.do")
public class Ex3_mvc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청된 command(writer.do, join.do, memberLogin.do, delete.do)
		// url : http://localhost:8090/ch05_jsp/delete.do
		// uri : /ch05_jsp/delete.do
		// conPath: /ch05_jsp
		String conPath = request.getContextPath(); // = /ch05_jsp
		String uri = request.getRequestURI(); // = /ch05_jsp/delete.do
		String command = uri.substring(conPath.length()+1);
		response.setContentType("text/html; charset=utf-8");
		System.out.println("command = " +command);
		response.getWriter().println("command = " +command);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
