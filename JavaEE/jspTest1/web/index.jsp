<%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/7/16
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%-- 解决关闭浏览器session还存在的问题 --%>
  <% session.invalidate(); %>
  当前人数为：${applicationScope.onlineNum}
  </body>
</html>
