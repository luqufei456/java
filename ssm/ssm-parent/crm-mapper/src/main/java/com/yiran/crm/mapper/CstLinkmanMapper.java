package com.yiran.crm.mapper;

import com.yiran.crm.pojo.CstLinkman;
import com.yiran.crm.pojo.CstLinkmanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CstLinkmanMapper {
    int countByExample(CstLinkmanExample example);

    int deleteByExample(CstLinkmanExample example);

    int deleteByPrimaryKey(Long lkmId);

    int insert(CstLinkman record);

    int insertSelective(CstLinkman record);

    List<CstLinkman> selectByExample(CstLinkmanExample example);

    CstLinkman selectByPrimaryKey(Long lkmId);

    int updateByExampleSelective(@Param("record") CstLinkman record, @Param("example") CstLinkmanExample example);

    int updateByExample(@Param("record") CstLinkman record, @Param("example") CstLinkmanExample example);

    int updateByPrimaryKeySelective(CstLinkman record);

    int updateByPrimaryKey(CstLinkman record);
}