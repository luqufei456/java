package cn.yiran.web.dao.impl;

import cn.yiran.web.dao.UserDAO;
import cn.yiran.web.domain.User;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class UserDAOImpl implements UserDAO {

    @Override
    public int register(User user) {
        String select = "select * from user where email = ?";
        String register = "insert into user(email,userPwd,userName,mobile,qq) values(?,?,?,?,?)";
        int i = 0;
        try {
            User sUser = qr.query(select,new BeanHandler<>(User.class),user.getEmail());
            if (sUser == null){
                i = qr.update(register,user.getEmail(),user.getUserPwd(),user.getUserName(),user.getMobile(),user.getQq());
            }
            return i;
        } catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public User login(User user) {
        String login = "select * from user where email = ? and userPwd = ?";
        try {
            return qr.query(login,new BeanHandler<>(User.class),user.getEmail(),user.getUserPwd());
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
