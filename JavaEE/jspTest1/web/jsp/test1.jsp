<%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/7/16
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
hello jsp

<%-- 脚本表达式  格式：<%= java代码 %>  可以将数据输出到页面  --%>
<!-- 另一种注释，只有html注释可以在页面源代码中看到 -->
<p>"<%=showCount()%>"</p>

<%-- 脚本声明  <%!  %>  一般用于声明变量、方法，作用范围为整个类，即jsp  --%>
<%!
    // 声明一个变量，另一种注释
    int count = 100;
    // 声明一个方法
    int showCount(){
        return count;
    }
    /* 没有返回值时，不能在脚本表达式中使用，但是可以在脚本片段使用 */
    void printCount(){
        System.out.println(count);
    }
%>

<%-- 脚本片段，即使分开书写，也能最终组合在一起 --%>
<%
    if (count == 100){
%>
<h1>满分</h1>
<%
    }
    else{
%>
<h1>加油</h1>
<%
    }
%>

<c:out value="啦啦啦，这是taglib"></c:out>

<%
    //从小到大的4个容器
    pageContext.setAttribute("name", "page-jack",pageContext.PAGE_SCOPE);
    request.setAttribute("name", "request-jack");
    session.setAttribute("name", "session-jack");
    application.setAttribute("name", "application-jack");
%>

<%
    // 可以通过pageContext获取其余8个内置对象
    pageContext.getPage();
    pageContext.getRequest();
    pageContext.getResponse();
    pageContext.getServletConfig();
    pageContext.getServletContext();
    pageContext.getSession();
    pageContext.getException();
    pageContext.getOut();
%>

<%
    // 使用pageContext获取
    // page
    pageContext.getAttribute("name",pageContext.PAGE_SCOPE); // 1
    // request
    pageContext.getAttribute("name",pageContext.REQUEST_SCOPE); // 2
    // session
    pageContext.getAttribute("name",pageContext.SESSION_SCOPE); // 3
    // application
    pageContext.getAttribute("name",pageContext.APPLICATION_SCOPE); // 4
%>
</body>
</html>
