package com.ShangQianDing.week3;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Statement;



@WebServlet("/register")
public class register extends HttpServlet {
    private Connection connection;

    @Override
    public void init() throws ServletException {
        // 获取上下文参数
        String driverClassName = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("username");
        String password = getServletContext().getInitParameter("password");

        // 加载驱动并创建数据库连接
        try {
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException("未能初始化数据库", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型  
        response.setContentType("text/html;charset=UTF-8");

        // 获取请求中的参数  
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date birthdayUtilDate = null;
        try {
            birthdayUtilDate = sdf.parse(birthday);
        } catch (Exception e) {
            System.out.println("Invalid birthday format. Please use YYYY-MM-DD format.");
            return;
        }
        java.sql.Date birthdaySqlDate = new java.sql.Date(birthdayUtilDate.getTime());
        try {
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO usertable (username, password, gender, birthdate, email) VALUES (?, ?, ?, ?, ?)");

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, gender);
            pstmt.setDate(4, birthdaySqlDate);
            pstmt.setString(5, email);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("<p>User registered successfully!</p>");
            } else {
                System.out.println("<p>Failed to register user.</p>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("<p>Error registering user: " + e.getMessage() + "</p>");
        }
        response.sendRedirect("login.jsp");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        System.out.println("连接成功！");
        try{PrintWriter out = response.getWriter();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM usertable");
        }
/*        {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>User List</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>UserName</th><th>PassWord</th><th>Email</th><th>Gender</th></tr>");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String gender = resultSet.getString("gender");
                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + username + "</td>");
                out.println("<td>" + password + "</td>");
                out.println("<td>" + email + "</td>");
                out.println("<td>" + gender + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } */
        catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            System.out.println("<p>Error retrieving user list: " + e.getMessage() + "</p>");
        }
    }
}