<%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/7/14
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提交表单</title>
</head>
<body>
    <form action="FormServlet">
        用户 <input type="text" name="formUser" /> <br />
        密码 <input type="password" name="formPwd" /> <br />
        <button type="submit">录入用户</button>
    </form>
</body>
</html>
