package com.yiran.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // 这称为构造型注释，它为阅读代码的人提供了提示，对于Spring，该类扮演了一个特定的角色 这个类是一个web @Controller
@EnableAutoConfiguration // 这个注解告诉Spring Boot“猜测”将如何配置Spring，它是基于添加的jar依赖。
public class HelloBoot {

    /*
    * @RestController和@RequestMapping注解是Spring MVC注释(它们不是Spring Boot特有的)。
    * */
    @RequestMapping("/")
    public String hello(){
        return "hello spring boot";
    }

    /*
    * 应用程序的最后一部分是主(main)方法。 这只是一个遵循Java约定的应用程序入口点的标准方法。
    * main方法通过调用run来委托Spring Boot SpringApplication类。SpringApplication将引导应用程序，
    * 启动Spring，从而启动自动配置Tomcat Web服务器。
    * 需要传递Example.class(就是类名.class 这里为HelloBoot.class)作为run方法的参数来告诉SpringApplication，这是主要的Spring组件。
    * args数组也被传递以暴露任何命令行参数。
    *
    * JVM_bind in use  --  tomcat端口被占用
    *   1: application.properties
    *   2: 创建类@Configuration
    * */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloBoot.class, args);
    }
}
