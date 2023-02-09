package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex3")
public class Ex3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numStr = request.getParameter("num");
		response.setContentType("text/html;charset=UTF-8");
		if(numStr==null) {
			response.getWriter().println("넘어온 파라미터가 없습니다");
		}else {
			int num = Integer.parseInt(numStr);
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<link href=\"css/ex2.css\" rel=\"stylesheet\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>"+num+"단</h2>");
			for(int i=1; i<10; i++) {
				out.println("<p>"+num+" * "+i+" = "+num*i+"</p>");
			}
			out.println("</body>");
			out.println("</html>");
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
