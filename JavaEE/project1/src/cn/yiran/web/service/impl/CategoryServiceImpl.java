package cn.yiran.web.service.impl;

import cn.yiran.web.domain.Category;
import cn.yiran.web.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Override
    // 查询所有的商品种类
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public Category findById(int cid) {
        return categoryDAO.findById(cid);
    }

    @Override
    public Category findByCname(String cname) {
        return categoryDAO.findByCname(cname);
    }
}
