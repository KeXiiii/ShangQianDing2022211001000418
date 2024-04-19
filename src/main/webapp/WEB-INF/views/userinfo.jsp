<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.ShangQianDing.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../../header.jsp"%>
<%
  User user = (User) request.getAttribute("user");
%>
<head>
  <h1>User Info</h1>
</head>
<body>
<table>
  <td><td>Username:</td><td><%=user.getUsername()%></td></tr>
  <td><td>password:</td><td><%=user.getPassword()%></td></tr>
  <td><td>email:</td><td><%=user.getEmail()%></td></tr>
  <td><td>gender:</td><td><%=user.getGender()%></td></tr>
  <td><td>birthdate:</td><td><%=user.getBirthdate()%></td></tr>
</table>
</body>
<%@include file="../../footer.jsp"%>
</html>
