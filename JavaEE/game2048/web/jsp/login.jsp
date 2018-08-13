<%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/8/3
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                var username = $("#username").val();
                var password = $("#password").val();
                if(username == "" || password == ""){
                    alert("请输入用户名或密码");
                    alert(username+password);
                    return;
                }

                $.ajax({
                    url: '${pageContext.request.contextPath }/LoginServlet',
                    //请求类型区分 get post 小型数据 不求安全 用get 否则post
                    type: 'POST',
                    dataType: 'json',
                    data:{'username':username,'password':password}
                })
                //data是json文件的实例对象 你取什么名字 下面就用什么
                    .done(function(data){
                        if (data.login){
                            window.location.href = "${pageContext.request.contextPath }" + data.data;
                        }
                        else{
                            alert(data.data);
                        }
                    })
                    .fail(function(){
                        alert('连接超时，请检查网络');
                    })
            })
        })
    </script>
</head>
<body>
    用户名：<input type="text" id="username" />
    密码：<input type="password" id="password" />
    <button id="btn">登录</button>
</body>
</html>
