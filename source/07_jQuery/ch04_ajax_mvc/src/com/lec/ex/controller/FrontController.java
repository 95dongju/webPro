package com.lec.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.service.*;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		// productStock.do?pname=공책	
		if(command.equals("/productStock.do")) {
			service = new ProductStockService();
			service.execute(request, response);
			viewPage = "2_product/productStock.jsp";
		}
		// productView.do (productStock.do를 ajax로 요청 페이지)
		else if(command.equals("/productView.do")) {
			viewPage = "2_product/product.html";
		}
		// midConfirm.do?mid=go
		else if(command.equals("/midConfirm.do")) {
			service = new MidConfirmService();
			service.execute(request, response);
			viewPage = "3_member/midConfirm.jsp";
		}
		// joinView.do (midConfirm.do를 ajax로 요청 페이지)
		else if(command.equals("/joinView.do")) {
			viewPage = "3_member/join.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
