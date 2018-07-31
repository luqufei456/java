package cn.yiran.web.service.impl;

import cn.yiran.web.domain.Page;
import cn.yiran.web.domain.Product;
import cn.yiran.web.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    // 查询所有商品
    public List<Product> findAll(int pflag) {
        return productDAO.findAll(pflag);
    }

    @Override
    // 查询所有热门商品
    public List<Product> findAllHost(int is_hot) {
        return productDAO.findAllHost(is_hot);
    }

    @Override
    // 通过pid查询商品
    public Product findById(int pid) {
        return productDAO.findById(pid);
    }

    @Override
    public Product findByPname(String pname) {
        return productDAO.findByPname(pname);
    }

    @Override
    public Page findByCid(int cid, int currentPage) {
        // 记录该类商品的总数
        int totalCount = productDAO.calCount(cid);
        // 每页显示的记录条数
        int pageSize = 5;
        // 总页数，能整除则就为这个数，不能则+1
        int totalPage = totalCount%pageSize==0?(totalCount/pageSize):(totalCount/pageSize)+1;
        // 分页后的数据为
        List<Product> data = productDAO.findByCid(cid,(currentPage-1)*pageSize,pageSize);
        // 封装page
        Page page = new Page();
        page.setTotalCount(totalCount);
        page.setTotalPage(totalPage);
        page.setPageSize(pageSize);
        page.setCurrentPage(currentPage);
        page.setData(data);

        return page;
    }
}
