package cn.yiran.web.servlet;

import cn.yiran.web.domain.Category;
import cn.yiran.web.domain.Product;
import cn.yiran.web.service.GoodsService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GoodsServlet",value = "/GoodsServlet")
public class GoodsServlet extends HttpServlet {
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

        GoodsService goodsService = new GoodsService();
        List<Category> categoryList = goodsService.allCategory();
        request.setAttribute("category",categoryList);

        List<Product> productList = goodsService.allProduct();

        request.setAttribute("product",productList);

        request.getRequestDispatcher("jsp/index.jsp").forward(request,response);
    }
}
