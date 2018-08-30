package com.yiran.crm.service.impl;

import com.yiran.crm.mapper.BaseDictMapper;
import com.yiran.crm.pojo.BaseDict;
import com.yiran.crm.pojo.BaseDictExample;
import com.yiran.crm.service.BaseDictService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BaseDictServiceImpl implements BaseDictService {

    @Resource
    private BaseDictMapper baseDictMapper;

    @Override
    @Transactional(readOnly = true)
    public List<BaseDict> queryBaseDictByType(String dictTypeCode) {
        BaseDictExample example = new BaseDictExample();
        example.createCriteria()
                .andDictTypeCodeEqualTo(dictTypeCode);
        return baseDictMapper.selectByExample(example);
    }
}
