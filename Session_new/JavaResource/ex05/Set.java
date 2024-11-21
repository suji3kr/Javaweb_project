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

@WebServlet("/set")
public class Set extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();

        // ServletContext 객체 가져오기
        ServletContext ctx = getServletContext();
        // HttpSession 객체 가져오기
        HttpSession sess = request.getSession();

        // 각각의 속성 값 가져오기
        String ctxMesg = (String) ctx.getAttribute("context");
        String sesMesg = (String) sess.getAttribute("session");
        String reqMesg = (String) request.getAttribute("request");

        // 값 출력
        out.print("context값: " + ctxMesg + "<br>");
        out.print("session값: " + sesMesg + "<br>");
        out.print("request값: " + reqMesg + "<br>");
    }
}
