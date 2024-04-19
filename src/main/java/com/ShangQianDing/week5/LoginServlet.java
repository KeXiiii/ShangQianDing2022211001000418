package com.ShangQianDing.week5;

import com.ShangQianDing.dao.UserDao;
import com.ShangQianDing.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private Connection con;
    @Override
    public void init() throws ServletException{
        super.init();
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost/userdb";
        String username = "root";
        String password = "Sqd20040917";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            System.out.println("-->" + con);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");

        // 获取表单数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDao userDao = new UserDao();
        try {
            User user = userDao.findByUsernamePassword(con,username,password);
            if(user!= null)
            {
                request.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request,response);
            }else{
                request.setAttribute("message","username or password is error!!!");
                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request,response);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        /*PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "select * from usertable where username = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, username);
            // 执行查询
            rs = stmt.executeQuery();
            if (rs.next()) {
                // 用户验证成功，将用户信息放入request属性中
                request.setAttribute("id", rs.getInt("id"));
                request.setAttribute("username", rs.getString("username"));
                request.setAttribute("password", rs.getString("password"));
                request.setAttribute("email", rs.getString("email"));
                request.setAttribute("gender", rs.getString("gender"));
                request.setAttribute("birthdate", rs.getDate("birthdate"));
                // 重定向到userinfo.jsp页面
                RequestDispatcher dispatcher = request.getRequestDispatcher("userinfo.jsp");
                dispatcher.forward(request, response);
            } else {
                // 用户验证失败，重定向回login.jsp或显示错误信息
                request.setAttribute("errorMessage", "Invalid username or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            // 处理数据库异常，可能需要将用户重定向到一个错误页面
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
        } finally {
            // 关闭数据库资源
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/

      /*  try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>登录成功</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Login Sucecss!!!</h1>");
            out.println("<h2>Welcome，" + username + "！</h2>");
            out.println("</body>");
            out.println("</html>");
        }*/
    }
}
