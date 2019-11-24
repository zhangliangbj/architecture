package com.example.spring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author zhangliang
 * @date 2019/11/19 10:41
 */
@EnableAutoConfiguration
public class SpringBootEventDemo {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootEventDemo.class)
                .listeners(event -> {
                    System.out.println("监听到事件：" + event.getClass().getName());
                })//增加监听器
                .run(args);//运行
    }
}
