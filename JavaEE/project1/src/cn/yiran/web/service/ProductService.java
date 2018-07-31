package cn.yiran.web.service;

import cn.yiran.web.dao.ProductDAO;
import cn.yiran.web.dao.impl.ProductDAOImpl;
import cn.yiran.web.domain.Page;
import cn.yiran.web.domain.Product;

import java.util.List;

public interface ProductService {
    ProductDAO productDAO = new ProductDAOImpl();

    // 查询所有的商品
    List<Product> findAll(int pflag);

    // 查询热门商品
    List<Product> findAllHost(int is_hot);

    // 通过pid查询商品
    Product findById(int pid);

    // 通过pname查询商品
    Product findByPname(String pname);

    // 通过cid查询商品,实现分页
    Page findByCid(int cid, int currentPage);
}
