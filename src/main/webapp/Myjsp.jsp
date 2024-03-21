<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册表单</title>
</head>
<body>
<form action="your_servlet_url" method="post">
    <div>
        <label for="username">用户名:</label>
        <input type="text" id="username" name="username" required>
    </div>
    <div>
        <label for="password">密码:</label>
        <input type="password" id="password" name="password" required>
    </div>
    <div>
        <label for="email">邮箱:</label>
        <input type="email" id="email" name="email" required>
    </div>
    <div>
        <label for="birthday">生日:</label>
        <input type="date" id="birthday" name="birthday" required>
    </div>
    <div>
        <label for="gender">性别:</label>
        <input type="radio" id="male" name="gender" value="male" required>
        <label for="male">男</label><br>
        <input type="radio" id="female" name="gender" value="female" required>
        <label for="female">女</label>
    </div>
    <div>
        <input type="submit" value="提交">
    </div>
</form>
</body>
</html>