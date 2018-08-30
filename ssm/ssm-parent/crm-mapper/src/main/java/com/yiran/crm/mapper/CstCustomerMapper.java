package com.yiran.crm.mapper;

import com.yiran.crm.pojo.CstCustomer;
import com.yiran.crm.pojo.CstCustomerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CstCustomerMapper {
    int countByExample(CstCustomerExample example);

    int deleteByExample(CstCustomerExample example);

    int deleteByPrimaryKey(Long custId);

    int insert(CstCustomer record);

    int insertSelective(CstCustomer record);

    List<CstCustomer> selectByExampleWithBLOBs(CstCustomerExample example);

    List<CstCustomer> selectByExample(CstCustomerExample example);

    CstCustomer selectByPrimaryKey(Long custId);

    int updateByExampleSelective(@Param("record") CstCustomer record, @Param("example") CstCustomerExample example);

    int updateByExampleWithBLOBs(@Param("record") CstCustomer record, @Param("example") CstCustomerExample example);

    int updateByExample(@Param("record") CstCustomer record, @Param("example") CstCustomerExample example);

    int updateByPrimaryKeySelective(CstCustomer record);

    int updateByPrimaryKeyWithBLOBs(CstCustomer record);

    int updateByPrimaryKey(CstCustomer record);

    List<CstCustomer> queryCustomerBaseDict(CstCustomer customer);
}