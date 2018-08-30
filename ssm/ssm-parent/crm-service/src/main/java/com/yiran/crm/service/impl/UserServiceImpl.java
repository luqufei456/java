package com.yiran.crm.service.impl;

import com.yiran.crm.mapper.SysUserMapper;
import com.yiran.crm.mapper.SysUserRoleMapper;
import com.yiran.crm.pojo.SysUser;
import com.yiran.crm.pojo.SysUserExample;
import com.yiran.crm.pojo.SysUserRoleKey;
import com.yiran.crm.pojo.UserRoleVo;
import com.yiran.crm.service.UserService;
import com.yiran.crm.utils.MD5Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional // 类中所有增删改，默认不是只读
public class UserServiceImpl implements UserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;


    @Override
    @Transactional(readOnly = true) // 查询 所以只读
    public SysUser login(SysUser user) {
        // 只查询用户
        SysUserExample example = new SysUserExample();

        // 这里是只查询用户所使用的方法，然而我们还想查询用户角色
        /*// 给查询设置条件
        example.createCriteria()
                .andUserCodeEqualTo(user.getUserCode())
                .andUserPasswordEqualTo(MD5Util.md5(user.getUserPassword()));
        // 返回的是个list
        List<SysUser> users = sysUserMapper.selectByExample(example);
        if (users.size() > 0){
            // 我们设置用户code为唯一键，所以直接取第一个就行，set密码为0是保护措施
            users.get(0).setUserPassword(null);
            return users.get(0);
        }*/

        // 关联查询用户 这里先不用加密
        /*user.setUserPassword(MD5Util.md5(user.getUserPassword()));*/
        return sysUserMapper.login(user);
    }

    @Override
    public void addUser(UserRoleVo userRoleVo) {
        /*
        * 插入数据，并返回主键值 id ,为什么要返回主键值id  因为要根据id来设置其角色
        * <insert id="insert" parameterType="com.yiran.crm.pojo.SysUser">
			    <selectKey keyColumn="user_id" keyProperty="userId" order="AFTER" resultType="long">
					SELECT LAST_INSERT_ID()
				</selectKey>
			    insert into sys_user (user_code, user_name,
			      user_password, user_state)
			    values (#{userCode,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR},
			      #{userPassword,jdbcType=VARCHAR}, #{userState,jdbcType=CHAR})
			  </insert>
        *
        * */
        SysUser user = userRoleVo.getUser();
        user.setUserState("1"); // 状态码，代表正常用户
        System.out.println("能运行不啊？");
        sysUserMapper.insert(user);
        // 插入数据后返回的主键值  user.getUserId();
        long userId = user.getUserId();

        // 对该用户进行角色添加
        for (long roleId : userRoleVo.getRoleIds()){
            SysUserRoleKey sysUserRoleKey = new SysUserRoleKey();
            sysUserRoleKey.setRoleId(roleId);
            sysUserRoleKey.setUserId(userId);
            sysUserRoleMapper.insert(sysUserRoleKey);
        }
    }

    @Override
    public String queryUserByCode(SysUser user) {
        SysUserExample example = new SysUserExample();
        // 查询code为发送参数的用户
        example.createCriteria().andUserCodeEqualTo(user.getUserCode());
        // list.isEmpty()  与 list.size() == 0 的区别
        // 前者可以判断null的情况  后者会报空指针异常
        List<SysUser> sysUsers = sysUserMapper.selectByExample(example);

        if (sysUsers.size() != 0) {
            return "false";
        }
        return "true";
    }
}
