<%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/8/7
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>管理主页</title>
    <script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* 放到index.css会失效，就放这里 */
        table tr th,td{
            height:30px;
            line-height:30px;
            border:1px solid #ccc;
            text-align:center;
        }
        .through_operation {
            background-color: #4cae4c;
            padding: 2px 5px;
            border-radius: 5px;
            color: RGB(255, 255, 255);

        }
        #pageStyle{
            display:inline-block;
            width:32px;
            height:32px;
            border:1px solid #CCC;
            line-height:32px;
            text-align:center;
            color:#999;
            margin-top:20px;
            text-decoration:none;

        }
        #pageStyle:hover{
            background-color:#CCC;
        }
        #pageStyle .active{
            background-color:#0CF;
            color:#ffffff;
        }
        #a_div{
            text-align: center;
        }

        .state {
            margin-top: 20px;
            margin-left: auto;
            margin-right: auto;
            width: 1360px;
        }

        .state li, a, input, select, label, form {
            display: inline-block;
        }

        .state li {
            margin-right: 10px;
        }
    </style>
    <script>
        $(function () {
            var $tby = $('#a_tbody');

            $.ajax({
                url: '${pageContext.request.contextPath }/ManagerServlet',
                type: 'POST',
                dataType: 'text',
                data: {'all_user':true}
            })
                .done(function (data) {
                    var json = JSON.parse(data);
                    console.log(json.userList);


                    $.each(json.userList, function (index,dict) {
                        var $tr = $("<tr></tr>");
                        $tby.append($tr);
                        $tr.append($("<td>" + dict.id + "</td>"));
                        $tr.append($("<td>" + dict.username + "</td>"));
                        $tr.append($("<td>" + dict.password + "</td>"));
                        $tr.append($("<td>" + dict.email + "</td>"));
                        $tr.append($("<td>" + dict.max_goal + "</td>"));
                        $tr.append($("<td>" + dict.activate + "</td>"));
                        $tr.append($("<td>" + dict.userLevel + "</td>"));
                        $tr.append($('<td><a href="${pageContext.request.contextPath }/UserUpdateServlet?id='+ dict.id +'" class="through_operation" style="background-color: #31b0d5">查看→</a></td>'));
                    })
                })
                .fail(function () {
                    alert('服务器超时，请重试！');
                });
            
            
            $('#btn').click(function () {
                var isActivate = $('#isActivate').val();
                var sort = $('#sort').val();
                var username = $('#username').val();
                console.log("激活："+isActivate+" 倒序："+sort+" 用户名："+username);

                $.ajax({
                    url: '${pageContext.request.contextPath }/ManagerServlet',
                    type: 'POST',
                    dataType: 'text',
                    data: {'isActivate':isActivate,'sort':sort,'username':username}
                })
                    .done(function (data) {
                        var json = JSON.parse(data);
                        console.log(json.userList);
                        // 清空子元素
                        $tby.empty();

                        $.each(json.userList, function (index,dict) {
                            var $tr = $("<tr></tr>");
                            $tby.append($tr);
                            $tr.append($("<td>" + dict.id + "</td>"));
                            $tr.append($("<td>" + dict.username + "</td>"));
                            $tr.append($("<td>" + dict.password + "</td>"));
                            $tr.append($("<td>" + dict.email + "</td>"));
                            $tr.append($("<td>" + dict.max_goal + "</td>"));
                            $tr.append($("<td>" + dict.activate + "</td>"));
                            $tr.append($("<td>" + dict.userLevel + "</td>"));
                            $tr.append($('<td><a href="${pageContext.request.contextPath }/UserUpdateServlet?id='+ dict.id +'" class="through_operation" style="background-color: #31b0d5">查看→</a></td>'));
                        })
                    })
                    .fail(function () {
                        alert('服务器超时，请重试！');
                    });

            })
            
        })
    </script>
</head>
<body>

    <div class="state">
        <ul>
            <li>
                <label>是否激活：</label>
                <select class="" id="isActivate">
                    <option value="1">已激活</option>
                    <option value="0">未激活</option>
                </select>
            </li>
            <li>
                <label>是否倒序：</label>
                <select class="" id="sort">
                    <option value="">默认升序</option>
                    <option value="asc">升序</option>
                    <option value="desc">降序</option>
                </select>
            </li>
            <li>
                <label>用户名：</label>
                <input type="text" placeholder="用户名" id="username" />
            </li>
            <li>
                <input type="button" id="btn" value="搜索" class="btn btn-info" />
            </li>

        </ul>
    </div>

    <div>
        <table class="table table-bordered" style="width: 1360px;margin: 20px auto 0;" id="all_tab">
            <thead>
            <tr>
                <th width="7%">Id</th>
                <th width="15%">用户名</th>
                <th width="15%">用户密码</th>
                <th width="17%">邮箱</th>
                <th width="13%">最高分</th>
                <th width="13%">是否激活</th>
                <th width="10%">用户等级</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="a_tbody">

            </tbody>
        </table>
    </div>
</body>
</html>
