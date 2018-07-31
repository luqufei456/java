<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/7/21
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>极客商城首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" type="text/css" />
    <script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js" type="text/javascript"></script>
</head>

<body>
<div class="container-fluid">

    <!-- 引入header.jsp -->
    <jsp:include page="header.jsp"></jsp:include>

    <!-- 轮播图 -->
    <div class="container-fluid">
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <!-- 轮播图的中的小点 -->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>
            <!-- 轮播图的轮播图片 -->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img src="${pageContext.request.contextPath }/static/images/index/1.jpg">
                    <div class="carousel-caption">
                        <!-- 轮播图上的文字 -->
                    </div>
                </div>
                <div class="item">
                    <img src="${pageContext.request.contextPath }/static/images/index/2.jpg">
                    <div class="carousel-caption">
                        <!-- 轮播图上的文字 -->
                    </div>
                </div>
                <div class="item">
                    <img src="${pageContext.request.contextPath }/static/images/index/3.jpg">
                    <div class="carousel-caption">
                        <!-- 轮播图上的文字 -->
                    </div>
                </div>
            </div>

            <!-- 上一张 下一张按钮 -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>

    <!-- 热门商品 -->
    <div class="container-fluid">
        <div class="col-md-12">
            <h2>热门商品&nbsp;&nbsp;<img src="${pageContext.request.contextPath }/static/images/index/title2.jpg"/></h2>
        </div>
        <div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
            <img src="${pageContext.request.contextPath }/static/images/index/big01.jpg" width="205" height="404" style="display: inline-block;"/>
        </div>
        <div class="col-md-10">
            <div class="col-md-6" style="text-align:center;height:200px;padding:0;">
                <a href="#">
                    <img src="${pageContext.request.contextPath }/static/images/index/middle01.jpg" width="516px" height="200px" style="display: inline-block;">
                </a>
            </div>

            <c:forEach var="item" items="${hotProductList}">
                <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                    <a href="${pageContext.request.contextPath }/ProductServlet?pid=${item.pid}">
                        <img src="${pageContext.request.contextPath }/${item.pimage }" width="130" height="130" style="display: inline-block;">
                    </a>
                    <p><a href="${pageContext.request.contextPath }/ProductServlet?pid=${item.pid}" style='color:#666'>${item.pname }</a></p>
                    <p><font color="#E4393C" style="font-size:16px">&yen;${item.shop_price }</font></p>
                </div>
            </c:forEach>

        </div>
    </div>

    <!-- 广告条 -->
    <div class="container-fluid">
        <img src="${pageContext.request.contextPath }/static/images/index/ad.jpg" width="100%"/>
    </div>

    <!-- 最新商品 -->
    <div class="container-fluid">
        <div class="col-md-12">
            <h2>最新商品&nbsp;&nbsp;<img src="${pageContext.request.contextPath }/static/images/index/title2.jpg"/></h2>
        </div>
        <div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
            <img src="${pageContext.request.contextPath }/static/images/index/big01.jpg" width="205" height="404" style="display: inline-block;"/>
        </div>
        <div class="col-md-10">
            <div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
                <a href="#">
                    <img src="${pageContext.request.contextPath }/static/images/index/middle01.jpg" width="516px" height="200px" style="display: inline-block;">
                </a>
            </div>

            <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="#">
                    <img src="${pageContext.request.contextPath }/static/images/index/small03.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="#" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>

            <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="#">
                    <img src="${pageContext.request.contextPath }/static/images/index/small04.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="#" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>

            <div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="#">
                    <img src="${pageContext.request.contextPath }/static/images/index/small05.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="#" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>

            <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="#">
                    <img src="${pageContext.request.contextPath }/static/images/index/small03.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="#" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>

            <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="#">
                    <img src="${pageContext.request.contextPath }/static/images/index/small04.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="#" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>

            <div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="#">
                    <img src="${pageContext.request.contextPath }/static/images/index/small05.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="#" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>
            <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="#">
                    <img src="${pageContext.request.contextPath }/static/images/index/small03.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="#" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>

            <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="#">
                    <img src="${pageContext.request.contextPath }/static/images/index/small04.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="#" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>

            <div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="#">
                    <img src="${pageContext.request.contextPath }/static/images/index/small05.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="#" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>
        </div>
    </div>

    <!-- 引入footer.jsp -->
    <jsp:include page="footer.jsp"></jsp:include>

</div>
</body>

</html>
