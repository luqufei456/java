<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/7/26
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" type="text/css" />
    <script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- 引入自定义css文件 style.css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/style.css" type="text/css" />
    <title>商品类别</title>
    <style>
        body {
            margin-top: 20px;
            margin: 0 auto;
            width: 100%;
        }

        .carousel-inner .item img {
            width: 100%;
            height: 300px;
        }
    </style>
</head>
<body>
    <!-- 引入header.jsp -->
    <jsp:include page="header.jsp"></jsp:include>

    <script>
        // 在外面获取不到
        // console.log($(".navbar-collapse>ul").children().length);
        $.ajax({
            url: '${pageContext.request.contextPath }/IndexServlet',
            type: 'GET',
            dataType: 'json',
            data:{'getCategory':true}
        })
            .done(function(data) {
                // 在里面才能获取到，因为ajax异步运行，需要一定时间。
                var $ul = $(".navbar-collapse>ul");

                // console.log($ul.children().length);
                /* 这里获取该标签的子元素为7，说明header.jsp中的ajax加载完了 */
                var $lis = $ul.children();
                for (var i = 0;i < $lis.length;i++){
                    if ($lis.eq(i).val() == ${indexCid}){
                        $lis.eq(i).addClass("active");

                        // 设置标题
                        var title = $lis.eq(i).children().contents().filter(function () {
                            return this.nodeType === 3;
                        }).text();
                        $(document).attr("title",title);
                        break;
                    }
                }
            })
            .fail(function() {
                alert('服务器超时，请重试！');
            });
    </script>

    <div class="row" style="width: 1210px; margin: 0 auto;">
        <div class="col-md-12">
            <ol class="breadcrumb">
                <li><a href="#">首页&nbsp;&nbsp;&gt;</a></li>
                <li></li>
            </ol>
        </div>

        <c:forEach var="item" items="${page.data}">
            <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="${pageContext.request.contextPath }/ProductServlet?pid=${item.pid}">
                    <img src="${pageContext.request.contextPath }/${item.pimage }" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="${pageContext.request.contextPath }/ProductServlet?pid=${item.pid}" style='color:#666'>${item.pname }</a></p>
                <font color="#FF0000" style="font-size:16px">商城价：&yen;${item.shop_price }</font>
            </div>
        </c:forEach>

    </div>

    <!--分页 -->
    <div style="width: 380px; margin: 0 auto; margin-top: 50px;">
        <ul class="pagination" style="text-align: center; margin-top: 10px;">
            <li class="disabled"><a href="${pageContext.request.contextPath }/ProductServlet?cid=${indexCid}" aria-label="Previous"><span
                    aria-hidden="true">&laquo;</span></a></li>

            <c:forEach items="${page.bar}" var="pageNum">
                <li <c:if test="${pageNum == page.currentPage }">class="active"</c:if>>
                    <a href="${pageContext.request.contextPath }/ProductServlet?cid=${indexCid}&currentPage=${pageNum }">${pageNum }</a></li>
            </c:forEach>

            <li><a href="${pageContext.request.contextPath }/ProductServlet?cid=${indexCid}&currentPage=${page.totalPage }" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
            </a></li>
        </ul>
    </div>
    <!-- 分页结束 -->

    <!--商品浏览记录-->
    <div
            style="width: 1210px; margin: 0 auto; padding: 0 9px; border: 1px solid #ddd; border-top: 2px solid #999; height: 246px;">

        <h4 style="width: 50%; float: left; font: 14px/30px 微软雅黑">浏览记录</h4>
        <div style="width: 50%; float: right; text-align: right;">
            <a href="">more</a>
        </div>
        <div style="clear: both;"></div>

        <div style="overflow: hidden;">

            <ul style="list-style: none;">
                <li
                        style="width: 150px; height: 216px; float: left; margin: 0 8px 0 0; padding: 0 18px 15px; text-align: center;"><img
                        src="${pageContext.request.contextPath }/static/images/product_list/cs10001.jpg" width="130px" height="130px" /></li>
            </ul>

        </div>
    </div>


    <!-- 引入footer.jsp -->
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
