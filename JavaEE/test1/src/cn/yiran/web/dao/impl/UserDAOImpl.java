package cn.yiran.web.dao.impl;

import cn.yiran.web.dao.UserDAO;
import cn.yiran.web.domain.User;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{


    public User findByName(String name){
        String select = "select * from user1 where name = ?";
        try {
            return qr.query(select,new BeanHandler<User>(User.class), name);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int register(User user){
        String insert = "insert into user1 values(null,?,?,?,?,?,?,?,?,?)";
        List<Object> list = new ArrayList<>();
        list.add(user.getName());
        list.add(user.getPassword());
        list.add(user.getAge());
        list.add(user.getSex());
        list.add(user.getEmail());
        list.add(user.getHobby());
        list.add(user.getAddress());
        list.add(user.getDescription());
        list.add(user.getBirthday());
        // 设置初始值，是否注册成功，默认不成功
        int i = 0;
        try {
            // 将集合转为数组
            i = qr.update(insert,list.toArray());
            return i;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return i;
    }

    public List<User> show(){
        String sql = "select * from user1";
        List<User> list = null;
        try {
            // BeanListHandler可以不传参
            list = qr.query(sql,new BeanListHandler<>(User.class));
            return list;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public User login(User user){
        String select = "select * from user1 where name = ? and password = ?";
        try {
            return qr.query(select,new BeanHandler<User>(User.class), user.getName(),user.getPassword());
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
