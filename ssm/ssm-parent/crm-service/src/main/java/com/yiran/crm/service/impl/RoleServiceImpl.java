package com.yiran.crm.service.impl;

import com.yiran.crm.mapper.SysRoleMapper;
import com.yiran.crm.pojo.SysRole;
import com.yiran.crm.pojo.SysRoleExample;
import com.yiran.crm.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    @Transactional(readOnly = true)
    public List<SysRole> queryRoles() {
        // 查询所有的角色，按role_id排序
        SysRoleExample example = new SysRoleExample();
        example.setOrderByClause("role_id");
        return sysRoleMapper.selectByExample(example);
    }
}
