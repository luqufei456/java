<%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/7/23
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" type="text/css" />
    <script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- 引入自定义css文件 style.css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/style.css" type="text/css" />
    <title>会员注册</title>
    <style>
        body {
            margin-top: 20px;
            margin: 0 auto;
        }

        .carousel-inner .item img {
            width: 100%;
            height: 300px;
        }

        font {
            color: #3164af;
            font-size: 18px;
            font-weight: normal;
            padding: 0 10px;
        }
    </style>
</head>
<body>
    <!-- 引入header.jsp -->
    <jsp:include page="header.jsp"></jsp:include>

    <div class="container"
         style="width: 100%; background: url('${pageContext.request.contextPath }/static/images/register/regist_bg.jpg');">
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8"
                 style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
                <font>会员注册</font>USER REGISTER
                <form class="form-horizontal" style="margin-top: 5px;" action="${pageContext.request.contextPath }/RegisterServlet" method="post">

                    <div class="form-group">
                        <label for="userName" class="col-sm-2 control-label">昵称</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="userName" name="userName"
                                   placeholder="请输入昵称">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">邮箱</label>
                        <div class="col-sm-6">
                            <input type="email" class="form-control" id="email" name="email"
                                   placeholder="请输入注册邮箱">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="userPwd" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-6">
                            <input type="password" class="form-control" id="userPwd" name="userPwd"
                                   placeholder="请输入密码">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="confirmPwd" class="col-sm-2 control-label">确认密码</label>
                        <div class="col-sm-6">
                            <input type="password" class="form-control" id="confirmPwd" name="confirmPwd"
                                   placeholder="确认密码">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="mobile" class="col-sm-2 control-label">手机号码</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="mobile" name="mobile"
                                   placeholder="请输入手机号码">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="qq" class="col-sm-2 control-label">QQ</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="qq" name="qq"
                                   placeholder="请输入QQ号">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="code" class="col-sm-2 control-label">验证码</label>
                        <div class="col-sm-3">
                            <input type="text" id="code" name="code" class="form-control">

                        </div>

                        <script>
                            function changeImage(img) {
                                // 点击图片，修改图片的加载路径
                                // 注意：加载路径仍然是之前的路径，只是在后面加上一个时间参数，来确保每次路径的地址不一样
                                // 如果路径一样，则图片不会重新加载
                                img.src = "${pageContext.request.contextPath }/ImagesServlet?abc" + Math.random()*100;
                            }
                        </script>

                        <div class="col-sm-2">
                            <img src="${pageContext.request.contextPath }/ImagesServlet" alt="验证码" onclick="changeImage(this)" />
                        </div>

                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <input type="submit" width="100" value="注册" name="submit"
                                   style="background: url('${pageContext.request.contextPath }/static/images/register/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
                        </div>
                    </div>
                </form>

                <div class="form-group">
                    <label for="qq" class="col-sm-2 control-label">响应信息</label>
                    <div class="col-sm-6">
                        <span>${registerResponse}</span>
                    </div>
                </div>

            </div>

            <div class="col-md-2"></div>

        </div>
    </div>

    <!-- 引入footer.jsp -->
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
