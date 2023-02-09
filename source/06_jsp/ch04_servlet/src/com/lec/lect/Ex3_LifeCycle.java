package com.lec.lect;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LifeCycleEx")
public class Ex3_LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PostConstruct
	private void PostConstruct() {
		// servlet 객체가 생성되자마자 실행
		System.out.println("EX3_LifeCycle Servlet 객체가 생성될 때 수행 - 1");
	}
	public void init(ServletConfig config) throws ServletException {
		// servlet 객체가 생성될 때 실행되는 함수
		System.out.println("EX3_LifeCycle Servlet 객체가 생성(메모리에 load)될 때 수행됨 - 2");
	}

	public void destroy() {
		// servlet 객체가 소멸될 때 실행되는 함수
		System.out.println("EX3_LifeCycle Servlet 객체가 소멸(메모리에서 삭제)될 때 수행됨 - 1");
	}
	@PreDestroy
	private void preDestroy() {
		// servlet 객체가 소멸되기 바로 전 실행
		System.out.println("Ex3_LifeCycle Servlet 객체가 소멸되기 바로 전 수행 - 2");
	}
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	// service 함수를 오버라이드 하면 doGet(), doPost() 함수가 무시되고 service() 함수가 실행됨
//		response.setContentType("text/html; charset=UTF-8");
//		response.getWriter().append("<h1>service() 수행</h1>").append(request.getContextPath());
//		System.out.println("service() 실행");
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("<h1>doGet() 수행</h1>");
		System.out.println("doGet() 실행");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("<h1>doPost() 수행</h1>");
		System.out.println("doPost() 실행");
	}
}
