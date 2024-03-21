package com.ShangQianDing.week3;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型  
        response.setContentType("text/html;charset=UTF-8");

        // 获取请求中的参数  
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");

        // 构建响应消息  
        StringBuilder responseMessage = new StringBuilder();
        responseMessage.append("<html><head><title>用户信息</title></head><body>");
        responseMessage.append("<h2>您填写的信息如下：</h2>");
        responseMessage.append("<p>用户名: ").append(username).append("</p>");
        responseMessage.append("<p>密码: ").append(password).append("</p>");
        responseMessage.append("<p>邮箱: ").append(email).append("</p>");
        responseMessage.append("<p>生日: ").append(birthday).append("</p>");
        responseMessage.append("<p>性别: ").append(gender).append("</p>");
        responseMessage.append("</body></html>");

        // 将响应消息发送到客户端  
        response.getWriter().write(responseMessage.toString());
    }
}