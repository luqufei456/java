package com.yiran.crm.service;

import com.github.pagehelper.PageInfo;
import com.yiran.crm.pojo.CstCustomer;

import java.util.List;

public interface CustomerService {
    void addCustomer(CstCustomer customer);

    PageInfo<CstCustomer> queryCustomers(PageInfo<CstCustomer> pageInfo, CstCustomer customer);
}
