package cn.yiran.web.dao.impl;

import cn.yiran.web.dao.SlaveDAO;
import cn.yiran.web.domain.Slave;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class SlaveDAOImpl implements SlaveDAO {
    public Slave getSlave(String sid){
        String sql = "select * from slaves where sid=?";
        try {
            return qr.query(sql,new BeanHandler<Slave>(Slave.class), sid);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
