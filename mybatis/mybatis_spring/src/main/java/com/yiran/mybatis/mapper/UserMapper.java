package com.yiran.mybatis.mapper;

import com.yiran.mybatis.pojo.User;
import com.yiran.mybatis.pojo.UserVo;

import java.util.List;


/**
 * Mapper动态代理方式
 * 	Mapper接口开发方法只需要程序员编写Mapper接口（相当于Dao接口），
 * 		由Mybatis框架根据接口定义创建接口的动态代理对象，代理对象的方法体同上边Dao接口实现类方法
 *
 * 	Mapper接口开发需要遵循以下规范：
 *		1、	Mapper.xml文件中的namespace与mapper接口的类路径相同。
 *		2、	Mapper接口方法名和Mapper.xml中定义的每个statement的id相同
 *		3、	Mapper接口方法的输入参数类型和mapper.xml中定义的每个sql 的parameterType的类型相同
 *		4、	Mapper接口方法的输出参数类型和mapper.xml中定义的每个sql的resultType的类型相同
 */

public interface UserMapper {

    User queryUserById(int userId);

    List<User> queryUserByUserName(String username);

    void saveUser(User user);

    void updatePwd(User user);

    int queryCount();

    void deleteUserById(Integer userId);

    List<User> queryUsers();

    List<User> queryUsersByLikeName(String name);

    List<User> queryUserByMutli(UserVo userVo);

    /* 配置settings 驼峰设置为true 从经典的数据库列名A_COLUMN启用自动映射到骆驼标识的经典的Java属性名aColumn
     * 这里我们就介绍一下，没有具体实现
     * */
    List<User> queryUserResultMap();

    List<User> queryUserByMutliWhere(UserVo userVo);

    List<User> queryUserByIds(UserVo userVo);

    /* 配置settings 驼峰设置为true 从经典的数据库列名A_COLUMN启用自动映射到驼峰标识的经典java属性名aColumn */
}
