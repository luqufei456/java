package cn.yiran.web.dao.impl;

import cn.yiran.web.dao.CategoryDAO;
import cn.yiran.web.domain.Category;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    @Override
    // 查询所有商品种类
    public List<Category> findAll() {
        String sql = "select * from category";
        try {
            return qr.query(sql,new BeanListHandler<>(Category.class));
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    // 根据cid查询商品种类
    public Category findById(int cid) {
        String sql = "select * from category where cid = ?";
        try {
            return qr.query(sql,new BeanHandler<>(Category.class),cid);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Category findByCname(String cname) {
        String sql = "select * from category where cname = ?";
        try {
            return qr.query(sql,new BeanHandler<>(Category.class),cname);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(Category category) {
        return false;
    }

    @Override
    public boolean update(Category category) {
        return false;
    }

    @Override
    public boolean delete(int cid) {
        return false;
    }
}
