package cn.yiran.web.dao;

import cn.yiran.web.domain.User;
import cn.yiran.web.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * 数据访问对象，实现对数据库表user的增删改查
 * */

public class UserDAO {
    private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    // 定义一个实现登录的方法
    public User login(User user){
        String sql = "select * from user where username=? and password=?";
        try{
            return qr.query(sql,new BeanHandler<User>(User.class),user.getUsername(),user.getPassword());
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("登录失败");
        }

    }

    // 定义一个实现注册的方法
    public int register(User user){
        String select = "select * from user where username=?";
        String register = "insert into user(username,password) value(?,?)";
        int i = 0;
        try{
            User sUser = qr.query(select,new BeanHandler<>(User.class),user.getUsername());
            System.out.println(sUser);
            if (sUser == null){
                i = qr.update(register,user.getUsername(),user.getPassword());
                System.out.println("影响了"+i+"行数据");
            }
            return i;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return i;
    }
}
