package com.company.ex06;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.do") //
public class TestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String context = request.getContextPath();  // path 경로기억
		String url = request.getRequestURL().toString();
		String mapping = request.getServletPath();
		String uri = request.getRequestURI();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Test Servlet1</title>");
		out.print("</head>");
		out.print("<body bgcolor='pink'>");
		out.print("<b>Testservelt2입니다.</b><br>");
		out.print("<b>컨텍스트 이름:"+ context +"<b><br>" );
		out.print("<b>전체경로: "+ url +"<b><br>");
		out.print("<b>매핑이름: " + mapping +"<b><br>");		
		out.print("<b>URI : "+uri + "<b>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
}