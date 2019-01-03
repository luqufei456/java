package com.example.demo1.dao;

import com.example.demo1.pojo.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

// 创建Dao接口, springboot 将接口类会自动注解到spring容器中，不需要我吗做任何配置，只需要继承JpaRepository即可
// JpaRepository内置了findAll()、save()等一些方法
// 其中第二个参数为Id的类型
public interface GirlRep extends JpaRepository<Girl,Integer>{
}
