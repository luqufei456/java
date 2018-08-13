<%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/8/3
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js"></script>
    <script>
        $(function () {
            //  随机字符串 --> 例如：uvnya6gwdas
            $('#code').html(Math.random().toString(36).substr(0,2));

            $('#btn').click(function () {
                var username = $('#username').val();
                var password = $('#password').val();
                var email = $('#email').val();
                var code = $('#code').val();

                if(username == "" || password == "" || email == ""){
                    alert("请输入账号、密码和邮箱地址");
                    return;
                }

                $.ajax({
                    url: '${pageContext.request.contextPath }/RegisterServlet',
                    //请求类型区分 get post 小型数据 不求安全 用get 否则post
                    type: 'POST',
                    dataType: 'json',
                    data:{'username':username,'password':password,'email':email,'code':code}
                })
                //data是json文件的实例对象 你取什么名字 下面就用什么
                    .done(function(data){
                        if (data.register){
                            alert(data.data);
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
    邮箱：<input type="email" id="email" />
    <input type="hidden" id="code" />
    <button id="btn">注册</button>

</body>
</html>
