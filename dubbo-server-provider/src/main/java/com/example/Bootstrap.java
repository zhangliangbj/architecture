package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author zhangliang
 * @date 2019/12/8 14:22
 */
public class Bootstrap {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("dubbo-server.xml");
        context.start();

        System.in.read();
    }

}
