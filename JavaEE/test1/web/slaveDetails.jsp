<%@ page import="cn.yiran.web.domain.Slave" %><%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/7/13
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%  ServletContext context = config.getServletContext();
    String sid = request.getAttribute("slaveSid").toString();
    Slave slave = (Slave) context.getAttribute(sid);
%>
<head>
    <title><%=slave.getName()%></title>
</head>
<body>
<form action="AddSlaveServlet?" method="get">
    <p>编号：<input type="text" readonly="readonly" name="sid" value="<%=slave.getSid()%>" /> </p>
    <p>名称：<%=slave.getName()%></p>
    <p>简介：<%=slave.getIntroduc()%></p>
    <p>价格：<%=slave.getPrice()%></p>
    <p>数量： <input type="text" name="number" value="1" /> </p>
    <button type="submit">加入购物车</button>
</form>
</body>
</html>
