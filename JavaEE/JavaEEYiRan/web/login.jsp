<%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/7/9
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试登录页面</title>
</head>
<body>
<form action="LoginServlet" method="post">
    User: <input type="text" name="username" /><br />
    password: <input type="password" name="password" /><br />
    <button type="submit">login</button>
</form>
</body>
</html>
