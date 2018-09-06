package com.yiran.ssm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//  @SpringBootApplication 被 @Configuration、@EnableAutoConfiguration、@ComponentScan 注解所修饰，
// 换言之 SpringBoot 提供了统一的注解来替代以上三个注解，简化程序的配置。
// https://blog.csdn.net/claram/article/details/75125749

@SpringBootApplication // 这个SpringBootServletInitializer执行传统的WAR部署运行SpringApplication
@EnableTransactionManagement   //如果mybatis中service实现类中加入事务注解，需要此处添加该注解
public class SpringBootWebApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootWebApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootWebApplication.class,args);
    }
}
