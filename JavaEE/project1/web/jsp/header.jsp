<%@ page import="cn.yiran.web.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/7/20
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js" type="text/javascript"></script>
<script>
    $.ajax({
        url: '${pageContext.request.contextPath }/IndexServlet',
        type: 'GET',
        dataType: 'json',
        data:{'getCategory':true}
    })
        .done(function(data) {
            var $ul = $(".navbar-collapse>ul");
            if ($ul.children().length === 0){
                for (var i = 0;i < data.categoryList.length;i++){
                    $ul.append(
                        "<li value='"+data.categoryList[i].cid+"' ><a href='${pageContext.request.contextPath }/ProductServlet?cid="+data.categoryList[i].cid+"'>"+data.categoryList[i].cname+"<span class='sr-only'>(current)</span></a></li>"
                    );
                }
            }
        })
        .fail(function() {
            alert('服务器超时，请重试！');
        });
</script>
<html>
<body>
    <!-- 登录 注册 购物车... -->
    <div class="container-fluid">
        <div class="col-md-4">
            <img src="${pageContext.request.contextPath}/static/images/base/logo2.png" />
        </div>
        <div class="col-md-5">
            <img src="${pageContext.request.contextPath}/static/images/base/header.png" />
        </div>
        <div class="col-md-3" style="padding-top:20px">
            <% User user = (User) session.getAttribute("user"); %>

            <ol class="list-inline">
                <c:choose>
                    <c:when test="${pageContext.getAttribute('user',3)!=null }">
                        <li> <span style="display: inline-block;padding-right: 14px;border-right: 1px solid #000">欢迎</span></li>
                        <li><span><%=user.getUserName() %></span></li>
                        <li><span><a href="${pageContext.request.contextPath }/IndexServlet?userOff=yes">注销</a></span></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${pageContext.request.contextPath }/jsp/login.jsp">登录</a></li>
                        <li><a href="${pageContext.request.contextPath }/jsp/register.jsp">注册</a></li>
                    </c:otherwise>
                </c:choose>

                <li><a href="${pageContext.request.contextPath }/CartServlet">购物车</a></li>
                <li><a href="${pageContext.request.contextPath }/jsp/order_list.jsp">我的订单</a></li>
            </ol>
        </div>
    </div>
    <c:set var="root" value="${pageContext.request.contextPath }" scope="application"></c:set>
    <!-- 导航条 -->
    <div class="container-fluid">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath }/IndexServlet">首页</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                    </ul>
                    <form class="navbar-form navbar-right" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </div>
        </nav>
    </div>
</body>
</html>
