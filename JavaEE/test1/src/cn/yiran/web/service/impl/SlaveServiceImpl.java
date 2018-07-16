package cn.yiran.web.service.impl;

import cn.yiran.web.domain.Slave;
import cn.yiran.web.service.SlaveService;

public class SlaveServiceImpl implements SlaveService {
    public Slave getSlave(String sid){
        return slaveDAO.getSlave(sid);
    }
}
