<%@ page import="cn.yiran.web.domain.Category" %>
<%@ page import="cn.yiran.web.domain.Product" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/7/23
  Time: 15:52
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
    <title>商品详情页</title>
</head>
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
<body>
    <!-- 引入header.jsp -->
    <jsp:include page="header.jsp"></jsp:include>

    <div class="container">
        <div class="row">
            <div
                    style="border: 1px solid #e4e4e4; width: 930px; margin-bottom: 10px; margin: 0 auto; padding: 10px; margin-bottom: 10px;">
                <% Category info_category = (Category) request.getAttribute("info_category"); %>
                <a href="${pageContext.request.contextPath }/IndexServlet">首页&nbsp;&nbsp;&gt;</a> <a href="${pageContext.request.contextPath }/IndexServlet?cid=<%=info_category.getCid()%>"><%=info_category.getCname()%>&nbsp;&nbsp;&gt;</a>
                <% Product product_info = (Product)request.getAttribute("product_info"); %>
                <a><%=product_info.getPname()%></a>
            </div>

            <div style="margin: 0 auto; width: 950px;">
                <div class="col-md-6">
                    <img style="opacity: 1; width: 400px; height: 350px;" title=""
                         class="medium"
                         src="${pageContext.request.contextPath }/<%=product_info.getPimage()%>">
                </div>

                <div class="col-md-6">
                    <div>
                        <strong><%=product_info.getPname()%></strong>
                    </div>
                    <form action="${pageContext.request.contextPath }/CartServlet" method="post">
                        <div
                                style="border-bottom: 1px dotted #dddddd; width: 350px; margin: 10px 0 10px 0;">
                            <div>编号：<input type="text" name="pid" style="border: none" value="<%=product_info.getPid()%>" readonly="readonly" /></div>
                        </div>

                        <div style="margin: 10px 0 10px 0;">
                            亿家价: <strong style="color: #ef0101;">￥：<%=product_info.getShop_price()%>元/份</strong> 参 考 价：
                            <del>￥<%=product_info.getMarket_price()%>元/份</del>
                        </div>

                        <div style="margin: 10px 0 10px 0;">
                            <%
                                // 获得日历对象
                                Calendar calendar = Calendar.getInstance();
                                // 设置时间，date转日历
                                calendar.setTime(product_info.getPdate());
                                // 计算离当前时间以后的日期，这里定为2个月
                                calendar.add(Calendar.DATE,60);
                                // 转成date类型
                                Date newDate = calendar.getTime();

                                // 定义转换格式
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                String startDate = sdf.format(product_info.getPdate());
                                String endDate = sdf.format(newDate);

                            %>
                            促销: <a target="_blank" title="限时抢购 (<%=startDate%> ~ <%=endDate%>)"
                                   style="background-color: #f07373;">限时抢购</a>
                        </div>

                        <div
                                style="padding: 10px; border: 1px solid #e7dbb1; width: 330px; margin: 15px 0 10px 0;; background-color: #fffee6;">
                            <div style="margin: 5px 0 10px 0;">白色</div>

                            <div
                                    style="border-bottom: 1px solid #faeac7; margin-top: 20px; padding-left: 10px;">
                                购买数量: <input id="quantity" name="quantity" value="1"
                                             maxlength="4" size="10" type="text">
                            </div>

                            <div style="margin: 20px 0 10px 0;; text-align: center;">
                                <a href=""> <input
                                        style="background: url('${pageContext.request.contextPath }/static/images/product_info/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0); height: 36px; width: 127px;"
                                        value="加入购物车" type="submit">
                                </a> &nbsp;收藏商品
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="clear"></div>
            <div style="width: 950px; margin: 0 auto;">
                <div
                        style="background-color: #d3d3d3; width: 930px; padding: 10px 10px; margin: 10px 0 10px 0;">
                    <strong>商品介绍</strong>
                </div>

                <div>
                    <img
                            src="${pageContext.request.contextPath }/<%=product_info.getPimage()%>">
                </div>

                <div
                        style="background-color: #d3d3d3; width: 930px; padding: 10px 10px; margin: 10px 0 10px 0;">
                    <strong>商品参数</strong>
                </div>
                <div style="margin-top: 10px; width: 900px;">
                    <table class="table table-bordered">
                        <tbody>
                        <tr class="active">
                            <th colspan="2">基本参数</th>
                        </tr>
                        <tr>
                            <th width="10%">级别</th>
                            <td width="30%">标准</td>
                        </tr>
                        <tr>
                            <th width="10%">标重</th>
                            <td>500</td>
                        </tr>
                        <tr>
                            <th width="10%">浮动</th>
                            <td>200</td>
                        </tr>
                        </tbody>
                    </table>
                </div>

                <div style="background-color: #d3d3d3; width: 900px;">
                    <table class="table table-bordered">
                        <tbody>
                        <tr class="active">
                            <th><strong>商品评论</strong></th>
                        </tr>
                        <tr class="warning">
                            <th>暂无商品评论信息 <a>[发表商品评论]</a></th>
                        </tr>
                        </tbody>
                    </table>
                </div>

                <div style="background-color: #d3d3d3; width: 900px;">
                    <table class="table table-bordered">
                        <tbody>
                        <tr class="active">
                            <th><strong>商品咨询</strong></th>
                        </tr>
                        <tr class="warning">
                            <th>暂无商品咨询信息 <a>[发表商品咨询]</a></th>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </div>


    <!-- 引入footer.jsp -->
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
