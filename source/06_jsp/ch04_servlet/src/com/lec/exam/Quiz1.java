package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Quiz1
 */
@WebServlet("/Quiz1")
public class Quiz1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String[] suStr = request.getParameterValues("gugudan");
		PrintWriter out = response.getWriter();
		if(suStr == null) {
			out.println("<h2>수를 선택하지 않았습니다.</h2>");
		} else {
			out.println("<html>");
			out.println("<head>");
			out.println("<style>");
			out.println("td {width:100px; text-align:center;}");
			out.println("</style>");
			out.println("</head>");
			out.println("<body>");
			for(int a=1; a<10; a++) {
				out.println("<table><tr>");
				int su[] = new int[suStr.length];
				for(int b=0; b<su.length; b++) {
					su[b] = Integer.parseInt(suStr[b]);
					out.println("<td>"+su[b] + " * " + a + " = " + su[b]*a + "</td>");
				}
				out.println("</tr></table>");
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
