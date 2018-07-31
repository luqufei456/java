
<%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/7/20
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>会员登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" type="text/css" />
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- 引入自定义css文件 style.css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" type="text/css" />

    <style>
        body {
            margin-top: 20px;
            margin: 0 auto;
        }

        .carousel-inner .item img {
            width: 100%;
            height: 300px;
        }

        .container .row div {
            /* position:relative;
                         float:left; */

        }

        font {
            color: #666;
            font-size: 22px;
            font-weight: normal;
            padding-right: 17px;
        }
    </style>
</head>
<body>

<%
    boolean isSave = false;
    String email = "";
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies){
        System.out.println(cookie.getName());
        if (cookie.getName().equals("email")){
            email = cookie.getValue();
            isSave = true;
        }
    }
%>

<!-- 引入header.jsp -->

<jsp:include page="header.jsp"></jsp:include>

<div class="container"
     style="width: 100%; height: 460px; background: #FF2C4C url('${pageContext.request.contextPath}/static/images/login/loginbg.jpg') no-repeat;">
    <div class="row">
        <div class="col-md-7">
            <!--<img src="./image/login.jpg" width="500" height="330" alt="会员登录" title="会员登录">-->
        </div>

        <div class="col-md-5">
            <div
                    style="width: 440px; border: 1px solid #E7E7E7; padding: 20px 0 20px 30px; border-radius: 5px; margin-top: 60px; background: #fff;">
                <font>会员登录</font>USER LOGIN
                <div>&nbsp;</div>
                <form class="form-horizontal" action="${pageContext.request.contextPath }/LoginServlet" method="post">
                    <div class="form-group">
                        <label for="username" class="col-sm-3 control-label">用户名</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="username" name="email"
                                   placeholder="请输入用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-sm-3 control-label">密码</label>
                        <div class="col-sm-6">
                            <input type="password" class="form-control" id="password" name="userPwd"
                                   placeholder="请输入密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="code" class="col-sm-3 control-label">验证码</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="code" name="code"
                                   placeholder="请输入验证码">
                        </div>

                        <script>
                            function changeImage(img) {
                                // 点击图片，修改图片的加载路径
                                // 注意：加载路径仍然是之前的路径，只是在后面加上一个时间参数，来确保每次路径的地址不一样
                                // 如果路径一样，则图片不会重新加载
                                img.src = "${pageContext.request.contextPath }/ImagesServlet?abc" + Math.random()*100;
                            }

                            window.onload = function () {
                                var userInput = document.getElementById("username");
                                var saveInput = document.getElementById("save");
                                if (<%=isSave%>) {
                                    userInput.value = "<%=email %>";
                                    saveInput.checked = "checked";
                                }
                            }
                        </script>

                        <div class="col-sm-3">
                            <img src="${pageContext.request.contextPath }/ImagesServlet" alt="验证码" onclick="changeImage(this)" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <div class="checkbox">
                                <label>
                                </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label> <input
                                    type="checkbox" id="save"  name="save"> 记住用户名
                            </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <input type="submit" width="100" value="登录"
                                   style="background: url('${pageContext.request.contextPath}/static/images/login/login.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- 引入footer.jsp -->
<%@include file="footer.jsp"%>
</body>
</html>