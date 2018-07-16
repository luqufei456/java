package cn.yiran.web.dao;

import cn.yiran.web.domain.Slave;
import cn.yiran.web.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;

public interface SlaveDAO {
    QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    Slave getSlave(String sid);
}
