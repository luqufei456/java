<%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/7/11
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证码</title>
</head>
<body>
    <script>
        function changeImage(img) {
            // 点击图片，修改图片的加载路径
            // 注意：加载路径仍然是之前的路径，只是在后面加上一个时间参数，来确保每次路径的地址不一样
            // 如果路径一样，则图片不会重新加载
            img.src = "ImagesServlet?abc" + Math.random()*100;
        }
    </script>

    <img src="ImagesServlet" onclick="changeImage(this)" alt="">
</body>
</html>
