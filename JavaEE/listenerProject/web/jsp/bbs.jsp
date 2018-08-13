<%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/7/19
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发帖</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/jsp/show.jsp" method="post">
    帖子内容：<br />
    <textarea name="desc" id="" cols="30" rows="10"></textarea>
    <input type="submit" value="发表" />
</form>
</body>
</html>
