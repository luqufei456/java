package cn.yiran.web.dao;

import cn.yiran.web.domain.Category;
import cn.yiran.web.domain.Product;
import cn.yiran.web.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class GoodsDAO {
    QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

    public List<Category> allCategory(){
        String sql = "select * from category";
        List<Category> list = null;
        try {
            // BeanListHandler可以不传参
            list = qr.query(sql,new BeanListHandler<>(Category.class));
            return list;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> allProduct(){
        String sql = "select * from product";
        List<Product> list = null;
        try {
            // BeanListHandler可以不传参
            list = qr.query(sql,new BeanListHandler<>(Product.class));
            return list;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
