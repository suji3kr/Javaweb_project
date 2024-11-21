package com.company.ex05;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/get")
public class Get extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext ctx = getServletContext();
		HttpSession sess = request.getSession();
		
		String ctxMesg =(String) ctx.getAttribute("context");
		String sesMesg =(String) ctx.getAttribute("context");
		String reqMesg =(String) ctx.getAttribute("context");
		
		out.print("context값: " + ctxMesg + "</br>");
		out.print("session값: " + ctxMesg + "</br>");
		out.print("request값: " + ctxMesg + "</br>");

	
	}
}