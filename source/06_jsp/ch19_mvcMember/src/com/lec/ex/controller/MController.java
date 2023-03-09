package com.lec.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.service.*;

/**
 * Servlet implementation class MController
 */
@WebServlet("*.do")
public class MController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean join = false;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		if(command.equals("/joinView.do")) {
			viewPage = "member/join.jsp";
		}else if(command.equals("/join.do")) {			
			service = new MJoinService();
			service.execute(request, response);
			viewPage = "member/login.jsp";
		}else if(command.equals("/loginView.do")) {
			viewPage = "member/login.jsp";
		}else if(command.equals("/login.do")) {
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		}else if(command.equals("/logout.do")) {
			service = new MLogoutervice();
			service.execute(request, response);
			viewPage = "loginView.do";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
