package cn.yiran.web.service;

import cn.yiran.web.dao.CategoryDAO;
import cn.yiran.web.dao.impl.CategoryDAOImpl;
import cn.yiran.web.domain.Category;

import java.util.List;

public interface CategoryService {
    CategoryDAO categoryDAO = new CategoryDAOImpl();

    // 查询所有的商品种类
    List<Category> findAll();

    // 通过cid查询商品种类
    Category findById(int cid);

    // 通过cname查询商品种类
    Category findByCname(String cname);
}
