package cn.yiran.web.dao;

import cn.yiran.web.domain.User;
import cn.yiran.web.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UserDAO {
    QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    User findByName(String name);



    int register(User user);

    List<User> show();

    User login(User user);
}
