package com.metacoding.demo2;

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

        BufferedReader br = request.getReader();

        String data = br.readLine();
        System.out.println("read buffer data");
        System.out.println(data);

        String uri = request.getRequestURI();
        String userAgent = request.getHeader("User-Agent");
        String contentType = request.getContentType();
        System.out.println(uri);  // uri는 식별자
        System.out.println(userAgent);
        System.out.println(contentType);

        // buffer를 뒤에서 비우든 앞에서 비우든 비우면 username에는 null 임. 버퍼 부분을 주석처리하고 밑에 코드 실행하면 파싱되서 ssar가 뜸.
        String username = request.getParameter("username");
        System.out.println("username: " + username);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>");
        out.println("good");
        out.println("<h1>");
        out.flush();


        // contentType, body는 알아야 함.
        // 내가 보내는 데이터를 설명해줘야함.
        // contentType에 적을 수 있는 MIME는 3개 -> HTML, JSON, x-www-form-urlencoded
        // readLine(), 버퍼는 \n 까지만 읽음
        // request 객체에 어떤 함수가 있는지 공부

    }
}

// 강사님 코드.
//package com.metacoding.demo2;
//
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@WebServlet("*.do")
//public class HelloServlet extends HttpServlet {
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        System.out.println("doGet called");
//    }
//
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        System.out.println("doPost called");
//
//        //BufferedReader br = request.getReader();
//
//        String username = request.getParameter("username");
//        System.out.println("username: " + username);
//
//        //String data = br.readLine();
//        //System.out.println("read buffer data");
//        //System.out.println(data);
//
//        String uri = request.getRequestURI();
//        String userAgent = request.getHeader("User-Agent");
//        String contentType = request.getHeader("Content-Type");
//        System.out.println(uri);
//        System.out.println(userAgent);
//        System.out.println(contentType);
//
//        response.setContentType("application/json");
//        PrintWriter out = response.getWriter();
//        out.println("<h1>");
//        out.println("good");
//        out.println("</h1>");
//        out.flush();
//    }
//
//}