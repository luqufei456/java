package com.yiran.dao.impl;

import com.yiran.dao.UserDao;
import com.yiran.pojo.User;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    // 用来注入sessionFactory（不注入会报错）
    @Resource(name = "sessionFactory")
    public void setSessionFactoryOverride(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public User login(User user) {
        // return new User(); // 假数据，后面会换成hibernate从数据库获取

        // hibernate语句 这里的红线可以忽略，没啥意义
        List<?> users = getHibernateTemplate().find("from User where userName = ? and password = ?",user.getUserName(),user.getPassword());
        return users.size()>0?(User)users.get(0):null;
    }
}
