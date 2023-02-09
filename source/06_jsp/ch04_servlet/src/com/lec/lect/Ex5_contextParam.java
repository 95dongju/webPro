package com.lec.lect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex5_contextParam
 */
@WebServlet("/Ex5_contextParam")
public class Ex5_contextParam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextId = getServletContext().getInitParameter("contextId");
		String contextPw = getServletContext().getInitParameter("contextPw");
		response.getWriter().append("contextId : " + contextId + ", ");
		response.getWriter().append("contextPw : " + contextPw);
		System.out.println("contextId : " + contextId);
		System.out.println("contextPw : " + contextPw);
		// 공유 파라미터는 프로젝트 내의 모든 서블릿이 공유함
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
