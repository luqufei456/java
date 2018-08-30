package com.yiran.reverse.mapper;

import com.yiran.reverse.pojo.Torder;
import com.yiran.reverse.pojo.TorderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TorderMapper {
    int countByExample(TorderExample example);

    int deleteByExample(TorderExample example);

    int deleteByPrimaryKey(Integer orderid);

    int insert(Torder record);

    int insertSelective(Torder record);

    List<Torder> selectByExample(TorderExample example);

    Torder selectByPrimaryKey(Integer orderid);

    int updateByExampleSelective(@Param("record") Torder record, @Param("example") TorderExample example);

    int updateByExample(@Param("record") Torder record, @Param("example") TorderExample example);

    int updateByPrimaryKeySelective(Torder record);

    int updateByPrimaryKey(Torder record);

    Torder queryOrderUserAddress(Integer torderId);
}