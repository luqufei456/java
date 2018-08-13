<%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/8/9
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户详情</title>
    <script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
    <style>
        ul{
            width: 500px;
            margin: 150px auto 0;
        }

        li{ padding:0;margin:5px 0;list-style:none}

        li input{
            border: 0;
        }

        li label{
            display: inline-block;
        }

    </style>

    <script>
        $(function () {
            $('#btn').click(function () {
                var data = {};
                var form = $('form').serializeArray();
                $.each(form,function () {
                    data[this.name] = this.value;
                });
                console.log(data);

                // 设置按钮不可点击，防止多次操作
                $('#btn').attr("disabled",true);

                $.ajax({
                    url: '${pageContext.request.contextPath }/UserUpdateServlet',
                    type: 'POST',
                    dataType: 'json',
                    data: data
                })
                    .done(function (data) {
                        // 收到返回后，设置可点击
                        $('#btn').attr("disabled",false);
                        alert(data);

                    })
                    .fail(function () {
                        alert('服务器超时，请重试！');
                    });
            })
        })
    </script>
</head>
<body>
    <form action="">
        <ul>
            <li>
                <label>用户id：</label>
                <input type="text" name="id" value="${gameUser.id}" style="outline: none;border: 0" readonly="readonly" />
            </li>
            <li>
                <label>用户名：</label>
                <input type="text" value="${gameUser.username}" style="outline: none;border: 0" readonly="readonly" />
            </li>
            <li>
                <label>密码：</label>
                <input type="text" name="password" value="${gameUser.password}" />
            </li>
            <li>
                <label>邮箱：</label>
                <input type="email" name="email" value="${gameUser.email}" />
            </li>
            <li>
                <label>最高分：</label>
                <input type="text" value="${gameUser.max_goal}" style="outline: none;border: 0" readonly="readonly" />
            </li>
            <li>
                <label>激活：</label>
                <input type="text" name="activate" value="${gameUser.activate}" />
            </li>
            <li>
                <label>等级：</label>
                <input type="text" name="userLevel" value="${gameUser.userLevel}" />
            </li>
            <li>
                <input type="button" value="修改" id="btn" class="btn btn-info" />
            </li>
        </ul>
    </form>
</body>
</html>
