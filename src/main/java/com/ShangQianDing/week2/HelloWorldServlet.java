package com.ShangQianDing.week2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html");

        // 获取PrintWriter对象，用于向客户端发送文本数据
        PrintWriter out = response.getWriter();

        // 准备要显示的数据
        String name = "ShangQianDing";
        String studentId = "2022211001000418";
        Date currentTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedTime = sdf.format(currentTime);

        // 写入HTML内容到输出流
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Student Information</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Student Information</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Student ID: " + studentId + "</p>");
        out.println("<p>Date And Time: " + formattedTime + "</p>");
        out.println("</body>");
        out.println("</html>");

        // 关闭PrintWriter
        out.close();
    }
}