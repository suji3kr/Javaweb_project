package com.company.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebServlet("/login")
public class LoginTest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 응답 인코딩 설정
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // 세션 객체 생성
        HttpSession session = request.getSession();

        // 폼에서 넘어온 데이터 받아오기
        String user_id = request.getParameter("user_id");
        String user_pw = request.getParameter("user_pw");

        LoginImpl loginUser =new LoginImpl(user_id, user_pw);
        
        // 로그인 성공 시 세션에 사용자 정보 저장 (예시)
        if (session.isNew()) {
            session.setAttribute("loginUser", loginUser);

        }

        // 출력하기
        out.print("<html>");
        out.print("<head>");
        out.print("<script>");
        out.print("<setTimeout('histor.go(0);', 5000");
        out.print("</script>");
        out.print("</head>");
        out.print("<body>");
        out.print("아이디는 "+ loginUser.user_id + "<br/>");
        out.print("총 접속자 수는 "+ LoginImpl.total_user + "<br/>");
        out.print("</body></html>");
    }
}
