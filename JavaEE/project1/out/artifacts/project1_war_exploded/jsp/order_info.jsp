<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/7/25
  Time: 8:48
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
                <strong>订单详情</strong>
                <table class="table table-bordered">
                    <tbody>
                    <tr class="warning">
                        <th colspan="5">订单编号:${orderInfo.orderId}</th>
                    </tr>
                    <tr class="warning">
                        <th>图片</th>
                        <th>商品</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>小计</th>
                    </tr>

                    <c:set var="total_price" value="0" />
                    <c:forEach var="item" items="${orderInfo.orderCarts}" varStatus="vs">
                        <tr class="active">
                            <td width="60" width="40%">
                                <img src="${pageContext.request.contextPath }/${item.value.product.pimage}" width="70" height="60">
                            </td>
                            <td width="30%">
                                <a target="_blank">${item.value.product.pname}</a>
                            </td>
                            <td width="20%">
                                ￥${item.value.product.shop_price}
                            </td>
                            <td width="10%">
                                ${item.value.quantity}
                            </td>
                            <td width="15%">
                                <span class="subtotal">￥${item.value.product.shop_price * item.value.quantity }</span>
                                <c:set var="total_price" value="${total_price + item.value.product.shop_price * item.value.quantity }" />
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>

            <div style="text-align: right; margin-right: 120px;">
                商品金额: <strong style="color: #ff6600;">￥${total_price}元</strong>
            </div>

        </div>

        <div>
            <hr />
            <form class="form-horizontal"
                  style="margin-top: 5px; margin-left: 150px;">
                <div class="form-group">
                    <label for="username" class="col-sm-1 control-label">地址</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="username"
                               placeholder="请输入收货地址">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-1 control-label">收货人</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="inputPassword3"
                               placeholder="请输收货人">
                    </div>
                </div>
                <div class="form-group">
                    <label for="confirmpwd" class="col-sm-1 control-label">电话</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="confirmpwd"
                               placeholder="请输入联系方式">
                    </div>
                </div>
            </form>

            <hr />

            <div style="margin-top: 5px; margin-left: 150px;">
                <strong>选择银行：</strong>
                <p>
                    <br /> <input type="radio" name="pd_FrpId" value="ICBC-NET-B2C"
                                  checked="checked" />工商银行 <img src="${pageContext.request.contextPath }/static/images/order_info/icbc.bmp"
                                                                align="middle" />&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
                                                                                                                 name="pd_FrpId" value="BOC-NET-B2C" />中国银行 <img
                        src="${pageContext.request.contextPath }/static/images/order_info/bc.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="pd_FrpId" value="ABC-NET-B2C" />农业银行 <img
                        src="${pageContext.request.contextPath }/static/images/order_info/abc.bmp" align="middle" /> <br /> <br /> <input
                        type="radio" name="pd_FrpId" value="BOCO-NET-B2C" />交通银行 <img
                        src="${pageContext.request.contextPath }/static/images/order_info/bcc.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="pd_FrpId" value="PINGANBANK-NET" />平安银行
                    <img src="${pageContext.request.contextPath }/static/images/order_info/pingan.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="pd_FrpId" value="CCB-NET-B2C" />建设银行 <img
                        src="${pageContext.request.contextPath }/static/images/order_info/ccb.bmp" align="middle" /> <br /> <br /> <input
                        type="radio" name="pd_FrpId" value="CEB-NET-B2C" />光大银行 <img
                        src="${pageContext.request.contextPath }/static/images/order_info/guangda.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C" />招商银行
                    <img src="${pageContext.request.contextPath }/static/images/order_info/cmb.bmp" align="middle" />

                </p>
                <hr />
                <p style="text-align: right; margin-right: 100px;">
                    <a href="javascript:document.getElementById('orderForm').submit();">
                        <img src="${pageContext.request.contextPath }/static/images/order_info/finalbutton.gif" width="204" height="51"
                             border="0" />
                    </a>
                </p>
                <hr />

            </div>
        </div>

    </div>

    <!-- 引入footer.jsp -->
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
