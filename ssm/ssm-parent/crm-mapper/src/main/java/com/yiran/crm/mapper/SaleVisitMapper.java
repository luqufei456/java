package com.yiran.crm.mapper;

import com.yiran.crm.pojo.SaleVisit;
import com.yiran.crm.pojo.SaleVisitExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SaleVisitMapper {
    int countByExample(SaleVisitExample example);

    int deleteByExample(SaleVisitExample example);

    int deleteByPrimaryKey(String visitId);

    int insert(SaleVisit record);

    int insertSelective(SaleVisit record);

    List<SaleVisit> selectByExample(SaleVisitExample example);

    SaleVisit selectByPrimaryKey(String visitId);

    int updateByExampleSelective(@Param("record") SaleVisit record, @Param("example") SaleVisitExample example);

    int updateByExample(@Param("record") SaleVisit record, @Param("example") SaleVisitExample example);

    int updateByPrimaryKeySelective(SaleVisit record);

    int updateByPrimaryKey(SaleVisit record);
}