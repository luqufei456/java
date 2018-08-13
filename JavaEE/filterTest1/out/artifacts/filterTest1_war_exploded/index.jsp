<%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/7/19
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="${pageContext.request.contextPath}/LoginServlet?arg=user">普通用户登录</a> <br />
  <a href="${pageContext.request.contextPath}/LoginServlet?arg=admin">管理员登录</a> <br />
  <a href="${pageContext.request.contextPath}/LoginServlet?arg=down">退出</a> <br />
  </body>
</html>
