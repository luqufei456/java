package cn.yiran.web.dao;

import cn.yiran.web.domain.Page;
import cn.yiran.web.domain.Product;
import cn.yiran.web.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

public interface ProductDAO {
    QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    //查询所有的商品
    List<Product> findAll(int pflag);

    //查询热门門商品
    List<Product> findAllHost(int is_hot);

    //通过pid查询商品
    Product findById(int pid);

    //通过pname查询商品（pname唯一）
    Product findByPname(String pname);

    // 通过cid查询商品，实现分页
    List<Product> findByCid(int cid,int startIndex,int size);

    // 计数，计算该类别一共有多少个商品
    int calCount(int cid);
}
