<%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/7/12
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>等待页面</title>
    <script>
        // 定义倒计时数字
        var count = 3;
        // 当页面加载完成时候调用
        window.onload = function () {
            function tick() {
                // 判断倒计时数字大于0继续进行倒计时操作
                if (count>0) {
                    var p = document.getElementById("time");
                    // 页面显示倒计时的数字，显示后数字-1
                    p.innerHTML = "" + count;
                    count--;
                    window.setTimeout(tick, 1000);
                }
            }

            tick();
        }
    </script>
    <% String name = (String)request.getAttribute("name"); %>
</head>
<body>
注册成功，你好，<span><%=name %></span>，页面将在<p id="time">3</p>秒后进行跳转
<% response.setHeader("Refresh", "3;index.jsp"); %>
</body>
</html>
