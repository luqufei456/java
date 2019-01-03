package com.example.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application {

	/*
	* 运行 Application的main(),呈现会启动，由于springboot自动内置了servlet容器，
	* 所以不需要类似传统的方式，先部署到容器再启动容器。只需要运行main()即可，
	* 这时打开浏览器输入网址：localhost:8080/springboot/hi ，
	* 就可以在浏览器上看到: hi you!!!
	* */

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
}
