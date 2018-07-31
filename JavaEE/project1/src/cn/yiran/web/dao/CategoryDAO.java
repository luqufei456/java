package cn.yiran.web.dao;

import cn.yiran.web.domain.Category;
import cn.yiran.web.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.util.ArrayList;
import java.util.List;

public interface CategoryDAO {
    public List<Category> list = new ArrayList<>();
    QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    //查询所有
    List<Category> findAll();

    //根据cid查询商品种类
    Category findById(int cid);

    //根据cname查询商品种类(商品类别唯一)
    Category findByCname(String cname);

    //新增
    boolean add(Category category);

    //更新
    boolean update(Category category);

    //更新
    boolean delete(int cid);
}
