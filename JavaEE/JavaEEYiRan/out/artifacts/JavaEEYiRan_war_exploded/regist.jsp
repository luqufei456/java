<%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/7/10
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form action="RegisterServlet" method="post">
        用户名：<input type="text" name="username" /><br />
        密码： <input type="password" name="password" />
        <input type="submit" value="提交" />
    </form>
</body>
</html>
