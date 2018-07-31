package cn.yiran.web.dao.impl;

import cn.yiran.web.dao.ProductDAO;
import cn.yiran.web.domain.Product;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    @Override
    // 查询所有商品
    public List<Product> findAll(int pflag) {
        String sql = "select * from product where pflag = ?";
        try {
            return qr.query(sql,new BeanListHandler<>(Product.class),pflag);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findAllHost(int is_hot) {
        String sql = "select * from product where pflag=0 and is_hot=?";
        try {
            return qr.query(sql,new BeanListHandler<>(Product.class),is_hot);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product findById(int pid) {
        String sql = "select * from product where pid = ?";
        try {
            return qr.query(sql,new BeanHandler<>(Product.class),pid);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product findByPname(String pname) {
        String sql = "select * from product where pname = ?";
        try {
            return qr.query(sql,new BeanHandler<>(Product.class),pname);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findByCid(int cid, int startIndex,int size) {
        String sql = "select * from product where cid = ? limit ?,?";
        try {
            return qr.query(sql,new BeanListHandler<>(Product.class),cid,startIndex,size);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int calCount(int cid){
        // 默认值为0
        int count = 0;
        String sql = "select count(*) from product where cid=?";
        try {
            Object obj = qr.query(sql,new ScalarHandler(),cid);
            Number num = (Number)obj;
            count = num.intValue();
        } catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }
}
