package cn.yiran.web.servlet;

import cn.yiran.web.domain.Cart;
import cn.yiran.web.domain.Product;
import cn.yiran.web.service.ProductService;
import cn.yiran.web.service.impl.ProductServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "CartServlet",value = "/CartServlet")
public class CartServlet extends HttpServlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.config = config;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        // 获取session
        HttpSession session = request.getSession();

        // 获取购物车
        Map<Integer,Cart> myCart = (Map)session.getAttribute("myCart");

        // 如果是添加至购物车
        if (request.getParameter("quantity") != null){
            // 获取要添加到购物车的商品的id
            int pid = Integer.parseInt(request.getParameter("pid"));
            // 获取添加到购物车的商品数量
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            ProductService productService = new ProductServiceImpl();
            // 获取商品的实体类
            Product cartProduct = productService.findById(pid);
            // 创建购物车实体
            Cart thisCart = new Cart();
            // 封装属性
            thisCart.setProduct(cartProduct);
            thisCart.setQuantity(quantity);

            // 查询是否是在购物车中修改商品数量，而不是在商品页重复购买该商品
            if (request.getParameter("changeQuantity") != null){
                // 通过map方法获取该键为thisCart.getProduct().getPid()的value，cart
                Cart inCart = myCart.get(thisCart.getProduct().getPid());
                // 修改商品数量
                inCart.setQuantity(thisCart.getQuantity());
                // 保存到map中
                myCart.put(thisCart.getProduct().getPid(),inCart);
                // 保存信息，跳转页面
                session.setAttribute("myCart",myCart);
                // 跳转到购物车页面
                request.getRequestDispatcher("jsp/cart.jsp").forward(request,response);
                return;
            }
            // 或者是在商品页面重复购买，则是添加数量
            else if(myCart.get(thisCart.getProduct().getPid()) != null){
                Cart inCart = myCart.get(thisCart.getProduct().getPid());
                // 修改商品数量，为原来的添加新加的
                int newQuantity = inCart.getQuantity()+thisCart.getQuantity();
                inCart.setQuantity(newQuantity);
                // 保存到map中
                myCart.put(thisCart.getProduct().getPid(),inCart);
                // 保存信息
                session.setAttribute("myCart",myCart);
                // 跳转到购物车页面
                request.getRequestDispatcher("jsp/cart.jsp").forward(request,response);
                return;
            }
            // 不是购物车中修改，也不是重复购买，则为第一次购买
            else {
                // 添加到购物车中
                myCart.put(thisCart.getProduct().getPid(),thisCart);
                // 保存信息
                session.setAttribute("myCart", myCart);
                // 跳转到购物车页面
                request.getRequestDispatcher("jsp/cart.jsp").forward(request, response);
                return;
            }
        }

        // 如果是从购物车删除
        if (request.getParameter("delete_product") != null){
            // 获取要从购物车删除的商品的pid
            int pid = Integer.parseInt(request.getParameter("pid"));
            // 直接使用map的删除方法删除该商品
            myCart.remove(pid);
            // 保存信息
            session.setAttribute("myCart",myCart);
            // 跳转到购物车页面
            request.getRequestDispatcher("jsp/cart.jsp").forward(request,response);
            return;
        }

        // 如果是清空购物车
        if (request.getParameter("delete_product_all") != null){
            // 清空购物车
            session.setAttribute("myCart",new HashMap<>());
            // 跳转到购物车页面
            request.getRequestDispatcher("jsp/cart.jsp").forward(request,response);
            return;
        }

        // 如果什么参数都没有，那么直接跳转到购物车页面即可
        request.getRequestDispatcher("jsp/cart.jsp").forward(request,response);
    }
}
