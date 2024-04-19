package com.ShangQianDing.week4;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.PrintWriter;

@WebServlet(
        name = "JDBCDemoServlet",
        urlPatterns = {"/JDBCDemoServlet"},
        initParams = {
                @WebInitParam(name = "name1", value = "TangZhengYu"),
                @WebInitParam(name = "studentId1", value = "2022211001000420")
        }
)
public class JDBCDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost/userdb";
        String username = "root";
        String password = "Sqd20040917";

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("-->" + con);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        response.setContentType("text/html");

        // 获取PrintWriter对象用于向客户端输出
        PrintWriter out = response.getWriter();

        // 获取servlet配置参数
        String name = getServletConfig().getInitParameter("name");
        String studentId = getServletConfig().getInitParameter("studentId");
        String name1 = getServletConfig().getInitParameter("name1");
        String studentId1 = getServletConfig().getInitParameter("studentId1");

        // 打印servlet配置参数的名称和值
        out.println("<h1>Task1-Get init parameters from web.xml</h1>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Student ID: " + studentId + "</p>");
        out.println("<h1>Task2-Get init parameters from @WebServlet</h1>");
        out.println("<p>Name 1: " + name1 + "</p>");
        out.println("<p>Student ID 1: " + studentId1 + "</p>");

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }
}
