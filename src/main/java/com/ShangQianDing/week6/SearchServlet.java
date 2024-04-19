package com.ShangQianDing.week6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");
        String engine = request.getParameter("engine");
        // 对查询字符串进行URL编码，防止特殊字符导致问题
        query = URLEncoder.encode(query, "UTF-8");

        // 根据选择的搜索引擎构造URL
        String redirectUrl;
        switch (engine) {
            case "baidu":
                redirectUrl = "https://www.baidu.com/s?wd=" + query;
                break;
            case "google":
                redirectUrl = "https://www.google.com/search?q=" + query;
                break;
            case "bing":
                redirectUrl = "https://www.bing.com/search?q=" + query;
                break;
            default:
                // 如果没有匹配的搜索引擎，可以重定向到一个默认页面或显示错误信息
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid search engine selected");
                return;
        }
        // 重定向到构造好的URL
        response.sendRedirect(redirectUrl);
    }
}