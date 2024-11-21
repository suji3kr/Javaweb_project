package com.company.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

 @WebServlet("/login")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//request.setCharacterEncoding("utf-8"); //입력 설정 안하고 필터 적용해보기
		
		response.setContentType("text/html;charset=utf-8"); //출력
		PrintWriter out = response.getWriter();
		
		// 폼에서 넘어온 데이터 받아오기
		String user_name  = request.getParameter("user_name");
		String user_pw  = request.getParameter("user_pw");
		
		// 출력하기
		out.print("<html><body>");
		out.print("이름은: " + user_name + "</br>");
		out.print("비밀번호는: " + user_pw + "</br>");
		out.print("</body></html>");
	}
}
