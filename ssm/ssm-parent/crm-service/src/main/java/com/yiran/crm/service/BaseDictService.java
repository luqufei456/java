package com.yiran.crm.service;

import com.yiran.crm.pojo.BaseDict;

import java.util.List;

public interface BaseDictService {
    List<BaseDict> queryBaseDictByType(String dictTypeCode);
}
