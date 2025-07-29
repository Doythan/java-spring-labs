package com.example.servletdemo2;

import jakarta.servlet.http.HttpServlet;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("*.do")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doGet called");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doPost called");

//        BufferedReader br = request.getReader();
//        String data;
//
//        while ((data = br.readLine()) != null) {
//            System.out.println("read buffer data: " + data);
//        }

        String username = request.getParameter("username");
        System.out.println("username: " + username);

        String uri = request.getRequestURI();
        String userAgent = request.getHeader("User-Agent");
        String contentType = request.getContentType();
        String method = request.getMethod();

        System.out.println("uri: " + uri);
        System.out.println("userAgent: " + userAgent);
        System.out.println("contentType: " + contentType);
        System.out.printf("method: %s\n", method);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>");
        out.println("good");
        out.println("</h1>");
        out.flush();
    }
}