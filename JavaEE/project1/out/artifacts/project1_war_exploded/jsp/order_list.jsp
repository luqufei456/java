<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/7/26
  Time: 9:41
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
    <title>我的订单</title>
    <style>
        body {
            margin-top: 20px;
            margin: 0 auto;
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

    <div class="container">
        <div class="row">
            <div style="margin: 0 auto; margin-top: 10px; width: 950px;">
                <strong>我的订单</strong>
                <table class="table table-bordered">
                    <c:forEach var="orderInfo_ol" varStatus="vs" items="${orderList}">
                        <tbody>
                        <tr class="success">
                            <th colspan="5">订单编号:${orderInfo_ol.orderId}</th>
                        </tr>
                        <tr class="warning">
                            <th>图片</th>
                            <th>商品</th>
                            <th>价格</th>
                            <th>数量</th>
                            <th>小计</th>
                        </tr>

                        <c:forEach var="cart_ol" items="${orderInfo_ol.orderCarts}">
                            <tr class="active">
                                <td width="60" width="40%"><input type="hidden" name="id"
                                                                  value="22"> <img src="${pageContext.request.contextPath }/${cart_ol.value.product.pimage}" width="70"
                                                                                   height="60"></td>
                                <td width="30%"><a target="_blank">${cart_ol.value.product.pname}</a></td>
                                <td width="20%">￥${cart_ol.value.product.shop_price}</td>
                                <td width="10%">${cart_ol.value.quantity}</td>
                                <td width="15%"><span class="subtotal">￥${cart_ol.value.quantity * cart_ol.value.product.shop_price}</span></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                        <br />
                    </c:forEach>

                </table>
            </div>
        </div>
        <div style="text-align: center;">
            <ul class="pagination">
                <li class="disabled"><a href="#" aria-label="Previous"><span
                        aria-hidden="true">&laquo;</span></a></li>
                <li class="active"><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">6</a></li>
                <li><a href="#">7</a></li>
                <li><a href="#">8</a></li>
                <li><a href="#">9</a></li>
                <li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                </a></li>
            </ul>
        </div>
    </div>

    <!-- 引入footer.jsp -->
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
