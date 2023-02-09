package com.lec.lect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex4_initParam
 */
//@WebServlet(urlPatterns = {"/Ex4_initParam"},
//			initParams = {@WebInitParam(name="id", value="root"),
//							@WebInitParam(name="pw", value="mysql"),
//							@WebInitParam(name="jdbcbriver", value="com.mysql.jdbcDriver")}
//			)
public class Ex4_initParam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = getInitParameter("id");
		String pw = getInitParameter("pw");
		String driver = getInitParameter("jdbcdriver");
		response.setContentType("text/html");
		response.getWriter().println("id = " + id + "<br>");
		response.getWriter().println("pw = " + pw + "<br>");
		response.getWriter().println("driver = " +driver + "<br>");
		System.out.println("id = " + id);
		System.out.println("pw = " + pw);
		System.out.println("driver = " + driver);
		
		// 공유 파라미터는 프로젝트 내의 모든 서블릿이 공유함
		String contextId = getServletContext().getInitParameter("contextId");
		String contextPw = getServletContext().getInitParameter("contextPw");
		response.getWriter().append("contextId : " + contextId + ", ");
		response.getWriter().append("contextPw : " + contextPw);
		System.out.println("contextId : " + contextId);
		System.out.println("contextPw : " + contextPw);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
