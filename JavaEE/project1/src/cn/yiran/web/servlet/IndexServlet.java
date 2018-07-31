package cn.yiran.web.servlet;

import cn.yiran.web.domain.Category;
import cn.yiran.web.domain.Product;
import cn.yiran.web.service.CategoryService;
import cn.yiran.web.service.ProductService;
import cn.yiran.web.service.impl.CategoryServiceImpl;
import cn.yiran.web.service.impl.ProductServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "IndexServlet",value = "/IndexServlet")
public class IndexServlet extends HttpServlet {
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

        // 如果收到参数userOff说明要注销
        String userOff = request.getParameter("userOff");
        // 先判断是否有这个参数
        if (userOff != null){
            if (userOff.equals("yes")){
                // 删掉登录状态
                session.removeAttribute("user");
                // 重定向，转到首页
                response.sendRedirect("IndexServlet");
                return;
            }
        }
        else if (request.getParameter("getCategory") != null){
            // 回应ajax请求，返回json数据
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            CategoryService categoryService = new CategoryServiceImpl();
            List<Category> categoryList = new ArrayList<>();
            // 所有商品种类
            categoryList = categoryService.findAll();

            JSONObject jsonObj = new JSONObject();
            jsonObj.put("categoryList",categoryList);

            // 将商品种类存到

            response.getWriter().print(jsonObj.toString());

        }
        else {
            ProductService productService = new ProductServiceImpl();

            List<Product> hotProductList = new ArrayList<>();

            // 热门商品
            hotProductList = productService.findAllHost(1);

            request.setAttribute("hotProductList", hotProductList);

            request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
        }
    }
}
