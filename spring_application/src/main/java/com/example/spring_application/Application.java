package com.example.spring_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    public static void main(String[] args) {
//        SpringApplication springApplication = new SpringApplication(Application.class);
//        Map<String,Object> proprities = new LinkedHashMap<>();
//        proprities.put("server.port","0");
//        springApplication.setDefaultProperties(proprities);
//        //设置为非web应用
//        springApplication.setWebApplicationType(WebApplicationType.NONE);
//        ConfigurableApplicationContext context = springApplication.run(args);
//        System.out.println(context.getBean(Application.class));
//        //输出当前Spring Boot应用的ApplicationContext的类名
//        System.out.println("当前Spring应用的上下文的类："+context.getClass().getName());
//    }

//    public static void main(String[] args) {
//        new SpringApplicationBuilder(Application.class)
//                .properties("server.port=0")  //0的意思是随机向操作系统要可用端口
//                .run(args);
//    }
}




