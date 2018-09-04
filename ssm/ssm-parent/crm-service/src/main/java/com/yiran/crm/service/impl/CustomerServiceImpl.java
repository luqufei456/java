package com.yiran.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yiran.crm.mapper.CstCustomerMapper;
import com.yiran.crm.pojo.CstCustomer;
import com.yiran.crm.pojo.CstCustomerExample;
import com.yiran.crm.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CstCustomerMapper customerMapper;

    @Override
    public void addCustomer(CstCustomer customer) {
        customerMapper.insert(customer);
    }

    @Override
    public PageInfo<CstCustomer> queryCustomers(PageInfo<CstCustomer> pageInfo, CstCustomer customer) {
        // 是否是点击页面相关进入的，就获取相关页码和每页显示数量
        int pageNum = 1;
        if (pageInfo.getPageNum() != 0){
            pageNum = pageInfo.getPageNum();
        }
        int pageSize = 5;
        if (pageInfo.getPageSize() != 0){
            pageSize = pageInfo.getPageSize();
        }
        // 使用mybatis分页插件
        PageHelper.offsetPage((pageNum - 1)*pageSize,pageSize);
        // 正常的查询
        /*CstCustomerExample example = new CstCustomerExample();
        example.setOrderByClause("cust_id desc");
        List<CstCustomer> list = customerMapper.selectByExample(example);*/

        // 由于customer有三个外键，所以要进行多表联合查询
        // 查询客户及其对应的数据字典的名称
        List<CstCustomer> list = customerMapper.queryCustomerBaseDict(customer);

        // 将数据封装进pageInfo
        return new PageInfo<>(list);
    }

    /*
    * 根据id删除customer
    * */

    @Override
    public void delCustomer(Long custId) {
        customerMapper.deleteByPrimaryKey(custId);
    }
}
