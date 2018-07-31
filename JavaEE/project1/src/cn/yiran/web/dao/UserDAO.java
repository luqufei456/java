package cn.yiran.web.dao;

import cn.yiran.web.domain.User;
import cn.yiran.web.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

public interface UserDAO {
    QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    int register(User user);

    User login(User user);
}
