package com.yiran.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yiran.ssm.mapper.SysUserMapper;
import com.yiran.ssm.pojo.SysUser;
import com.yiran.ssm.pojo.SysUserExample;
import com.yiran.ssm.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private SysUserMapper userMapper;

    @Override
    public SysUser login(SysUser user) {
        return userMapper.login(user);
    }

    @Override
    public PageInfo<SysUser> queryList() {
        // 设置按 id倒序查询
        SysUserExample example = new SysUserExample();
        example.setOrderByClause("user_id");
        // 从下标为1的开始 取5个数据  offset (page-1)*PageSize  limit  PageSize
        PageHelper.offsetPage(1,5);
        List<SysUser> list = userMapper.selectByExample(example);
        // 返回pageInfo
        return new PageInfo<>(list);
    }
}
