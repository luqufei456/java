<%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/7/18
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  当前在线游客人数：${pageContext.getAttribute("touristNum",4).size()} <br>
  当前在线登录人数：${pageContext.getAttribute("userNum",4).size()} <br>
  当前在线总数：${pageContext.getAttribute("touristNum",4).size()+pageContext.getAttribute("userNum",4).size()}
  <a href="${pageContext.request.contextPath}/OnlineNumServlet?login=up">用户登录</a> <a href="${pageContext.request.contextPath}/OnlineNumServlet?login=down">退出登录</a>
  </body>
</html>
