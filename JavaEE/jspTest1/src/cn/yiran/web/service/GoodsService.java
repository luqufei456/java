package cn.yiran.web.service;

import cn.yiran.web.dao.GoodsDAO;
import cn.yiran.web.domain.Category;
import cn.yiran.web.domain.Product;

import java.util.List;

public class GoodsService {
    GoodsDAO goodsDAO = new GoodsDAO();

    public List<Category> allCategory(){
        return goodsDAO.allCategory();
    }

    public List<Product> allProduct(){
        return goodsDAO.allProduct();
    }
}
