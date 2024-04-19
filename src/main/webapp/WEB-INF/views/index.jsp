<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1><%= "Hello World!" %></h1>
<br/>
<form action="SearchServlet" method="get">
  <input type="text" name="query" placeholder="Enter search query" required />
  <select name="engine">
    <option value="baidu">百度</option>
    <option value="google">谷歌</option>
    <option value="bing">必应</option>
  </select>
  <input type="submit" value="Search" />
</form>
<a href="HelloWorldServlet">Hello Servlet-week2</a>
<br/>
<a href="register">register Servlet-week3</a>
<br/>
<a href="register.jsp">register.jsp-week3</a>
<br/>
<a href="JDBCDemoServlet">JDBCDemoServlet-week4</a>
<br/>
<a href="index.jsp">include-week5</a>
<br/>
<a href="login.jsp">Login-week5</a>
<%@include file="footer.jsp"%>
</body>
</html>