package com.yiran.spring.service.impl;

import com.yiran.spring.dao.UserDao;
import com.yiran.spring.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Component注解放置到类上
 * 相当于spring容器中定义：<bean id="customerService" class="com.igeek.ioc.CustomerService">
 * 其中id属性默认bean的名字是类名的小写
 * ——————————————————————————————————————————————————————
 * @Component(value="customer")//自定义bean的名字
 * 相当于spring容器中定义：<bean id="customer" class="com.igeek.ioc.CustomerService">
 * ——————————————————————————————————————————————————————
 */
//@Controller("userService")
@Service("userService")
public class UserServiceImpl implements UserService {
    Logger logger = Logger.getLogger(UserDao.class);

    // 简单类型的成员变量
    @Value("Rose") //参数的值简单类型
    private String name = "yiran";


    // @Autowired // 默认按照类型注入，类型为UserDao，所以如果UserDao接口有多个实现类，就需要下一种结合使用指定
    // @Qualifier("userDao") // 必须配合@Autowired注解使用，根据名字注入
    @Resource(name="userDao") // 默认先按照名称进行匹配，再按照类型进行匹配，我揣测这个名称是变量名 userDao
    private UserDao userDao;

    public void save() {
        logger.info("开始save");
        System.out.println("service的业务层被调用了");
        System.out.println("name"+name); // 输出为Rose，而不是yiran
        userDao.sava();
        logger.info("save结束");
    }
}
