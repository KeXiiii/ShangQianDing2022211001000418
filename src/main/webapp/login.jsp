<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<%@include file="header.jsp"%>
<h2>登录</h2>
<form action="LoginServlet" method="post">
    账号：<input type="text" id="username" name="username" required>
    <br><br>
    密码：<input type="password" id="password" name="password" required>
    <br><br>
    <input type="submit" value="登录">
</form>
<%@include file="footer.jsp"%>
</body>
</html>
