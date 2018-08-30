package com.yiran.reverse.mapper;

import com.yiran.reverse.pojo.Taddress;
import com.yiran.reverse.pojo.TaddressExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaddressMapper {
    int countByExample(TaddressExample example);

    int deleteByExample(TaddressExample example);

    int deleteByPrimaryKey(Integer addressid);

    int insert(Taddress record);

    int insertSelective(Taddress record);

    List<Taddress> selectByExample(TaddressExample example);

    Taddress selectByPrimaryKey(Integer addressid);

    int updateByExampleSelective(@Param("record") Taddress record, @Param("example") TaddressExample example);

    int updateByExample(@Param("record") Taddress record, @Param("example") TaddressExample example);

    int updateByPrimaryKeySelective(Taddress record);

    int updateByPrimaryKey(Taddress record);
}