<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/7/23
  Time: 16:34
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
    <title>我的购物车</title>
</head>
<body>
    <!-- 引入header.jsp -->
    <jsp:include page="header.jsp"></jsp:include>

    <div class="container">
        <div class="row">

            <div style="margin:0 auto; margin-top:10px;width:950px;">
                <strong style="font-size:16px;margin:5px 0;">订单详情</strong>
                <form action="">

                </form>
                <table class="table table-bordered">
                    <tbody>
                    <tr class="warning">
                        <th>结算</th>
                        <th>图片</th>
                        <th>商品</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>小计</th>
                        <th>操作</th>
                    </tr>

                    <script>
                        function changeNum(obj) {
                            var quantity = $(obj).val();
                            var r=/^[1-9][0-9]*$/gi;
                            if (r.test(quantity)){
                                $(obj).parent().submit();
                            }
                            else{
                                alert("请输入正确的数字");
                                return;
                            }
                        }
                    </script>

                    <script>
                        window.onload = function () {
                            $("#order_sub").click(function () {
                                // 找到name为cart[]的元素，且被选中
                                var carts = $("*[name='cart[]']:checked").map(function () {
                                    return "cart[]="+$(this).val();
                                }).get().join("&");
                                window.location.href = "${pageContext.request.contextPath }/OrderInfoServlet?"+carts;
                            });
                        }
                    </script>

                    <c:set var="total_price" value="0" />
                    <c:forEach var="item" items="${myCart}" varStatus="vs">
                            <tr class="active">
                                <td width="5%">
                                    <input type="checkbox" name="cart[]" checked="checked" value="${item.value.product.pid}">
                                </td>
                                <td width="60" width="40%">
                                    <img src="${pageContext.request.contextPath }/${item.value.product.pimage}" width="70" height="60">
                                </td>
                                <td width="25%">
                                    <a target="_blank">${item.value.product.pname}</a>
                                </td>
                                <td width="20%">
                                    ￥${item.value.product.shop_price}
                                </td>
                                <td width="10%">
                                    <form action="${pageContext.request.contextPath }/CartServlet" method="post">
                                        <input type="hidden" name="changeQuantity" value="change" />
                                        <input type="hidden" name="pid" value="${item.key}" />
                                        <input type="text" onchange="changeNum(this)" name="quantity" value="${item.value.quantity}" maxlength="4" size="10" />
                                    </form>
                                </td>
                                <td width="15%">
                                    <span class="subtotal">￥${item.value.product.shop_price * item.value.quantity }</span>
                                    <c:set var="total_price" value="${total_price + item.value.product.shop_price * item.value.quantity }" />
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath }/CartServlet?delete_product=true&pid=${item.value.product.pid}" class="delete">删除</a>
                                </td>
                            </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <div style="margin-right:130px;">
            <div style="text-align:right;">
                <em style="color:#ff6600;">
                    欢迎，${user.userName}&nbsp;&nbsp;
                </em> 赠送积分: <em style="color:#ff6600;">${total_price}</em>&nbsp; 商品金额: <strong style="color:#ff6600;">￥${total_price}元</strong>
            </div>
            <div style="text-align:right;margin-top:10px;margin-bottom:10px;">
                <a href="${pageContext.request.contextPath }/CartServlet?delete_product_all=true" id="clear" class="clear">清空购物车</a>

                <input type="button" width="100" value="提交订单" id="order_sub" border="0" style="background: url('${pageContext.request.contextPath }/static/images/register/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
                            height:35px;width:100px;color:white;">
            </div>
        </div>

    </div>

    <!-- 引入footer.jsp -->
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
