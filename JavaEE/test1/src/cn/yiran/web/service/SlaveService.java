package cn.yiran.web.service;

import cn.yiran.web.dao.SlaveDAO;
import cn.yiran.web.dao.impl.SlaveDAOImpl;
import cn.yiran.web.domain.Slave;

public interface SlaveService {
    SlaveDAO slaveDAO = new SlaveDAOImpl();

    Slave getSlave(String sid);
}
