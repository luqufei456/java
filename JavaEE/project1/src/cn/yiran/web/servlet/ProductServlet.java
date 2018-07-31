package cn.yiran.web.servlet;

import cn.yiran.web.domain.Category;
import cn.yiran.web.domain.Page;
import cn.yiran.web.domain.Product;
import cn.yiran.web.service.CategoryService;
import cn.yiran.web.service.ProductService;
import cn.yiran.web.service.impl.CategoryServiceImpl;
import cn.yiran.web.service.impl.ProductServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet",value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
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

        if (request.getParameter("cid") != null){
            // 分页
            String pageNum = request.getParameter("currentPage");
            // 商品类别
            int cid = Integer.parseInt(request.getParameter("cid"));
            // 默认显示第一页
            int currentPage = 1;
            // 如果收到请求有页面参数
            if (pageNum != null){
                currentPage = Integer.parseInt(pageNum);
            }
            // 找到productService
            ProductService productService = new ProductServiceImpl();
            // 构造page实体类
            Page page = productService.findByCid(cid,currentPage);

            // 存储数据
            request.setAttribute("page",page);
            request.setAttribute("indexCid",cid);
            request.getRequestDispatcher("jsp/product_list.jsp").forward(request,response);
            return;

        }

        if (request.getParameter("pid") != null) {
            // 1.获取session，通过session获取pid
            int pid = Integer.parseInt(request.getParameter("pid"));
            // 2.获取productService
            ProductService productService = new ProductServiceImpl();
            // 3.通过数据库找到该商品
            Product product_info = productService.findById(pid);
            // 4.将该商品封装到request
            request.setAttribute("product_info", product_info);
            // 5.通过该商品的cid，找到所属类别
            CategoryService categoryService = new CategoryServiceImpl();
            Category info_category = categoryService.findById(product_info.getCid());
            // 6.封装于request
            request.setAttribute("info_category", info_category);
            // 7.请求转发
            request.getRequestDispatcher("jsp/product_info.jsp").forward(request, response);
        }
    }
}
