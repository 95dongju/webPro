package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Quiz3
 */
@WebServlet("/Quiz3")
public class Quiz3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		int num = Integer.parseInt(request.getParameter("num"));
		int tot = 0;
		PrintWriter out = response.getWriter();
		for(int i=1; i<=num; i++) {
			tot +=i;
		}
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("h2 {color: red;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.print("<h2>1부터 "+num+"까지 누적합은 "+tot);
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
