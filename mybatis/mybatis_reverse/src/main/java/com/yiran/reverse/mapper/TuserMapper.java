package com.yiran.reverse.mapper;

import com.yiran.reverse.pojo.Tuser;
import com.yiran.reverse.pojo.TuserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TuserMapper {
    int countByExample(TuserExample example);

    int deleteByExample(TuserExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(Tuser record);

    int insertSelective(Tuser record);

    List<Tuser> selectByExample(TuserExample example);

    Tuser selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") Tuser record, @Param("example") TuserExample example);

    int updateByExample(@Param("record") Tuser record, @Param("example") TuserExample example);

    int updateByPrimaryKeySelective(Tuser record);

    int updateByPrimaryKey(Tuser record);
}