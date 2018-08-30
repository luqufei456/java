package com.yiran.mybatis.dao.impl;

import com.yiran.mybatis.dao.UserDao;
import com.yiran.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class UserDaoImpl implements UserDao {

    /*
    *
    * */
    @Override
    public User login(User user) throws Exception {
        // 1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 2. 加载SqlMapConfig.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 3. 创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

        // 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        /* 调用增删改查方法
         *
         *
         * */
        User existUser = sqlSession.selectOne("user.login",user);
        // 关闭资源
        sqlSession.close();
        return existUser;
    }

}
