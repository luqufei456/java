<%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/7/13
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <%
        boolean isSave = false;
        String username = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("user")){
               username = cookie.getValue();
               isSave = true;
            }
        }
    %>

    <script>
        function changeImage(img) {
            // 点击图片，修改图片的加载路径
            // 注意：加载路径仍然是之前的路径，只是在后面加上一个时间参数，来确保每次路径的地址不一样
            // 如果路径一样，则图片不会重新加载
            img.src = "ImagesServlet?abc" + Math.random()*100;
        }

        window.onload = function () {
            var userInput = document.getElementById("userInput");
            var saveInput = document.getElementById("save");
            if (<%=isSave%>){
                userInput.value = "<%=username %>";
                saveInput.checked = "checked";
            }
        }
    </script>

    <form action="LoginServlet" method="post">
        User: <input type="text" id="userInput" name="username" /><br />
        password: <input type="password" name="password" /> <br />
        验证码： <input type="text" name="code" /> <br/>
        <label><input type="checkbox" id="save" name="save" />保存用户名</label> <br />
        <img src="ImagesServlet" onclick="changeImage(this)" alt="">
        <button type="submit">登录</button>
    </form>
</body>
</html>
