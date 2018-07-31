package cn.yiran.web.servlet;

import cn.yiran.web.domain.Cart;
import cn.yiran.web.domain.OrderInfo;
import cn.yiran.web.domain.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "OrderInfoServlet",value = "/OrderInfoServlet")
public class OrderInfoServlet extends HttpServlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.config = config;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        // 获取session
        HttpSession session = request.getSession();

        // 判断是否提交订单
        if (request.getParameterValues("cart[]") != null) {

            // 获取购物车
            Map<Integer,Cart> myCart = (Map) session.getAttribute("myCart");
            // 获取被选中要结算的商品id,为一个数组
            String[] orderCarts = request.getParameterValues("cart[]");

            // 创建一个订单，其实订单和购物车相同，只不过订单中的商品是在购物车中选中要结算的
            OrderInfo orderInfo = new OrderInfo();

            // 创建一个用用户id+当前时间生成的订单编号
            // 获取用户
            User loginUser = (User) session.getAttribute("user");
            int userId = loginUser.getId();

            // 获取当前时间的字符串
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            Date nowDate = new Date();
            String nowTime = sdf.format(nowDate);

            // 创建一个订单编号
            String orderId = userId + nowTime;
            System.out.println(orderId);

            // 封装订单
            orderInfo.setOrderId(orderId);

            // 遍历，从购物车中找到要结算的商品
            for (String orderCart : orderCarts){
                int orderPid = Integer.parseInt(orderCart);
                // 向订单中添加该购买的商品
                Map<Integer,Cart> newOrderCart = orderInfo.getOrderCarts();
                newOrderCart.put(orderPid,myCart.get(orderPid));
                // 因为购物车中选中的商品已经交付订单了，所以从购物车中删除该商品
                myCart.remove(orderPid);
            }

            // 获取订单集合，将该订单存入到订单集合中
            Set<OrderInfo> orderList = (Set) session.getAttribute("orderList");
            // 添加
            orderList.add(orderInfo);
            // 保存该订单与订单集合
            session.setAttribute("orderInfo", orderInfo);
            session.setAttribute("orderList", orderList);

            // 请求转发
            request.getRequestDispatcher("jsp/order_info.jsp").forward(request, response);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
